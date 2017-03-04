package com.example.mydialogfordemo.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mydialogfordemo.R;

/**
 * 项目名:     MyApplication
 * 包名:       ${APCKAGE_NAME}
 * 文件名:     MykeyDialogDemo
 * 创建者:     NYK
 * 描述:
 * 总体的思路就是:第一点:我么可以看做一个dialog是一个activity来理解,因为dialog可以自定义,自定义的时候,后anctivity'一样
 * 我们通过setContetnView(view)来设置一个想要展示的view来作为自定义的dialog来展示出来,第二点:在设置自定义dialog的时候我们设置他的样式
 * 第三个就是回调监听,可以通过回调监听来吧弹出对话框后用户的操作传递出去.
 *    第一的构思就是,我们设置一个自定义的对话框,里面的布局就是表情的那个布局,用户点击表情的那个按钮后显示的是表情的那个样式
 *    使用回调监听.
 *   初始化自定义对话框的展示属性:第一个属性是展示的宽度,我们可以获取展示的屏幕的宽度
 *   DisplayMetrics displayMetrics=getcontex().getResourecs().getdisplaymetrices();这个类:Andorid.util 包下的DisplayMetrics 类提供了一种关于显示的通用信息，如显示大小，分辨率和字体。
 *   这个类中包含当前的宽度,获取displayMetrics.width;就是我们需要设置给自定义dialog的属性,最后自定义的对话框是展示在屏幕上面的,获取窗口的属性,设置dialog的属性
 *   属性就包括对话框的展示的位置和对话框展示的宽度是怎么样子的
 *     获取窗口的属性:
 *  WindowManager.LayoutParams params=   getWindow().getAttributes();
 *  设置位置  params.gravity = Gravity.bottom;  设置展示的位置
 *  设置展示的宽度
 *  params.width = displayMetrics.width;
 *  参数变化后重新设置给我窗口
 *  getWindow()setAttributes(params)
 *
 *
 */
public class MykeyDialogDemo extends Dialog{
    private Button mShow;
    private Button mSend;
    //首先是自定义对框的设置,第一点就是继承dialog
    //里面的构造方法和一般的自定义控件是不相同的
    //第一个参数实在直接new的时候获取的
    //第二个参数是直接定义了一个style来设置的,我们在这里可以直接给自定义控件设置一个样式:样式中包包括的是背景和是自定义dialog
    //是否是需要tittle后名就是在这行这个自定义的dialog的时候是的一些自定义的动画,注意我们常见的自定义dialog是宽和高都是固定好的
    //我们需要自定义初始化对话框的高度和位置
    //就在设置自定义对话框的样式扥那个构造方法里面来设定,



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //转化一个view
        View view = View.inflate(getContext(), R.layout.mdialogshowview, null);
        setContentView(view);
        //初始化对话框的一些展示属性
        //获取屏幕的宽度,设置展示的屏幕的信息
//Andorid.util 包下的DisplayMetrics 类提供了一种关于显示的通用信息，如显示大小，分辨率和字体。

        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        //获取框

        int widthPixels = metrics.widthPixels;
        // 获取窗口管理
        //在获窗口的属性
        //设置属性

        //将获取的屏幕的宽度设置给自定义对话框的展示

        //重新设置属性

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity= Gravity.BOTTOM;

        params.width=widthPixels;
        getWindow().setAttributes(params);
        //初始化控件:
        mShow = (Button) view.findViewById(R.id.btn_show_emotion);
        //获取发送
        mSend = (Button) view.findViewById(R.id.btn_send);


    }

    public MykeyDialogDemo(Context context) {
        this(context,R.style.CustomDialog);
        //好处就是,在获取自定义对话框的时候,代码获取的时候只传递一个上下文,而不能指定样式,我们在内部设置好了样式

    }

    public MykeyDialogDemo(Context context, int themeResId) {
        super(context, themeResId);
    }

    public MykeyDialogDemo(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

}
