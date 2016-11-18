package com.geekluxun.www.myandroidlib.test.java.annotations.handle;

import com.geekluxun.www.myandroidlib.test.java.annotations.Test;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by geekluxun on 2016/11/18.
 * test注解处理器
 */
public class HandleTestAnnotation {
    public static void handleTestAnnotion(List<Integer> test, Class<?> cl){
        for(Method m: cl.getDeclaredMethods()){
            Test test1 = m.getAnnotation(Test.class);
            if (test1 != null){
                test.remove(new Integer(test1.id()));
                Logger.i("found test: id=%d, des= %s",test1.id(), test1.name());
            }
        }

        for (int i: test){
            Logger.i("missing test:%d" , i);
        }
    }
}
