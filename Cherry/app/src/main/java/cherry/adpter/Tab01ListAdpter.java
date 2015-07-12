package cherry.adpter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import cherry.action.model.ViewNews;
import cherry.cherry.R;

/**
 * Created by aqi on 15/7/3.
 */
public class Tab01ListAdpter extends BaseAdapter {
    private Context mContext;
    private List<ViewNews> mList;
    private LayoutInflater inflater;

    private EditText et_url;
    private ImageView iv_img;
    private TextView textView;

    private ImageView image;


    public Tab01ListAdpter(Context context, List<ViewNews> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.fragment_tab01_item, null);


        iv_img = (ImageView) view.findViewById(R.id.item_img);
        textView = (TextView) view.findViewById(R.id.textView1);


        try{
            Drawable d = new GetImageTask().execute(mList.get(position).getImgUrl()).get();
            iv_img.setImageDrawable(d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



        return view;
    }



    private class GetImageTask extends AsyncTask<String,Void,Drawable>{

        @Override
        protected Drawable doInBackground(String... params) {

            Drawable drawable = loadImageFromNetwork(params[0]);

            return drawable;
        }

        //download image from network using @urladdress
        private Drawable loadImageFromNetwork(String urladdr) {
            // TODO Auto-generated method stub
            Drawable drawable = null;
            try{
                //judge if has picture locate or not according to filename
                drawable = Drawable.createFromStream(new URL(urladdr).openStream(), "image.jpg");
            }catch(IOException e){
                Log.d("drawble",e.getMessage());
            }
            if(drawable == null){
                Log.d("drawablenull","null drawable");
            }else{
                Log.d("drawalenotnull","not null drawable");
            }
            return drawable;
        }
    }
}


