package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geekluxun.www.myandroidlib.R;

public class GlideTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);

        ImageView imageView = (ImageView) findViewById(R.id.iv_1);
        Glide.with(GlideTestActivity.this).load("http://img3.imgtn.bdimg.com/it/u=1444979405,2171488504&fm=21&gp=0.jpg").into(imageView);

    }
}
