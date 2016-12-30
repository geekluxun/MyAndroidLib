package com.geekluxun.www.myandroidlib.test.widget.RecyclerViewTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geekluxun.www.myandroidlib.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewTestActivity extends AppCompatActivity {
    @Bind(R.id.rvPerson)
    RecyclerView mRecyclerView;

    PersonAdapter personAdapter;

    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);
        ButterKnife.bind(this);

        initData();
    }


    public void initData(){
        list = new ArrayList<PersonBean>();
        PersonBean bean = new PersonBean();
        bean.setAge("22");
        bean.setName("MarkLu");

        list.add(bean);
        list.add(bean);
        list.add(bean);
        personAdapter = new PersonAdapter(new PersonAdapter.PersonClickListener() {
            @Override
            public void onPersonClick(int position) {

            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(personAdapter);
        personAdapter.setListData(list);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    Logger.i("onScrollStateChanged");
                    personAdapter.addListData(list);
                }
            }
        });
    }
}
