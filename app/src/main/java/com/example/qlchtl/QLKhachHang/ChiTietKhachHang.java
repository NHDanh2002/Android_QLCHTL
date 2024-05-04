package com.example.qlchtl.QLKhachHang;

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

import Database.KhachHangDataSource;

public class ChiTietKhachHang extends AppCompatActivity {
    EditText tenkh,sdt,loai;
    Button dong, capnhat;
    KhachHangDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_chitietkh);

        Intent intent = getIntent();
        Integer makh = intent.getIntExtra("MAKH",-1);
        tenkh = (EditText) findViewById(R.id.txt_tenkh);
        sdt = (EditText) findViewById(R.id.txt_sdt);
        loai = (EditText) findViewById(R.id.txt_loai);
        dong = (Button) findViewById(R.id.btn_back);
        capnhat = (Button) findViewById(R.id.btn_update);
        tenkh.setText(intent.getStringExtra("TENKH"));
        sdt.setText(intent.getStringExtra("SDT"));
        loai.setText(intent.getStringExtra("LOAI"));
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new KhachHangDataSource(ChiTietKhachHang.this);
                dataSource.open();
                String tenkh_moi = tenkh.getText().toString();
                String sdt_moi = sdt.getText().toString();
                String loai_moi = loai.getText().toString();

                int kq = dataSource.updateKhachHang_manager(makh,tenkh_moi,sdt_moi, loai_moi);
                if(kq > 0)
                {
                    Toast.makeText(ChiTietKhachHang.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    tenkh.setText(tenkh_moi);
                    sdt.setText(sdt_moi);
                    loai.setText(loai_moi);
                    Intent intentkq = new Intent();
                    setResult(Activity.RESULT_OK, intentkq);
                    finish();
                }
                else {
                    Toast.makeText(ChiTietKhachHang.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
