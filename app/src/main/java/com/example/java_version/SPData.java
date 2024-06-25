package com.example.java_version;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.jar.Attributes;

/*
保存文件信息
 */
public class SPData {
public static final String mFile = "mydate";
public static boolean saveuseinfo(Context context,String name,String password){
    boolean flag = false;
    SharedPreferences sp = context.getSharedPreferences(mFile,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString("uname",name);
    editor.putString("password",password);
    editor.commit();
    flag = true;
    return flag;
}
public static USinfo getUserinfo(Context context){
    USinfo user = null;
    SharedPreferences sp = context.getSharedPreferences(mFile,Context.MODE_PRIVATE);
    String uname = sp.getString("name",null);
    String password = sp.getString("password",null);
    user = new USinfo();
    user.setName(uname);
    user.setPassword(password);
    return user;
}
}
