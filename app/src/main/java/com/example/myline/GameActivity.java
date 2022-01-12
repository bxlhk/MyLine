package com.example.myline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void alpha(View view) {
        //AlphaAnimation 透明动画
        //第一个参数是开始的透明度，第二个参数是结束的透明度，1.0完全透明，0.0完全透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        //设置动画的时间长度
        alphaAnimation.setDuration(2000);
        //设置重复的类型
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        //设置重复的次数
        alphaAnimation.setRepeatCount(2);
        //设置是否停留在最终状态
        alphaAnimation.setFillAfter(false);
        //让动画执行起来
        imageView.startAnimation(alphaAnimation);
    }

    public void rotate(View view) {
        //RotateAnimation 旋转动画
        //第一个参数是开始的的角度，第二个参数是结束的角度
        //第三个参数是旋转中心的X坐标类型，Animation.RELATIVE_TO_SELF 表示自身
        //第四个参数是X坐标，0.5f表示X的一半
        //第五个参数是旋转中心的坐标类型，Animation.RELATIVE_TO_PARENT 表示父级容器
        //第六个参数是Y坐标，0.5f表示X的一半
        RotateAnimation rotateAnimation = new
                RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        //设置动画的时间长度
        rotateAnimation.setDuration(2000);
        //设置重复的类型
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        //设置重复的次数
        rotateAnimation.setRepeatCount(2);
        //设置是否停留在最终状态
        rotateAnimation.setFillAfter(false);
        //让动画执行起来
        imageView.startAnimation(rotateAnimation);
    }

    public void scale(View view) {
        //ScaleAnimation 缩放动画
        //第一个参数和第二个参数是表示X轴从1倍变宽2倍
        //第三个参数和第四个参数是表示轴从1倍变宽2倍
        //第五个参数是中心的X坐标类型，Animation.RELATIVE_TO_SELF 表示自身
        //第六个参数是X坐标，0.5f表示X的一半
        //第七个参数是中心的坐标类型，Animation.RELATIVE_TO_PARENT 表示父级容器
        //第八个参数是Y坐标，0.5f表示X的一半
        ScaleAnimation scaleAnimation = new
                ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        //设置动画的时间长度
        scaleAnimation.setDuration(2000);
        //设置重复的类型
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        //设置重复的次数
        scaleAnimation.setRepeatCount(2);
        //设置是否停留在最终状态
        scaleAnimation.setFillAfter(false);
        //让动画执行起来
        imageView.startAnimation(scaleAnimation);
    }

    public void translate(View view) {
        //TranslateAnimation 平移动画
        //前四个参数是表示X轴父级容器的-0.5平移到父级容器的0.5
        //后四个参数是表示Y轴父级容器的-0.5平移到父级容器的0.5
        TranslateAnimation translateAnimation = new
                TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        //设置动画的时间长度
        translateAnimation.setDuration(2000);
        //设置重复的类型
        translateAnimation.setRepeatMode(Animation.REVERSE);
        //设置重复的次数
        translateAnimation.setRepeatCount(2);
        //设置是否停留在最终状态
        translateAnimation.setFillAfter(true);
        //可以设置一个动画插入器，可以添加一些效果，以下是一个跳动的效果
        translateAnimation.setInterpolator(new BounceInterpolator());
        //让动画执行起来
        imageView.startAnimation(translateAnimation);
    }

    public void set(View view) {
        //AnimationSet 组合动画
        AnimationSet animationSet = new AnimationSet(false);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setFillAfter(false);
        //添加透明动画
        animationSet.addAnimation(alphaAnimation);

        RotateAnimation rotateAnimation = new
                RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setFillAfter(false);
        //添加旋转动画
        animationSet.addAnimation(rotateAnimation);

        ScaleAnimation scaleAnimation = new
                ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(2);
        scaleAnimation.setFillAfter(false);
        //添加缩放动画
        animationSet.addAnimation(scaleAnimation);

        TranslateAnimation translateAnimation = new
                TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new BounceInterpolator());
        //添加平移动画
        animationSet.addAnimation(translateAnimation);

        //把整个动画组执行起来
        imageView.startAnimation(animationSet);
    }
}
