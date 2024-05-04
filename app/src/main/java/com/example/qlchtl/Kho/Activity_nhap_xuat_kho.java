package com.example.qlchtl.Kho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlchtl.R;

import java.util.ArrayList;

import Database.QLCHTL_DatabaseHandler;

public class Activity_nhap_xuat_kho extends AppCompatActivity {
    private Button update;
    private Button backButton,loc;
    private ListView productListview;
    Spinner spinnerngay;
    private Listnhap arrayAdapter;
    private ArrayAdapter<String> adapterngay;
    private ArrayList<nhapsanpham> productList;
    private QLCHTL_DatabaseHandler database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_xuat_kho);
        database = new QLCHTL_DatabaseHandler(this);
        productListview = findViewById(R.id.productinputListView);
        backButton = findViewById(R.id.backButton);
        spinnerngay = findViewById(R.id.ngaynhap);
        loadngay();
        loc = findViewById(R.id.loc);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngay = (String) spinnerngay.getSelectedItem();
                nh(ngay);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        productListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                loadProduct();
                try{
                    // Get the product at the clicked position
                    nhapsanpham product = (nhapsanpham) arrayAdapter.getItem(position);
                    // Call updateproduct method with the Product as argument
                    capnhatsoluong(product);
                }catch (Exception e){
                    Toast.makeText(Activity_nhap_xuat_kho.this, "Cập nhật sản phẩm không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        update = findViewById(R.id.updateButton);
    }
    void loadngay() {
        ArrayList<String> dayList = database.getAllDayinputproduct();
        if (spinnerngay != null) {
            adapterngay = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dayList);
            adapterngay.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
            spinnerngay.setAdapter(adapterngay);
        } else {
            Toast.makeText(Activity_nhap_xuat_kho.this, "Spinner is null", Toast.LENGTH_SHORT).show();
        }
    }
    void nh(String ngay){
        // Get list of Product from database
        ArrayList<nhapsanpham> products = database.getInputProducts(ngay);
        // Create a new instance of ProductAdapter with the list of products
        arrayAdapter = new Listnhap(products, this);
        // Set the array adapter to listView
        productListview.setAdapter(arrayAdapter);
    }
    void capnhatsoluong(nhapsanpham product){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_nhap, null);
        builder.setView(dialogView);

        final EditText editTextQuantity = dialogView.findViewById(R.id.editTextQuantity);
        Button buttonUpdate = dialogView.findViewById(R.id.buttonUpdate);

        final AlertDialog dialog = builder.create();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityString = editTextQuantity.getText().toString().trim();
                if (!quantityString.isEmpty()) {
                    int quantity = Integer.parseInt(quantityString);
                    product.setProductQuantityt(quantity);
                    database.capnhatsoluong(product);
                    dialog.dismiss();
                } else {
                    Toast.makeText(Activity_nhap_xuat_kho.this, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
        // After updating the quantity, refresh the list view to reflect the changes
        String ngay = spinnerngay.getSelectedItem().toString();
        nh(ngay);
    }
}