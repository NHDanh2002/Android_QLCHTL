package com.example.qlchtl.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.QLUuDai.ChiTietUuDaiGuest;
import com.example.qlchtl.QLUuDai.ChuongTrinhUuDaiAdapter;
import com.example.qlchtl.R;

import java.util.ArrayList;
import java.util.List;

import Database.UuDaiDataSource;

public class GuestSalesActivity extends AppCompatActivity{
    ImageView back;
    ListView lstuudai;

    List<UuDai> chuongTrinhUuDaiList;
    UuDaiDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_flashsale);
        back = (ImageView) findViewById(R.id.img_back);
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
                Intent intent = new Intent(GuestSalesActivity.this, ChiTietUuDaiGuest.class);
                intent.putExtra("MACT", selectedChuongTrinh.getMaCT());
                intent.putExtra("TENCT", selectedChuongTrinh.getTenCT());
                intent.putExtra("MOTA", selectedChuongTrinh.getMoTa());
                intent.putExtra("NGAYBD", selectedChuongTrinh.getNgayBatDau());
                intent.putExtra("NGAYKT", selectedChuongTrinh.getNgayKetThuc());
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
