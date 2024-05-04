package com.example.qlchtl.Kho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlchtl.R;

import java.util.ArrayList;
import java.util.List;

import Database.QLCHTL_DatabaseHandler;

public class Listnhap extends BaseAdapter {
    private QLCHTL_DatabaseHandler database;
    ArrayList<nhapsanpham> listData;
    LayoutInflater inflater;

    TextView txtId, txtName, txtCategory, txtsl,txtsln;

    public Listnhap(ArrayList<nhapsanpham> listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void clear() {
        listData.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<nhapsanpham> products) {
        listData.addAll(products);
        notifyDataSetChanged();
    }

    public ArrayList<nhapsanpham> getListData() {
        return listData;
    }

    public void setListData(ArrayList<nhapsanpham> listData) {
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listnhap, null);
        }

        //Anh xa
        txtId = (TextView) convertView.findViewById(R.id.txtId);
        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtCategory = (TextView) convertView.findViewById(R.id.txtCategory);
        txtsl = (TextView) convertView.findViewById(R.id.txtsl);
        txtsln = (TextView) convertView.findViewById(R.id.txtsln);
        // gán dữ liệu
        nhapsanpham product = (nhapsanpham) getItem(position);
        txtId.setText(product.getProductId());
        txtName.setText(product.getProductName());
        txtCategory.setText(product.getProductCategory().getCategoryName());
        txtsl.setText(product.getProductQuantityt());
        txtsln.setText(product.getProductQuantityn());
        return convertView;
    }
}