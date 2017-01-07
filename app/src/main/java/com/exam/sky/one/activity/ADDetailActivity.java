package com.exam.sky.one.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.adapter.AdDetailAdapter;
import com.exam.sky.one.bean.MainReadAdData;
import com.exam.sky.one.bean.ReadAdDetailBean;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.squareup.picasso.Picasso;

public class ADDetailActivity extends AppCompatActivity implements DataCallback {

    RelativeLayout rl_bg;
    TextView tv_ad_detail_title;
    ListView listView;

    Handler handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addetail);
        rl_bg = (RelativeLayout) findViewById(R.id.bg);
        listView = (ListView) findViewById(R.id.ad_detail_listview);
        tv_ad_detail_title = (TextView) findViewById(R.id.tv_ad_detail_title);
        MainReadAdData.DataBean dataBean = getIntent().getParcelableExtra("dataBean");
        String path = String.format(Constants.READING.READING_AD_DETIL_PATH, dataBean.getId());
        tv_ad_detail_title.setText(dataBean.getTitle());
        rl_bg.setBackgroundColor(Color.parseColor(dataBean.getBgcolor()));
        ImageView imageView =new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
        Picasso.with(this).load(dataBean.getCover()).config(Bitmap.Config.RGB_565).into(imageView);
        listView.addFooterView(imageView);
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, path,handler);
        httpUtils.setDataCallback(this);

        findViewById(R.id.img_base_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              startActivity(new Intent(ADDetailActivity.this,MainActivity.class));
                overridePendingTransition(0,R.anim.down_out);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ADDetailActivity.this,MainActivity.class));
        overridePendingTransition(0,R.anim.down_out);
    }

    @Override
    public void setDataCallback(int type, String s) {
        ReadAdDetailBean detailBean = JSON.parseObject(s, ReadAdDetailBean.class);
        listView.setAdapter(new AdDetailAdapter(detailBean.getData(),this));


    }
}
