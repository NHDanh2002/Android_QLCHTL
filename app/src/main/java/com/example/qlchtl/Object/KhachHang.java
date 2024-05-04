package com.example.qlchtl.Object;

import java.io.Serializable;

public class KhachHang implements Serializable {
    int makh;
    String tenkh,sdt,loaikh,taikhoan,matkhau;

    public KhachHang(){}

    public KhachHang(int makh, String tenkh, String sdt, String loaikh, String taikhoan, String matkhau) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.loaikh = loaikh;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLoaikh() {
        return loaikh;
    }

    public void setLoaikh(String loaikh) {
        this.loaikh = loaikh;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }
    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return new String(this.makh + "-" + this.tenkh);// + "-" + this.sdt + "-" + this.loaikh);
    }
}
