package com.example.qlchtl.Guest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.Object.FeedBack;
import com.example.qlchtl.R;

import java.util.ArrayList;

import Database.FeedbackDataSource;
import Database.QLCHTL_DatabaseHandler;

public class GuestMyFeedback extends AppCompatActivity {
    static QLCHTL_DatabaseHandler dbHelper;
    static SQLiteDatabase db;
    FeedbackDataSource dataSource;
    ImageView back;
    ListView lstfb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_myfeedback);
        Intent intent = getIntent();
        Integer makh = intent.getIntExtra("USER_ID", -1);
        back = (ImageView) findViewById(R.id.img_back);
        lstfb = (ListView) findViewById(R.id.list_feedback);
        dataSource = new FeedbackDataSource(this);
        dataSource.open();
        dataSource.loadCustomerDataToListView(makh.toString(),lstfb);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
