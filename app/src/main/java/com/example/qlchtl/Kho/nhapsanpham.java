package com.example.qlchtl.Kho;

import java.io.Serializable;

import com.example.qlchtl.DanhMuc.Category;

public class nhapsanpham implements Serializable {
    private static final String DATABASE_NAME = "QLCHTL.sqlite";
    private String productId;
    private String productName;
    private Category productCategory;
    private Double productPrice;
    private int productQuantityn;
    private int productQuantityt;
    private String nn;

    public nhapsanpham() {
    }

    public nhapsanpham(String productId, String productName,Category productCategory, Double productPrice, int productQuantityn,int productQuantityt, String nn) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productCategory=productCategory;
        this.productPrice = productPrice;
        this.productQuantityn = productQuantityn;
        this.productQuantityt = productQuantityt;
        this.nn = nn;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantityn() {
        return this.productQuantityn;
    }

    public void setProductQuantityn(int productQuantityn) {
        this.productQuantityn = productQuantityn;
    }

    public int getProductQuantityt() {
        return this.productQuantityt;
    }

    public void setProductQuantityt(int productQuantityt) {
        this.productQuantityt = productQuantityt;
    }
    public String getnn() {
        return nn;
    }

    public void setnn(String nn) {
        this.nn = nn;
    }


    @Override
    public String toString() {
        return "Sanpham{" +
                "masp='" + productId + '\'' +
                ", tensp='" + productName + '\'' +
                ", danhmuc=" + productCategory +
                ", dongia=" + productPrice +
                ", soluongthucte=" + productQuantityt +
                ", soluongnhap=" + productQuantityn +
                ", ngaynhap='" + nn + '\'' +
                '}';
    }

}
