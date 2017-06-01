package com.lin.studysmartrecom.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/6/1.
 */

public class MyApplication extends Application {
    private static Context sContext;
    private static Application sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        sApplication = this;
    }

    public static Context getContext(){
        return sContext;
    }

    public static Application sApplication(){
        return sApplication;
    }
}
