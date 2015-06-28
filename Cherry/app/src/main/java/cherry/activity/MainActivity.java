package cherry.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cherry.cherry.R;
import cherry.fragment.Tab01Fragment;
import cherry.fragment.Tab02Fragment;
import cherry.fragment.Tab03Fragment;


public class MainActivity extends Activity implements View.OnClickListener{
    private LinearLayout mTab01;
    private LinearLayout mTab02;
    private LinearLayout mTab03;
    private TextView mTextView01;
    private TextView mTextView02;
    private TextView mTextView03;
    private Fragment mFragmentTab01;
    private Fragment mFragmentTab02;
    private Fragment mFragmentTab03;
    public FragmentManager fm = getFragmentManager();
    public FragmentTransaction trans = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }

    void initView(){
        mTab01=(LinearLayout)findViewById(R.id.ll_tab01);
        mTab02=(LinearLayout)findViewById(R.id.ll_tab02);
        mTab03=(LinearLayout)findViewById(R.id.ll_tab03);
        mTextView01=(TextView)findViewById(R.id.tv_tab01);
        mTextView02=(TextView)findViewById(R.id.tv_tab02);
        mTextView03=(TextView)findViewById(R.id.tv_tab03);
    }

    void initEvent(){
        mTab01.setOnClickListener(this);
        mTab02.setOnClickListener(this);
        mTab03.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setSelect(int i) {
        fm = getFragmentManager();
        trans = fm.beginTransaction();
        switch (i) {
            case 0:
                mFragmentTab01 = new Tab01Fragment();
                trans.replace(R.id.id_fragment, mFragmentTab01);
                mTab01.setBackgroundColor(Color.parseColor("#367d9c"));
                mTab02.setBackgroundColor(Color.parseColor("#333334"));
                mTab03.setBackgroundColor(Color.parseColor("#333334"));

                break;
            case 1:
                mFragmentTab02 = new Tab02Fragment();
                trans.replace(R.id.id_fragment, mFragmentTab02);
                mTab02.setBackgroundColor(Color.parseColor("#367d9c"));
                mTab01.setBackgroundColor(Color.parseColor("#333334"));
                mTab03.setBackgroundColor(Color.parseColor("#333334"));
                break;
            case 2:
                mFragmentTab03 = new Tab03Fragment();
                trans.replace(R.id.id_fragment, mFragmentTab03);
                mTab03.setBackgroundColor(Color.parseColor("#367d9c"));
                mTab01.setBackgroundColor(Color.parseColor("#333334"));
                mTab02.setBackgroundColor(Color.parseColor("#333334"));
                break;
        }
        trans.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab01:
                setSelect(0);
                break;
            case R.id.ll_tab02:
                setSelect(1);
                break;
            case R.id.ll_tab03:
                setSelect(2);
                break;
        }
    }
}
