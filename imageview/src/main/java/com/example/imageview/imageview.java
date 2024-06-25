package com.example.imageview;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class imageview extends AppCompatActivity {
private Button btn;
private boolean flag = false;

private ImageView ima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imageview);

        RelativeLayout relativeLayout = findViewById(R.id.linearLayout);
        AnimationDrawable anim = (AnimationDrawable)relativeLayout.getBackground();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    anim.stop();
                    flag = false;
                }
                else{
                    anim.start();
                    flag = true;
               }
            }
        });

        ima = findViewById(R.id.ima);
        AnimationDrawable anima = (AnimationDrawable) ima.getBackground();


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    anima.start();
                    flag = false;
                }
                else{
                    anima.stop();
                }
            }
        });

    }
}
