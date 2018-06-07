package com.example.vcoromero.reposteria;

public class Pedidos {
    public static final String TABLE = "pedidos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_DIRECCION = "direccion";
    public static final String COLUMN_TELEFONO = "telefono";
    public static final String COLUMN_FECHA_ENTREGA = "fecha_entrega";
    public static final String COLUMN_HORA_ENTREGA = "hora_entrega";
    public static final String COLUMN_SABOR_PAN = "sabor_pan";
    public static final String COLUMN_TAMANO = "tamaño";
    public static final String COLUMN_RELLENO_PAN = "relleno_pan";
    public static final String COLUMN_EXTRA = "extra";

    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String fecha_entrega;
    private String hora_entrega;
    private String sabor_pan;
    private String tamano;
    private String relleno_pan;
    private String extra;
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOMBRE + " TEXT NOT NULL, "
            + COLUMN_DIRECCION + " TEXT NOT NULL,"
            + COLUMN_TELEFONO + " INTEGER NOT NULL,"
            + COLUMN_FECHA_ENTREGA + " TEXT NOT NULL,"
            + COLUMN_HORA_ENTREGA + " TEXT NOT NULL,"
            + COLUMN_SABOR_PAN + " TEXT NOT NULL,"
            + COLUMN_TAMANO + " TEXT NOT NULL,"
            + COLUMN_RELLENO_PAN + " TEXT NOT NULL,"
            + COLUMN_EXTRA + " TEXT NOT NULL)";

    public Pedidos() {

    }

    public Pedidos(String nombre, String direccion, int telefono, String fecha_entrega, String hora_entrega,
                   String sabor_pan, String tamano, String relleno_pan, String extra) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_entrega = fecha_entrega;
        this.hora_entrega = hora_entrega;
        this.sabor_pan = sabor_pan;
        this.tamano = tamano;
        this.relleno_pan = relleno_pan;
        this.extra = extra;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getFecha_entrega() {
        return this.fecha_entrega;
    }

    public String getHora_entrega() {
        return this.hora_entrega;
    }

    public String getRelleno_pan() {
        return this.relleno_pan;
    }

    public String getSabor_pan() {
        return this.sabor_pan;
    }

    public String getTamano() {
        return this.tamano;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRelleno_pan(String relleno_pan) {
        this.relleno_pan = relleno_pan;
    }

    public void setSabor_pan(String sabor_pan) {
        this.sabor_pan = sabor_pan;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

