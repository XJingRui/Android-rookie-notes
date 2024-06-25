package com.example.tyre2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private  ImageView  tyre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tyre = findViewById(R.id.tyre);
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(tyre,"rotationY", 0f, 360f);
        rotationAnimator = ObjectAnimator.ofFloat(tyre,"rotationY", 0f, 360f);

        rotationAnimator.setDuration(1000); // 设置动画持续时间
        rotationAnimator.setInterpolator(new LinearInterpolator()); // 设置插值器
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE); // 设置动画无限重复
        rotationAnimator.start(); // 开始动画



    }
}