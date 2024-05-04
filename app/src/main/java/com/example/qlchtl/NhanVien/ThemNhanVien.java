package com.example.qlchtl.NhanVien;

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
import Database.NhanVienDataSource;
import Database.UuDaiDataSource;

public class ThemNhanVien extends AppCompatActivity {
    EditText tennv,phone, chucvu;
    Button dong,add;
    NhanVienDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_themnv);

        Intent intent = getIntent();
        tennv = (EditText) findViewById(R.id.txt_tennv);
        phone = (EditText) findViewById(R.id.txt_sdt);
        chucvu = (EditText) findViewById(R.id.txt_loai);
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
                dataSource = new NhanVienDataSource(ThemNhanVien.this);
                dataSource.open();
                String ten = tennv.getText().toString();
                String sdt = phone.getText().toString();
                String loai = chucvu.getText().toString();

                if(ten.isEmpty() || sdt.isEmpty() || loai.isEmpty())
                {
                    Toast.makeText(ThemNhanVien.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataSource.addNhanVien(ten,sdt, loai, "admin","123");
                    Toast.makeText(ThemNhanVien.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent intentkq = new Intent();
                    setResult(Activity.RESULT_OK, intentkq);
                    finish();
                }
            }
        });
    }
}
