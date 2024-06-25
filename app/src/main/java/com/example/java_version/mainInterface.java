package com.example.java_version;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class mainInterface extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.maininterface);
        findViewById(R.id.btn_star).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn_jinli).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn_service).setOnClickListener((View.OnClickListener) this);
    }
    public void backmain(View view) {
        startActivity(new Intent(this,MainActivity.class));
        Log.d("lenient","这个是跳转页面");
    }
    public void closeact(View view) {
        finish();
        Log.d("lenient","这个是关闭页面");
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_star){
//            finish();
//            Log.d("lenient","这个是关闭页面");
            startActivity(new Intent(this,MainActivity.class));
            Log.d("lenient","这个是跳转页面");
        }
        if(v.getId()==R.id. btn_jinli){
            startActivity(new Intent(this,vp.class));
            Log.d("lenient","这个是跳转到锦鲤页面");
        }
        if(v.getId()==R.id. btn_service){
            startActivity(new Intent(this,service.class));
            Log.d("lenient","这个是跳转到service页面");
        }

    }

}
