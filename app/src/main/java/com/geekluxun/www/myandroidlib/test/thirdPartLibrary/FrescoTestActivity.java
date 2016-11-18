package com.geekluxun.www.myandroidlib.test.thirdPartLibrary;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.drawee.view.SimpleDraweeView;
import com.geekluxun.www.myandroidlib.R;

/**
 * Created by geekluxun on 2016/11/17.
 */
public class FrescoTestActivity  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_test);
        loadImage();
    }


    public void loadImage(){
        //网络获取
        //Uri uri = Uri.parse("http://img3.imgtn.bdimg.com/it/u=1444979405,2171488504&fm=21&gp=0.jpg");
        //本地资源
        String url = "res://com.geekluxun.www.myandroidlib/" + R.mipmap.ic_launcher;
        Uri uri = Uri.parse(url);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.sv_image);
        draweeView.setImageURI(uri);
    }
}
