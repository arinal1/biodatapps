package com.osg15.biodatapps.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.osg15.biodatapps.R;
import com.osg15.biodatapps.adapter.ListBiodataAdapter;
import com.osg15.biodatapps.base.BaseActivity;
import com.osg15.biodatapps.model.Biodata;
import com.osg15.biodatapps.navigator.ListBiodataNavigator;
import com.osg15.biodatapps.viewmodel.ListBiodataViewModel;

public class ListBiodataActivity extends BaseActivity implements ListBiodataNavigator {

    private ListBiodataViewModel viewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar loading;
    private RecyclerView recyclerView;
    private ListBiodataAdapter adapter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_biodata);
        initView();
        initData();
    }

    private void initView(){
        setTitle(R.string.biodata_app);
        loading = findViewById(R.id.loading);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                viewModel.getList(count,"");
                setLoading(View.VISIBLE);
            }
        });
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData(){
        count = getIntent().getIntExtra("count", 1);
        viewModel = new ListBiodataViewModel(this);
        viewModel.getList(count, "");
    }

    @Override
    public void onLoadSuccess(final Biodata biodataList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setLoading(View.GONE);
                adapter = new ListBiodataAdapter(ListBiodataActivity.this, biodataList.data);
                recyclerView.setAdapter(adapter);
                adapter.updateData(biodataList.data);
            }
        });
    }

    @Override
    public void onLoadFailed(String message) {
        setLoading(View.GONE);
        showSnackbar(message);
    }

    private void setLoading(int view){loading.setVisibility(view);}
}
