package com.eja.realmcrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eja.realmcrud.R;
import com.eja.realmcrud.activities.UpdateDataActivity;
import com.eja.realmcrud.model.ModelSiswa;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ModelSiswa> modelSiswa;

    public DataAdapter(Context context, ArrayList<ModelSiswa> modelSiswa) {
        this.context = context;
        this.modelSiswa = modelSiswa;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvEmail, tvMotto;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_list_nama);
            tvAlamat = itemView.findViewById(R.id.tv_list_alamat);
            tvEmail = itemView.findViewById(R.id.tv_list_email);
            tvMotto = itemView.findViewById(R.id.tv_list_motto);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item_data, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNama.setText(modelSiswa.get(position).getNama());
        holder.tvAlamat.setText(modelSiswa.get(position).getAlamat());
        holder.tvEmail.setText(modelSiswa.get(position).getEmail());
        holder.tvMotto.setText(modelSiswa.get(position).getMotto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, UpdateDataActivity.class);
                pindah.putExtra("DATA_ID", modelSiswa.get(position).getId());
                pindah.putExtra("DATA_NAMA", modelSiswa.get(position).getNama());
                pindah.putExtra("DATA_ALAMAT", modelSiswa.get(position).getAlamat());
                pindah.putExtra("DATA_EMAIL", modelSiswa.get(position).getEmail());
                pindah.putExtra("DATA_MOTTO", modelSiswa.get(position).getMotto());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelSiswa.size();
    }
}
