package com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test;

import javax.inject.Inject;

/**
 * Created by geekluxun on 2016/11/18.
 */
public class User {
    public String mUserName;
    public String mUserAge;

    @Inject
    public User(){
        mUserName = "geekluxun";
        mUserAge = "20";
    }
}
