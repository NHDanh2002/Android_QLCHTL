package com.example.qlchtl.Object;

public class FeedBack {
    private String maCS;
    private String maKH;
    private String yeuCau;
    private String phanHoi;
    private String ngayPhanHoi;

    public FeedBack(String maCS, String maKH, String yeuCau, String phanHoi) {
        this.maCS = maCS;
        this.maKH = maKH;
        this.yeuCau = yeuCau;
        this.phanHoi = phanHoi;
    }

    public String getMaCS() {
        return maCS;
    }

    public void setMaCS(String maCS) {
        this.maCS = maCS;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(String phanHoi) {
        this.phanHoi = phanHoi;
    }
    public String toString()
    {
        return "Phản hồi: " + this.maCS;
    }
}

