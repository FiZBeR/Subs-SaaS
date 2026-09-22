package com.proyectocuatro.motordesuscripcionessaas.model;

public class Plan {

    private String nombre;
    private double precio;
    private int limitePantallas;

    public Plan(String nombre, double precio, int limitePantallas) {
        this.nombre = nombre;
        this.precio = precio;
        this.limitePantallas = limitePantallas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getLimitePantallas() {
        return limitePantallas;
    }

    public void setLimitePantallas(int limitePantallas) {
        this.limitePantallas = limitePantallas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
