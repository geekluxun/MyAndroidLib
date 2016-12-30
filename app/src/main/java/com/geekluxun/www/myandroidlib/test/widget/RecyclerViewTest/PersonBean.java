package com.geekluxun.www.myandroidlib.test.widget.RecyclerViewTest;

import java.io.Serializable;

/**
 * Created by mark on 2016/12/23.
 */

public class PersonBean implements Serializable{
    private static final long serialVersionUID = 5071606360468239565L;
    private String name;
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
