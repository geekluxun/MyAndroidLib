package com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test;

import com.geekluxun.www.myandroidlib.test.MainActivity;
import dagger.Component;

/**
 * Created by geekluxun on 2016/11/18.
 */
@com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test.PerActivity
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
