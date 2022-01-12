package com.example.myline.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;


import com.example.myline.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment2 extends Fragment {
    public int[] imageIds = {R.mipmap.s1, R.mipmap.s2,R.mipmap.s3,R.mipmap.s4};
    public String[] names={"张三","里斯","王五","赵六"};
    //private OnNewsItemClickListener mListener;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        System.out.println("SecondFragment onCreate（）");
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        System.out.println("SecondFragment onCreateView（）1");
        //container.findViewById(R.id.ly_content);
        View view=inflater.inflate(R.layout.fg2, container, false);

        //Drawable drawable1 = getResources().getDrawable(R.mipmap.sousuo);
       // drawable1.setBounds(0, 0, 15, 15);//第一0是距左边距离，第二0是距上边距离，40分别是长宽

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(Fragment2.this.getContext(),listItems,R.layout.fg11,new String[]{"header","name"},new int[]{R.id.header,R.id.name});
        ListView myList=(ListView)view.findViewById(R.id.mylist);
        myList.setAdapter(simpleAdapter);
        return view;
    }

}
