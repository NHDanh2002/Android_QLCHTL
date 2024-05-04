package com.example.qlchtl.Manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Guest.GuestSalesActivity;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.QLUuDai.ChiTietUuDaiGuest;
import com.example.qlchtl.QLUuDai.ChitietUuDaiManager;
import com.example.qlchtl.QLUuDai.ChuongTrinhUuDaiAdapter;
import com.example.qlchtl.QLUuDai.ThemUuDai;
import com.example.qlchtl.R;

import java.util.List;

import Database.UuDaiDataSource;

public class ManagerUuDaiActivity extends AppCompatActivity {
    ImageView back,add;
    ListView lstuudai;

    List<UuDai> chuongTrinhUuDaiList;
    UuDaiDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_qluudai);
        back = (ImageView) findViewById(R.id.img_back);
        add = (ImageView) findViewById(R.id.img_them);
        lstuudai = (ListView) findViewById(R.id.list_uudai);
        dataSource = new UuDaiDataSource(this);
        dataSource.open();

        chuongTrinhUuDaiList = dataSource.getAllChuongTrinhUuDai();

        ChuongTrinhUuDaiAdapter adapter = new ChuongTrinhUuDaiAdapter(this, chuongTrinhUuDaiList);
        lstuudai.setAdapter(adapter);
        lstuudai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UuDai selectedChuongTrinh = chuongTrinhUuDaiList.get(position);
                Intent intent = new Intent(ManagerUuDaiActivity.this, ChitietUuDaiManager.class);
                intent.putExtra("MACT", selectedChuongTrinh.getMaCT());
                intent.putExtra("TENCT", selectedChuongTrinh.getTenCT());
                intent.putExtra("MOTA", selectedChuongTrinh.getMoTa());
                intent.putExtra("NGAYBD", selectedChuongTrinh.getNgayBatDau());
                intent.putExtra("NGAYKT", selectedChuongTrinh.getNgayKetThuc());
                startActivityForResult(intent,1);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentadd = new Intent(ManagerUuDaiActivity.this, ThemUuDai.class);
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
                dataSource = new UuDaiDataSource(this);
                dataSource.open();

                chuongTrinhUuDaiList = dataSource.getAllChuongTrinhUuDai();

                ChuongTrinhUuDaiAdapter adapter = new ChuongTrinhUuDaiAdapter(this, chuongTrinhUuDaiList);
                lstuudai.setAdapter(adapter);
            }
        }
    }
}
