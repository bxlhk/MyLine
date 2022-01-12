package com.example.myline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;

import com.example.myline.GameActivity;
import com.example.myline.MusicServiceActivity;
import com.example.myline.R;



public class Fragment3 extends Fragment {

    //打电话按钮
    Button playgame;
    //听音乐按钮
    Button playmmusic;

    private String content;
    public Fragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg3,container,false);
        playgame = (Button) view.findViewById(R.id.B_PlayGame);
        playmmusic = (Button)view.findViewById(R.id.B_PlayMusic);
        //txt_content.setText(content);
        //实现注册Button
        playmmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MusicServiceActivity.class);
                startActivity(intent);
            }
        });
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
