package com.bawei.mengxyan.util;

import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @包名 com.bawei.mengxyan.util
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名Mengxyan
 * @类名NetUtil
 **/
public class NetUtil {
    private static NetUtil netUtil;
    private final OkHttpClient okHttpClient;
    private Handler handler;


    private NetUtil() {
        handler = new Handler();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor httpLoggingInterceptor1 = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static NetUtil getInstance() {
        if (netUtil == null) {
            synchronized (NetUtil.class) {
                if (netUtil == null) {
                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void getJson(String u, ImyCback imyCback) {
        Request request = new Request.Builder()
                .get()
                .url(u)
                .build();
        Call call = okHttpClient.newCall(request);
       call.enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
             imyCback.doErro(e);
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               if (request != null&&response.isSuccessful()) {
                   String string = response.body().string();
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         imyCback.doGetSering(string);
                     }
                 });
               }else {
                   imyCback.doErro(new Exception("失败"));
               }
           }
       });

    }
    public void postJson(String u, ImyCback imyCback) {
        Request request = new Request.Builder()
                .get()
                .url(u)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                imyCback.doErro(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (request != null&&response.isSuccessful()) {
                    String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imyCback.doGetSering(string);
                        }
                    });
                }else {
                    imyCback.doErro(new Exception("失败"));
                }
            }
        });

    }
    public interface ImyCback {
        void doGetSering(String s);

        void doErro(Throwable throwable);
    }
}
