package com.example.spsg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button loginr;
//  its just a check for github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginr =  findViewById(R.id.loginbtn1);

        loginr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, uploadActivity.class));
                Toast.makeText(LoginActivity.this, "Welcome Back!!", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}