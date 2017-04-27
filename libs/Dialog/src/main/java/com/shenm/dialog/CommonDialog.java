package com.shenm.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CANC on 2017/4/27.
 */

public class CommonDialog extends DialogFragment implements View.OnClickListener {

    private MyDialogLisenter linenter;
    private Activity mActivity;
    private static DialogConfig sDialogConfig;
    private Dialog dialog;

    private static CommonDialog newIntance(DialogConfig pickerConfig) {
        CommonDialog commonDialog = new CommonDialog();
        commonDialog.initialize(pickerConfig);
        return commonDialog;
    }

    private void initialize(DialogConfig dialogConfig) {
        sDialogConfig = dialogConfig;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linenter = sDialogConfig.lisenter;
        mActivity = getActivity();
        mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(getActivity(), R.style.CommonDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(sDialogConfig.mCanceledOnTouchOutside);
        dialog.setCancelable(true);
        dialog.setContentView(initView());
        return dialog;
    }

    View initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.common_dialog, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ImageView ivImg = (ImageView) view.findViewById(R.id.iv_img);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
        TextView tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tvAgree = (TextView) view.findViewById(R.id.tv_agree);
        tvTitle.setTextColor(ContextCompat.getColor(getContext(), sDialogConfig.mTitleColor));
        tvTitle.setText(sDialogConfig.mTitleString);
        ivImg.setVisibility(sDialogConfig.isShow ? View.VISIBLE : View.GONE);
        if (sDialogConfig.isShow) {
            ivImg.setImageResource(sDialogConfig.mImageId);
            ivImg.getLayoutParams().height = sDialogConfig.mImageHeight;
            ivImg.getLayoutParams().width = sDialogConfig.mImageWidth;
        }
        tvMsg.setText(sDialogConfig.mMessageString);
        tvMsg.setTextColor(ContextCompat.getColor(getContext(), sDialogConfig.mMessageColor));
        tvCancel.setText(sDialogConfig.mCancelString);
        tvCancel.setTextColor(ContextCompat.getColor(getContext(), sDialogConfig.mCancelColor));
        tvAgree.setText(sDialogConfig.mSureString);
        tvAgree.setTextColor(ContextCompat.getColor(getContext(), sDialogConfig.mSureColor));
        tvTitle.setGravity(sDialogConfig.mTitlePosition);
        tvCancel.setOnClickListener(this);
        tvAgree.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_cancel) {
            if (linenter != null) {
                linenter.cancel();
            }
            dismiss();
        } else if (id == R.id.tv_agree) {
            if (linenter != null) {
                linenter.agree();
            }
            dismiss();
        }
    }

    public static class Builder {
        DialogConfig sDialogConfig;

        public Builder() {
            sDialogConfig = new DialogConfig();
        }

        /**
         * 能否触摸隐藏,默认不可
         *
         * @param isSetCanceledOnTouchOutside
         * @return
         */
        public Builder setCanceledOnTouchOutside(boolean isSetCanceledOnTouchOutside) {
            sDialogConfig.mCanceledOnTouchOutside = isSetCanceledOnTouchOutside;
            return this;
        }

        /**
         * 设置标题位置，默认在左边
         *
         * @param titlePosition
         * @return
         */
        public Builder setTitlePosition(int titlePosition) {
            sDialogConfig.mTitlePosition = titlePosition;
            return this;
        }

        /**
         * 设置标题文字，默认显示标题
         *
         * @param title
         * @return
         */
        public Builder setTitleString(String title) {
            sDialogConfig.mTitleString = title;
            return this;
        }

        /**
         * 设置标题颜色，默认显示黑色
         *
         * @param titleColor
         * @return
         */
        public Builder setTitleColor(int titleColor) {
            sDialogConfig.mTitleColor = titleColor;
            return this;
        }

        /**
         * 是否显示提示图片，默认隐藏
         *
         * @param isShow
         * @return
         */
        public Builder showImage(boolean isShow) {
            sDialogConfig.isShow = isShow;
            return this;
        }

        /**
         * 设置提示图片
         *
         * @param imageId
         * @return
         */
        public Builder setImage(int imageId) {
            sDialogConfig.mImageId = imageId;
            return this;
        }

        /**
         * 设置图片大小,默认自适应
         *
         * @param width
         * @param height
         * @return
         */
        public Builder setImageSpecifications(int width, int height) {
            sDialogConfig.mImageWidth = width;
            sDialogConfig.mImageHeight = height;
            return this;
        }

        /**
         * 设置提示文字
         *
         * @param message
         * @return
         */
        public Builder setMessageString(String message) {
            sDialogConfig.mMessageString = message;
            return this;
        }

        /**
         * 设置提示文字颜色，默认提示文字黑色
         *
         * @param messageColor
         * @return
         */
        public Builder setMessageColor(int messageColor) {
            sDialogConfig.mMessageColor = messageColor;
            return this;
        }

        /**
         * 设置取消按钮文字
         *
         * @param left
         * @return
         */
        public Builder setCancelString(String left) {
            sDialogConfig.mCancelString = left;
            return this;
        }

        /**
         * 设置取消按钮文字颜色，默认取消按钮文字黑色
         *
         * @param cancelColor
         * @return
         */
        public Builder setCancelColor(int cancelColor) {
            sDialogConfig.mCancelColor = cancelColor;
            return this;
        }

        /**
         * 设置同意按钮文字
         *
         * @param right
         * @return
         */
        public Builder setAgreeString(String right) {
            sDialogConfig.mSureString = right;
            return this;
        }

        /**
         * 设置取消按钮文字颜色，默认取消按钮文字黑色
         *
         * @param agreeColor
         * @return
         */
        public Builder setAgreeColor(int agreeColor) {
            sDialogConfig.mSureColor = agreeColor;
            return this;
        }

        /**
         * 点击按钮要处理其他事情
         * 必须设置该属性,否则无效
         *
         * @param listener
         * @return
         */
        public Builder setCallBack(MyDialogLisenter listener) {
            sDialogConfig.lisenter = listener;
            return this;
        }

        public CommonDialog build() {
            return newIntance(sDialogConfig);
        }
    }
}
