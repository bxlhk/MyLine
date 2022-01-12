package com.example.myline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener{

    private Button returnloginBtn;
    private Button saveBtn;
    private ImageView returnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        returnloginBtn = (Button)findViewById(R.id.ReturnloginBtn);
        saveBtn = (Button)findViewById(R.id.SaveBtn);
        returnHome = (ImageView) findViewById(R.id.ReturnHome);

        returnloginBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        returnHome.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            // 跳转到注册界面
            case R.id.ReturnloginBtn:
                Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.SaveBtn:
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
            case R.id.ReturnHome:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}
