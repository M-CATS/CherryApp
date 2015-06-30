package cherry.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cherry.cherry.R;
import cherry.widget.Tag;
import cherry.widget.TagListView;
import cherry.widget.TagView;

public class TagActivity extends Activity {
    private TextView mTagDone;

    private TagListView mTagListView;
    private final List<Tag> mTags = new ArrayList<Tag>();
    private final String[] titles = {"安全必备", "音乐", "父母学", "上班族必备",
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
    }

    void initEvent(){
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
