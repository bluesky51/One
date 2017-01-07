package com.exam.sky.one.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.exam.sky.one.R;
import com.exam.sky.one.adapter.SearchAdapter;
import com.exam.sky.one.fragment.SearchContentFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView img_back;
    @BindView(R.id.search)
    ImageView img_search;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.tip)
    ImageView img_tip;
    @BindView(R.id.search_vp)
    ViewPager search_vp;
    @BindView(R.id.search_tabLayout)
    TabLayout search_tab;

    String[] titles = new String[]{"插图", "阅读", "音乐", "影视", "作者/音乐人"};
    List<Fragment> fragmentList;

    @BindView(R.id.layout_content)
    RelativeLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void back(View view) {
        finish();
    }

    @OnClick(R.id.search)
    public void search(View view) {
        String key = et_content.getText().toString();
        if (!TextUtils.isEmpty(key)) {
            img_tip.setVisibility(View.GONE);
            frameLayout.setVisibility(View.VISIBLE);
            setSearchContentView(key);
        } else {
            img_tip.setVisibility(View.VISIBLE);
            frameLayout.setVisibility(View.GONE);
        }


    }

    public void setSearchContentView(String key) {
        fragmentList = new ArrayList<>();
        search_tab.setTabTextColors(Color.parseColor("#88878787"), Color.parseColor("#0000ff"));
        search_tab.setSelectedTabIndicatorColor(Color.parseColor("#0000ff"));
        search_tab.setSelectedTabIndicatorHeight(5);
        for (int i = 0; i < titles.length; i++) {
            search_tab.addTab(search_tab.newTab().setText(titles[i]));
            SearchContentFragment contentFragment = new SearchContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", key);
            bundle.putInt("pos", i);
            contentFragment.setArguments(bundle);
            fragmentList.add(contentFragment);
        }
        SearchAdapter adapter = new SearchAdapter(
                getSupportFragmentManager(), fragmentList, titles);
        search_vp.setAdapter(adapter);

        search_tab.setupWithViewPager(search_vp);
    }
}
