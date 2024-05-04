package com.example.qlchtl.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.R;

public class GuestMenuActivity extends AppCompatActivity {
    ImageView aboutus,guestinfo,products,sales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_menu);
        // Nhận thông tin người dùng từ Intent
        Intent intent = getIntent();
        Integer userId = intent.getIntExtra("USER_ID", -1);
        String name = intent.getStringExtra("NAME");
        String type = intent.getStringExtra("LOAI");
        String phone = intent.getStringExtra("PHONE");
        String username = intent.getStringExtra("USERNAME");
        String password = intent.getStringExtra("PASSWORD");
        aboutus = (ImageView) findViewById(R.id.img_aboutus);
        guestinfo = (ImageView) findViewById(R.id.img_userinfo);
        products = (ImageView) findViewById(R.id.img_products);
        sales = (ImageView) findViewById(R.id.img_sales);

        guestinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info_intent = new Intent(GuestMenuActivity.this, GuestInfoActivity.class);
                info_intent.putExtra("USER_ID", userId);
                info_intent.putExtra("NAME",name);
                info_intent.putExtra("PHONE",phone);
                info_intent.putExtra("LOAI",type);
                info_intent.putExtra("USERNAME", username);
                info_intent.putExtra("PASSWORD", password);
                startActivity(info_intent);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus_intent = new Intent(GuestMenuActivity.this, GuestShopInfoActivity.class);
                startActivity(aboutus_intent);
            }
        });

        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent products_intent = new Intent(GuestMenuActivity.this, GuestProductsActivity.class);
                startActivity(products_intent);
            }
        });

        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sales_intent = new Intent(GuestMenuActivity.this, GuestSalesActivity.class);
                startActivity(sales_intent);
            }
        });
    }
}
