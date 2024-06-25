package com.example.java_version;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

//
/*常用控件
 按钮图片按钮
  文本框
  编辑框
  图片框
  开关

  c 拖动条
  进度条
  浏览器框
  地图
  单选框
  复选框


两个控件关联
按钮单击 发送命令控制硬件
文本框更新数据 来接受硬件上报的 数值
添加mqtt包  需要右键添加到工程 可以在gradle的配置文件中找到
mqtt 相关函数 开始重连 连接 初始化


动画 使用动画素材 获取id并绑定动画 使用控件来操作动画
* */




public class ActMainActivity extends AppCompatActivity {
   private Button btn_1,btn_long,btn_touch,btn_e,btn_log;
   private ImageView image_1;
   private TextView textView_1;
   private EditText edit,password;
    private final  String TAG = ActMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("lenient",TAG+" onCreate");
        Log.d("lenient","hash:"+hashCode());
//        一般先用脑进行界面初始化  控件初始化  变量参数 初始化
//        TextView name_one =  findViewById(R.id.name_one);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        ui_init();
        Dbinit();
        Log.d("lenientxx","Dbinit();");
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            System.out.println("hello world");
//            Toast.makeText(MainActivity.this,"hello!", Toast.LENGTH_SHORT).show();
//            textView_1.setText("新的内容");
//            Log.e("btn","click");
            }
        });

        btn_long.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               // Log.e("TAG","onLongClick");
                return false;
            }
        });
        btn_touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("hello touch");
                textView_1.setText("touch");
                return true;
            }
        });

//        btn_e.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            String texte = edit.getText().toString();
//                Log.e("editee",texte);

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("lenient",TAG+" onCreate");
                chkData();
            }
        });

    }

    private void chkData(){
        String uname = edit.getText().toString().trim();
        String upass = password.getText().toString().trim();
        if(TextUtils.isEmpty(uname)){
        showMsg("name is wrong");
        } else if (TextUtils.isEmpty(upass)) {
            showMsg("password");
        }
        else{
            boolean flag = SPData.saveuseinfo(this,uname,upass);
            if(flag){showMsg("suss");}
            else {showMsg("fail");}
        }
    }
    private void showMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void Dbinit(){
//        USinfo user = SPData.getUserinfo(this);
//        Log.d("lenientx",edit+"edit");
//        if( user!=null && !TextUtils.isEmpty(user.getName())){
//            edit.setText(user.getName());
//            Log.d("lenientx",user.getName()+"edit");
//            password.setText(user.getPassword());
//            Log.d("lenientx",user.getPassword()+"edit");
//        }


    }
    private void ui_init() {
        btn_1 = findViewById(R.id.btn_1); //寻找真正的id  //点击
        btn_long = findViewById(R.id.btn_long);         //长按
        btn_touch = findViewById(R.id.btn_touch);       //触摸
        btn_log= findViewById(R.id.btn_log); //寻找真正的id  //点击
//        btn_e = findViewById(R.id.btn_e);
//        image_1 = findViewById(R.id.image_1);
        textView_1 = findViewById(R.id.textView_1);
        edit = findViewById(R.id.edit);
        Log.d("lenientx","获取到的edit"+edit+"edit");
        password = findViewById(R.id.password);
    }

    public void arrow_action(View view) {

        Toast.makeText(ActMainActivity.this,"this is a image",Toast.LENGTH_SHORT).show();

    }
//显式 跳转  从前面到后面的意图  还可以用setclass  setclassname  setcomponent
//隐式
//    页面跳转传递参数
//    返回参数 startActivityForResult(); 已经启用
    public void startactivity2(View view) {
        Intent intent = new Intent(this, ActVp.class);
        Bundle bundle = new Bundle();
        bundle.putString("name","lenient");
        bundle.putInt("number",88);
        intent.putExtra("age",18);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void startactivity3(View view) {
        Intent intent = new Intent(this, ActNew.class);
       Bundle bundle = new Bundle();
       intent.putExtra("age",18);
       intent.putExtras(bundle);
        startActivity(intent);
    }

    public void selectPass(View view) {
        USinfo user = SPData.getUserinfo(this);
        Log.d("lenientx",edit+"edit");
        if( user!=null && !TextUtils.isEmpty(user.getName())){
            edit.setText(user.getName());
            Log.d("lenientx",user.getName()+"edit");
            password.setText(user.getPassword());
            Log.d("lenientx",user.getPassword()+"edit");
        }
    }

/*
activity 的4中启动模式 standard  singletop singletask singleinstance
activity是由任务栈管理的每启动一个act 就会被放在栈中
*/

}


