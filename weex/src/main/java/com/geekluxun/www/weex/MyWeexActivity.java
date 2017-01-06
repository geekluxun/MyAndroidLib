package com.geekluxun.www.weex;

import android.os.Bundle;

import com.alibaba.weex.commons.SimpleWeexActivity;

public class MyWeexActivity extends SimpleWeexActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderPageByURL("http://172.16.1.34:8080/geekluxun/test-network-request.js");
    }
}
