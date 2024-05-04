package Database;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.qlchtl.DanhMuc.Category;
import com.example.qlchtl.Kho.Product;
import com.example.qlchtl.Kho.nhapsanpham;

import java.util.ArrayList;
import java.util.List;

public class QLCHTL_DatabaseHandler extends SQLiteOpenHelper {
    List<String> create_sql_list = new ArrayList<String>();
    String sql;

    private static final String DATABASE_NAME = "QLCHTL.sqlite";
    private static final int DATABASE_VERSION = 2;

    public static final String TBL_SANPHAM = "tblSanPham";
    public static final String TBL_SANPHAM_MSP = "MASP";
    public static final String TBL_SANPHAM_TSP = "TENSP";
    public static final String TBL_SANPHAM_GIA = "DONGIA";
    public static final String TBL_SANPHAM_SL = "SOLUONG";
    public static final String TBL_SANPHAM_HSD = "HSD";
    public static final String TBL_SANPHAM_MDM = "MADM";

    public static final String TBL_DANHMUC = "tblDanhMuc";
    public static final String TBL_DANHMUC_MDM = "MADM";
    public static final String TBL_DANHMUC_TDM = "TENDM";

    public static final String TBL_NXKHO = "tblNhapXuatKho";
    public static final String TBL_NXKHO_MNX = "MANX";
    public static final String TBL_NXKHO_LOAI = "LOAI";
    public static final String TBL_NXKHO_NGAYTH = "NGAYTHUCHIEN";

    public static final String TBL_KIEMKE = "tblKiemKe";
    public static final String TBL_KIEMKE_MK = "MAK";
    public static final String TBL_KIEMKE_MNX = "MANX";
    public static final String TBL_KIEMKE_MSP = "MASP";
    public static final String TBL_KIEMKE_SLTT = "SOLUONGTHUCTE";
    public static final String TBL_KIEMKE_SLN = "SOLUONGNHAP";
    public static final String TBL_KIEMKE_NGAYKIEM = "NGAYKIEM";

    public static final String TBL_NHANVIEN = "tblNhanVien";
    public static final String TBL_NHANVIEN_MNV = "MANV";
    public static final String TBL_NHANVIEN_TNV = "TENNV";
    public static final String TBL_NHANVIEN_SDT  = "SDT";
    public static final String TBL_NHANVIEN_CV  = "CHUCVU";
    public static final String TBL_NHANVIEN_TK  = "TAIKHOAN";
    public static final String TBL_NHANVIEN_MK  = "MATKHAU";

    public static final String TBL_PCNHANVIEN = "tblPhanCongNhanVien";
    public static final String TBL_PCNHANVIEN_MPC = "MAPC";
    public static final String TBL_PCNHANVIEN_MNV = "MANV";
    public static final String TBL_PCNHANVIEN_NGAYLAM = "NGAYLAM";
    public static final String TBL_PCNHANVIEN_GIOLAM = "GIOLAM";

    public static final String TBL_LUONGNV = "tblLuongNhanVien";
    public static final String TBL_LUONGNV_ML = "MALUONG";
    public static final String TBL_LUONGNV_MNV = "MANV";
    public static final String TBL_LUONGNV_NGAYNHAN = "NGAYNHAN";
    public static final String TBL_LUONGNV_LUONGNHAN = "LUONGNHAN";

    public static final String TBL_KHACHHANG = "tblKhachHang";
    public static final String TBL_KHACHHANG_MKH = "MAKH";
    public static final String TBL_KHACHHANG_TKH = "TENKH";
    public static final String TBL_KHACHHANG_SDT  = "SDT";
    public static final String TBL_KHACHHANG_LKH  = "LOAIKH";
    public static final String TBL_KHACHHANG_TK  = "TAIKHOAN";
    public static final String TBL_KHACHHANG_MK  = "MATKHAU";

    public static final String TBL_CSKHACHHANG = "tblChamSocKhachHang";
    public static final String TBL_CSKHACHHANG_MCS = "MACS";
    public static final String TBL_CSKHACHHANG_MKH = "MAKH";
    public static final String TBL_CSKHACHHANG_YC = "YEUCAU";
    public static final String TBL_CSKHACHHANG_PH = "PHANHOI";

    public static final String TBL_CTUUDAI = "tblChuongTrinhUuDai";
    public static final String TBL_CTUUDAI_MCT = "MACT";
    public static final String TBL_CTUUDAI_TENCT = "TENCT";
    public static final String TBL_CTUUDAI_MOTA = "MOTA";
    public static final String TBL_CTUUDAI_NBATDAU = "NGAYBATDAU";
    public static final String TBL_CTUUDAI_NKETTHUC = "NGAYKETTHUC";

    /*public static final String TBL_UDTV = "tblUuDaiThanhVien";
    public static final String TBL_UDTV_MUD = "MAUD";
    public static final String TBL_UDTV_MCT = "MACT";
    public static final String TBL_UDTV_MKH = "MAKH";*/

    public static final String TBL_HOADON = "tblHoaDon";
    public static final String TBL_HOADON_MHD = "MAHD";
    public static final String TBL_HOADON_MNV = "MANV";
    public static final String TBL_HOADON_MKH = "MAKH";
    public static final String TBL_HOADON_NL = "NGAYLAP";

    public static final String TBL_CTHOADON = "tblCTHOADON";
    public static final String TBL_CTHOADON_MCT = "MACTHD";
    public static final String TBL_CTHOADON_MHD = "MAHD";
    public static final String TBL_CTHOADON_MSP = "MASP";
    public static final String TBL_CTHOADON_SL = "SOLUONGCT";
    public static final String TBL_CTHOADON_TT = "THANHTIEN";
    public QLCHTL_DatabaseHandler(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*private void create_table_DanhMuc(){
        sql = "CREATE TABLE tblDanhMuc (MADM INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENDM NVARCHAR NOT NULL  UNIQUE)";
        create_sql_list.add(sql);
    }
    private void create_table_SanPham() {
        sql = "CREATE TABLE tblSanPham (MASP INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENSP NVARCHAR NOT NULL  UNIQUE , DONGIA DOUBLE NOT NULL , SOLUONG INT NOT NULL , HSD DATE, MADM INTEGER REFERENCES tblDanhMuc(MADM))";
        create_sql_list.add(sql);
    }
    private void create_table_NhapXuatKho(){
        sql = "CREATE TABLE tblNhapXuatKho (MANX INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , LOAI VARCHAR NOT NULL  UNIQUE , SOLUONG INT NOT NULL , NGAYTHUCHIEN DATE NOT NULL)";
        create_sql_list.add(sql);
    }
    private void create_table_KiemKe(){
        sql = "CREATE TABLE tblKiemKe (MAK INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , MANX INTEGER REFERENCES tblNhapXuatKho(MANX), MASP INTEGER REFERENCES tblSanPham(MASP), SOLUONGTHUCTE INT NOT NULL , NGAYKIEM DATE NOT NULL)";
        create_sql_list.add(sql);
    }
     */
    //DanhMuc
    private void create_table_DanhMuc(){
        sql = "CREATE TABLE tblDanhMuc (MADM INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENDM NVARCHAR NOT NULL  UNIQUE)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblDanhMuc (TENDM) VALUES(\"Nước\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblDanhMuc (TENDM) VALUES(\"Snack\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblDanhMuc (TENDM) VALUES(\"Cơm\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblDanhMuc (TENDM) VALUES(\"Đồ gia dụng\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblDanhMuc (TENDM) VALUES(\"Đồ điện tử\")";
        create_sql_list.add(sql);
    }
    @SuppressLint("Range")
    public ArrayList<Category> getAllCategories() {
        // Get readable database
        SQLiteDatabase db = this.getReadableDatabase();
        // Create list to store Category
        ArrayList<Category> categories = new ArrayList<>();
        // SQL statement to select all records
        String SELECT_ALL = "SELECT * FROM " + TBL_DANHMUC;
        // Execute SQL statement and get cursor
        Cursor cursor = db.query(TBL_DANHMUC, null, null, null, null, null, null);
        // Loop through cursor and create category
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setCategoryId((cursor.getString(cursor.getColumnIndex(TBL_DANHMUC_MDM))));
                category.setCategoryName(cursor.getString(cursor.getColumnIndex(TBL_DANHMUC_TDM)));
                // Add category to list
                categories.add(category);
            } while (cursor.moveToNext());
        }
        // Close cursor and database
        cursor.close();
        db.close();
        // Return list of category
        return categories;
    }

    @SuppressLint("Range")
    public ArrayList<Category> getAllNameCategories() {
        // Get readable database
        SQLiteDatabase db = this.getReadableDatabase();
        // Create list to store category names
        ArrayList<Category> category = new ArrayList<>();
        // SQL statement to select all category names
        String SELECT_ALL_NAMES = "SELECT " + TBL_DANHMUC_MDM + ", " + TBL_DANHMUC_TDM + " FROM " + TBL_DANHMUC;
        // Execute SQL statement and get cursor
        Cursor cursor = db.rawQuery(SELECT_ALL_NAMES, null);
        // Loop through cursor and add category names to the list
        if (cursor.moveToFirst()) {
            do {
                Category Cate = new Category();
                Cate.setCategoryId(String.valueOf(cursor.getInt(cursor.getColumnIndex(TBL_DANHMUC_MDM))));
                Cate.setCategoryName(cursor.getString(cursor.getColumnIndex(TBL_DANHMUC_TDM)));
                category.add(Cate);
            } while (cursor.moveToNext());
        }
        // Close cursor and database
        cursor.close();
        db.close();
        // Return list of category names
        return category;
    }
    public void addCategory(Category category) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Create content values to store data
        ContentValues values = new ContentValues();
        values.put(TBL_DANHMUC_MDM, category.getCategoryId());
        values.put(TBL_DANHMUC_TDM, category.getCategoryName());
        // Insert data into table
        db.insert(TBL_DANHMUC, null, values);
        // Close database
        db.close();
    }
    public void deleteCategory(Category category) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // SQL statement to delete record
        String DELETE = "DELETE FROM " + TBL_DANHMUC + " WHERE " + TBL_DANHMUC_MDM + " = ?";
        // Execute SQL statement with student id as argument
        db.delete(TBL_DANHMUC, TBL_DANHMUC_MDM+ " = ?", new String[]{String.valueOf(category.getCategoryId())});
        // Close database
        db.close();
    }
    public void updateCategory(Category category) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Create content values to store data
        ContentValues values = new ContentValues();
        values.put(TBL_DANHMUC_TDM, category.getCategoryName());
        // SQL statement to update record
        String UPDATE = "UPDATE " + TBL_DANHMUC + " SET "
                + TBL_DANHMUC_TDM + " = ?"
                + " WHERE " + TBL_DANHMUC_MDM + " = ?";
        // Execute SQL statement with product data and id as arguments
        db.update(TBL_DANHMUC, values, TBL_DANHMUC_MDM + " = ?", new String[]{String.valueOf(category.getCategoryId())});

        // Close database
        db.close();
    }

    //SanPham
    private void create_table_SanPham() {
        sql = "CREATE TABLE tblSanPham (MASP INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENSP NVARCHAR NOT NULL  UNIQUE , DONGIA DOUBLE NOT NULL , SOLUONG INT NOT NULL , HSD DATE, MADM INTEGER REFERENCES tblDanhMuc(MADM))";
        create_sql_list.add(sql);

        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"IPHONE15\",6500000,20,5)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"LAPTOP ASUS\",25000000,20,5)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"MAY TINH CASIO\",750000,20,5)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"IPAD\",2000000,20,5)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"Sting\",14000,200,1)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"Aquafina\",7500,200,1)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"StrongBow\",20000,200,1)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"Oreo\",14000,200,2)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"Sushi\",15000,200,3)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblSanPham (TENSP,DONGIA,SOLUONG,MADM) VALUES(\"Quạt máy\",1500000,200,4)";
        create_sql_list.add(sql);
    }
    @SuppressLint("Range")
    public Category getCategoryFromString(String categoryId) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Define the query to fetch the category based on its name
        String SELECT_CATEGORY = "SELECT * FROM " + TBL_DANHMUC + " WHERE " + TBL_DANHMUC_MDM + " = ?";

        // Execute the query
        Cursor cursor = db.rawQuery(SELECT_CATEGORY, new String[]{categoryId});

        // Initialize a Category object to store the result
        Category category = null;

        // Check if cursor has data
        if (cursor != null && cursor.moveToFirst()) {
            // Retrieve category data from cursor
            categoryId = cursor.getString(cursor.getColumnIndex(TBL_DANHMUC_MDM));
            String categoryNameFromDB = cursor.getString(cursor.getColumnIndex(TBL_DANHMUC_TDM));

            // Create a new Category object
            category = new Category(categoryId, categoryNameFromDB);

            // Close the cursor
            cursor.close();
        }

        // Close the database connection
        db.close();

        // Return the Category object
        return category;
    }
    @SuppressLint("Range")
    public ArrayList<Product> getAllProducts() {
        // Get readable database
        SQLiteDatabase db = this.getReadableDatabase();
        // Create list to store Products
        ArrayList<Product> products = new ArrayList<>();
        // SQL statement to select all records
        String SELECT_ALL = "SELECT * FROM " + TBL_SANPHAM;
        // Execute SQL statement and get cursor
        Cursor cursor = db.query(TBL_SANPHAM, null, null, null, null, null, null);
        // Loop through cursor and create product
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setProductId((cursor.getString(cursor.getColumnIndex(TBL_SANPHAM_MSP))));
                product.setProductName(cursor.getString(cursor.getColumnIndex(TBL_SANPHAM_TSP)));
                String categoryId = cursor.getString(cursor.getColumnIndex(TBL_SANPHAM_MDM));
                Category category = getCategoryFromString(categoryId);
                product.setProductCategory(category);
                product.setProductPrice(cursor.getDouble(cursor.getColumnIndex(TBL_SANPHAM_GIA)));
                product.setProductQuantity(cursor.getInt(cursor.getColumnIndex(TBL_SANPHAM_SL)));
                product.sethsd(cursor.getString(cursor.getColumnIndex(TBL_SANPHAM_HSD)));

                // Add product to list
                products.add(product);
            } while (cursor.moveToNext());
        }
        // Close cursor and database
        cursor.close();
        db.close();
        // Return list of product
        return products;
    }

    // Add Product
    public void addProduct(Product product) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Create content values to store data
        ContentValues values = new ContentValues();
        values.put(TBL_SANPHAM_MSP, product.getProductId());
        values.put(TBL_SANPHAM_TSP, product.getProductName());

        values.put(TBL_SANPHAM_MDM, product.getProductCategory().getCategoryId());
        values.put(TBL_SANPHAM_GIA,product.getProductPrice());
        values.put(TBL_SANPHAM_SL, product.getProductQuantity());
        values.put(TBL_SANPHAM_HSD,product.gethsd());

        // Insert data into table
        db.insert(TBL_SANPHAM, null, values);
        // Close database
        db.close();
    }
    public void deleteProduct(Product product) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // SQL statement to delete record
        String DELETE = "DELETE FROM " + TBL_SANPHAM + " WHERE " + TBL_SANPHAM_MSP + " = ?";
        // Execute SQL statement with student id as argument
        db.delete(TBL_SANPHAM, TBL_SANPHAM_MSP + " = ?", new String[]{String.valueOf(product.getProductId())});
        // Close database
        db.close();
    }
    public void updateProduct(Product product) {
        // Get writable database
        SQLiteDatabase db = this.getWritableDatabase();
        // Create content values to store data
        ContentValues values = new ContentValues();
        values.put(TBL_SANPHAM_TSP, product.getProductName());
        values.put(TBL_SANPHAM_MDM, product.getProductCategory().getCategoryId());
        values.put(TBL_SANPHAM_GIA,product.getProductPrice());
        values.put(TBL_SANPHAM_SL, product.getProductQuantity());
        values.put(TBL_SANPHAM_HSD,product.gethsd());
        // SQL statement to update record
        String UPDATE = "UPDATE " + TBL_SANPHAM + " SET "
                + TBL_SANPHAM_TSP + " = ?,"
                + TBL_SANPHAM_MDM + " = ?"
                + TBL_SANPHAM_GIA + " = ?"
                + TBL_SANPHAM_SL + " = ?"
                + TBL_SANPHAM_HSD + " = ?"
                + " WHERE " + TBL_SANPHAM_MSP + " = ?";
        // Execute SQL statement with product data and id as arguments
        db.update(TBL_SANPHAM, values, TBL_SANPHAM_MSP + " = ?", new String[]{String.valueOf(product.getProductId())});

        // Close database
        db.close();
    }


    private void create_table_NhapXuatKho(){
        sql = "CREATE TABLE tblNhapXuatKho (MANX INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , LOAI VARCHAR NOT NULL, NGAYTHUCHIEN DATE NOT NULL)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhapXuatKho (LOAI,NGAYTHUCHIEN) VALUES(\"Nhap\",\"2024-04-07\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhapXuatKho (LOAI,NGAYTHUCHIEN) VALUES(\"Nhap\",\"2024-04-08\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhapXuatKho (LOAI,NGAYTHUCHIEN) VALUES(\"Nhap\",\"2024-04-09\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhapXuatKho (LOAI,NGAYTHUCHIEN) VALUES(\"Nhap\",\"2024-04-10\")";
        create_sql_list.add(sql);
    }


    private void create_table_KiemKe(){
        sql = "CREATE TABLE tblKiemKe (MAK INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , MANX INTEGER REFERENCES tblNhapXuatKho(MANX), MASP INTEGER REFERENCES tblSanPham(MASP), SOLUONGTHUCTE INT NOT NULL, SOLUONGNHAP INT NOT NULL , NGAYKIEM DATE NOT NULL)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(1,1,0,20,\"2024-04-07\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(1,2,0,20,\"2024-04-07\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(2,3,0,20,\"2024-04-08\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(2,1,0,20,\"2024-04-08\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(3,5,0,20,\"2024-04-09\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKiemKe (MANX,MASP,SOLUONGTHUCTE,SOLUONGNHAP,NGAYKIEM) VALUES(4,5,0,20,\"2024-04-10\")";
        create_sql_list.add(sql);
    }
    public ArrayList<String> getAllDayinputproduct() {
        ArrayList<String> dayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT NGAYTHUCHIEN FROM tblNhapXuatKho", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String day = cursor.getString(cursor.getColumnIndex("NGAYTHUCHIEN"));
                dayList.add(day);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return dayList;
    }
    public ArrayList<nhapsanpham> getInputProducts(String ngay) {
        ArrayList<nhapsanpham> inputProducts = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"MASP", "SOLUONGNHAP"}; // Adjust columns as per your table structure
        String selection = "NGAYKIEM = ?";
        String[] selectionArgs = {ngay};
        Cursor cursor = db.query("tblKiemKe", columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Assuming you have a constructor for nhapsanpham that takes productId, productQuantityn, and other necessary attributes
                @SuppressLint("Range") nhapsanpham product = new nhapsanpham(cursor.getString(cursor.getColumnIndex("MASP")),
                        null,  // productName - adjust accordingly
                        null,  // productCategory - adjust accordingly
                        null,  // productPrice - adjust accordingly
                        cursor.getInt(cursor.getColumnIndex("SOLUONGNHAP")),
                        0,     // productQuantityt - adjust accordingly
                        null); // nn - adjust accordingly
                inputProducts.add(product);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }

        db.close();

        return inputProducts;
    }
    public void capnhatsoluong(nhapsanpham product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("SOLUONGTHUCTE", product.getProductQuantityt());

        String selection = "MASP = ?"; // Assuming "MASP" is the column for product ID
        String[] selectionArgs = {product.getProductId()}; // The product ID to identify the row to update

        // Update the row
        int rowsAffected = db.update("tblKiemKe", values, selection, selectionArgs);

        // Check if the update was successful
        if (rowsAffected > 0) {
            Log.d("Cập nhật", "Số lượng sản phẩm được cập nhật thành công");
        } else {
            Log.e("Cập nhật", "Không cập nhật được số lượng sản phẩm");
        }
        db.close();
    }
    private void create_table_NhanVien() {
        sql = "CREATE TABLE tblNhanVien (MANV INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, TENNV NVARCHAR NOT NULL, SDT NUMBER, CHUCVU NVARCHAR, TAIKHOAN VARCHAR NOT NULL, MATKHAU VARCHAR NOT NULL)";
        create_sql_list.add(sql);

        sql = "INSERT INTO tblNhanVien (TENNV,SDT,CHUCVU,TAIKHOAN,MATKHAU) VALUES(\"Nguyễn Hoàng Danh\",0968703002,\"Admin\",\"admin1\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhanVien (TENNV,SDT,CHUCVU,TAIKHOAN,MATKHAU) VALUES(\"Nguyễn Đỗ Hoàng Khang\",0326337172,\"Nhân viên\",\"nv1\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblNhanVien (TENNV,SDT,CHUCVU,TAIKHOAN,MATKHAU) VALUES(\"Phạm Thị Mỹ Linh\",0932112051,\"Nhân viên\",\"nv2\",\"123\")";
        create_sql_list.add(sql);
    }
    public Cursor getDataByMAHD(int mahd) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT KH.TENKH, NV.TENNV, HD.NGAYLAP, CTHD.THANHTIEN " +
                "FROM tblHoaDon HD " +
                "INNER JOIN tblNhanVien NV ON HD.MANV = NV.MANV " +
                "INNER JOIN tblKhachHang KH ON HD.MAKH = KH.MAKH " +
                "INNER JOIN tblCTHOADON CTHD ON HD.MAHD = CTHD.MAHD " +
                "WHERE HD.MAHD = ?"; // Sử dụng tham số để chọn MAHD
        return db.rawQuery(query, new String[] {String.valueOf(mahd)});
    }
    public double tinhTongThanhTienTheoMAHD(int maHD) {
        double totalAmount = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + TBL_CTHOADON_TT + ") AS TOTAL FROM " + TBL_CTHOADON + " WHERE " + TBL_CTHOADON_MHD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(maHD)});
        if (cursor.moveToFirst()) {
            totalAmount = cursor.getDouble(cursor.getColumnIndex("TOTAL"));
        }
        cursor.close();
        db.close();
        return totalAmount;
    }
    private void create_table_PhanCong(){
        sql = "CREATE TABLE tblPhanCongNhanVien (MAPC INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , MANV INTEGER REFERENCES tblNhanVien(MANV) , NGAYLAM DATE NOT NULL, GIOLAM INT NOT NULL)";
        create_sql_list.add(sql);
    }
    private void create_table_LuongNhanVien(){
        sql = "CREATE TABLE tblLuongNhanVien (MALUONG INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , MANV INTEGER REFERENCES tblNhanVien(MANV) , NGAYNHAN DATE NOT NULL, LUONGNHAN INT NOT NULL)";
        create_sql_list.add(sql);
    }
    private void create_table_KhachHang() {
        sql = "CREATE TABLE tblKhachHang (MAKH INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, TENKH NVARCHAR NOT NULL, SDT NUMBER, LOAIKH NVARCHAR, TAIKHOAN VARCHAR NOT NULL, MATKHAU VARCHAR NOT NULL)";
        create_sql_list.add(sql);

        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Nguyễn Văn Bình\",0967812234,\"Bạc\",\"vanbinh2001\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Nguyễn Hoàng Oanh\",0967421334,\"Bạc\",\"hoanganh111\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Lê Thị Kim Ánh\",0967135126,\"Bạc\",\"kimanh1991\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Trần Văn Minh\",0988122234,\"Bạc\",\"vanminh112\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Nguyễn Thị Huyền\",0961245234,\"Bạc\",\"huyennguyen123\",\"123\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblKhachHang (TENKH,SDT,LOAIKH,TAIKHOAN,MATKHAU) VALUES(\"Lê Thị Bảo Trâm\",0912812586,\"Bạc\",\"baotram113\",\"123\")";
        create_sql_list.add(sql);
    }
    private void create_table_ChamSocKH() {
        sql = "CREATE TABLE tblChamSocKhachHang (MACS INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, MAKH INTEGER REFERENCES tblKhachHang(MAKH),YEUCAU NVARCHAR NOT NULL, PHANHOI NVARCHAR)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChamSocKhachHang (MAKH,YEUCAU,PHANHOI) VALUES(1,\"Đây là phản hồi demo\",\"trả lời\")";
        create_sql_list.add(sql);
    }
    private void create_table_ChuongTrinhUuDai() {
        sql = "CREATE TABLE tblChuongTrinhUuDai (MACT INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,TENCT NVARCHAR NOT NULL,MOTA NVARCHAR, NGAYBATDAU DATE NOT NULL, NGAYKETTHUC DATE NOT NULL)";
        create_sql_list.add(sql);

        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Chương trình giảm giá đặc biệt\",\"Chương trình giảm giá 20% cho các sản phẩm gia dụng\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Khuyến mãi mùa hè\",\"Giảm giá 10% cho tất cả các sản phẩm\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Ưu đãi dành cho thành viên\",\"Giảm giá 5% cho các đơn hàng trên 100.000 VNĐ cho thành viên đã đăng ký\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Chương trình khuyến mãi sinh nhật\",\"Bóc thăm trúng quà trị giá 200,000 VNĐ cho mỗi đơn hàng trên 100,000 VNĐ vào ngày sinh nhật\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Ưu đãi dành cho học sinh - sinh viên\",\"Giảm giá 10% cho hóa đơn từ 100,000 VNĐ trở lên cho học sinh và sinh viên\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Chương trình tri ân khách hàng thân thiết\",\"Tặng voucher giảm giá 50,000 VNĐ cho mỗi lần mua hàng từ 500,000 VNĐ trở lên\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Chương trình giảm giá cuối mùa\",\"Giảm giá 40% cho các sản phẩm dành cho mùa hè\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Ưu đãi cho người mua hàng lần đầu\",\"Giảm giá 20% cho người mua hàng lần đầu tiên\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Chương trình quà tặng mùa hè\",\"Nhận ngay cặp đôi ly cao cấp khi mua bất kỳ sản phẩm nào\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblChuongTrinhUuDai (TENCT,MOTA,NGAYBATDAU,NGAYKETTHUC) VALUES(\"Khuyến mãi dành cho ngày lễ\",\"Giảm giá 25% cho tất cả các sản phẩm trong dịp lễ lớn\",\"2024-04-06\",\"2024-04-20\")";
        create_sql_list.add(sql);
    }
    /*private void create_table_UuDaiTV() {
        sql = "CREATE TABLE tblUuDaiThanhVien (MAUD INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, MACT INTEGER REFERENCES tblChuongTrinhUuDai(MACT), MAKH INTEGER REFERENCES tblKhachHang(MAKH))";
        create_sql_list.add(sql);
    }*/
    private void create_table_HoaDon() {
        sql = "CREATE TABLE tblHoaDon (MAHD INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, MANV INTEGER REFERENCES tblNhanVien(MANV), MAKH INTEGER REFERENCES tblKhachHang(MAKH), NGAYLAP DATE NOT NULL)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblHoaDon (MANV,MAKH,NGAYLAP) VALUES(1,2,\"2024-04-06\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblHoaDon (MANV,MAKH,NGAYLAP) VALUES(2,1,\"2024-04-03\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblHoaDon (MANV,MAKH,NGAYLAP) VALUES(3,4,\"2024-04-01\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblHoaDon (MANV,MAKH,NGAYLAP) VALUES(1,6,\"2024-04-07\")";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblHoaDon (MANV,MAKH,NGAYLAP) VALUES(1,3,\"2024-04-05\")";
        create_sql_list.add(sql);
    }
    private void create_table_CTHoaDon(){
        sql = "CREATE TABLE tblCTHoaDon (MACTHD INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, MAHD INTEGER REFERENCES tblHoaDon(MAHD), MASP INTEGER REFERENCES tblSanPham(MASP), SOLUONGCT INT NOT NULL, THANHTIEN DOUBLE NOT NULL)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(1,5,2,28000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(1,6,1,15000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(2,7,1,20000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(2,9,2,30000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(3,5,1,14000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(3,8,1,14000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(4,10,1,1500000)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(4,6,1,7500)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(5,6,3,22500)";
        create_sql_list.add(sql);
        sql = "INSERT INTO tblCTHoaDon (MAHD,MASP,SOLUONGCT,THANHTIEN) VALUES(5,9,2,30000)";
        create_sql_list.add(sql);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        create_table_DanhMuc();
        create_table_SanPham();
        create_table_NhapXuatKho();
        create_table_KiemKe();
        create_table_NhanVien();
        create_table_PhanCong();
        create_table_LuongNhanVien();
        create_table_KhachHang();
        create_table_ChamSocKH();
        create_table_ChuongTrinhUuDai();
        //create_table_UuDaiTV();
        create_table_HoaDon();
        create_table_CTHoaDon();
        for(int i = 0;i < create_sql_list.size();i++)
            db.execSQL(create_sql_list.get(i));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TBL_DANHMUC);
        db.execSQL("drop table if exists " + TBL_SANPHAM);
        db.execSQL("drop table if exists " + TBL_NXKHO);
        db.execSQL("drop table if exists " + TBL_KIEMKE);
        db.execSQL("drop table if exists " + TBL_NHANVIEN);
        db.execSQL("drop table if exists " + TBL_PCNHANVIEN);
        db.execSQL("drop table if exists " + TBL_LUONGNV);
        db.execSQL("drop table if exists " + TBL_KHACHHANG);
        db.execSQL("drop table if exists " + TBL_CSKHACHHANG);
        db.execSQL("drop table if exists " + TBL_CTUUDAI);
        //db.execSQL("drop table if exists " + TBL_UDTV);
        db.execSQL("drop table if exists " + TBL_HOADON);
        db.execSQL("drop table if exists " + TBL_CTHOADON);
        onCreate(db);
    }
}

