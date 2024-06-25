package com.example.java_version;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActMainInterface extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.maininterface);
        findViewById(R.id.btn_star).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn_jinli).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn_service).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn_db).setOnClickListener((View.OnClickListener) this);
    }
    public void backmain(View view) {
        startActivity(new Intent(this, ActMainActivity.class));
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
            startActivity(new Intent(this, ActMainActivity.class));
            Log.d("lenient","这个是跳转页面");
        }
        if(v.getId()==R.id. btn_jinli){
            startActivity(new Intent(this, ActVp.class));
            Log.d("lenient","这个是跳转到锦鲤页面");
        }
        if(v.getId()==R.id. btn_service){
            startActivity(new Intent(this, ActService.class));
            Log.d("lenient","这个是跳转到service页面");
        }
        if(v.getId()==R.id.btn_db){
            startActivity(new Intent(this, ActMySqlite.class));
            Log.d("lenient","这个是跳转到DB页面");
        }
    }

}
