package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlchtl.Object.UuDai;

import java.util.ArrayList;
import java.util.List;

public class UuDaiDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public UuDaiDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public UuDaiDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }
    public List<UuDai> getAllChuongTrinhUuDai() {
        List<UuDai> chuongTrinhUuDaiList = new ArrayList<>();
        Cursor cursor = db.query("tblChuongTrinhUuDai", null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int maCTIndex = cursor.getColumnIndex("MACT");
                int tenCTIndex = cursor.getColumnIndex("TENCT");
                int moTaIndex = cursor.getColumnIndex("MOTA");
                int ngayBatDauIndex = cursor.getColumnIndex("NGAYBATDAU");
                int ngayKetThucIndex = cursor.getColumnIndex("NGAYKETTHUC");

                do {
                    Integer maCT = cursor.getInt(maCTIndex);
                    String tenCT = cursor.getString(tenCTIndex);
                    String moTa = cursor.getString(moTaIndex);
                    String ngayBatDau = cursor.getString(ngayBatDauIndex);
                    String ngayKetThuc = cursor.getString(ngayKetThucIndex);
                    UuDai chuongTrinhUuDai = new UuDai(maCT, tenCT, moTa, ngayBatDau, ngayKetThuc);
                    chuongTrinhUuDaiList.add(chuongTrinhUuDai);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return chuongTrinhUuDaiList;
    }
    public int updateUuDai(int id, String ten, String mota, String ngaybatdau, String ngayketthuc) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_CTUUDAI_TENCT, ten);
        values.put(dbHelper.TBL_CTUUDAI_MOTA, mota);
        values.put(dbHelper.TBL_CTUUDAI_NBATDAU, ngaybatdau);
        values.put(dbHelper.TBL_CTUUDAI_NKETTHUC, ngayketthuc);
        String whereClause = dbHelper.TBL_CTUUDAI_MCT + "=?";
        String[] whereArgs = {String.valueOf(id)};
        return db.update(dbHelper.TBL_CTUUDAI, values, whereClause, whereArgs);
    }
    public long addUuDai(String tenct, String mota, String ngaybd, String ngaykt) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_CTUUDAI_TENCT, tenct);
        values.put(dbHelper.TBL_CTUUDAI_MOTA, mota);
        values.put(dbHelper.TBL_CTUUDAI_NBATDAU, ngaybd);
        values.put(dbHelper.TBL_CTUUDAI_NKETTHUC, ngaykt);
        return db.insert(dbHelper.TBL_CTUUDAI, null, values);
    }
}
