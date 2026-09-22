package com.proyectocuatro.motordesuscripcionessaas.dto;

public record FacturaDTO (
        String idUsuario,
        String nombre,
        String empresa,
        double montoPagar
){
}
