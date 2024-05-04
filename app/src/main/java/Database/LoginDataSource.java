package Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public LoginDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public LoginDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }

    public void close() {
        dbHelper.close();
    }
    public boolean checkUser_Guest(String username, String password) {
        Cursor cursor = db.query(dbHelper.TBL_KHACHHANG, new String[]{dbHelper.TBL_KHACHHANG_MK},
                dbHelper.TBL_KHACHHANG_TK + " = ? AND " + dbHelper.TBL_KHACHHANG_MK + " = ?",
                new String[]{username, password}, null, null, null);
        return cursor.moveToFirst();
    }
    public boolean checkUser_Manager(String username, String password) {
        Cursor cursor = db.query(dbHelper.TBL_NHANVIEN, new String[]{dbHelper.TBL_NHANVIEN_MNV},
                dbHelper.TBL_NHANVIEN_TK + " = ? AND " + dbHelper.TBL_NHANVIEN_MK + " = ?",
                new String[]{username, password}, null, null, null);
        return cursor.moveToFirst();
    }
    public Cursor getUserByUsername(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {dbHelper.TBL_KHACHHANG_MKH, dbHelper.TBL_KHACHHANG_TKH, dbHelper.TBL_KHACHHANG_SDT, dbHelper.TBL_KHACHHANG_LKH,dbHelper.TBL_KHACHHANG_TK, dbHelper.TBL_KHACHHANG_MK};
        String selection = dbHelper.TBL_KHACHHANG_TK + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(dbHelper.TBL_KHACHHANG, columns, selection, selectionArgs, null, null, null);
        return cursor;
    }
}
