package com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test;

import dagger.Module;
import dagger.Provides;

/**
 * Created by geekluxun on 2016/11/18.
 */

@Module
public class ActivityModule {

    @Provides
    User provideUser(){
        return new User();
    }
}
