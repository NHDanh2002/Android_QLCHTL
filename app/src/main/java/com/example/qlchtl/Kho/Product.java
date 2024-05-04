package com.example.qlchtl.Kho;

import java.io.Serializable;

import com.example.qlchtl.DanhMuc.Category;

public class Product implements Serializable {
    private static final String DATABASE_NAME = "QLCHTL.sqlite";
    private String productId;
    private String productName;
    private Category productCategory;
    private Double productPrice;
    private int productQuantity;
    private String hsd;

    public Product() {
    }

    public Product(String productId, String productName,Category productCategory, Double productPrice, int productQuantity, String hsd) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productCategory=productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.hsd = hsd;
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

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String gethsd() {
        return hsd;
    }

    public void sethsd(String hsd) {
        this.hsd = hsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productQuantity != product.productQuantity) return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null)
            return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null)
            return false;
        if (productCategory != null ? !productCategory.equals(product.productCategory) : product.productCategory != null)
            return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        return hsd != null ? hsd.equals(product.hsd) : product.hsd == null;

    }

    @Override
    public String toString() {
        return "Sanpham{" +
                "masp='" + productId + '\'' +
                ", tensp='" + productName + '\'' +
                ", danhmuc=" + productCategory +
                ", dongia=" + productPrice +
                ", soluong=" + productQuantity +
                ", hansudung='" + hsd + '\'' +
                '}';
    }

}
