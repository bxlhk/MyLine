package com.example.myline.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;

import com.example.myline.BasicMapActivity;
import com.example.myline.GameActivity;
import com.example.myline.R;


public class Fragment4 extends Fragment {

    Button mapLocation;
    public Fragment4() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg4,container,false);
        mapLocation = (Button) view.findViewById(R.id.B_MapLocation);
        //跳转到定位页面
        mapLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BasicMapActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


}
