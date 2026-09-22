package com.proyectocuatro.motordesuscripcionessaas.model;

public class Usuario {

    private String id;
    private String nombre;
    private boolean estadoActivo;
    private Plan plan;

    public Usuario(String id, String nombre, boolean estadoActivo, Plan plan) {
        this.id = id;
        this.nombre = nombre;
        this.estadoActivo = estadoActivo;
        this.plan = plan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
