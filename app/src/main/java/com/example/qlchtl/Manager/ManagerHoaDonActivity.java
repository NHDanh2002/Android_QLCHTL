package com.example.qlchtl.Manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.HoaDon.ChiTietHoaDon;
import com.example.qlchtl.HoaDon.HoaDonAdapter;
import com.example.qlchtl.Object.HoaDon;
import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.QLKhachHang.ChiTietKhachHang;
import com.example.qlchtl.QLKhachHang.KhachHangAdapter;
import com.example.qlchtl.R;

import java.util.List;

import Database.HoaDonDataSource;

public class ManagerHoaDonActivity extends AppCompatActivity {
    ImageView back;
    ListView lsthd;
    List<HoaDon> HDlist;
    HoaDonDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_qlhoadon);
        back = (ImageView) findViewById(R.id.img_back);
        lsthd = (ListView) findViewById(R.id.list_hd);
        dataSource = new HoaDonDataSource(this);
        dataSource.open();
        HDlist = dataSource.getAllHoaDon();
        HoaDonAdapter adapter = new HoaDonAdapter(this, HDlist);
        lsthd.setAdapter(adapter);
        lsthd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HoaDon selectedkh = HDlist.get(position);
                Intent intent = new Intent(ManagerHoaDonActivity.this, ChiTietHoaDon.class);
                intent.putExtra("MAHD", selectedkh.getMahd());
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
