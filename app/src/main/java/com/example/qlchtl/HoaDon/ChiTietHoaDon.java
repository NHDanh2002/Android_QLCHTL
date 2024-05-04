package com.example.qlchtl.HoaDon;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.CTHoaDon;
import com.example.qlchtl.Object.ChiTietHoaDonItem;
import com.example.qlchtl.Object.UuDai;
import com.example.qlchtl.QLUuDai.ChitietUuDaiManager;
import com.example.qlchtl.R;

import java.util.ArrayList;
import java.util.List;

import Database.ChiTietHoaDonDataSource;
import Database.KhachHangDataSource;
import Database.QLCHTL_DatabaseHandler;

public class ChiTietHoaDon extends AppCompatActivity {
    EditText tenkh,tennv,ngaylap,thanhtien;
    ListView lstct;
    Button dong;
    ChiTietHoaDonDataSource dataSource;

    ArrayList<ChiTietHoaDonItem> cthd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_chitiethoadon);
        tenkh = (EditText) findViewById(R.id.txt_tenkh);
        tennv = (EditText) findViewById(R.id.txt_tennv);
        ngaylap = (EditText) findViewById(R.id.txt_date);
        dong = (Button) findViewById(R.id.btn_back);
        lstct = (ListView) findViewById(R.id.lst_danhsach);
        thanhtien = (EditText) findViewById(R.id.txt_thanhtien);
        Intent intent = getIntent();
        Integer mahd = intent.getIntExtra("MAHD", -1);
        /*dataSource = new ChiTietHoaDonDataSource(this);
        dataSource.open();
        cthd = new ArrayList<>();
        cthd = dataSource.dsSanPham(mahd);
        ArrayAdapter<ChiTietHoaDonItem> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cthd);
        lstct.setAdapter(adapter);*/

        QLCHTL_DatabaseHandler dbHelper = new QLCHTL_DatabaseHandler(this);
        double tongthanhtien = dbHelper.tinhTongThanhTienTheoMAHD(mahd);
        thanhtien.setText(String.valueOf(tongthanhtien));
        ArrayList<ChiTietHoaDonItem> dstensp = new ArrayList<>();
        dataSource = new ChiTietHoaDonDataSource(this);
        dataSource.open();
        dstensp = dataSource.dsSanPham(mahd);
        ArrayAdapter<ChiTietHoaDonItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dstensp);
        lstct.setAdapter(adapter);
        Cursor cursor = dbHelper.getDataByMAHD(mahd);
        if (cursor != null && cursor.moveToFirst()) {
            int tenKHIndex = cursor.getColumnIndex("TENKH");
            int tenNVIndex = cursor.getColumnIndex("TENNV");
            int ngayLapIndex = cursor.getColumnIndex("NGAYLAP");
            int thanhTienIndex = cursor.getColumnIndex("THANHTIEN");
            if (tenKHIndex != -1 && tenNVIndex != -1 && ngayLapIndex != -1 && thanhTienIndex != -1) {
                String tenKH = cursor.getString(tenKHIndex);
                String tenNV = cursor.getString(tenNVIndex);
                String ngayLap = cursor.getString(ngayLapIndex);
                double thanhTien = cursor.getDouble(thanhTienIndex);
                tenkh.setText(tenKH);
                tennv.setText(tenNV);
                ngaylap.setText(ngayLap);
            } else {
                Toast.makeText(this, "Cột không tồn tại trong kết quả truy vấn", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Không có dữ liệu hoặc MAHD không tồn tại", Toast.LENGTH_SHORT).show();
        }
        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
