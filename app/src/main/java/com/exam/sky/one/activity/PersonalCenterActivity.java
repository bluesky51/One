package com.exam.sky.one.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.utils.Preferenceutils;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalCenterActivity extends AppCompatActivity implements View.OnClickListener {

    CircleImageView img_head;
    TextView tv_userName;
    RelativeLayout rl_other_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        img_head = (CircleImageView) findViewById(R.id.head);
        tv_userName = (TextView) findViewById(R.id.userName);
        rl_other_setting = (RelativeLayout) findViewById(R.id.rl_other_setting);
        rl_other_setting.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setLoginStatus();
    }

    private void setLoginStatus() {
        SharedPreferences sp = getSharedPreferences(Preferenceutils.LOGIN_INFO, Context.MODE_PRIVATE);
        if (sp.getBoolean(Preferenceutils.IS_LOGIN,false)==true){
           //已登录
            Picasso.with(this).load(sp.getString(Preferenceutils.IMG_HEAD,""))
                    .placeholder(R.mipmap.head)
                    .into(img_head);
            tv_userName.setText(sp.getString(Preferenceutils.USE_RNAME,""));
            img_head.setEnabled(false);
        }else{
            //未登录
            img_head.setImageResource(R.mipmap.head);
            tv_userName.setText("未登录");
            img_head.setEnabled(true);

        }

    }

    public void login(View view){

        startActivityForResult(new Intent(this,LoginActivity.class),100);
    }
    public void back(View view){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            if (resultCode==RESULT_OK){
                if (data!=null){
                    Picasso.with(this)
                            .load(data.getStringExtra(Preferenceutils.IMG_HEAD))
                            .placeholder(R.mipmap.head).into(img_head);
                    tv_userName.setText(data.getStringExtra(Preferenceutils.USE_RNAME));
                    img_head.setEnabled(false);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_other_setting:
                startActivity(new Intent(this,OtherActivity.class));
                break;
        }
    }
}
