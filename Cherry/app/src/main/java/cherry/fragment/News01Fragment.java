package cherry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cherry.action.GetNewsAction;
import cherry.action.model.NewsSet;
import cherry.action.model.ViewNews;
import cherry.action.model.ViewTag;
import cherry.action.util.ActionBase;
import cherry.action.util.Responser;
import cherry.adpter.Tab01ListAdpter;
import cherry.cherry.R;


public class News01Fragment extends Fragment {
    private ListView mMainList;
    private ListView mRecommandList;
    private ArrayList<String> list;

    public News01Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview= inflater.inflate(R.layout.fragment_news, container, false);
        mMainList = (ListView) mview.findViewById(R.id.tab01List_main);
        getNews();
        return mview;
    }
    private void getNews() {
        List<ViewTag> taglist = new ArrayList<ViewTag>();
        taglist.add(new ViewTag("5", "tdd"));


        ActionBase action = new GetNewsAction(taglist);
        action.execute(new Responser() {
            @Override
            public void successfulResponse(Object param) {
                NewsSet set = (NewsSet) param;
                List<ViewNews> mainList = set.getMainList();
                List<ViewNews> recommandList = set.getRecommandList();
                mMainList.setAdapter(new Tab01ListAdpter(getActivity(), mainList));

            }

            @Override
            public void failedResponse(String error) {
                Log.e("new error", error);
            }
        });
    }

}
