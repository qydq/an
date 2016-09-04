package com.an.an_aar.struts.utils;

import android.content.Context;
import android.view.Window;

/**
 * Created by stary on 2016/8/17.
 * 文件名称：FeatureUtils
 * 文件描述：
 * 作者：staryumou@163.com
 * 修改时间：2016/8/17
 */

public class DUtilsFeature {
    public static final void featureUtils(Context context, Window window) {
        AndroidFeature af = new AndroidFeature(context, window);
        af.androidFeature();
    }
}
