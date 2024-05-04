package com.example.qlchtl.Object;

public class ChiTietHoaDonItem {
    private String tenSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietHoaDonItem(String tenSP, int soLuong, double donGia, double thanhTien) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }
    public String toString()
    {
        return tenSP + "_ số lượng: " + String.valueOf(soLuong) + "   =>   " + thanhTien;
    }
}

