package com.proyectocuatro.motordesuscripcionessaas;

public record FacturaDTO (
        String idUsuario,
        String nombre,
        String empresa,
        double montoPagar
){
}
