package com.geekluxun.www.myandroidlib.test;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by geekluxun on 2016/8/29.
 */
public class MyApplication extends Application {
    //public final Context mAppContext = getApplicationContext();

    @Override
    public void onCreate() {
        super.onCreate();
        //AutoLayoutConifg.getInstance().useDeviceSize();
        //BigDecimalTest bigDecimalTest = new BigDecimalTest();
        //bigDecimalTest.BigDecimalTest1();
        Fresco.initialize(getApplicationContext());
    }

//    public Context getContext(){
//        return mAppContext;
//    }
}
