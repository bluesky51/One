package com.exam.sky.one.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.adapter.ReadCommentAdapter;
import com.exam.sky.one.adapter.RelatedAdapter;
import com.exam.sky.one.bean.serial.SerialComment;
import com.exam.sky.one.bean.serial.SerialContent;
import com.exam.sky.one.bean.serial.SerialRelated;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.view.CustomListView;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SerialDetailActivity extends AppCompatActivity implements DataCallback, View.OnClickListener {
    TextView tv_detail_title;
    CustomListView commentListView;
    CustomListView relatedListView;
    ImageView img_return;


    CircleImageView img_head;
    TextView tv_author;
    TextView tv_date;
    TextView tv_title;
    TextView tv_content;
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_serial);
        findView();
        String id = getIntent().getStringExtra("id");
        getData(id);
        img_return.setOnClickListener(this);
    }

    private void getData(String id) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0,  String.format(Constants.READING.SERIAL_CONTENT, id),handler);
        httpUtils.getStrByNetWork(1, String.format(Constants.READING.SERIAL_RELATED_CONTENT, id),handler);
        httpUtils.getStrByNetWork(2, String.format(Constants.READING.SERIAL_COMMENT_CONTENT, id),handler);
        httpUtils.setDataCallback(this);
    }

    private void findView() {
        img_return = (ImageView) findViewById(R.id.img_return);
        commentListView = (CustomListView) findViewById(R.id.comment_Listview);
        relatedListView = (CustomListView) findViewById(R.id.related_Listview);
        tv_detail_title = (TextView) findViewById(R.id.tv_detail_title);
        tv_detail_title.setText("连载");

        img_head = (CircleImageView) findViewById(R.id.img_head);
        tv_author = (TextView) findViewById(R.id.tv_author);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_title = (TextView) findViewById(R.id.tv_title1);
        tv_content = (TextView) findViewById(R.id.tv_content1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_return:
                finish();
                break;
        }
    }

    @Override
    public void setDataCallback(int type, String s) {
        switch (type) {
            case 0:
                SerialContent serialContent = JSON.parseObject(s,SerialContent.class);
                Picasso.with(this).load(serialContent.getData().getWeb_url())
                        .placeholder(R.mipmap.head).into(img_head);
                tv_author.setText(serialContent.getData().getAuthor().getUser_name());
                tv_date.setText(serialContent.getData().getMaketime());
                tv_content.setText(Html.fromHtml(serialContent.getData().getContent()));
                tv_title.setText(serialContent.getData().getTitle());

                break;
            case 1:
                SerialRelated serialRelated = JSON.parseObject(s, SerialRelated.class);
                List<SerialRelated.DataBean> dataBeanList = serialRelated.getData();
                RelatedAdapter relatedAdapter =new RelatedAdapter(dataBeanList,this);
                relatedAdapter.setType(0);
                 relatedListView.setAdapter(relatedAdapter);
                break;
            case 2:
                SerialComment serialComment = JSON.parseObject(s, SerialComment.class);
                List<SerialComment.DataBean.DataBeans> dataBeanses = serialComment.getData().getData();
                ReadCommentAdapter adapter = new ReadCommentAdapter(dataBeanses, SerialDetailActivity.this);
                adapter.setType(2);
                commentListView.setAdapter(adapter);
                break;
        }
    }
}
