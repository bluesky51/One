package com.exam.sky.one.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.adapter.ReadCommentAdapter;
import com.exam.sky.one.bean.essay.EssayComment;
import com.exam.sky.one.bean.essay.EssayContent;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.view.CustomListView;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EssayDetailActivity extends AppCompatActivity
        implements DataCallback, View.OnClickListener {
    CircleImageView img_head;
    TextView tv_author;
    TextView tv_date;
    TextView tv_title;
    TextView tv_content;
    String id;
    CustomListView listView;

    ImageView img_play;

    TextView tv_detail_title;

    String path;

    ImageView img_return;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay_detail);
        findView();
        id = getIntent().getStringExtra("id");
        getData(id);
        setListener();

    }

    private void setListener() {
        img_play.setOnClickListener(this);
        img_return.setOnClickListener(this);
    }

    private void findView() {
        img_return = (ImageView) findViewById(R.id.img_return);
        img_play = (ImageView) findViewById(R.id.img_play);
        tv_detail_title = (TextView) findViewById(R.id.tv_detail_title);
        tv_detail_title.setText("短篇");
        listView = (CustomListView) findViewById(R.id.comment_Listview);
        img_head = (CircleImageView) findViewById(R.id.img_head);
        tv_author = (TextView) findViewById(R.id.tv_author);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_title = (TextView) findViewById(R.id.tv_title1);
        tv_content = (TextView) findViewById(R.id.tv_content1);
    }

    private void getData(String id) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, String.format(Constants.READING.ESSAY_CONTENT, id), handler);
        httpUtils.getStrByNetWork(2, String.format(Constants.READING.ESSAY_COMMENT_CONTENT, id), handler);
        httpUtils.setDataCallback(this);
    }

    @Override
    public void setDataCallback(int type, String s) {
        switch (type) {
            case 0:
                EssayContent essayContent = JSON.parseObject(s, EssayContent.class);
                path = essayContent.getData().getAudio();
                EssayContent.DataBean.AuthorBean authorBean = essayContent.getData().getAuthor().get(0);
                if (!TextUtils.isEmpty(authorBean.getWeb_url())) {
                    Picasso.with(this).load(authorBean.getWeb_url())
                            .placeholder(R.mipmap.head).into(img_head);
                }
                tv_author.setText(authorBean.getUser_name());
                tv_date.setText(essayContent.getData().getHp_makettime());
                tv_content.setText(Html.fromHtml(essayContent.getData().getHp_content()));
                tv_title.setText(essayContent.getData().getHp_title());
                break;
            case 2:
                EssayComment essayComment = JSON.parseObject(s, EssayComment.class);
                List<EssayComment.DataBean.DataBeans> data = essayComment.getData().getData();
                ReadCommentAdapter adapter = new ReadCommentAdapter(data, this);
                adapter.setType(0);
                listView.setAdapter(adapter);
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_return:
                finish();
                break;
        }
    }
}
