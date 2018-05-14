package com.example.vcoromero.reposteria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vcoro on 14/05/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE = "reposteria.db";
    private static String TABLE = "usuarios";
    private static String COLUMN_ID = "id";
    private static String COLUMN_EMAIL = "email";
    private static String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
