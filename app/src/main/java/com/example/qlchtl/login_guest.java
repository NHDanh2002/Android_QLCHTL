package com.example.qlchtl;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qlchtl.Guest.GuestMenuActivity;
import com.example.qlchtl.Guest.GuestSignupActivity;

import Database.LoginDataSource;
import Database.QLCHTL_DatabaseHandler;

public class login_guest extends Fragment {

    EditText username, password;
    Button btnlogin, btnsignup;
    LoginDataSource dataSource;

    public login_guest() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_guest, container, false);

        username = view.findViewById(R.id.guest_taikhoan);
        password = view.findViewById(R.id.guest_matkhau);
        btnlogin = view.findViewById(R.id.btn_login_guest);
        btnsignup = view.findViewById(R.id.btn_signup_guest);
        dataSource = new LoginDataSource(requireContext());
        dataSource.open();
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_intent = new Intent(requireActivity(), GuestSignupActivity.class);
                startActivity(signup_intent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = username.getText().toString();
                String matkhau = password.getText().toString();
                if (dataSource.checkUser_Guest(taikhoan, matkhau)) {
                    Cursor cursor = dataSource.getUserByUsername(taikhoan);
                    if (cursor != null && cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_MKH);
                        int nameIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_TKH);
                        int sdtIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_SDT);
                        int loaiIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_LKH);
                        int usernameIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_TK);
                        int passwordIndex = cursor.getColumnIndex(QLCHTL_DatabaseHandler.TBL_KHACHHANG_MK);

                        int userId = cursor.getInt(idIndex);
                        String userName = cursor.getString(nameIndex);
                        String userPhone = cursor.getString(sdtIndex);
                        String userType = cursor.getString(loaiIndex);
                        String userUsername = cursor.getString(usernameIndex);
                        String userPassword = cursor.getString(passwordIndex);
                        Intent intent = new Intent(requireActivity(), GuestMenuActivity.class);
                        intent.putExtra("USER_ID", userId);
                        intent.putExtra("NAME",userName);
                        intent.putExtra("PHONE",userPhone);
                        intent.putExtra("LOAI",userType);
                        intent.putExtra("USERNAME", userUsername);
                        intent.putExtra("PASSWORD", userPassword);
                        startActivity(intent);
                    }
                } else if(!dataSource.checkUser_Guest(taikhoan, matkhau)) {
                    Toast.makeText(requireContext(), "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
