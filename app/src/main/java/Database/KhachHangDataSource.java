package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.Object.UuDai;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public KhachHangDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public KhachHangDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }

    public void close() {
        dbHelper.close();
    }
    public long addKhachHang(String name, String phone, String type, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_KHACHHANG_TKH, name);
        values.put(dbHelper.TBL_KHACHHANG_SDT, phone);
        values.put(dbHelper.TBL_KHACHHANG_LKH, type);
        values.put(dbHelper.TBL_KHACHHANG_TK, username);
        values.put(dbHelper.TBL_KHACHHANG_MK, password);
        return db.insert(dbHelper.TBL_KHACHHANG, null, values);
    }
    public int updateKhachHang(int id, String name, String phone, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_KHACHHANG_TKH, name);
        values.put(dbHelper.TBL_KHACHHANG_SDT, phone);
        values.put(dbHelper.TBL_KHACHHANG_TK, username);
        values.put(dbHelper.TBL_KHACHHANG_MK, password);
        String whereClause = dbHelper.TBL_KHACHHANG_MKH + "=?";
        String[] whereArgs = {String.valueOf(id)};
        return db.update(dbHelper.TBL_KHACHHANG, values, whereClause, whereArgs);
    }
    public int updateKhachHang_manager(int id, String name, String phone, String loai) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_KHACHHANG_TKH, name);
        values.put(dbHelper.TBL_KHACHHANG_SDT, phone);
        values.put(dbHelper.TBL_KHACHHANG_LKH, loai);
        String whereClause = dbHelper.TBL_KHACHHANG_MKH + "=?";
        String[] whereArgs = {String.valueOf(id)};
        return db.update(dbHelper.TBL_KHACHHANG, values, whereClause, whereArgs);
    }
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> KhachHangList = new ArrayList<>();
        Cursor cursor = db.query("tblKhachHang", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int maKHIndex = cursor.getColumnIndex("MAKH");
                int tenKHIndex = cursor.getColumnIndex("TENKH");
                int SDTIndex = cursor.getColumnIndex("SDT");
                int LoaiIndex = cursor.getColumnIndex("LOAIKH");
                int tkIndex = cursor.getColumnIndex("TAIKHOAN");
                int mkIndex = cursor.getColumnIndex("MATKHAU");

                do {
                    Integer maKH = cursor.getInt(maKHIndex);
                    String tenKH = cursor.getString(tenKHIndex);
                    String SDT = cursor.getString(SDTIndex);
                    String loaiKH = cursor.getString(LoaiIndex);
                    String taikhoan = cursor.getString(tkIndex);
                    String matkhau = cursor.getString(mkIndex);
                    KhachHang khachHang = new KhachHang(maKH, tenKH, SDT, loaiKH, taikhoan, matkhau);
                    KhachHangList.add(khachHang);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return KhachHangList;
    }
}
