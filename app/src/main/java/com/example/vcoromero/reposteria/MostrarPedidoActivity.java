package com.example.vcoromero.reposteria;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarPedidoActivity extends AppCompatActivity {

    private String id = "";
    private DatabaseHelper db;
    private TextView lblNombre;
    private TextView lblDireccion;
    private TextView lblTelefono;
    private TextView lblFechaEntrega;
    private TextView lblHoraEntrega;
    private TextView lblSabor;
    private TextView lblRelleno;
    private TextView lblTamano;
    private TextView lblExtra;
    private DatabaseHelper deb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_pedido);
        lblNombre = (TextView) findViewById(R.id.lblPedidoNombre);
        lblDireccion = (TextView) findViewById(R.id.lblPedidoDireccion);
        lblTelefono = (TextView) findViewById(R.id.lblPedidoTelefono);
        lblFechaEntrega = (TextView) findViewById(R.id.lblPedidoFechaEntrega);
        lblHoraEntrega = (TextView) findViewById(R.id.lblPedidoHoraEntrega);
        lblSabor = (TextView) findViewById(R.id.lblPedidoSaborPan);
        lblRelleno = (TextView) findViewById(R.id.lblPedidoRellenoPan);
        lblTamano = (TextView) findViewById(R.id.lblPedidoTamano);
        lblExtra = (TextView) findViewById(R.id.lblPedidoExtra);
        deb = new DatabaseHelper(this);
        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            id = parametros.getString("id");
            lblNombre.setText(parametros.getString("nombre"));
            lblDireccion.setText(parametros.getString("direcion"));
            lblTelefono.setText(parametros.getString("telefono"));
            lblFechaEntrega.setText(parametros.getString("fecha_entrega"));
            lblHoraEntrega.setText(parametros.getString("hora_entrega"));
            lblSabor.setText(parametros.getString("sabor"));
            lblRelleno.setText(parametros.getString("relleno"));
            lblTamano.setText(parametros.getString("tamaño"));
            lblExtra.setText(parametros.getString("extra"));
            //this.mostrarPedido(Long.parseLong(id)); esta fallando el metodo ARREGLAR
            Toast.makeText(MostrarPedidoActivity.this, id, Toast.LENGTH_LONG).show();
        }

    }
}
