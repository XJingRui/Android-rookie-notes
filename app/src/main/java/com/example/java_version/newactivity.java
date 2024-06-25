package com.example.java_version;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class newactivity extends AppCompatActivity {

    private final  String TAG = MainActivity.class.getSimpleName();
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newactivity);

        Log.d("lenient",TAG+" onCreate");
        Log.d("lenient","hash:"+hashCode());

        textView = (TextView)findViewById(R.id.text3);
        Bundle bundle =  getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        int number = bundle.getInt("number");
        textView.setText(name + number + "maageis" +age);


        TextView textView1 = findViewById(R.id.text3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView1,"alpha",0f,20f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
        objectAnimator.setRepeatCount(5);

        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
//                int count = objectAnimator.getRepeatCount();
//                Log.d("lenient","repeat: "+ count);
            }
        });
/*也可以用适配的方式去选择监听器*/
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }
        });

//渲染布局

        ViewPager viewpage = findViewById(R.id.vp);
        ArrayList<View> viewContainter = new ArrayList<View>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.layout, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout2, null);
        viewContainter.add(view1);
        viewContainter.add(view2);
        MyAdapter myAdapter = new  MyAdapter(viewContainter);
        viewpage.setAdapter(myAdapter);


/*******************************************************************************/
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,180f);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//            }
//        });
//        valueAnimator.start();




//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }


    public void tioazhaun1(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}