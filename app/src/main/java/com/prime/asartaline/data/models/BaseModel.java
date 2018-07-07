package com.prime.asartaline.data.models;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.prime.asartaline.network.ASarTaLineAPI;
import com.prime.asartaline.persistence.WarDeeDB;
import com.prime.asartaline.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class BaseModel {

    protected ASarTaLineAPI mTheAPI;
    protected WarDeeDB mTheDB;

    protected BaseModel(Context context){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mTheAPI  = retrofit.create(ASarTaLineAPI.class);
        mTheDB = WarDeeDB.getDatabase(context);
    }
}
