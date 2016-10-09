package com.geekluxun.www.myandroidlib.test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.geekluxun.www.myandroidlib.R;

public class MainActivity extends AppCompatActivity  implements MyFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
        //startActivity(new Intent(MainActivity.this, MyActivity.class));
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
}
