package com.example.qlchtl.Manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.NhanVien.ChiTietNhanVien;
import com.example.qlchtl.NhanVien.NhanVienAdapter;
import com.example.qlchtl.NhanVien.ThemNhanVien;
import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.Object.NhanVien;
import com.example.qlchtl.QLKhachHang.ChiTietKhachHang;
import com.example.qlchtl.QLKhachHang.KhachHangAdapter;
import com.example.qlchtl.QLUuDai.ThemUuDai;
import com.example.qlchtl.R;

import java.util.List;

import Database.KhachHangDataSource;
import Database.NhanVienDataSource;

public class ManagerNhanVienActivity extends AppCompatActivity {
    ImageView back,add;
    ListView lstnv;
    List<NhanVien> NVlist;
    NhanVienDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_qlnv);
        back = (ImageView) findViewById(R.id.img_back);
        add = (ImageView) findViewById(R.id.img_them);
        lstnv = (ListView) findViewById(R.id.list_nv);
        dataSource = new NhanVienDataSource(this);
        dataSource.open();
        NVlist = dataSource.getAllNhanVien();
        NhanVienAdapter adapter = new NhanVienAdapter(this, NVlist);
        lstnv.setAdapter(adapter);
        lstnv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NhanVien selectedkh = NVlist.get(position);
                Intent intent = new Intent(ManagerNhanVienActivity.this, ChiTietNhanVien.class);
                intent.putExtra("MANV", selectedkh.getMaNV());
                intent.putExtra("TENNV", selectedkh.getTenNV());
                intent.putExtra("SDT", selectedkh.getSdt());
                intent.putExtra("CHUCVU", selectedkh.getChucVu());
                startActivityForResult(intent,1);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentadd = new Intent(ManagerNhanVienActivity.this, ThemNhanVien.class);
                startActivityForResult(intentadd,1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                dataSource = new NhanVienDataSource(this);
                dataSource.open();

                NVlist = dataSource.getAllNhanVien();

                NhanVienAdapter adapter = new NhanVienAdapter(this, NVlist);
                lstnv.setAdapter(adapter);
            }
        }
    }
}
