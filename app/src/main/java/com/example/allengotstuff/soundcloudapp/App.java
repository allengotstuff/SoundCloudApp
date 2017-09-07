package com.example.allengotstuff.soundcloudapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by allengotstuff on 4/5/2017.
 */

public class App extends Application {


    private static volatile OkHttpClient client;

    private static volatile ThreadPoolExecutor myExecutor;

    public static OkHttpClient getHttpClient() {

        if (client == null) {
            synchronized (App.class) {
                if (client == null) {

                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15,TimeUnit.SECONDS)
                            .readTimeout(15,TimeUnit.SECONDS);

                    client =  builder.build();

                }
            }
        }

        return client;
    }

    public static ThreadPoolExecutor getExecutor() {

        if (myExecutor == null) {
            synchronized (App.class) {
                if (myExecutor == null) {
                    myExecutor = new ThreadPoolExecutor(12, 30, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
                }
            }
        }

        return myExecutor;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }





}
