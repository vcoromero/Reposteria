package com.example.vcoromero.reposteria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vcoro on 14/05/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static String DATABASE = "reposteria_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Usuarios.CREATE_TABLE);
        db.execSQL(Pedidos.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Usuarios.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Pedidos.TABLE);
        onCreate(db);
    }

    public long addUser(Usuarios u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Usuarios.COLUMN_EMAIL, u.getEmail());
        values.put(Usuarios.COLUMN_PASSWORD, u.getPassword());
        long r = db.insert(Usuarios.TABLE, null, values);
        db.close();
        return r;
    }

    public long addPedido(Pedidos p) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Pedidos.COLUMN_NOMBRE, p.getNombre());
        values.put(Pedidos.COLUMN_DIRECCION, p.getDireccion());
        values.put(Pedidos.COLUMN_TELEFONO, p.getTelefono());
        values.put(Pedidos.COLUMN_FECHA_ENTREGA, p.getFecha_entrega());
        values.put(Pedidos.COLUMN_HORA_ENTREGA, p.getHora_entrega());
        values.put(Pedidos.COLUMN_SABOR_PAN, p.getSabor_pan());
        values.put(Pedidos.COLUMN_TAMANO, p.getTamano());
        values.put(Pedidos.COLUMN_RELLENO_PAN, p.getRelleno_pan());
        values.put(Pedidos.COLUMN_EXTRA, p.getExtra());
        long r = db.insert(Pedidos.TABLE, null, values);
        db.close();
        return r;
    }
    public Pedidos getPedido(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Pedidos.TABLE,
                new String[]{Pedidos.COLUMN_ID, Pedidos.COLUMN_NOMBRE, Pedidos.COLUMN_DIRECCION, Pedidos.COLUMN_TELEFONO, Pedidos.COLUMN_FECHA_ENTREGA,
                        Pedidos.COLUMN_HORA_ENTREGA, Pedidos.COLUMN_SABOR_PAN, Pedidos.COLUMN_TAMANO, Pedidos.COLUMN_RELLENO_PAN, Pedidos.COLUMN_EXTRA},
                Pedidos.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Pedidos object
        Pedidos pedido = new Pedidos(
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_NOMBRE)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_DIRECCION)),
                cursor.getInt(cursor.getColumnIndex(Pedidos.COLUMN_TELEFONO)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_FECHA_ENTREGA)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_HORA_ENTREGA)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_SABOR_PAN)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_TAMANO)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_RELLENO_PAN)),
                cursor.getString(cursor.getColumnIndex(Pedidos.COLUMN_EXTRA)));

        // close the db connection
        cursor.close();

        return pedido;
    }

    public boolean checkUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Usuarios.TABLE,
                new String[]{Usuarios.COLUMN_ID},
                Usuarios.COLUMN_EMAIL + "=?",
                new String[]{String.valueOf(email)}, null, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Usuarios.TABLE,
                new String[]{Usuarios.COLUMN_ID},
                Usuarios.COLUMN_EMAIL + "= ? AND " + Usuarios.COLUMN_PASSWORD + "= ?",
                new String[]{String.valueOf(email), String.valueOf(password)}, null, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}
