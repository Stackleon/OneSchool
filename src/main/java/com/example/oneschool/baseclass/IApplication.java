package com.example.oneschool.baseclass;

import android.app.Application;

/**
 * Created by leon on 2015/12/18.
 */
public class IApplication extends Application {
    public static final boolean debugOn = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
