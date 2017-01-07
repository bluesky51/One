package com.exam.sky.one.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.search.AuthorBean;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class AuthorActivity extends AppCompatActivity {


    @BindView(R.id.userName)
    TextView tv_userName;
    @BindView(R.id.userDesc)
    TextView tv_userDesc;
    @BindView(R.id.head)
    CircleImageView img_head;
    @BindView(R.id.back)
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        ButterKnife.bind(this);
        AuthorBean.DataBean dataBean = getIntent().getParcelableExtra("data");
        tv_userName.setText(dataBean.getUser_name());
        tv_userDesc.setText(dataBean.getDesc());
        Picasso.with(this).load(dataBean.getWeb_url()).into(img_head);

    }
    @OnClick(R.id.back)
    public void back(View view){
        finish();

    }
}
