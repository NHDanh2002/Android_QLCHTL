package com.example.qlchtl.Object;

import java.io.Serializable;
import java.time.LocalDate;

public class UuDai implements Serializable {
    private Integer maCT;
    private String tenCT;
    private String moTa;
    private String ngayBatDau;
    private String ngayKetThuc;

    public UuDai(Integer maCT, String tenCT, String moTa, String ngayBatDau, String ngayKetThuc) {
        this.maCT = maCT;
        this.tenCT = tenCT;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getMaCT() {
        return maCT;
    }

    public void setMaCT(Integer maCT) {
        this.maCT = maCT;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return tenCT;
    }
}
