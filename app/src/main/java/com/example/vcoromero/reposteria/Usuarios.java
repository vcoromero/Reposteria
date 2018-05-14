package com.example.vcoromero.reposteria;

/**
 * Created by vcoro on 14/05/2018.
 */

public class Usuarios {

    private int id;
    private String email;
    private String password;

    public Usuarios() {

    }

    public Usuarios(int id, String email, String password) {
        this.id = id;
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
