package com.exam.sky.one.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.utils.Preferenceutils;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * 使用RenderScript实现高斯模糊背景图：(RenderScript是android平台上进行高性能计算的库，对图像处理功能非常强大，只适用于png图)
 * 1.优点：使用RenderScript方式速度极快，约为java方式的100被处理速度，NDK方法20倍速度(不同图片质量测试结果不同)
 * 2.缺点:Api17以上有效，兼容后续介绍
 */
public class LoginActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView = (TextView) findViewById(R.id.agree);
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        textView.getPaint().setAntiAlias(true);//抗锯齿
    }

    public void back(View view) {
        finish();
    }

    public void qqLogin(View view) {

        login(QQ.NAME);
    }

    public void wechatLogin(View view) {
        login(Wechat.NAME);
    }

    public void sinaLogin(View view) {
        login(SinaWeibo.NAME);
    }

    public void login(String name) {
        ShareSDK.initSDK(this);
        final Platform p = ShareSDK.getPlatform(this, name);
        p.SSOSetting(false);
        p.showUser(null);
        p.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                String icon = platform.getDb().getUserIcon();
                String name = platform.getDb().getUserName();

                SharedPreferences sp = getSharedPreferences(Preferenceutils.LOGIN_INFO, Context.MODE_PRIVATE);
                sp.edit().putString(Preferenceutils.USE_RNAME, name)
                        .putString(Preferenceutils.IMG_HEAD, icon)
                        .putBoolean(Preferenceutils.IS_LOGIN, true)
                        .putString(Preferenceutils.PLATROM_NAME, platform.getName()).commit();

                Intent intent=new Intent(LoginActivity.this,LoginActivity.class);
                intent.putExtra(Preferenceutils.USE_RNAME,name);
                intent.putExtra(Preferenceutils.IMG_HEAD,icon);
                setResult(RESULT_OK,intent);
                finish();

            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(Platform platform, int i) {

            }
        });

    }
}
