package com.an.an_aar.app.zxing.activity;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.an.an_aar.R;
import com.an.an_aar.app.zxing.zxing.encoding.EncodingHandler;


public class AarZxingMainActivity extends Activity {

    //如果要实现连续扫描请调用handler.restartPreviewAndDecode();

    private final static int SCANNIN_GREQUEST_CODE = 1;
    /**
     * 显示扫描结果
     */
    private TextView mTextView;
    /**
     * 显示扫描拍的图片
     */
    private ImageView mImageView;

    /**
     * 显示创建的二维码
     */
    private ImageView qrImgImageView;
    /**
     * 输入需要生成的二维码信息
     */
    private EditText qrStrEditText;
    /**
     * 显示结果
     */
    private TextView resultTextView;
    private EditText editText;

    RelativeLayout rll;

    private Button btn3;

    public static final int REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aar_zxing_activity_main);

        mTextView = (TextView) findViewById(R.id.result);
        btn3 = (Button) findViewById(R.id.btn3);
        rll = (RelativeLayout) findViewById(R.id.rll);
        mImageView = (ImageView) findViewById(R.id.qrcode_bitmap);
        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
        editText = (EditText) this.findViewById(R.id.editText);
        //扫描默认二维码。
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AarZxingMainActivity.this, AarCaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        //点击按钮跳转到二维码扫描界面，这里用的是startActivityForResult跳转
        //扫描完了之后调到该界面
        Button mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String strNumb = editText.getText().toString().trim();
                if (TextUtils.isEmpty(strNumb)) {
                    strNumb = "1";
                }
                int number = Integer.parseInt(strNumb);
                intent.putExtra("times", number);
                Toast.makeText(getApplicationContext(), "您可以扫描" + number + "次", Toast.LENGTH_SHORT).show();
                intent.setClass(AarZxingMainActivity.this, MipcaActivityCapture.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
            }
        });

        Button generateQRCodeButton = (Button) this.findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String contentString = qrStrEditText.getText().toString();
                if (TextUtils.isEmpty(contentString)) {
                    Snackbar.make(rll, "输入的内容不能为空!", Snackbar.LENGTH_SHORT).setAction("Undo",
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(getApplication(), "请输入内容后再试试", Toast.LENGTH_SHORT).show();
                                }
                            }).show();

                } else {
                    //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                    Bitmap qrCodeBitmap = null;
                    //                        qrCodeBitmap = EncodingHandler.createQRCode(contentString, 350);
                    //生成带log的二维码
                    qrCodeBitmap = EncodingHandler.createImage(contentString, 400, 400, BitmapFactory.decodeResource(getResources(), R.drawable.aar_ic_launcher));
                    qrImgImageView.setImageBitmap(qrCodeBitmap);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    mTextView.setText(bundle.getString("result"));
                    //显示
                    mImageView.setImageBitmap((Bitmap) data.getParcelableExtra("bitmap"));
                }
                break;
            default:
                mTextView.setText("没有内容");
                break;
        }
    }
}
