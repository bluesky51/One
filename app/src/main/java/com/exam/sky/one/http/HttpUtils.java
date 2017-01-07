package com.exam.sky.one.http;

import android.os.Handler;

import com.exam.sky.one.callback.DataCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bluesky on 16/9/13.
 */
public class HttpUtils {
    public static HttpUtils httpUtils = null;
    DataCallback dataCallback;
    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.dataCallback = dataCallback;
    }

    public  void getStrByNetWork(final int type, final String path,final Handler handler ) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        final Request request=new Request.Builder().url(path).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                final String str = response.body().string();
                if (dataCallback != null&&str!=null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            dataCallback.setDataCallback(type, str);

                        }
                    });


                }
            }
        });



    }
}
