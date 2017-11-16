package com.example.ba.bestrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by BA on 2017/11/16 0016.
 *
 * @Function : 水平展示的ViewHolder
 */

public class HorizonViewHolder  extends RecyclerView.ViewHolder{
    static final int TYPE_HORIZON=4; //ViewHolder的类型
    RecyclerView recyclerView;

    public HorizonViewHolder( View itemView){
        super(itemView);
        recyclerView=(RecyclerView)itemView.findViewById(R.id.recycler_view_horizon);
    }

    public void setData(Context context,List<String> list){
        recyclerView.setAdapter(new HorizonRecyclerViewAdapter(context,list));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
