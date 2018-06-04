package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PastelesCumpleanosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasteles_cumpleanos);
    }

    public void openPastelRosa(View v){
        Intent i = new Intent(PastelesCumpleanosActivity.this, PastelRosaActivity.class);
        startActivity(i);
    }
}
