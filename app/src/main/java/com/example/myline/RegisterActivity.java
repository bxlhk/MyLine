package com.example.myline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mIvRegisteractivityShowcode;
    private DBOpenHelper mDBOpenHelper;
    private EditText mEtRegisteractivityPhonecodes;
    private String realCode;

    //用户名
    EditText userNameTxt;
    //密码
    EditText passwordTxt;
    //确认密码
    EditText passwordTxtAgain;
    //返回登录按钮
    Button backBtn;
    //注册按钮
    Button registerBtn;
    //复选框



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        mDBOpenHelper = new DBOpenHelper(this);
        //将验证码用图片的形式显示出来
        mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();
    }

    private void initView() {
        //初始化各个组件
        userNameTxt =(EditText)findViewById(R.id.userNameTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        backBtn = (Button)findViewById(R.id.backBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        passwordTxtAgain = findViewById(R.id.passwordTxtAgain);
        mIvRegisteractivityShowcode = findViewById(R.id.iv_registeractivity_showCode);//验证码图片
        mEtRegisteractivityPhonecodes = findViewById(R.id.et_registeractivity_phoneCodes);//验证码

        backBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        mIvRegisteractivityShowcode.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backBtn: //返回登录页面
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.iv_registeractivity_showCode:    //改变随机验证码的生成
                mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();//转为小写,降低难度，否则还要区分大小写
                break;
            case R.id.registerBtn:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = userNameTxt.getText().toString().trim();
                String password = passwordTxtAgain.getText().toString().trim();
                String userInputCode = mEtRegisteractivityPhonecodes.getText().toString().toLowerCase();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(userInputCode) ) {
                    //用TextUtils.equals（）不用string的equals，TextUtils.equals（）多了非空判断
                    if (TextUtils.equals(userInputCode,realCode)) {
                        //将用户名和密码加入到数据库中
                        mDBOpenHelper.add(username, password);
                        Intent intent2 = new Intent(this, MainActivity.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(this,  "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "验证码错误,注册失败", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
