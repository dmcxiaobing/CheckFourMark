package com.qq986945193.CheckFourMark;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 微博：http://weibo.com/mcxiaobing
 * ============================================================================
 * Copyright (c) 2015-2016 QQ986945193 All rights reserved.
 * ----------------------------------------------------------------------------
 * 类名：主类。实现验证码的点击以及验证是否正确的功能。
 * ----------------------------------------------------------------------------
 * 功能描述：http://blog.csdn.net/qq_21376985
 * ----------------------------------------------------------------------------
 */
public class MainActivity extends Activity implements OnClickListener {
    ImageView vc_image; // 图片
    Button vc_shuaixi, vc_ok;
    String getCode = null;
    EditText vc_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vc_image = (ImageView) findViewById(R.id.vc_image);
        vc_image.setImageBitmap(CodeUtils.getInstance().getBitmap());
        vc_code = (EditText) findViewById(R.id.vc_code);
        getCode = CodeUtils.getInstance().getCode(); // 获取显示的验证码
        vc_shuaixi = (Button) findViewById(R.id.vc_shuaixi);
        vc_shuaixi.setOnClickListener(this);
        vc_ok = (Button) findViewById(R.id.vc_ok);
        vc_ok.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        switch (view.getId()) {
            case R.id.vc_shuaixi:
                vc_image.setImageBitmap(CodeUtils.getInstance().getBitmap());
                getCode = CodeUtils.getInstance().getCode();
                break;
            case R.id.vc_ok:
                String v_code = vc_code.getText().toString().trim();
                if (v_code == null || v_code.equals("")) {
                    Toast.makeText(MainActivity.this, "验证码为空", Toast.LENGTH_SHORT).show();
                } else if (!v_code.equalsIgnoreCase(getCode)) {
                    Toast.makeText(MainActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

}
