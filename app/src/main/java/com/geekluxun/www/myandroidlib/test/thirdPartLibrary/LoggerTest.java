package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

/**
 * Created by geekluxun on 2016/10/26.
 * Github地址 https://github.com/orhanobut/logger
 */
public class LoggerTest {
    public LoggerTest(){
        //初始化
        if (BuildConfig.BUILD_TYPE.equals("release")){
            Logger.init().logLevel(LogLevel.NONE).methodCount(5);
        } else {
            com.orhanobut.logger.Logger.init("tag").logLevel(LogLevel.FULL).methodCount(3);
        }
        Exception exception = new NullPointerException("不能为空");
        //打印 list
        List list = new ArrayList();
        list.add("123");
        list.add("456");
        list.add("789");
        Logger.d(list);
        //打印 map
        Map<String, String> map = new HashMap<>();
        map.put("name", "luxun");
        map.put("age", "30");
        map.put("addr", "shanghai");
        Logger.d(map);
        //格式化打印
        Logger.i("my name is %s, my age is %d", "luxun", 30);
        Logger.d("my name is %s, my age is %d", "luxun", 30);
        String s = null;
        Logger.e(exception,"luxun");
        //打印json字符串
        Logger.json("{\"name\":\"luxun\",\"age\":30}");

        //打印Throwable
        try {
            s.getBytes();
        } catch (IllegalFormatCodePointException e){
            Logger.e(e, "luxun");
        } catch (Exception e){
            Logger.e(e, "luxun");
        }

        //设置tag
        Logger.t("luxun2").d(list);
        Logger.t("luxun2").i("testluxun");

        //测试方法路径
        test();
    }

    public void test(){
        test2();
    }

    public void test2(){
        Logger.d("hello123");
    }

}
