package com.example.ba.bestrecyclerviewdemo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by BA on 2017/11/16 0016.
 *
 * @Function : FootViewHolder
 */

public class FootViewHolder extends RecyclerView.ViewHolder {
    static final int TYPE_FOOT=2;
    public TextView textView;
    public FootViewHolder(View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.text);
    }
}
