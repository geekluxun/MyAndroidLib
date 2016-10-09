package com.geekluxun.www.myandroidlib.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.geekluxun.www.myandroidlib.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by geekluxun on 2016/8/29.
 */
public class AutoLayoutTestActivity extends AutoLayoutActivity {
    private final String Tag = "AutoLayoutTestActivity";
    @Bind(R.id.ll_1)
    LinearLayout mLl1;
    @Bind(R.id.btn_1)
    Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autolayout_test2);
        ButterKnife.bind(this);
        testWidthHeightPxValue();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void testWidthHeightPxValue() {
        ViewGroup.LayoutParams layoutParams = mLl1.getLayoutParams();
        Log.i(Tag, "width:" + layoutParams.width);
        Log.i(Tag, "height:" + layoutParams.height);
    }

    @OnClick(R.id.btn_1)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                testWidthHeightPxValue();
                break;
            default:
                break;
        }
    }
}
