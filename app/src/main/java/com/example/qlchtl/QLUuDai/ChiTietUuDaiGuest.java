package com.example.qlchtl.QLUuDai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.R;

public class ChiTietUuDaiGuest extends AppCompatActivity {
    EditText tenct,mota,ngaybatdau,ngayketthuc;
    Button dong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_salesdetail);

        Intent intent = getIntent();
        tenct = (EditText) findViewById(R.id.txt_tenct);
        mota = (EditText) findViewById(R.id.txt_mota);
        ngaybatdau = (EditText) findViewById(R.id.txt_ngaybd);
        ngayketthuc = (EditText) findViewById(R.id.txt_ngaykt);
        dong = (Button) findViewById(R.id.btn_back);
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
    }
}
