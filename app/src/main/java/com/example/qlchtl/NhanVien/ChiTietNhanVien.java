package com.example.qlchtl.NhanVien;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.QLUuDai.ChitietUuDaiManager;
import com.example.qlchtl.R;

import Database.NhanVienDataSource;

public class ChiTietNhanVien extends AppCompatActivity {
    EditText tennv,sdt,loai;
    Button dong, capnhat;
    NhanVienDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_chitietnv);

        Intent intent = getIntent();
        Integer manv = intent.getIntExtra("MANV",-1);
        tennv = (EditText) findViewById(R.id.txt_tennv);
        sdt = (EditText) findViewById(R.id.txt_sdt);
        loai = (EditText) findViewById(R.id.txt_loai);
        dong = (Button) findViewById(R.id.btn_back);
        capnhat = (Button) findViewById(R.id.btn_update);

        tennv.setText(intent.getStringExtra("TENNV"));
        sdt.setText(intent.getStringExtra("SDT"));
        loai.setText(intent.getStringExtra("CHUCVU"));
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new NhanVienDataSource(ChiTietNhanVien.this);
                dataSource.open();
                String tennv_moi = tennv.getText().toString();
                String sdt_moi = sdt.getText().toString();
                String loai_moi = loai.getText().toString();

                int kq = dataSource.updateNhanVien(manv, tennv_moi,sdt_moi, loai_moi);
                if(kq > 0)
                {
                    Toast.makeText(ChiTietNhanVien.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    tennv.setText(tennv_moi);
                    sdt.setText(sdt_moi);
                    loai.setText(loai_moi);
                    Intent intentkq = new Intent();
                    setResult(Activity.RESULT_OK, intentkq);
                    finish();
                }
                else {
                    Toast.makeText(ChiTietNhanVien.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
