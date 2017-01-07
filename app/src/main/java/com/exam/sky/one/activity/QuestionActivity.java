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
import com.exam.sky.one.bean.question.QuestionComment;
import com.exam.sky.one.bean.question.QuestionContent;
import com.exam.sky.one.bean.question.QuestionRelated;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.view.CustomListView;

import java.util.List;

public class QuestionActivity extends AppCompatActivity implements DataCallback,View.OnClickListener {
    TextView tv_detail_title;
    CustomListView commentListView;
    CustomListView relatedListView;
    ImageView img_return;

    TextView tv_question_title;
    TextView tv_question_content;
    TextView tv_answer_title;
    TextView tv_answer_content;
    TextView tv_answer_date;

    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        findView();
        String id = getIntent().getStringExtra("id");
        getData(id);
        img_return.setOnClickListener(this);
    }

    private void getData(String id) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, String.format(Constants.READING.QUESTION_CONTENT, id),handler);
        httpUtils.getStrByNetWork(1, String.format(Constants.READING.QUESTION_RELATED_CONTENT, id),handler);
        httpUtils.getStrByNetWork(2,String.format(Constants.READING.QUESTION_COMMENT_CONTENT, id),handler);
        httpUtils.setDataCallback(this);
    }


    private void  findView(){
       img_return = (ImageView) findViewById(R.id.img_return);
       tv_detail_title = (TextView) findViewById(R.id.tv_detail_title);
       relatedListView= (CustomListView) findViewById(R.id.related_Listview);
       commentListView= (CustomListView) findViewById(R.id.comment_Listview);
       tv_detail_title.setText("问答");


       tv_question_title = (TextView) findViewById(R.id.tv_question_title);
       tv_question_content = (TextView) findViewById(R.id.tv_question_desc);
       tv_answer_title = (TextView) findViewById(R.id.tv_answer_title);
       tv_answer_content = (TextView) findViewById(R.id.tv_answer_desc);
       tv_answer_date = (TextView) findViewById(R.id.tv_answer_date);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_return:
                finish();
                break;
        }
    }

    @Override
    public void setDataCallback(int type, String s) {
        switch (type) {
            case 0:
                QuestionContent questionContent = JSON.parseObject(s, QuestionContent.class);
                QuestionContent.DataBean dataBean  = questionContent.getData();
                tv_answer_title.setText(dataBean.getAnswer_title());
                tv_answer_content.setText(Html.fromHtml(dataBean.getAnswer_content()));
                tv_question_content.setText(dataBean.getQuestion_content());
                tv_question_title.setText(dataBean.getQuestion_title());
                tv_answer_date.setText(dataBean.getQuestion_makettime());
                break;
            case 1:
                QuestionRelated questionRelated = JSON.parseObject(s, QuestionRelated.class);
                List<QuestionRelated.DataBean> related_data = questionRelated.getData();
                RelatedAdapter relatedAdapter =new RelatedAdapter(related_data,this);
                relatedAdapter.setType(1);
                relatedListView.setAdapter(relatedAdapter);
                break;
            case 2:
                QuestionComment questionComment =JSON.parseObject(s, QuestionComment.class);
                List<QuestionComment.DataBean.DataBeans> comment_data = questionComment.getData().getData();
                ReadCommentAdapter adapter = new ReadCommentAdapter(comment_data,QuestionActivity.this);
                adapter.setType(1);
                commentListView.setAdapter(adapter);
                break;
        }

    }



}
