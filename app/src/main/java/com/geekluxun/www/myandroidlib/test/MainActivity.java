package com.geekluxun.www.myandroidlib.test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import com.geekluxun.www.myandroidlib.R;
import com.geekluxun.www.myandroidlib.test.thirdPartLibrary.TimberTest;

public class MainActivity extends AppCompatActivity  implements MyFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
        //startActivity(new Intent(MainActivity.this, MyActivity.class));
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
    public void initTest(){
        //LoggerTest loggerTest = new LoggerTest();
        TimberTest timberTest = new TimberTest();
    }
}
