package com.kejar15.biodata.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.kejar15.biodata.model.User;

public class UserViewModel {

    public final static String TOAST_MESSAGE_SUCCESS = "Login Berhasil";
    public final static String TOAST_MESSAGE_FAILED = "Login Gagal";
    private Context context;
    private User user;

    public UserViewModel(Context context, User user) {
        this.user = user;
        this.context = context;
    }

    public void updateModel(String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
    }

    public void validLogin(){

        boolean isValid = true;

        if (TextUtils.isEmpty(user.getEmail()))
            isValid = false;

        if (TextUtils.isEmpty(user.getPassword()))
            isValid = false;

        if (isValid)
            showToast(TOAST_MESSAGE_SUCCESS);
        else
            showToast(TOAST_MESSAGE_FAILED);
    }

    private void showToast(String messageToast){
        Toast.makeText(context, messageToast, Toast.LENGTH_SHORT).show();
    }

}
