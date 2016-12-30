package com.geekluxun.www.myandroidlib.test.java;

import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by geekluxun on 2016/9/12.
 */
public class BigDecimalTest {
    private static  final  String  TAG = "BigDecimalTest";

    public void BigDecimalTest(){

        float f[] = {0.010f, 2.510f, 2.515f, 2.516f, -2.510f, -2.511f, -2.515f, -2.516f};


        DecimalFormat df = new DecimalFormat("0.00");
        /**
         * 0.010f 使用Down模式值为0.00而不是0.01  但0.011 则为0.01 特此注意！！！
         */
        //靠近零舍入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.DOWN);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_DOWN" + ":" +  bg.setScale(2, BigDecimal.ROUND_DOWN));
        }

        //远离零舍入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.UP);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_UP" + ":" +  bg.setScale(2, BigDecimal.ROUND_UP));
        }

        //5舍6入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.HALF_DOWN);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_HALF_DOWN" + ":" +  bg.setScale(2, BigDecimal.ROUND_HALF_DOWN));
        }

        //4舍5入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.HALF_UP);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_HALF_UP" + ":" +  bg.setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        //向靠近无穷大舍入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.CEILING);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_CEILING" + ":" +  bg.setScale(2, BigDecimal.ROUND_CEILING));
        }

        //向靠近无穷小舍入
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.FLOOR);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_FLOOR" + ":" +  bg.setScale(2, BigDecimal.ROUND_FLOOR));
        }

        //前一位是奇数 同 HALF_UP  前一位位是偶数  同 HALF_DOWN
        for (float ff: f ) {
            df.setRoundingMode(RoundingMode.HALF_EVEN);
            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));

            BigDecimal bg = new BigDecimal(ff);
            Log.i(TAG, ff + " " + "ROUND_HALF_EVEN" + ":" +  bg.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        }

//        for (float ff: f ) {
//            df.setRoundingMode(RoundingMode.UNNECESSARY);
//            Log.i(TAG, ff + " " + df.getRoundingMode().toString() + ":" + df.format(ff));
//        }
    }
}
