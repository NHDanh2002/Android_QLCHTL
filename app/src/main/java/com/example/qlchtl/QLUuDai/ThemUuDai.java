package com.example.qlchtl.QLUuDai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Guest.GuestInfoActivity;
import com.example.qlchtl.Manager.ManagerUuDaiActivity;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

import Database.KhachHangDataSource;
import Database.UuDaiDataSource;

public class ThemUuDai extends AppCompatActivity {
    EditText tenct,mota,ngaybatdau,ngayketthuc;
    Button dong,add;
    UuDaiDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_themuudai);

        Intent intent = getIntent();
        tenct = (EditText) findViewById(R.id.txt_tenct);
        mota = (EditText) findViewById(R.id.txt_mota);
        ngaybatdau = (EditText) findViewById(R.id.txt_ngaybd);
        ngayketthuc = (EditText) findViewById(R.id.txt_ngaykt);
        dong = (Button) findViewById(R.id.btn_back);
        add = (Button) findViewById(R.id.btn_add);;
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new UuDaiDataSource(ThemUuDai.this);
                dataSource.open();
                String ten = tenct.getText().toString();
                String mt = mota.getText().toString();
                String ngaybd = ngaybatdau.getText().toString();
                String ngaykt = ngayketthuc.getText().toString();

                if(ten.isEmpty() || mt.isEmpty() || ngaybd.isEmpty() || ngaykt.isEmpty())
                {
                    Toast.makeText(ThemUuDai.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataSource.addUuDai(ten,mt, ngaybd, ngaykt);
                    Toast.makeText(ThemUuDai.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent intentkq = new Intent();
                    setResult(Activity.RESULT_OK, intentkq);
                    finish();
                }
            }
        });
    }
}
