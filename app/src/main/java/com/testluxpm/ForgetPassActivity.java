package com.testluxpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassActivity extends AppCompatActivity {
    Button btnSubmitEmail;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        etEmail=findViewById(R.id.etEmail);
        btnSubmitEmail=findViewById(R.id.btnSubmitEmail);

        btnSubmitEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().isEmpty()) {
                    Toast.makeText(ForgetPassActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
                    Toast.makeText(ForgetPassActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if(!etEmail.getText().toString().equalsIgnoreCase("test@luxpmsoft.com") ){
                    Toast.makeText(ForgetPassActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(ForgetPassActivity.this,OtpActivity.class));
                }
            }
        });
    }
}