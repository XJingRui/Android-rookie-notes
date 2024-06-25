package com.example.java_version;

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

public class vp extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vp);

        Log.d("lenient","vvvvvvvvvvvvvp");

        findViewById(R.id.backmainact).setOnClickListener((View.OnClickListener) this);

        LayoutInflater lf = getLayoutInflater().from(this);
        View view1 = lf.inflate(R.layout.layout,null);
        View view2 = lf.inflate(R.layout.layout2,null);
        List<View> viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        ViewPager viewpage = findViewById(R.id.vp1);
        TabLayout tableLayout = findViewById(R.id.tablelayout);
        MyAdapter myAdapter = new MyAdapter(viewList);
        viewpage.setAdapter(myAdapter);
        viewpage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
        tableLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpage));
        Log.d("lenient","pppppppppppppppppv");
    }
    public void backmain(View view) {
        startActivity(new Intent(this,service.class));
        Log.d("lenient","这个是跳转页面");
    }
    public void closeact(View view) {
        finish();
        Log.d("lenient","这个是关闭页面");
    }
    @Override
    public void onClick(View v) {
    if(v.getId()==R.id.backmainact){
        finish();
        Log.d("lenient","这个是关闭页面");
    }


    }

    @Override
    protected void onStart() {
        Log.d("activitytext","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activitytext","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activitytext","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activitytext","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activitytext","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activitytext","onDestroy");
    }
}
