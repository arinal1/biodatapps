package com.osg15.biodatapps.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.osg15.biodatapps.data.BiodataRepository;
import com.osg15.biodatapps.data.BiodataSource;
import com.osg15.biodatapps.data.local.BiodataLocalDataSource;
import com.osg15.biodatapps.data.remote.BiodataRemoteDataSource;
import com.osg15.biodatapps.model.Biodata;
import com.osg15.biodatapps.navigator.ListBiodataNavigator;

import java.util.List;

public class ListBiodataViewModel extends ViewModel {

    private ListBiodataNavigator navigator;
    private BiodataRepository repository;

    public ListBiodataViewModel(ListBiodataNavigator listBiodataNavigator){
        navigator = listBiodataNavigator;
        repository = new BiodataRepository(new BiodataRemoteDataSource(), new BiodataLocalDataSource((Context) navigator));
    }

    public void getList(int count, String filter){
        if (!filter.isEmpty()){
//            repository.getListBiodataCount(new BiodataSource.GetBiodataCallback() {
//                @Override
//                public void onGetSuccess(List<Biodata> data) {navigator.onLoadSuccess(data);}
//
//                @Override
//                public void onGetFailed(String errorMessage) {navigator.onLoadFailed(errorMessage);}
//            });
        } else {
            repository.getListBiodataCount(count, new BiodataSource.GetBiodataCallback() {
                @Override
                public void onGetSuccess(Biodata data) {navigator.onLoadSuccess(data);}

                @Override
                public void onGetFailed(String errorMessage) {navigator.onLoadFailed(errorMessage);}
            });
        }
    }

}
