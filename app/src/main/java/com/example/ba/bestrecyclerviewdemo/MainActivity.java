package com.example.ba.bestrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();
        initList();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(this,list);

        recyclerView.setAdapter(adapter);

    }

    public void initList(){
        for (int i=1;i<=30;i++){
            if(i%3==0){
                list.add(new MyData("big"));
            }else if (i%10==0){
                list.add(new MyData("horizon",getStringList()));
            }
            else {
                list.add(new MyData("small"));
            }
        }
    }

    public List<String> getStringList(){
        Log.d("aaaaaa", "getStringList: ");
        List<String> list=new ArrayList<>();
        for (int i=0;i<5;i++)
            list.add("fkjdhk"+i);
        return list;
    }
}
