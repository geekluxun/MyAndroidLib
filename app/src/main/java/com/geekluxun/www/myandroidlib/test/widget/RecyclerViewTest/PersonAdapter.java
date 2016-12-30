package com.geekluxun.www.myandroidlib.test.widget.RecyclerViewTest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geekluxun.www.myandroidlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Mark.Lu on 2016/12/23.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder>{
    private PersonClickListener clickListener;
    private List<PersonBean> listData;


    public  PersonAdapter(PersonClickListener listener){
        clickListener = listener;
        listData = new ArrayList<>();
    }
    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
        return  new PersonHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        PersonBean bean = listData.get(position);
        holder.name.setText(bean.getName());
        holder.age.setText(bean.getAge());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public interface PersonClickListener{
        void onPersonClick(int position);
    }

    static class  PersonHolder extends  RecyclerView.ViewHolder{
        public TextView name;
        public TextView age;

        public PersonHolder(View itemview , final PersonClickListener clickListener){
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.tvName);
            age = (TextView)itemview.findViewById(R.id.tvAge);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null){
                        clickListener.onPersonClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setListData(List<PersonBean> list){
        listData = list;
        notifyDataSetChanged();
    }

    public void addListData(List<PersonBean> list){
        listData.addAll(list);
        notifyDataSetChanged();
    }
}
