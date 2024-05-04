package com.example.qlchtl.NhanVien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.Object.NhanVien;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

import java.util.List;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {

    private List<NhanVien> nhanVienList;
    private Context context;

    public NhanVienAdapter(Context context, List<NhanVien> objects) {
        super(context, R.layout.list_item_nv, objects);
        this.context = context;
        this.nhanVienList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.list_item_nv, parent, false);
        }

        NhanVien nhanvien = nhanVienList.get(position);

        TextView tvTenNV = itemView.findViewById(R.id.tvTenNV);
        TextView tvLoai = itemView.findViewById(R.id.tvLoai);

        tvTenNV.setText(nhanvien.getTenNV());
        tvLoai.setText("Chức vụ: " + nhanvien.getChucVu());

        return itemView;
    }
}
