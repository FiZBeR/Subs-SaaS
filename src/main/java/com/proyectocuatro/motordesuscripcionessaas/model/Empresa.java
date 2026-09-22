package com.proyectocuatro.motordesuscripcionessaas.model;

import com.proyectocuatro.motordesuscripcionessaas.dto.FacturaDTO;
import com.proyectocuatro.motordesuscripcionessaas.exception.UsuarioInactivoException;
import com.proyectocuatro.motordesuscripcionessaas.exception.UsuarioNoEncontradoException;

import java.util.List;
import java.util.stream.Collectors;

public class Empresa {

    private String nombre;
    private List<Usuario> clientes;

    public Empresa(String nombre, List<Usuario> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getEmpleados() {
        return clientes;
    }

    public void setEmpleados(List<Usuario> empleados) {
        this.clientes = empleados;
    }

    public void cambiarPlanUsuario(String idUsuario, Plan nuevoPlan) throws UsuarioNoEncontradoException {

        Usuario  user = this.clientes.stream()
                .filter(e -> e.getId().equalsIgnoreCase(idUsuario))
                .findFirst()
                .orElseThrow(() -> new UsuarioNoEncontradoException("El usuario ingresado no existe"));

        boolean userActive = UserIsActive(user);

        if(userActive){
            user.setPlan(nuevoPlan);
        } else {
            throw new UsuarioInactivoException("El usuario no esta activo");
        }
    }

    public List<FacturaDTO> generarFacturacionMensual() {
        return clientes.stream()
                .filter(Usuario::isEstadoActivo)
                .map(usuario -> new FacturaDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        this.getNombre(),
                        usuario.getPlan().getPrecio()
                ))
                .collect(Collectors.toList());

    }

    public double calcularMRR(){
        return clientes.stream()
                .filter(Usuario::isEstadoActivo)
                .mapToDouble(e -> e.getPlan().getPrecio())
                .sum();
    }

    public boolean UserIsActive(Usuario user) throws UsuarioInactivoException{
        if(!user.isEstadoActivo()){
            throw new UsuarioInactivoException("El usuario no se encuentra activo");
        } else {
            return true;
        }
    }

}
