package com.testluxpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail,
            etPassword;
    TextView tvForgetPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvForgetPass = findViewById(R.id.tvForgetPass);
        btnLogin = findViewById(R.id.btnLogin);


        tvForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgetPassActivity.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
                    Toast.makeText(MainActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (etPassword.getText().toString().isEmpty() || etPassword.getText().toString().length() < 10) {
                    Toast.makeText(MainActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
                } else if (!etEmail.getText().toString().equalsIgnoreCase("test@luxpmsoft.com") && !etPassword.getText().toString().equalsIgnoreCase("test1234!.")) {
                    Toast.makeText(MainActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }
            }
        });

    }
}