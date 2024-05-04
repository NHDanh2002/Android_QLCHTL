package com.example.qlchtl.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlchtl.R;

public class GuestFeedBack extends AppCompatActivity {
    ImageView back, writefeedback, myfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_feedback);
        back = (ImageView) findViewById(R.id.img_back);
        Intent intent = getIntent();
        Integer makh = intent.getIntExtra("USER_ID",-1);
        writefeedback = (ImageView) findViewById(R.id.img_feedback);
        myfeedback = (ImageView) findViewById(R.id.img_myfeedback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        writefeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent writefeedback_intent = new Intent(GuestFeedBack.this, GuestWriteFeedback.class);
                writefeedback_intent.putExtra("USER_ID", makh);
                startActivity(writefeedback_intent);
            }
        });
        myfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myfeedback_intent = new Intent(GuestFeedBack.this, GuestMyFeedback.class);
                myfeedback_intent.putExtra("USER_ID", makh);
                startActivity(myfeedback_intent);
            }
        });
    }
}
