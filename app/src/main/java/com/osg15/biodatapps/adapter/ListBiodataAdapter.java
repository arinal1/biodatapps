package com.osg15.biodatapps.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.osg15.biodatapps.R;
import com.osg15.biodatapps.model.DetailBiodata;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListBiodataAdapter extends RecyclerView.Adapter<ListBiodataAdapter.BiodataHolder> {

    private Context context;
    private List<DetailBiodata> data;

    public ListBiodataAdapter(Context context, List<DetailBiodata> data){
        this.context = context;
        this.data = data;
    }

    public void updateData(List<DetailBiodata> data){
        this.data = data;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BiodataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BiodataHolder(LayoutInflater.from(context).inflate(R.layout.item_biodata, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BiodataHolder biodataHolder, int i) {
        DetailBiodata.Name dataName = data.get(i).name;
        String name = dataName.first + " " + dataName.last;
        DetailBiodata.Location dataLocation = data.get(i).location;
        String location = dataLocation.street + ", " + dataLocation.city + ", " + dataLocation.state;
        biodataHolder.tvNama.setText(name);
        biodataHolder.tvHp.setText(data.get(i).cell);
        biodataHolder.tvAlamat.setText(location);
        Picasso.get().load(data.get(i).picture.medium).into(biodataHolder.ivFoto);
        biodataHolder.cvLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "HALO", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class BiodataHolder extends RecyclerView.ViewHolder {
        private CardView cvLayout;
        private ImageView ivFoto;
        private TextView tvNama;
        private TextView tvHp;
        private TextView tvAlamat;

        BiodataHolder(@NonNull View itemView) {
            super(itemView);
            cvLayout = itemView.findViewById(R.id.cv_layout);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_name);
            tvHp = itemView.findViewById(R.id.tv_phone);
            tvAlamat = itemView.findViewById(R.id.tv_location);
        }
    }
}
