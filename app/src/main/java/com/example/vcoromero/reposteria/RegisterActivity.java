package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtConfirmPassword;
    private Button btnConfirm;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtCofirmPassword);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        db = new DatabaseHelper(this);
    }

    public void confirm(View v) {

        if (txtEmail.getText().toString().trim().equals("") || txtPassword.getText().toString().trim().equals("") || txtConfirmPassword.getText().toString().trim().equals("")) {
            Toast.makeText(RegisterActivity.this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
        }
        else{
            if (txtPassword.getText().toString().trim().equals(txtConfirmPassword.getText().toString().trim())) {
                Log.d("Insert:", "Insertando...");
                if (db.addUser(new Usuarios(txtEmail.getText().toString().trim(), txtPassword.getText().toString().trim())) > 1) {
                    Toast.makeText(RegisterActivity.this, "Insertó", Toast.LENGTH_SHORT).show();
                    cleanInputs();
                    Intent i = new Intent(RegisterActivity.this, MenuActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(RegisterActivity.this, "No insertó", Toast.LENGTH_SHORT).show();
                    cleanInputs();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void hasAccount(View v) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void cleanInputs(){
        txtEmail.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
    }
}
