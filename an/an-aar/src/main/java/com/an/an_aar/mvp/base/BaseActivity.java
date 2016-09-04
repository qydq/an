package com.an.an_aar.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.an.an_aar.struts.utils.DUtilsActivity;
import com.an.an_aar.struts.utils.DUtilsFeature;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * Created by stary on 2016/8/18.
 * 文件名称：BaseActivity
 * 文件描述：基类
 * 作者：staryumou@163.com
 * 修改时间：2016/8/18
 */

public abstract class BaseActivity extends FragmentActivity {

    /**
     * 基类(Activity)所使用的TAG标签
     */
    protected String TAG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
//         设置标题栏
        DUtilsFeature.featureUtils(this, getWindow());
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 用于确定当前界面是属于哪个活动(Activity), 让新加入开发的人快速锁定所在的界面,不得擅自移除.
        TAG = getClass().getSimpleName();
        // 将其子activity添加到activity采集器
        DUtilsActivity.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 将其子activity从activity采集器中移除
        DUtilsActivity.getInstance().removeActivity(this);
    }

    // 覆盖以下方法,设置动画.

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//		overridePendingTransition(R.anim.aim_common_right_in,
//				R.anim.aim_common_left_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
//		overridePendingTransition(R.anim.aim_common_right_in,
//				R.anim.aim_common_zoom_out);
    }

    @Override
    public void finish() {
        super.finish();
//		overridePendingTransition(R.anim.aim_common_left_in,
//				R.anim.aim_common_right_out);
    }

    public String getViewValue(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString();
        } else if (view instanceof TextView) {
            return ((TextView) view).getText().toString();
        } else if (view instanceof CheckBox) {
            return ((CheckBox) view).getText().toString();
        } else if (view instanceof RadioButton) {
            return ((RadioButton) view).getText().toString();
        } else if (view instanceof Button) {
            return ((Button) view).getText().toString();
        }
        return null;
    }

}
