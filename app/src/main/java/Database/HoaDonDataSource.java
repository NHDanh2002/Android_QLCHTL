package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlchtl.Object.HoaDon;
import com.example.qlchtl.Object.UuDai;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public HoaDonDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public HoaDonDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> HoaDonList = new ArrayList<>();
        Cursor cursor = db.query("tblHoaDon", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int maHDIndex = cursor.getColumnIndex("MAHD");
                int maNVIndex = cursor.getColumnIndex("MANV");
                int maKHIndex = cursor.getColumnIndex("MAKH");
                int ngaylapIndex = cursor.getColumnIndex("NGAYLAP");

                do {
                    Integer maHD = cursor.getInt(maHDIndex);
                    Integer maNV = cursor.getInt(maNVIndex);
                    Integer maKH = cursor.getInt(maKHIndex);
                    String ngaylap = cursor.getString(ngaylapIndex);
                    HoaDon hoadon = new HoaDon(maHD, maNV, maKH, ngaylap);
                    HoaDonList.add(hoadon);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return HoaDonList;
    }
}
