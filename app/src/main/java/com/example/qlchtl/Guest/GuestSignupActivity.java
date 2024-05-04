package com.example.qlchtl.Guest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.R;

import Database.KhachHangDataSource;

public class GuestSignupActivity extends AppCompatActivity {
    ImageView back;
    EditText ten, sdt, taikhoan, matkhau, matkhaunhaplai;
    Button dangky;
    KhachHangDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_signup);

        back = (ImageView) findViewById(R.id.img_back);
        ten = (EditText) findViewById(R.id.guest_name);
        sdt = (EditText) findViewById(R.id.guest_phone);
        taikhoan = (EditText) findViewById(R.id.guest_taikhoan);
        matkhau = (EditText) findViewById(R.id.guest_matkhau);
        matkhaunhaplai = (EditText) findViewById(R.id.guest_matkhau_again);
        dangky = (Button) findViewById(R.id.btn_signup);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guestname = ten.getText().toString();
                String guestphone = sdt.getText().toString();
                String username = taikhoan.getText().toString();
                String password1 = matkhau.getText().toString();
                String password2 = matkhaunhaplai.getText().toString();
                if(guestname.isEmpty() || guestphone.isEmpty() || username.isEmpty() || password1.isEmpty() || password2.isEmpty())
                {
                    Toast.makeText(GuestSignupActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if(!password1.equals(password2))
                {
                    Toast.makeText(GuestSignupActivity.this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
                    matkhau.setText("");
                    matkhaunhaplai.setText("");
                } else {
                    dataSource = new KhachHangDataSource(GuestSignupActivity.this);
                    dataSource.open();
                    long kq = dataSource.addKhachHang(guestname,guestphone,"bạc",username,password1);
                    if (kq != -1) {
                        Toast.makeText(GuestSignupActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(GuestSignupActivity.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
