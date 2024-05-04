package Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlchtl.Object.ChiTietHoaDonItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChiTietHoaDonDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;

    Context context;

    public ChiTietHoaDonDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }

    public ChiTietHoaDonDataSource open() throws SQLException {
        db = dbHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<ChiTietHoaDonItem> dsSanPham(int mahd) {
        ArrayList<ChiTietHoaDonItem> dstensp = new ArrayList<ChiTietHoaDonItem>();
        db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM tblCTHoaDon INNER JOIN tblSanPham ON tblSanPham.MASP = tblCTHoaDon.MASP WHERE " + QLCHTL_DatabaseHandler.TBL_CTHOADON_MHD + " = \"" + mahd + "\"";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            int tenspIndex = cursor.getColumnIndex("TENSP");
            int soluongIndex = cursor.getColumnIndex("SOLUONGCT");
            int thanhtienIndex = cursor.getColumnIndex("THANHTIEN");
            int dongiaIndex = cursor.getColumnIndex("DONGIA");
            if (tenspIndex != -1 && soluongIndex != -1 && thanhtienIndex != -1 && dongiaIndex != -1) {
                while (!cursor.isAfterLast()) {
                    String tenSanPham = cursor.getString(tenspIndex);
                    int soLuong = cursor.getInt(soluongIndex);
                    Double thanhtien = cursor.getDouble(thanhtienIndex);
                    Double dongia = cursor.getDouble(dongiaIndex);
                    ChiTietHoaDonItem cthd = new ChiTietHoaDonItem(tenSanPham,soLuong,dongia, thanhtien);
                    dstensp.add(cthd);
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return dstensp;
    }
}