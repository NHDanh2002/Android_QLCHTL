package com.example.qlchtl.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.MainActivity;
import com.example.qlchtl.R;

import Database.KhachHangDataSource;

public class GuestInfoActivity extends AppCompatActivity {
    ImageView back;
    EditText hoten, sdt,loai,taikhoan,matkhau;
    Button update,logout;
    KhachHangDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_info);
        back = (ImageView) findViewById(R.id.imgback);
        hoten = (EditText) findViewById(R.id.txt_guestname);
        sdt = (EditText) findViewById(R.id.txt_guestphone);
        loai = (EditText) findViewById(R.id.txt_guesttype);
        taikhoan = (EditText) findViewById(R.id.txt_guestusername);
        matkhau = (EditText) findViewById(R.id.txt_guestpassword);
        update = (Button) findViewById(R.id.btn_guestupdate);
        logout = (Button) findViewById(R.id.btn_guestlogout);

        Intent intent = getIntent();
        Integer userId = intent.getIntExtra("USER_ID", -1);
        String name = intent.getStringExtra("NAME");
        String type = intent.getStringExtra("LOAI");
        String phone = intent.getStringExtra("PHONE");
        String username = intent.getStringExtra("USERNAME");
        String password = intent.getStringExtra("PASSWORD");

        hoten.setText(name);
        sdt.setText(phone);
        loai.setText(type);
        taikhoan.setText(username);
        matkhau.setText(password);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource = new KhachHangDataSource(GuestInfoActivity.this);
                dataSource.open();
                String newname = hoten.getText().toString();
                String newphone = sdt.getText().toString();
                String newusername = taikhoan.getText().toString();
                String newpassword = matkhau.getText().toString();

                int kq = dataSource.updateKhachHang(userId,newname,newphone, newusername, newpassword);
                if(kq > 0)
                {
                    Toast.makeText(GuestInfoActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    hoten.setText(newname);
                    sdt.setText(newphone);
                    taikhoan.setText(newusername);
                    matkhau.setText(newpassword);
                }
                else {
                    Toast.makeText(GuestInfoActivity.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout_intent = new Intent(GuestInfoActivity.this, MainActivity.class);
                startActivity(logout_intent);
            }
        });
    }
}
