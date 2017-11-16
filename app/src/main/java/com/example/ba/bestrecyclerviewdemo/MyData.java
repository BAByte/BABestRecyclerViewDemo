package com.example.ba.bestrecyclerviewdemo;

import java.util.List;

/**
 * Created by BA on 2017/11/6 0006.
 *
 * @Function : 数据实体类
 */

public class MyData {
    private List<String> list; //当这个数据中还有数据需要展示的时候，就放到这里，然后水平展示
    private String text; //基本展示的数据

    public MyData(String text,List<String> list){
        this.text=text;
        this.list=list;
    }

    public MyData(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public List<String> getList(){
        return list;
    }
}
