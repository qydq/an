package com.an.an_aar.struts.utils;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by Luue on 2016/6/18.
 */

public class DUtilsAnimHeart {

    private volatile static DUtilsAnimHeart instance;

    private DUtilsAnimHeart() {

    }

    //线程安全机制。
    public static DUtilsAnimHeart getInstance() {
        if (instance == null) {
            synchronized (DUtilsAnimHeart.class) {
                if (instance == null)
                    instance = new DUtilsAnimHeart();
            }
        }
        return instance;
    }

    /**
     * sunshuntao ;staryumou@163.com
     * 图片跳动 按钮模拟心脏跳动
     */
    public static void playHeartbeatAnimation(final View view) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f));
        animationSet.setDuration(200);
        animationSet.setInterpolator(new AccelerateInterpolator());
        // 结尾停在最后一针
        animationSet.setFillAfter(true);
        // 对动画进行监听
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            // 开始时候怎么样
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            // 结束时候怎么样
            @Override
            public void onAnimationEnd(Animation animation) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(new ScaleAnimation(1.2f, 1.0f, 1.2f,
                        1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f));
                animationSet.setDuration(200);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.setFillAfter(false);
                // 实现心跳的View
                view.startAnimation(animationSet);
            }
        });

        // 实现心跳的View
        view.startAnimation(animationSet);

    }
}
