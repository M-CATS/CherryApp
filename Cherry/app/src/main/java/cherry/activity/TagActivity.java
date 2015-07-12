package cherry.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cherry.cherry.R;
import cherry.widget.Tag;
import cherry.widget.TagListView;
import cherry.widget.TagView;

public class TagActivity extends Activity {
    private TextView mTagDone;
    private Button mButtonSet;
    private TagListView mTagListView;
    private Context mContext;
    private TextView mInput;
    private List<Tag> mTags = new ArrayList<Tag>();
    private String[] titles = {"安全必备", "音乐", "父母学", "上班族必备",
            "360手机卫士", "QQ", "输入法", "微信", "最美应用", "AndevUI", "蘑菇街"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_tag_activity);
        initView();
        initEvent();
    }

    void initView(){
        mTagListView = (TagListView) findViewById(R.id.tagview);
        setUpData();
        mTagListView.setTags(mTags);
        mTagDone=(TextView)findViewById(R.id.tag_done);
        mButtonSet=(Button)findViewById(R.id.button_set);
    }

    void initEvent(){
        mContext=this;
        mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView tagView, Tag tag) {
                if (tag.isChecked() == false) {
                    tagView.setTextColor(Color.parseColor("#ffffff"));
                    tagView.setBackgroundResource(R.drawable.tag_bg2);
                    tag.setChecked(true);
                } else if (tag.isChecked() == true) {
                    tagView.setTextColor(Color.parseColor("#009688"));
                    tagView.setBackgroundResource(R.drawable.tag_bg);
                    tag.setChecked(false);
                }

            }
        });
        mTagDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputServer = new EditText(mContext);
                inputServer.setFilters(new InputFilter[]{new InputFilter.LengthFilter(26)});
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("自定义标签").setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }


    private void setUpData() {
        for (int i = 0; i < 10; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(false);
            tag.setTitle(titles[i]);
            mTags.add(tag);
        }
    }
}
