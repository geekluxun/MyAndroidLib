package com.geekluxun.www.myandroidlib.test.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.geekluxun.www.myandroidlib.R;
import com.orhanobut.logger.Logger;

/**
 * Created by geekluxun on 2016/12/7.
 */
public class MyDialogTest extends Dialog implements View.OnClickListener{
    ImageView mImageView;

    @Override
    public void onClick(View v) {

    }

    public MyDialogTest(Context context){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dialogView = inflater.inflate(R.layout.dialog_test_layout, null);
        mImageView = (ImageView) dialogView.findViewById(R.id.iv_1);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.i("image height:" + v.getHeight());
            }
        });

        setContentView(dialogView);

        show();
    }
}
