package com.qydq.an;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.xutils.x;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String url = "http://imgsrc.baidu.com/forum/w%3D580/sign=7d080186c8fcc3ceb4c0c93ba244d6b7/9699a9014c086e06278db2ef02087bf40ad1cb69.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 本来应该在application的onCreate中初始化
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        x.image().bind(imageView, url);
    }
}
