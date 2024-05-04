package com.example.qlchtl.Manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.QLKhachHang.ChiTietKhachHang;
import com.example.qlchtl.QLKhachHang.KhachHangAdapter;
import com.example.qlchtl.R;

import java.util.List;

import Database.KhachHangDataSource;

public class ManagerKhachHangActivity extends AppCompatActivity {
    ImageView back;
    ListView lstkh;
    List<KhachHang> KHlist;
    KhachHangDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_qlkhachhang);
        back = (ImageView) findViewById(R.id.img_back);
        lstkh = (ListView) findViewById(R.id.list_kh);
        dataSource = new KhachHangDataSource(this);
        dataSource.open();
        KHlist = dataSource.getAllKhachHang();
        KhachHangAdapter adapter = new KhachHangAdapter(this, KHlist);
        lstkh.setAdapter(adapter);
        lstkh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                KhachHang selectedkh = KHlist.get(position);
                Intent intent = new Intent(ManagerKhachHangActivity.this, ChiTietKhachHang.class);
                intent.putExtra("MAKH", selectedkh.getMakh());
                intent.putExtra("TENKH", selectedkh.getTenkh());
                intent.putExtra("SDT", selectedkh.getSdt());
                intent.putExtra("LOAI", selectedkh.getLoaikh());
                startActivityForResult(intent,1);
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
                dataSource = new KhachHangDataSource(this);
                dataSource.open();

                KHlist = dataSource.getAllKhachHang();

                KhachHangAdapter adapter = new KhachHangAdapter(this, KHlist);
                lstkh.setAdapter(adapter);
            }
        }
    }
}
