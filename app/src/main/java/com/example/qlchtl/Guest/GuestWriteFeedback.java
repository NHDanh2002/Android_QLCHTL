package com.example.qlchtl.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.R;

import Database.FeedbackDataSource;
import Database.KhachHangDataSource;

public class GuestWriteFeedback extends AppCompatActivity {
    Button send, back;
    EditText feedback;
    FeedbackDataSource dataSource;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_writefeedback);
        send = (Button) findViewById(R.id.btn_gui);
        back = (Button) findViewById(R.id.btn_dong);
        feedback = (EditText) findViewById(R.id.txt_feedback);
        Intent intent = getIntent();
        Integer makh = intent.getIntExtra("USER_ID",-1);
        //feedback.setText(makh.toString());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ykien = feedback.getText().toString();
                if(ykien.isEmpty())
                {
                    Toast.makeText(GuestWriteFeedback.this, "Vui lòng điền thông tin ý kiến", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataSource = new FeedbackDataSource(GuestWriteFeedback.this);
                    dataSource.open();
                    long kq = dataSource.addFeedback(makh,ykien,"null");
                    if (kq != -1) {
                        Toast.makeText(GuestWriteFeedback.this, "Gửi thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(GuestWriteFeedback.this, "Gửi thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
