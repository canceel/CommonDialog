package com.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.shenm.dialog.CommonDialog;
import com.shenm.dialog.MyDialogLisenter;

public class MainActivity extends AppCompatActivity implements MyDialogLisenter {
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        findViewById(R.id.tv_showDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        CommonDialog commonDialog = new CommonDialog.Builder()
                .setCanceledOnTouchOutside(false)
                .setCallBack(this)
                .setTitleString("权限设置")
                .setCancelString("取消")
                .setAgreeString("确定")
                .setTitleColor(R.color.text_black)
                .setMessageColor(R.color.text_black)
                .setCancelColor(R.color.text_normal)
                .setAgreeColor(R.color.text_black)
                .setTitlePosition(Gravity.LEFT)
                .setImageSpecifications(Utils.dpToPx(mActivity, 50), Utils.dpToPx(mActivity, 50))
                .showImage(true)
                .setMessageString("在设置-应用-CommonDialog-权限中开启相机权限以正常使用拍照，扫一扫等功能")
                .build();
        commonDialog.show(getSupportFragmentManager(), "all");
    }

    @Override
    public void agree() {
        Toast.makeText(mActivity, "Agree", Toast.LENGTH_SHORT).show();
        Utils.gotoPhoneSetting(mActivity);
    }

    @Override
    public void cancel() {
        Toast.makeText(mActivity, "Cancel", Toast.LENGTH_SHORT).show();
    }
}
