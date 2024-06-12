package com.example.spsg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;


public class RegisterActivity extends AppCompatActivity {
     private EditText rEmail;
     private EditText rPassword;
     private Button rButton;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rEmail = findViewById(R.id.r_email);
        rPassword = findViewById(R.id.r_password);
        rButton = findViewById(R.id.signupbtn1);
        mAuth = FirebaseAuth.getInstance();

        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = rEmail.getText().toString();
                String txtPassword = rPassword.getText().toString();
                if ( TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(RegisterActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 8){
                    Toast.makeText(RegisterActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser( txtEmail , txtPassword);
                }
            }
        });




}

    private void registerUser(String rEmail, String rPassword) {
        mAuth.createUserWithEmailAndPassword(rEmail, rPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registering is successfu!", Toast.LENGTH_SHORT);
                }else {
                    Toast.makeText(RegisterActivity.this, "Sorry!, Registering Failed", Toast.LENGTH_SHORT);
                }

            }
        });
    }
}
