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

public class ProductAdapter extends BaseAdapter {

    ArrayList<Product> listData;
    LayoutInflater inflater;

    TextView txtId, txtName, txtCategory, txtsl;

    public ProductAdapter(ArrayList<Product> listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void clear() {
        listData.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Product> products) {
        listData.addAll(products);
        notifyDataSetChanged();
    }

    public ArrayList<Product> getListData() {
        return listData;
    }

    public void setListData(ArrayList<Product> listData) {
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
            convertView = inflater.inflate(R.layout.item_listview, null);
        }

        //Anh xa
        txtId = (TextView) convertView.findViewById(R.id.txtId);
        txtName = (TextView) convertView.findViewById(R.id.txtName);

        txtsl = (TextView) convertView.findViewById(R.id.txtsl);
        // gán dữ liệu vào từng đối tượng trong item_listview.xml
        Product product = (Product) getItem(position);
        txtId.setText(product.getProductId());
        txtName.setText(product.getProductName());

        txtsl.setText(String.valueOf(product.getProductQuantity()));
        return convertView;
    }
}

