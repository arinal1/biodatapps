package com.kejar15.biodata.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kejar15.biodata.R;
import com.kejar15.biodata.viewmodel.UserViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.etEmail);
        inputPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    String email, password;
//                    email = inputEmail.getText().toString();
//                    password = inputPassword.getText().toString();
//                    userViewModel.updateModel(email, password);
//                    userViewModel.validLogin();

//                userViewModel.updateModel(inputEmail.getText().toString(),inputPassword.getText().toString());
//                userViewModel.validLogin();

                Toast.makeText(getApplicationContext(),"Ok Login", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
