package com.changlg.cn.loglg;

import android.app.Application;

/**
 * Created by chang on 2016/4/12.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Loglg.init(BuildConfig.LOG_SWITCH);
    }
}
