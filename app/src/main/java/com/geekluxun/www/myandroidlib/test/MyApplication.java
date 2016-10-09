package com.geekluxun.www.myandroidlib.test;

import android.app.Application;

import com.geekluxun.www.myandroidlib.test.java.BigDecimalTest;

/**
 * Created by geekluxun on 2016/8/29.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //AutoLayoutConifg.getInstance().useDeviceSize();
        BigDecimalTest bigDecimalTest = new BigDecimalTest();
        bigDecimalTest.BigDecimalTest1();
    }
}
