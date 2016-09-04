package com.an.an_aar.app.zxing.activity;

/**********************************************************
 * @文件名称：CaptureActivity
 * @文件作者：staryumou@163.com
 * @创建时间：2016/9/2
 * @文件描述：null
 * @修改历史：2016/9/2
 **********************************************************/

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.an.an_aar.R;
import com.an.an_aar.app.zxing.fragment.CaptureFragment;
import com.an.an_aar.app.zxing.utils.CodeUtils;


/**
 * Initial the camera
 * <p>
 * 默认的二维码扫描Activity
 */
public class AarCaptureActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aar_zxing_activity_capture);
        CaptureFragment captureFragment = new CaptureFragment();
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            AarCaptureActivity.this.setResult(RESULT_OK, resultIntent);
            AarCaptureActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            AarCaptureActivity.this.setResult(RESULT_OK, resultIntent);
            AarCaptureActivity.this.finish();
        }
    };
}