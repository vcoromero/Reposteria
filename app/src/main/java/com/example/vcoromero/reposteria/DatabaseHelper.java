package com.example.vcoromero.reposteria;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vcoro on 14/05/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static String DATABASE = "reposteria2";


    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Usuarios.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF EXISTS " + Usuarios.TABLE);
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
}
