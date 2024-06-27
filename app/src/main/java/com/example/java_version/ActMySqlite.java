package com.example.java_version;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ActMySqlite extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mysqlite);
        findViewById(R.id.btn_cdb).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btn_add).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btn_show).setOnClickListener((View.OnClickListener)this);

    }
    public void createDB(){
        SQLiteOpenHelper helper = MySQLiteHelper.getmInstance(this);
        SQLiteDatabase db = helper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_cdb){
            SQLiteOpenHelper helper = MySQLiteHelper.getmInstance(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            Log.d("lenientxxx","ddddddddddddddb");
        }

        if(v.getId()==R.id.btn_add){

            SQLiteOpenHelper helper = MySQLiteHelper.getmInstance(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values=new ContentValues();
            Log.d("lenientxxx","插入成功?");
            values.put("username","lemon");
            values.put("password","123456");
            db.insert("person",null,values);
            values.clear();
            Log.d("lenientxxx","插入成功");
        }
        if(v.getId()==R.id.btn_show){
            SQLiteOpenHelper helper = MySQLiteHelper.getmInstance(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            // 查询Book表中所有的数据
            Cursor cursor = db.query("person", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    // 遍历Cursor对象，取出数据并打印
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("username"));
                    @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
                    Log.d("MainActivity", "book name is " + name);
                    Log.d("MainActivity", "book password is " + password);

                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        }
        }

    }


