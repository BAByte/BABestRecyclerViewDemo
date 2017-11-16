package com.example.ba.bestrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BA on 2017/11/6 0006.
 *
 * @Function : 实现一个包含headView和FootView和嵌套横向滑动的RecyclerVIew，
 * 符合RecyclerVIew的设计思想，主要针对ViewHolder设置
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MyData> datas;
    private Context mContext;
    private final int TYPE_NORMAL = 3;

    public MyRecyclerViewAdapter(Context context, List<MyData> datas) {
        mContext = context;
        this.datas = datas;
    }


    //普通的ViewHolder
    static class NormalViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public NormalViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }


    /**
     *@fuction 根据View类型来初始化ViewHolder
     *@parm
     *@return
     *@exception
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == FootViewHolder.TYPE_FOOT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_itemlayout_foot, parent, false);
            viewHolder = new FootViewHolder(view);
        } else if (viewType == HeadViewHolder.TYPE_HEAD) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_itemlayout_head, parent, false);
            viewHolder = new HeadViewHolder(view);
        } else if (viewType == HorizonViewHolder.TYPE_HORIZON) {
            Log.d("aaaaa", "onCreateViewHolder: horizon");
            View view=LayoutInflater.from(mContext).inflate(R.layout.recyclerview_itemlayout_horizon_list,parent,false);
            viewHolder=new HorizonViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_itemlayout, parent, false);
            viewHolder = new NormalViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //根据View的类型来初始化数据
        int viewType = getItemViewType(position);
        if (viewType != FootViewHolder.TYPE_FOOT && viewType != HeadViewHolder.TYPE_HEAD&&viewType!=HorizonViewHolder.TYPE_HORIZON) {
            ((NormalViewHolder) holder).textView.setText(datas.get(position).getText());
        }else if(viewType==HorizonViewHolder.TYPE_HORIZON){
            ((HorizonViewHolder)holder).setData(mContext,datas.get(position).getList());
        }
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    /**
     *@fuction 根据数据类型确定ViewHolder的类型
     *@parm 根据位置判断
     *@return
     *@exception
     */
    @Override
    public int getItemViewType(int position) {
        Log.d("sssss", "getItemViewType: " + position + "---" + getItemCount());
        if (position == 0)
            return HeadViewHolder.TYPE_HEAD; //头部
        else if (position == (getItemCount() - 1))
            return FootViewHolder.TYPE_FOOT; //尾部
        else if (datas.get(position).getList() != null) {
            Log.d("aaaa", "getItemViewType: Type_horizon");
            return HorizonViewHolder.TYPE_HORIZON; //水平嵌套一个水平滑动的RecyclerView
        }

        return TYPE_NORMAL;
    }
}
