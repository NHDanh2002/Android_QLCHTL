package com.example.qlchtl.QLUuDai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

import java.util.List;

public class ChuongTrinhUuDaiAdapter extends ArrayAdapter<UuDai> {

    private List<UuDai> chuongTrinhUuDaiList;
    private Context context;

    public ChuongTrinhUuDaiAdapter(Context context, List<UuDai> objects) {
        super(context, R.layout.list_item_uudai, objects);
        this.context = context;
        this.chuongTrinhUuDaiList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.list_item_uudai, parent, false);
        }

        UuDai chuongTrinhUuDai = chuongTrinhUuDaiList.get(position);

        TextView tvTenCT = itemView.findViewById(R.id.tvTenCT);
        TextView tvNgayBatDau = itemView.findViewById(R.id.tvNgayBatDau);
        TextView tvNgayKetThuc = itemView.findViewById(R.id.tvNgayKetThuc);

        tvTenCT.setText(chuongTrinhUuDai.getTenCT());
        tvNgayBatDau.setText("Ngày bắt đầu: " + chuongTrinhUuDai.getNgayBatDau());
        tvNgayKetThuc.setText("Ngày kết thúc: " + chuongTrinhUuDai.getNgayKetThuc());

        return itemView;
    }
}
