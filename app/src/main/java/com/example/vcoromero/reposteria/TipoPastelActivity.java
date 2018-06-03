package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipoPastelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_pastel);
    }


    public void openPastelesCumpleanos(View v){
        Intent i = new Intent(TipoPastelActivity.this, PastelesCumpleanosActivity.class);
        startActivity(i);
    }
}
