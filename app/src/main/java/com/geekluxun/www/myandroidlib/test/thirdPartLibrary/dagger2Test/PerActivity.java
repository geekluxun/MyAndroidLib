package com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by geekluxun on 2016/11/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}