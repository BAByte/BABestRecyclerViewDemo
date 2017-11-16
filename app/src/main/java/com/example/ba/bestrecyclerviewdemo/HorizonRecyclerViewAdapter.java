package com.example.ba.bestrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BA on 2017/11/16 0016.
 *
 * @Function : 水平RecuyclerView的Adapter
 */

public class HorizonRecyclerViewAdapter extends RecyclerView.Adapter<HorizonRecyclerViewAdapter.NormalViewHolder> {
    List<String> list;
    Context context;
    public HorizonRecyclerViewAdapter(Context context, List<String> list){
        this.list=list;
        this.context=context;
    }

    static class NormalViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public NormalViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.recycler_view_horizon_item_text);
        }
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_itemlayout_horizon_list_item,parent,false);
        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
