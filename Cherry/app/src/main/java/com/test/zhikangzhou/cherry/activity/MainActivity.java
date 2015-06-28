package com.test.zhikangzhou.cherry.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.zhikangzhou.cherry.R;
import com.test.zhikangzhou.cherry.fragment.Tab01Fragment;
import com.test.zhikangzhou.cherry.fragment.Tab02Fragment;
import com.test.zhikangzhou.cherry.fragment.Tab03Fragment;

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
                mTextView01.setTextColor(Color.parseColor("#367d9c"));
                mTextView02.setTextColor(Color.parseColor("#A4A4A4"));
                mTextView03.setTextColor(Color.parseColor("#A4A4A4"));
                break;
            case 1:
                mFragmentTab02 = new Tab02Fragment();
                trans.replace(R.id.id_fragment, mFragmentTab02);
                mTextView02.setTextColor(Color.parseColor("#367d9c"));
                mTextView01.setTextColor(Color.parseColor("#A4A4A4"));
                mTextView03.setTextColor(Color.parseColor("#A4A4A4"));
                break;
            case 2:
                mFragmentTab03 = new Tab03Fragment();
                trans.replace(R.id.id_fragment, mFragmentTab03);
                mTextView03.setTextColor(Color.parseColor("#367d9c"));
                mTextView01.setTextColor(Color.parseColor("#A4A4A4"));
                mTextView02.setTextColor(Color.parseColor("#A4A4A4"));
                break;
        }
        trans.commit();
    }

    public void hidFragment(FragmentTransaction trans) {
        if (mTab01 != null) {
            trans.hide(mFragmentTab01);
        }
        if (mTab02 != null) {
            trans.hide(mFragmentTab02);
        }
        if (mTab03 != null) {
            trans.hide(mFragmentTab03);
        }

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
