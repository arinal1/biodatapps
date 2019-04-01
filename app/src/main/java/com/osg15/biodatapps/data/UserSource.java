package com.osg15.biodatapps.data;

import com.osg15.biodatapps.model.User;

public interface UserSource {
    void login(String email, String password, UserCallback callback);
    void signup(String email, String password, UserCallback callback);

    interface UserCallback {
        void onDataLoaded(User data);
        void onDataNotAvailable(String msg);
    }
}
