package com.example.vcoromero.reposteria;

/**
 * Created by vcoro on 14/05/2018.
 */

public class Usuarios {

    public static final String TABLE = "usuarios2";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    private int id;
    private String email;
    private String password;
    public static final String CREATE_TABLE ="CREATE TABLE " + TABLE
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EMAIL + " TEXT NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL)";
    public Usuarios() {

    }

    public Usuarios(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
