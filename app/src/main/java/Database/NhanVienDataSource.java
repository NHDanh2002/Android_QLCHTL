package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlchtl.Object.KhachHang;
import com.example.qlchtl.Object.NhanVien;
import com.example.qlchtl.Object.UuDai;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public NhanVienDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public NhanVienDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }

    public void close() {
        dbHelper.close();
    }
    public long addNhanVien(String name, String phone, String type, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_NHANVIEN_TNV, name);
        values.put(dbHelper.TBL_NHANVIEN_SDT, phone);
        values.put(dbHelper.TBL_NHANVIEN_CV, type);
        values.put(dbHelper.TBL_NHANVIEN_TK, username);
        values.put(dbHelper.TBL_NHANVIEN_MK, password);
        return db.insert(dbHelper.TBL_NHANVIEN, null, values);
    }
    public int updateNhanVien(int id, String name, String phone, String loai) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_NHANVIEN_TNV, name);
        values.put(dbHelper.TBL_NHANVIEN_SDT, phone);
        values.put(dbHelper.TBL_NHANVIEN_CV, loai);
        String whereClause = dbHelper.TBL_NHANVIEN_MNV + "=?";
        String[] whereArgs = {String.valueOf(id)};
        return db.update(dbHelper.TBL_NHANVIEN, values, whereClause, whereArgs);
    }
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> NhanVienList = new ArrayList<>();
        Cursor cursor = db.query("tblNhanVien", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int maNVIndex = cursor.getColumnIndex("MANV");
                int tenNVIndex = cursor.getColumnIndex("TENNV");
                int SDTIndex = cursor.getColumnIndex("SDT");
                int LoaiIndex = cursor.getColumnIndex("CHUCVU");
                int tkIndex = cursor.getColumnIndex("TAIKHOAN");
                int mkIndex = cursor.getColumnIndex("MATKHAU");

                do {
                    Integer maNV = cursor.getInt(maNVIndex);
                    String tenNV = cursor.getString(tenNVIndex);
                    String SDT = cursor.getString(SDTIndex);
                    String loaiKH = cursor.getString(LoaiIndex);
                    String taikhoan = cursor.getString(tkIndex);
                    String matkhau = cursor.getString(mkIndex);
                    NhanVien nhanVien = new NhanVien(maNV, tenNV, SDT, loaiKH, taikhoan, matkhau);
                    NhanVienList.add(nhanVien);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return NhanVienList;
    }
}
