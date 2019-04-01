package com.osg15.biodatapps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osg15.biodatapps.R;
import com.osg15.biodatapps.navigator.UserNavigator;
import com.osg15.biodatapps.utils.LoadingDialog;
import com.osg15.biodatapps.viewmodel.UserViewModel;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements UserNavigator {

    private EditText inputEmail, inputPassword;
    private Button btnSend;
    private TextView tvSignup, tvPrompt;
    private LoadingDialog loadingDialog;
    private UserViewModel userViewModel;
    private boolean inLogin = true;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initOnclick();
        userViewModel = new UserViewModel(this);
    }

    private void initView(){
        inputEmail = findViewById(R.id.etEmail);
        inputPassword = findViewById(R.id.etPassword);
        btnSend = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tv_signup);
        tvPrompt = findViewById(R.id.tv_account_prompt);
        loadingDialog = new LoadingDialog(this);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void initOnclick(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onClickBtnSend();}
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inLogin){
                    btnSend.setText(R.string.signup);
                    tvPrompt.setText(R.string.have_account);
                    tvSignup.setText(R.string.btn_signin);
                } else {
                    btnSend.setText(R.string.signin);
                    tvPrompt.setText(R.string.no_account);
                    tvSignup.setText(R.string.btn_signup);
                }
                inLogin = !inLogin;
            }
        });
    }

    private void onClickBtnSend(){
        showLoading(true);
        hideKeyboard();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        if (inLogin) userViewModel.login(email, password);
        else userViewModel.signup(email, password);
    }

    @Override
    public void focusToEmail() {inputEmail.requestFocus();}

    @Override
    public void focusToPass() {inputPassword.requestFocus();}

    @Override
    public void showSnackbar(String msg) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void onLoginFailed(String msg) {
        showLoading(false);
        showSnackbar(msg);
    }

    @Override
    public void onSignupSuccess() {
        showSnackbar("Signup Success");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        }, 100);
    }

    @Override
    public void onSignupFailed(String msg) {
        loadingDialog.hide();
        showSnackbar(msg);
    }

    @SuppressLint("NewApi")
    private void hideKeyboard(){
        imm.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
    }

    private void showLoading(boolean show){
        if (show) loadingDialog.show();
        else loadingDialog.hide();
    }
}
