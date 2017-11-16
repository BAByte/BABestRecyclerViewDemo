package com.example.ba.bestrecyclerviewdemo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by BA on 2017/11/16 0016.
 *
 * @Function : HeadViewHolder
 */

public class HeadViewHolder extends RecyclerView.ViewHolder{
    static final int TYPE_HEAD=1;
    TextView text;
    public HeadViewHolder(View itemView) {
        super(itemView);
        text=(TextView)itemView.findViewById(R.id.text);
    }
}
