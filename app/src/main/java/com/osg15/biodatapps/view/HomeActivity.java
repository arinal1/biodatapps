package com.osg15.biodatapps.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.osg15.biodatapps.R;
import com.osg15.biodatapps.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        setTitle(R.string.biodata_app);
        hideBackButton();
        final EditText count = findViewById(R.id.et_count);
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(count.getText().toString())) {
                    showSnackbar("Jumlah data kosong");
                    count.requestFocus();
                } else {
                    Intent i = new Intent(HomeActivity.this, ListBiodataActivity.class);
                    i.putExtra("count", Integer.parseInt(count.getText().toString()));
                    startActivity(i);
                }
            }
        });
    }
}
