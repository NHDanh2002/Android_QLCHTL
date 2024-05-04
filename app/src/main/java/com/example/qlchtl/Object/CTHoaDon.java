package com.example.qlchtl.Object;

import java.io.Serializable;

public class CTHoaDon implements Serializable {
    int macthd, mahd, masp, sl;
    double thanhtien;
    public CTHoaDon(){}
    public CTHoaDon(int macthd, int mahd, int masp, int sl, double thanhtien){
        this.macthd = macthd;
        this.mahd = mahd;
        this.masp = masp;
        this.sl = sl;
        this.thanhtien = thanhtien;
    }
    public void setMaCTHoaDon(int mact){
        this.macthd = mact;
    }
    public int getMaCTHoaDon(){
        return this.macthd;
    }
    public void setMaHoaDon(int mahd){
        this.mahd = mahd;
    }
    public int getMaHoaDon(){
        return this.mahd;
    }
    public void setMaSP(int masp){
        this.masp = masp;
    }
    public int getMaSP(){
        return this.masp;
    }
    public void setSL(int sl){
        this.sl = sl;
    }
    public int getSL(){
        return this.sl;
    }
    public void setThanhTien(double tt){
        this.thanhtien = tt;
    }
    public double getThanhTien(){
        return this.thanhtien;
    }
    @Override
    public String toString() {
        return new String("Số lượng: " + this.sl + " - Thành tiền: " + this.thanhtien ); //+ " - " + this.manv + " - " + this.makh + " - " + this.masp + " - " + this.soluong);
    }
}
