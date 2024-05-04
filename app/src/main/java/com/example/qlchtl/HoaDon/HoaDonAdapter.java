package com.example.qlchtl.HoaDon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qlchtl.Object.HoaDon;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

import java.util.List;

public class HoaDonAdapter extends ArrayAdapter<HoaDon> {

    private List<HoaDon> HoaDonList;
    private Context context;

    public HoaDonAdapter(Context context, List<HoaDon> objects) {
        super(context, R.layout.list_item_hoadon, objects);
        this.context = context;
        this.HoaDonList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.list_item_hoadon, parent, false);
        }

        HoaDon hoaDon = HoaDonList.get(position);

        TextView tvHoaDon = itemView.findViewById(R.id.tvHoaDon);
        TextView tvNgayLap = itemView.findViewById(R.id.tvNgayLap);

        tvHoaDon.setText("Hoá đơn " + hoaDon.getMahd());
        tvNgayLap.setText("Ngày lập: " + hoaDon.getNgaylap());
        return itemView;
    }
}
