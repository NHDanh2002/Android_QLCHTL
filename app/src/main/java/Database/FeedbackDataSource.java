package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qlchtl.Object.FeedBack;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDataSource {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    Context context;

    public FeedbackDataSource(Context context) {
        this.context = context;
        this.dbHelper = new QLCHTL_DatabaseHandler(context);
    }
    public FeedbackDataSource open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        db.execSQL("PRAGMA foreign_keys=ON;");
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    public long addFeedback(Integer makh,String yeucau, String phanhoi) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.TBL_CSKHACHHANG_MKH, makh);
        values.put(dbHelper.TBL_CSKHACHHANG_YC, yeucau);
        values.put(dbHelper.TBL_CSKHACHHANG_PH, phanhoi);
        return db.insert(dbHelper.TBL_KHACHHANG, null, values);
    }
    public void loadCustomerDataToListView(String maKH, ListView listView) {
        ArrayList<String> customerData = new ArrayList<>();
        // Thực hiện truy vấn dữ liệu từ bảng dựa trên mã khách hàng (MAKH)
        String query = "SELECT * FROM " + dbHelper.TBL_CSKHACHHANG + " WHERE " + dbHelper.TBL_CSKHACHHANG_MKH + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{maKH});

        // Kiểm tra xem Cursor có dữ liệu không
        if (cursor != null && cursor.getCount() > 0) {
            // Duyệt qua các dòng kết quả và thêm vào ArrayList
            while (cursor.moveToNext()) {
                // Kiểm tra xem cột có tồn tại không trước khi truy cập
                int macsIndex = cursor.getColumnIndex(dbHelper.TBL_CSKHACHHANG_MCS);
                int yeucauIndex = cursor.getColumnIndex(dbHelper.TBL_CSKHACHHANG_YC);
                int phanhoiIndex = cursor.getColumnIndex(dbHelper.TBL_CSKHACHHANG_PH);

                if (macsIndex >= 0 && yeucauIndex >= 0 && phanhoiIndex >= 0) {
                    String macs = cursor.getString(macsIndex);
                    String yeucau = cursor.getString(yeucauIndex);
                    String phanhoi = cursor.getString(phanhoiIndex);
                    // Thêm dữ liệu vào ArrayList
                    customerData.add("MACS: " + macs + ", YEUCAU: " + yeucau + ", PHANHOI: " + phanhoi);
                }
            }
        }
        cursor.close();

        // Sử dụng ArrayAdapter để hiển thị dữ liệu trên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, customerData);
        listView.setAdapter(adapter);
    }
}
