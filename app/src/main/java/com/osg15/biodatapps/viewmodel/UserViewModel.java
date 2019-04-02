package com.osg15.biodatapps.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;
import com.osg15.biodatapps.data.UserRepository;
import com.osg15.biodatapps.data.UserSource;
import com.osg15.biodatapps.data.remote.UserRemoteDataSource;
import com.osg15.biodatapps.model.User;
import com.osg15.biodatapps.navigator.UserNavigator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserViewModel extends ViewModel {

    private UserNavigator userNavigator;
    private UserRepository userRepository = new UserRepository(new UserRemoteDataSource());

    public UserViewModel(UserNavigator userNavigator) {
        this.userNavigator = userNavigator;
    }

    public void login(String email, String pass) {
        if (cekValid(email, pass)){
            userRepository.login(email, pass, new UserSource.UserCallback() {
                @Override
                public void onDataLoaded(User data) {userNavigator.onLoginSuccess();}

                @Override
                public void onDataNotAvailable(String msg) {userNavigator.onLoginFailed(msg);}
            });
        }
    }

    public void signup(String email, String pass){
        if (cekValid(email, pass)){
            userRepository.signup(email, pass, new UserSource.UserCallback() {
                @Override
                public void onDataLoaded(User data) {userNavigator.onSignupSuccess();}

                @Override
                public void onDataNotAvailable(String msg) {userNavigator.onSignupFailed(msg);}
            });
        }
    }

    private boolean cekValid(String email, String password){
        boolean valid = false;
        int error = 0;
        if (TextUtils.isEmpty(email)) error = 1;
        else if (TextUtils.isEmpty(password)) error = 2;
        else if (password.length() < 6) error = 3;
        else {
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            Pattern p = java.util.regex.Pattern.compile(ePattern);
            Matcher m = p.matcher(email);
            if (!m.matches()) error = 4;
        }
        userNavigator.showLoading(false);
        switch (error){
            case 1:
                userNavigator.showSnackbar("Email kosong");
                userNavigator.focusToEmail();
                break;
            case 2:
                userNavigator.showSnackbar("Password kosong");
                userNavigator.focusToPass();
                break;
            case 3:
                userNavigator.showSnackbar("Password minimal 6 digit");
                userNavigator.focusToPass();
                break;
            case 4:
                userNavigator.showSnackbar("Email salah");
                userNavigator.focusToEmail();
                break;
            default:
                valid = true;
                userNavigator.showLoading(true);
                break;
        }
        return valid;
    }
}
