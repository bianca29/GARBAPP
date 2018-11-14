package com.example.biancaandrea.garbapp.entities;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nombre;
    private String distrito;
    private String email;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String distrito, String email, String contraseña) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.email = email.trim();
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        Map<String, String> values = new HashMap<>();
        values.put("nombre", nombre);
        values.put("distrito", distrito);
        values.put("email", email);
        values.put("contraseña", contraseña);
        return values.toString();
    }

    public void setData(Usuario user) {
        this.nombre = user.nombre;
        this.distrito = user.distrito;
        this.email = user.email;
        this.contraseña = user.contraseña;
    }

    private static final class SingletonHolder{
        public static final Usuario INSTANCE = new Usuario();
    }

    public static Usuario getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
