package com.example.qlchtl.Object;

import java.io.Serializable;
import java.util.Date;

public class HoaDon implements Serializable {
    int mahd,makh,manv;
    String ngaylap;
    public HoaDon(){}
    public HoaDon(int mahd, int manv, int makh, String ngaylap)
    {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ngaylap = ngaylap;
    }
    public int getMahd() {
        return mahd;
    }
    public void setMahd(int mahd) {
        this.mahd = mahd;
    }
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }
    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }


    @Override
    public String toString() {
        return new String("Hóa đơn: " + this.mahd); //+ " - " + this.manv + " - " + this.makh + " - " + this.masp + " - " + this.soluong);
    }
}
