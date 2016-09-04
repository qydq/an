package com.an.an_aar.struts.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by stary on 2016/8/17.
 * 文件名称：AndroidFeature
 * 文件描述：
 * 作者：staryumou@163.com
 * 修改时间：2016/8/17
 */

public class AndroidFeature extends Activity {
    Context mContext;
    Window mwindow;

    public AndroidFeature(Context context, Window window) {
        super();
        // TODO Auto-generated constructor stub
        this.mContext = context;
        this.mwindow = window;
    }

    public void androidFeature() {
        onCreate(null);
    }

    @SuppressLint("InlinedApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mwindow.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            mwindow.addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
