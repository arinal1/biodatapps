package com.osg15.biodatapps.navigator;

public interface UserNavigator {
    void focusToEmail();
    void focusToPass();
    void showSnackbar(String msg);
    void showLoading(boolean show);
    void onLoginSuccess();
    void onLoginFailed(String msg);
    void onSignupSuccess();
    void onSignupFailed(String msg);
}
