package com.osg15.biodatapps.data;

import com.osg15.biodatapps.data.remote.UserRemoteDataSource;
import com.osg15.biodatapps.model.User;

public class UserRepository implements UserSource {

    private UserRemoteDataSource userRemoteDataSource;

    public UserRepository(UserRemoteDataSource userRemoteDataSource){
        this.userRemoteDataSource = userRemoteDataSource;
    }

    @Override
    public void login(String email, String password, final UserCallback callback) {
        userRemoteDataSource.login(email, password, new UserCallback() {
            @Override
            public void onDataLoaded(User data) {
                callback.onDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                callback.onDataNotAvailable(msg);
            }
        });
    }

    @Override
    public void signup(String email, String password, final UserCallback callback) {
        userRemoteDataSource.signup(email, password, new UserCallback() {
            @Override
            public void onDataLoaded(User data) {
                callback.onDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                callback.onDataNotAvailable(msg);
            }
        });
    }
}