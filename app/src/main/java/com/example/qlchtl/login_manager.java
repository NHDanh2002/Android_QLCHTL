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
import com.example.qlchtl.Manager.ManagerMenuActivity;

import Database.LoginDataSource;
import Database.QLCHTL_DatabaseHandler;

public class login_manager extends Fragment {
    EditText username, password;
    Button btnlogin;
    LoginDataSource dataSource;


    public login_manager() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_manager, container, false);

        username = view.findViewById(R.id.txt_manager_user);
        password = view.findViewById(R.id.txt_manager_password);
        btnlogin = view.findViewById(R.id.btn_managerlogin);
        dataSource = new LoginDataSource(requireContext());
        dataSource.open();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = username.getText().toString();
                String matkhau = password.getText().toString();
                if (dataSource.checkUser_Manager(taikhoan, matkhau)) {
                        Intent intent = new Intent(requireActivity(), ManagerMenuActivity.class);
                        startActivity(intent);
                } else{
                    Toast.makeText(requireContext(), "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}