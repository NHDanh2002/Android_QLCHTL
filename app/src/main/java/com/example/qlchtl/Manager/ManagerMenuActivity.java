package com.example.qlchtl.Manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.R;

import com.example.qlchtl.Kho.Activity_Qlkho;
import com.example.qlchtl.DanhMuc.CategoryActivity;

public class ManagerMenuActivity extends AppCompatActivity {
    ImageView img_back,qlnv,qlkh,qlkho,qldanhmuc,qlhoadon,qluudai;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_menu);
        img_back = (ImageView) findViewById(R.id.img_back);
        qlnv = (ImageView) findViewById(R.id.qlnv);
        qlkh = (ImageView) findViewById(R.id.qlkh);
        qlkho = (ImageView) findViewById(R.id.qlkho);
        qldanhmuc = (ImageView) findViewById(R.id.qldanhmuc);
        qlhoadon = (ImageView) findViewById(R.id.qlhoadon);
        qluudai = (ImageView) findViewById(R.id.qluudai);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        qlkho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ManagerMenuActivity.this, Activity_Qlkho.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(ManagerMenuActivity.this, "Không thể mở trang quản lý kho", Toast.LENGTH_SHORT).show();
                }
            }
        });
        qldanhmuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ManagerMenuActivity.this, CategoryActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(ManagerMenuActivity.this, "Không thể mở trang quản lý danh mục・", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        Button btn2 = findViewById(R.id.hoadon);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent = new Intent(TrangChuAdminActivity.this, Activity_Qlkho.class);
//                    startActivity(intent);
//                } catch (Exception e) {
//                    Toast.makeText(TrangChuAdminActivity.this, "Khﾃｴng th盻・m盻・, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        qlkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerMenuActivity.this, ManagerKhachHangActivity.class);
                startActivity(intent);
            }
        });
        qlnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ManagerMenuActivity.this, ManagerNhanVienActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(ManagerMenuActivity.this, "Không thể mở trang quản lý nhân viên", Toast.LENGTH_SHORT).show();
                }
            }
        });
        qlhoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ManagerMenuActivity.this, ManagerHoaDonActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(ManagerMenuActivity.this, "Không thể mở trang quản lý hóa đơn", Toast.LENGTH_SHORT).show();
                }
            }
        });
        qluudai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerMenuActivity.this, ManagerUuDaiActivity.class);
                startActivity(intent);
            }
        });
    }
}
