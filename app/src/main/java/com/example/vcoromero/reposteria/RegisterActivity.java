package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void confirm(View v){
        Intent i = new Intent(RegisterActivity.this, MenuActivity.class);
        startActivity(i);
    }
    public void hasAccount(View v){
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
