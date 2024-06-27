package com.example.java_version;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

/*
工具类 单例模式（构造函数私有化、对外提供函数）
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    private static SQLiteOpenHelper mInstance;
    public static synchronized SQLiteOpenHelper getmInstance(Context context){
        Log.d("lenientxxx","已经创建");
        if(mInstance == null){
            mInstance = new MySQLiteHelper(context,"newDB.db",null,1);
            Log.d("lenientxxx","创建成功");
        }
        return mInstance;
    }
    private MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql = "create table henry(id integer primary key autoincrement,name varchar(64),address varchar(64))";
//        //execSQL用于执行SQL语句 完成数据库的创建
//        db.execSQL(sql);
        db.execSQL("create table person(_id integer primary key autoincrement,"+"username text,"+ "password text)");
        //数据库实际上是没有被创建或者打开的，直到getWritableDatabase() 或者 getReadableDatabase() 方法中的一个被调用时才会进行创建或者打开
    Log.d("lenientxxx","导入信息测试");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
