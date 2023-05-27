package com.example.ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.apporder.R;
import com.example.ordering.MainAdminActivity;
import com.example.ordering.MainUserActivity;
import com.example.ordering.UI.CartFragment;

public class LoginActivity extends AppCompatActivity {

    EditText etName, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                if(name.equals("admin") && password.equals("123456")) {
                    intent = new Intent(LoginActivity.this, MainAdminActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(name.equals("ban1") || name.equals("ban2") || name.equals("ban3") || name.equals("ban4") || name.equals("ban5") || name.equals("ban6") && password.equals("123456789")) {
                    intent = new Intent(LoginActivity.this, MainUserActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
                intent.putExtra("id", name); // key là tên của thông tin cần chuyển, value là giá trị của thông tin
                startActivity(intent);
            }
        });
    }
}
