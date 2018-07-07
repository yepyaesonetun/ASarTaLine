package com.prime.asartaline.root;

import android.app.Application;

import com.prime.asartaline.data.models.WarDeeModel;

/**
 * Created by yepyaesonetun on 7/5/18.
 **/

public class WarDeeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        WarDeeModel.initWarDeeModel(this);
    }
}
