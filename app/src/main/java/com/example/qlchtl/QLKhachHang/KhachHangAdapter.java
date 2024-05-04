package com.example.qlchtl.QLKhachHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

import java.util.List;

public class KhachHangAdapter extends ArrayAdapter<KhachHang> {

    private List<KhachHang> KhachHanglist;
    private Context context;

    public KhachHangAdapter(Context context, List<KhachHang> objects) {
        super(context, R.layout.list_item_kh, objects);
        this.context = context;
        this.KhachHanglist = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.list_item_kh, parent, false);
        }

        KhachHang khachHang = KhachHanglist.get(position);

        TextView tvTenKH = itemView.findViewById(R.id.tvTenKH);
        TextView tvSDT = itemView.findViewById(R.id.tvSDT);
        TextView tvLoai = itemView.findViewById(R.id.tvLoai);

        tvTenKH.setText(khachHang.getTenkh());
        tvSDT.setText("Số điện thoại: " + khachHang.getSdt());
        tvLoai.setText("Bậc: " + khachHang.getLoaikh());

        return itemView;
    }
}
