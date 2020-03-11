package com.example.myapplication;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Database.DataDiri;

public class dataDiriAdapter extends RecyclerView.Adapter<dataDiriAdapter.VH> {

    private DataDiri[] list;
    private dataDiriListener listener;


    public dataDiriAdapter(DataDiri[] list, dataDiriListener listener){
        this.list = list;
        this.listener = listener;
    }
    @NonNull
    @Override
    public dataDiriAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_datadiri, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull dataDiriAdapter.VH holder, int position) {
        final DataDiri item = list[position];

        holder.tvNama.setText(item.getNama());
        holder.tvAlamat.setText(item.getAlamat());
        holder.tvJK.setText("" + item.getJk());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onButtonDelete(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvJK;
        Button btnDelete;
        public VH(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvJK = itemView.findViewById(R.id.tvJK);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
