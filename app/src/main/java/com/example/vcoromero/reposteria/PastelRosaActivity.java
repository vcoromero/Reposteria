package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PastelRosaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastel_rosa);
    }


    public void realizarPedido(View v)
    {
        Intent i = new Intent(PastelRosaActivity.this, PedidoActivity.class);
        startActivity(i);
    }
}
