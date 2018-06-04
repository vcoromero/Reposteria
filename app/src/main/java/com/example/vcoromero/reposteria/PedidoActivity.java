package com.example.vcoromero.reposteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PedidoActivity extends AppCompatActivity {

    private Spinner spinnerSaborPan;
    private Spinner spinnerTamaño;
    private Spinner spinnerSaborRelleno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        spinnerSaborPan = (Spinner) findViewById(R.id.spinnerSaborPan);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterSaborPan = ArrayAdapter.createFromResource(this,
                R.array.sabor_pan_array, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapterSaborPan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSaborPan.setAdapter(adapterSaborPan);

        spinnerTamaño = (Spinner) findViewById(R.id.spinnerTamaño);
        ArrayAdapter<CharSequence> adapterTamaño = ArrayAdapter.createFromResource(this,
                R.array.tamaño_array, android.R.layout.simple_spinner_item);
        adapterTamaño.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTamaño.setAdapter(adapterTamaño);


        spinnerSaborRelleno = (Spinner) findViewById(R.id.spinnerSaborRelleno);
        ArrayAdapter<CharSequence> adapterSaborRelleno = ArrayAdapter.createFromResource(this,
                R.array.sabor_relleno_array, android.R.layout.simple_spinner_item);
        adapterSaborRelleno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSaborRelleno.setAdapter(adapterSaborRelleno);
    }
}
