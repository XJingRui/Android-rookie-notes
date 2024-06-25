package com.example.java_version;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class broadcast extends BroadcastReceiver {
    //动态广播 1.0/3  规范化程序还需要用接口定义广播action
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("lenient","boardcast");
    }
}
