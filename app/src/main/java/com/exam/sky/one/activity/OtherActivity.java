package com.exam.sky.one.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.exam.sky.one.R;
import com.exam.sky.one.utils.Preferenceutils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rl_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        rl_exit = (RelativeLayout) findViewById(R.id.rl_exit);
        rl_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_exit:


               final  SharedPreferences sp = getSharedPreferences(Preferenceutils.LOGIN_INFO, Context.MODE_PRIVATE);
                if (sp.getBoolean(Preferenceutils.IS_LOGIN,false)==true){
                    //已登录
                    new AlertDialog.Builder(this)
                            .setTitle("亲，确认退出登录吗?")
                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    String platformName=  sp.getString(Preferenceutils.PLATROM_NAME,"");
                                    ShareSDK.initSDK(OtherActivity.this);
                                    Platform p  = ShareSDK.getPlatform(OtherActivity.this,platformName);
                                    p.removeAccount();

                                    sp.edit().clear().commit();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create().show();



                }else{
                    //未登录
                    Toast.makeText(this,"未登录",Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}
