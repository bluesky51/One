package com.exam.sky.one.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.exam.sky.one.R;
import com.exam.sky.one.utils.ShareUtils;

import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

public class ShareActivity extends AppCompatActivity {

    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        path = getIntent().getStringExtra("path");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(0, R.anim.down_out);
    }

    public void wechatFri(View view) {
        ShareUtils.ShareContent(this, Wechat.NAME);

    }

    public void wechatMoments(View view) {
        ShareUtils.ShareContent(this, WechatMoments.NAME);
    }

    public void sinaWeibo(View view) {
        ShareUtils.ShareContent(this, SinaWeibo.NAME);
    }

    public void QQ(View view) {
        ShareUtils.ShareContent(this, QQ.NAME);
    }

    public void copyLink(View view) {
        //复制到剪贴板
        copy(path,this);

    }

    public void storage(View view) {
        //收藏到本地

    }

    /**
     * 实现文本复制功能
     * add by wangqianzhou
     * @param content
     */
    public static void copy(String content, Context context)
    {
// 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(content.trim());
        Toast.makeText(context,"已成功复制到剪贴板",Toast.LENGTH_LONG).show();
    }
    /**
     * 实现粘贴功能
     * add by wangqianzhou
     * @param context
     * @return
     */
    public static String paste(Context context)
    {
// 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        return cmb.getText().toString().trim();
    }
}
