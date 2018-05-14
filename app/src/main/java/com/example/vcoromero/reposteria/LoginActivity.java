package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnSignin;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        db = new DatabaseHelper(this);
    }

    public void signin(View v) {

        if (txtEmail.getText().toString().trim().equals("") || txtPassword.getText().toString().trim().equals("")) {
            Toast.makeText(LoginActivity.this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            if (db.checkUser(txtEmail.getText().toString().trim(), txtPassword.getText().toString().trim())) {
                Log.d("Login:", "Logeando...");
                Toast.makeText(LoginActivity.this, "Entró", Toast.LENGTH_SHORT).show();
                cleanInputs();
                Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(i);

            } else {
                Toast.makeText(LoginActivity.this, "Ocurrió algún error, verifique sus datos.", Toast.LENGTH_SHORT).show();
                cleanInputs();
            }
        }
    }

    public void signup(View v) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void cleanInputs() {
        txtEmail.setText("");
        txtPassword.setText("");
    }

}
