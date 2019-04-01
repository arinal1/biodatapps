package com.osg15.biodatapps.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.osg15.biodatapps.R;

import java.util.Objects;

public class LoadingDialog extends Dialog {

    @SuppressLint("NewApi")
    public LoadingDialog(@NonNull Context context) {
        super(context);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
    }
}