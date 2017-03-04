package com.example.mydialogfordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mydialogfordemo.ui.MykeyDialogDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取自定义view'的控件初始化
        //最后设置点击事件

    }
    public void show(View v){
        //展示自定义对话框的那妞
        //获取
        MykeyDialogDemo mykeyDialogDemo = new MykeyDialogDemo(this);
        //show出来
        //设置可以点击其他位置消失
        mykeyDialogDemo.setCanceledOnTouchOutside(true);

        mykeyDialogDemo.show();


    }
}
