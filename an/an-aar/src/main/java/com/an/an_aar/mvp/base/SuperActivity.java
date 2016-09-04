package com.an.an_aar.mvp.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.an.an_aar.R;

/**
 * Created by stary on 2016/8/18.
 * 文件名称：SuperActivity
 * 文件描述：
 * 作者：staryumou@163.com
 * 修改时间：2016/8/18
 */

public abstract class SuperActivity extends BaseActivity {
    public String TAG = "SuperActivity";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO 固件化的操作
        super.onCreate(savedInstanceState);
        //DaqiApp.geCookieStore(this);
//		EMChat.getInstance().init(this.getApplicationContext());
        initView();
        //用来保存皮肤切换模式的sp
        sp = this.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
        if (sp.getBoolean("isNightMode", false)) {
            getWindow().getDecorView().setBackground(this.getResources().getDrawable(R.drawable.yy_drawable_bgnigt_shape));
        } else {
            getWindow().getDecorView().setBackground(getResources().getDrawable(R.drawable.yy_drawable_bgday_shape));
        }
    }

    protected void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    /**
     * 各种对象、组件的初始化
     */
    public abstract void initView();
}

