package cherry.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import cherry.activity.TagActivity;
import cherry.cherry.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Tab01Fragment extends Fragment implements View.OnClickListener {
    private ImageButton mAdd;


    public Tab01Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mview=inflater.inflate(R.layout.fragment_tab01, container, false);
        mAdd=(ImageButton)mview.findViewById(R.id.ib_add);
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

}
