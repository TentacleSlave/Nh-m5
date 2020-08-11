package tdc.edu.vn.test.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import tdc.edu.vn.test.Model.SanPham;
import tdc.edu.vn.test.R;

public class CustomAdapterSanPham extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SanPham> data;
    ArrayList<ArrayList<SanPham>> data_CS;

    public CustomAdapterSanPham(Context context, int resource, ArrayList<SanPham> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_CS = new ArrayList<ArrayList<SanPham>>();
        this.data_CS.add(data);
    }

    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgDelete;
        TextView tvTenSP;
        TextView tvMaSP;
        TextView tvLoai;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        Holder holder = null;
        if(view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgDelete = view.findViewById(R.id.imgDelect);
            holder.tvTenSP = view.findViewById(R.id.tvTenSP);
            holder.tvMaSP = view.findViewById(R.id.tvMaSP);
            holder.tvLoai = view.findViewById(R.id.tvLoai);
            view.setTag(holder);
        }
        else
            holder=(Holder)view.getTag();

        SanPham sanPham = data.get(position);
        holder.tvMaSP.setText(sanPham.getMasp());
        holder.tvTenSP.setText(sanPham.getTensp());
        holder.tvLoai.setText(sanPham.getLoai());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Xóa", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}


