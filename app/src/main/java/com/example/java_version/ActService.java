package com.example.java_version;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ActService extends AppCompatActivity {
    private boolean isconnect = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.module);

//    =========================broarcast============================
//动态广播 2/3
//动态注册一个广播接受者
    broadcast broadcast = new broadcast();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
    registerReceiver(broadcast,intentFilter);
    }
//=========================serviice============================
// service服务 2/2 绑定服务或者开启服务
    public void service_start(View view) {
        startService(new Intent(this,myService.class));
    }

    public void service_stop(View view) {
        stopService(new Intent(this,myService.class));
    }
    public void service_bind(View view) {
        bindService(new Intent(this,myService.class), connection, Context.BIND_AUTO_CREATE);
        isconnect = true;
    }
    public void service_unbind(View view) {

        if(isconnect == true){
            unbindService(connection);
            isconnect = false;
        }


    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
//一般在activity被销毁是 就需要解绑
    @Override
    protected void onDestroy() {

        if(isconnect == true){unbindService(connection);}
        super.onDestroy();
        Log.d("lenient","activity销毁，并解绑");
//        为什么调试的时候注释执行顺序改变了
    }
//=============================broarcast===============================


//    动态广播 3/3 发出广播
    public void broadcast(View view) {
        Intent intent = new Intent();
        intent.setAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        sendBroadcast(intent);
    }

//    start、stopservice 用于音乐播放器
//    bind unbind用于普通界面




}
