package com.changlg.cn.loglg;

import android.app.Application;

import com.libs.chang.loglib.Loglg;

/**
 * 全局配置
 * Created by chang on 2016/4/12.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // 这里配置全局Log的显示
        Loglg.init(BuildConfig.DEBUG);
    }
}
