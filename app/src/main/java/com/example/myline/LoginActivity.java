package com.example.myline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //用户名
    EditText userNameTxt;
    //密码
    EditText passwordTxt;
    //登录按钮
    Button loginBtn;
    //注册按钮
    Button registerBtn;
    private DBOpenHelper mDBOpenHelper;

    private CheckBox mRemenber;//记住密码
    private boolean mPasswordFlag = true;//记住密码标志
    private CheckBox mAutoLogin;//自动登录
    private boolean mAutoLoginFlag = false;//自动登录标志
    private String userPassword = "";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void initView(){
        // 初始化控件
        userNameTxt =(EditText)findViewById(R.id.userNameTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        mRemenber = findViewById(R.id.remenber_pwd);
        mAutoLogin = findViewById(R.id.login_auto);
        sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE);

        //获取info文件的内容，第一参数为保存时的key，第二个是如果获取不到的默认值
        String numberStr1 = sharedPreferences.getString("number","");
        String passwordStr2 = sharedPreferences.getString("password","");
        userNameTxt.setText(numberStr1);
        passwordTxt.setText(passwordStr2);
        if(mPasswordFlag){
            mRemenber.setChecked(true);
        }
        // 设置点击事件监听器
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        mRemenber.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()) {
            // 跳转到注册界面
            case R.id.registerBtn:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
            /**
             * 登录验证：
             *
             * 从EditText的对象上获取文本编辑框输入的数据，并把左右两边的空格去掉
             *  String name = mEtLoginactivityUsername.getText().toString().trim();
             *  String password = mEtLoginactivityPassword.getText().toString().trim();
             *  进行匹配验证,先判断一下用户名密码是否为空，
             *  if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password))
             *  再进而for循环判断是否与数据库中的数据相匹配
             *  if (name.equals(user.getName()) && password.equals(user.getPassword()))
             *  一旦匹配，立即将match = true；break；
             *  否则 一直匹配到结束 match = false；
             *
             *  登录成功之后，进行页面跳转：
             *
             *  Intent intent = new Intent(this, MainActivity.class);
             *  startActivity(intent);
             *  finish();//销毁此Activity
             */
            case R.id.loginBtn:
                String name = userNameTxt.getText().toString().trim();
                String password = passwordTxt.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    } else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remenber_pwd:
                //获取输入框的账号和密码
                String numberStr = userNameTxt.getText().toString().trim();
                String passwordStr = passwordTxt.getText().toString().trim();
                //判断是否为空
                if (numberStr.isEmpty() || passwordStr.isEmpty()){
                    Toast.makeText(getApplicationContext(),"账号或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    //获取Editor
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    mPasswordFlag = true;
                    //输入内容
                    editor.putString("number",numberStr);
                    editor.putString("password",passwordStr);
                    //必须提交才会生效，也可以使用apply
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
                }
        }
    }
}
