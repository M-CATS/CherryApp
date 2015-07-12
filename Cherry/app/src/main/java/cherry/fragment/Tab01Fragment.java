package cherry.fragment;


import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cherry.action.GetNewsAction;
import cherry.action.model.NewsSet;
import cherry.action.model.ViewNews;
import cherry.action.model.ViewTag;
import cherry.action.util.ActionBase;
import cherry.action.util.Responser;
import cherry.activity.MainActivity;
import cherry.activity.TagActivity;
import cherry.adpter.Tab01ListAdpter;
import cherry.cherry.R;
import cherry.widget.FlowLayout;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Tab01Fragment extends Fragment implements View.OnClickListener {
    private ImageButton mAdd;
    private FragmentPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private List<Fragment> mDatas;
    private ImageView mTabline;
    private TextView mNewsTab01;
    private TextView mNewsTab02;
    private TextView mNewsTab03;
    private int mScreen1_3;
    private int mCurrentPageIndex;


    public Tab01Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview=inflater.inflate(R.layout.fragment_tab01, container, false);
        mAdd=(ImageButton)mview.findViewById(R.id.ib_add);
        mViewPager=(ViewPager)mview.findViewById(R.id.vp_viewpaper);
        mNewsTab01=(TextView)mview.findViewById(R.id.tv_news01);
        mNewsTab02=(TextView)mview.findViewById(R.id.tv_news02);
        mNewsTab03=(TextView)mview.findViewById(R.id.tv_news03);

        mTabline=(ImageView)mview.findViewById(R.id.iv_tabline);
        Display display=getActivity().getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics=new DisplayMetrics();
        display.getMetrics(outMetrics);
        mScreen1_3=outMetrics.widthPixels/3;
        LayoutParams lp=  mTabline.getLayoutParams();
        lp.width=mScreen1_3;
        mTabline.setLayoutParams(lp);

        mDatas = new ArrayList<Fragment>();
        News01Fragment news01=new News01Fragment();
        News02Fragment news02=new News02Fragment();
        News03Fragment news03=new News03Fragment();
        mDatas.add(news01);
        mDatas.add(news02);
        mDatas.add(news03);

        mAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager())
        {
            @Override
            public int getCount()
            {
                return mDatas.size();
            }

            @Override
            public Fragment getItem(int arg0)
            {
                return mDatas.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                resetTextView();
                switch (position)
                {
                    case 0:
                        mNewsTab01.setTextColor(Color.parseColor("#1497f2"));
                        break;
                    case 1:
                        mNewsTab02.setTextColor(Color.parseColor("#1497f2"));
                        break;
                    case 2:
                        mNewsTab03.setTextColor(Color.parseColor("#1497f2"));
                        break;

                }

                mCurrentPageIndex = position;

            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPx)
            {
                Log.e("TAG", position + " , " + positionOffset + " , "
                        + positionOffsetPx);

                LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabline
                        .getLayoutParams();

                if (mCurrentPageIndex == 0 && position == 0)// 0->1
                {
                    lp.leftMargin = (int) (positionOffset * mScreen1_3 + mCurrentPageIndex
                            * mScreen1_3);
                } else if (mCurrentPageIndex == 1 && position == 0)// 1->0
                {
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + (positionOffset - 1)
                            * mScreen1_3);
                } else if (mCurrentPageIndex == 1 && position == 1) // 1->2
                {
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + positionOffset
                            * mScreen1_3);
                } else if (mCurrentPageIndex == 2 && position == 1) // 2->1
                {
                    lp.leftMargin = (int) (mCurrentPageIndex * mScreen1_3 + ( positionOffset-1)
                            * mScreen1_3);
                }
                mTabline.setLayoutParams(lp);

            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub

            }
        });
        initEvent();
        return mview;
    }

    void initEvent(){
        mAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_add:
                Intent intent=new Intent(this.getActivity(),TagActivity.class);
                startActivity(intent);
                break;

        }
    }

    protected void resetTextView()
    {
        mNewsTab01.setTextColor(Color.BLACK);
        mNewsTab02.setTextColor(Color.BLACK);
        mNewsTab03.setTextColor(Color.BLACK);
    }

}
