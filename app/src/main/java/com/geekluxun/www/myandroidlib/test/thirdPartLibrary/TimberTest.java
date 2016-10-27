package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import com.geekluxun.www.myandroidlib.BuildConfig;

import timber.log.Timber;

/**
 * Created by mark on 2016/10/27.
 * Github地址 https://github.com/JakeWharton/timber
 */
public class TimberTest {

    public TimberTest() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            //Timber.plant(new CrashReportingTree());
        }
        Timber.tag("Timber");
        Timber.i("Activity Created1");
        Timber.i("I am %s, year is %d", "luxun", 2016);


        Timber.e(new NullPointerException("err"),"luxun");
        Timber.d("I am %s, year is %d", "luxun", 2016);
    }

    /** A tree which logs important information for crash reporting. */
//    private static class CrashReportingTree extends Timber.Tree {
//        @Override protected void log(int priority, String tag, String message, Throwable t) {
//            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
//                return;
//            }
//
//            FakeCrashLibrary.log(priority, tag, message);
//
//            if (t != null) {
//                if (priority == Log.ERROR) {
//                    FakeCrashLibrary.logError(t);
//                } else if (priority == Log.WARN) {
//                    FakeCrashLibrary.logWarning(t);
//                }
//            }
//        }
//    }
}
