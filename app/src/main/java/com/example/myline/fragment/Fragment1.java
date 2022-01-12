package com.example.myline.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myline.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment1 extends Fragment {

    public String[] names = {"杨曙岳","张冰冰","里酷虎","换楼的长"};
    public String[] title = {"转发微博","有深意[思考]","马哲课就炸药结束了，也不用在看到ddzl [鼓掌]","@洒点零分"};
    public String[] time = {"1分钟前","11分钟前","30分钟前","31分钟前"};
    public int[] imageIds = {R.mipmap.s1, R.mipmap.s2,R.mipmap.s3,R.mipmap.s4};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("FirstFragment onCreateView()方法被调用");
        View view = inflater.inflate(R.layout.fg1, container, false);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("title",title[i]);
            listItem.put("name",names[i]);
            listItem.put("time",time[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(Fragment1.this.getContext(),listItems,R.layout.fg11,new String[]{"header","title","name","time"},new int[]{R.id.header,R.id.title,R.id.name,R.id.time});
        ListView myList=(ListView)view.findViewById(R.id.mylist);
        myList.setAdapter(simpleAdapter);
        return view;
    }
}
