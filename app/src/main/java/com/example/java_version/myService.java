package com.example.java_version;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class myService extends Service{
private final static  String TAG = "lenientX";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"servicr + onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"servicr + onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }
    //包含了onstar
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"servicr + onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"servicr + onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"servicr + onDestroy");
        super.onDestroy();
    }
}
