package com.osg15.biodatapps.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class BiodataAdapter extends  RecyclerView.Adapter<BiodataAdapter.BiodataHolder> {

    @NonNull
    @Override
    public BiodataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BiodataHolder biodataHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BiodataHolder extends RecyclerView.ViewHolder {

        public BiodataHolder (@NonNull View itemView) {
            super(itemView);
        }
    }
}
