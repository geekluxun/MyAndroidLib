package com.geekluxun.www.myandroidlib.test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.geekluxun.www.myandroidlib.R;
import com.geekluxun.www.myandroidlib.test.java.annotations.Test;
import com.geekluxun.www.myandroidlib.test.java.annotations.handle.HandleTestAnnotation;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.RxJavaTest;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test.ActivityComponent;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test.ActivityModule;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test.DaggerActivityComponent;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.dagger2Test.User;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends Activity implements MyFragment.OnFragmentInteractionListener{
    private static final String TAG = "MainActivity";
    private ActivityComponent mActivityComponent; //注入器 完成依赖和消费依赖的连接

    @Inject
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init(TAG).methodCount(0).hideThreadInfo();
        Logger.t(TAG).i("onCreate");
        setContentView(R.layout.activity_main);
        addFragment();
        initTest();
    }

    public void addFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MyFragment myFragment = MyFragment.newInstance("p1", "p2");
        ft.replace(R.id.fragment, (Fragment) myFragment);
        //ft.add(R.id.fragment, (Fragment) myFragment);
        ft.addToBackStack(null);
        try {
            ft.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * 测试初始化
     */
    @Test(id = 3, name = "mytest")
    public void initTest(){
        //LoggerTest loggerTest = new LoggerTest();
        //TimberTest timberTest = new TimberTest();
        //startActivity(new Intent(MainActivity.this, FrescoTestActivity.class));
        new RxJavaTest();
        handleTestAnnotation();
        testDagger2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onAttachedToWindow() {
        Logger.i("onAttachedToWindow");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Logger.i("onAttachFragment");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Logger.i("onConfigurationChanged");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.i("onStop");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.i("onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Logger.i("onResume:" + getLocalClassName());
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.i("onRestart");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.i("onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.i("onRestoreInstanceState");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i("onDestroy");

    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.i("onDetachedFromWindow");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.i("onPause");
    }

    /**
     * 自定义注解test处理器
     */
    public void handleTestAnnotation(){
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        HandleTestAnnotation.handleTestAnnotion(list, MainActivity.class);
    }

    /**
     * 测试dagger2 注入对象 User
     */
    public void testDagger2(){
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        mActivityComponent.inject(this);
        Logger.i("user: %s, %s", mUser.mUserName , mUser.mUserAge);
    }

}
