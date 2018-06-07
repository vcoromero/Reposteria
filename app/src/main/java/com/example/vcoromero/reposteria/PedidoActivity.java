package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PedidoActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtDireccion;
    private EditText txtTelefono;
    private EditText txtHoraEntrega;
    private EditText txtFechaEntrega;
    private EditText txtExtra;

    private Spinner spinnerSaborPan;
    private Spinner spinnerTamaño;
    private Spinner spinnerSaborRelleno;

    private Button btnRealizarPedido;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtHoraEntrega = (EditText) findViewById(R.id.txtHoraEntrega);
        txtFechaEntrega = (EditText) findViewById(R.id.txtFechaEntrega);
        txtExtra = (EditText) findViewById(R.id.txtExtra);
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
        db = new DatabaseHelper(this);

    }

    public void savePedido(View v) {
        if (txtNombre.getText().toString().trim().equals("") || txtDireccion.getText().toString().trim().equals("") || txtTelefono.getText().toString().trim().equals("") ||
                txtFechaEntrega.getText().toString().trim().equals("") || txtHoraEntrega.getText().toString().trim().equals("") || txtExtra.getText().toString().trim().equals("")) {
            Toast.makeText(PedidoActivity.this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            long r = db.addPedido(
                    new Pedidos(
                            txtNombre.getText().toString().trim(),
                            txtDireccion.getText().toString().trim(),
                            Integer.parseInt(txtTelefono.getText().toString().trim()),
                            txtFechaEntrega.getText().toString().trim(),
                            txtHoraEntrega.getText().toString().trim(),
                            spinnerSaborPan.getSelectedItem().toString().trim(),
                            spinnerTamaño.getSelectedItem().toString().trim(),
                            spinnerSaborRelleno.getSelectedItem().toString().trim(),
                            txtExtra.getText().toString().trim()));
            if (r > 0) {
                Toast.makeText(PedidoActivity.this, "Se ha registrado tu pedido exitosamente " + r, Toast.LENGTH_SHORT).show();
                cleanInputs();
                Intent i = new Intent(PedidoActivity.this, MostrarPedidoActivity.class);
                i.putExtra("id", Long.toString(r));
                i.putExtra("nombre", txtNombre.getText().toString().trim());
                i.putExtra("direccion", txtDireccion.getText().toString().trim());
                i.putExtra("telefono", txtTelefono.getText().toString().trim());
                i.putExtra("fecha_entegra", txtFechaEntrega.getText().toString().trim());
                i.putExtra("hora_entrega", txtHoraEntrega.getText().toString().trim());
                i.putExtra("sabor", spinnerSaborPan.getSelectedItem().toString().trim());
                i.putExtra("tamaño", spinnerTamaño.getSelectedItem().toString().trim());
                i.putExtra("relleno", spinnerSaborRelleno.getSelectedItem().toString().trim());
                i.putExtra("extra", txtExtra.getText().toString().trim());
                startActivity(i);
            } else {
                Toast.makeText(PedidoActivity.this, "Ocurrió un error al realizar el pedido", Toast.LENGTH_SHORT).show();
                cleanInputs();
            }

        }
    }

    public void cleanInputs() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtHoraEntrega.setText("");
        txtFechaEntrega.setText("");
        txtExtra.setText("");
    }
}
