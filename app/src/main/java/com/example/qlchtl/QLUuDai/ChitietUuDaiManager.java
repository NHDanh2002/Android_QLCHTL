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

public class ChitietUuDaiManager extends AppCompatActivity {
    EditText tenct,mota,ngaybatdau,ngayketthuc;
    Button dong,update;
    UuDaiDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_chitietuudai);

        Intent intent = getIntent();
        tenct = (EditText) findViewById(R.id.txt_tenct);
        mota = (EditText) findViewById(R.id.txt_mota);
        ngaybatdau = (EditText) findViewById(R.id.txt_ngaybd);
        ngayketthuc = (EditText) findViewById(R.id.txt_ngaykt);
        dong = (Button) findViewById(R.id.btn_back);
        update = (Button) findViewById(R.id.btn_update);
        Integer mact = intent.getIntExtra("MACT",-1);
        tenct.setText(intent.getStringExtra("TENCT"));
        mota.setText(intent.getStringExtra("MOTA"));
        ngaybatdau.setText(intent.getStringExtra("NGAYBD"));
        ngayketthuc.setText(intent.getStringExtra("NGAYKT"));
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new UuDaiDataSource(ChitietUuDaiManager.this);
                dataSource.open();
                String tenct_moi = tenct.getText().toString();
                String mota_moi = mota.getText().toString();
                String ngaybd = ngaybatdau.getText().toString();
                String ngaykt = ngayketthuc.getText().toString();

                int kq = dataSource.updateUuDai(mact,tenct_moi,mota_moi, ngaybd, ngaykt);
                if(kq > 0)
                {
                    Toast.makeText(ChitietUuDaiManager.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    tenct.setText(tenct_moi);
                    mota.setText(mota_moi);
                    ngaybatdau.setText(ngaybd);
                    ngayketthuc.setText(ngaykt);
                    Intent intentkq = new Intent();
                    setResult(Activity.RESULT_OK, intentkq);
                    finish();
                }
                else {
                    Toast.makeText(ChitietUuDaiManager.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
