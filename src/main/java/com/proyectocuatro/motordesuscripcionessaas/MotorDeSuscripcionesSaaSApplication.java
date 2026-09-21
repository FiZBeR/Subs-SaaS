package com.proyectocuatro.motordesuscripcionessaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MotorDeSuscripcionesSaaSApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorDeSuscripcionesSaaSApplication.class, args);

        // 1. Instanciar los Planes base
        Plan planBasico = new Plan("Básico", 9.99, 1);
        Plan planEstandar = new Plan("Estándar", 14.99, 2);
        Plan planPremium = new Plan("Premium", 19.99, 4);

        // 2. Instanciar Usuarios (Algunos activos, uno inactivo)
        Usuario u1 = new Usuario("U-01", "Cristian", true, planPremium);
        Usuario u2 = new Usuario("U-02", "Ana", true, planBasico);
        Usuario u3 = new Usuario("U-03", "Beto", false, planEstandar);

        // 3. Crear la Empresa y agregar los usuarios
        List<Usuario> listaUsuarios = new ArrayList<>(List.of(u1, u2, u3));
        Empresa netpolix = new Empresa("NetPolix", listaUsuarios);

        // --- PRUEBA 1: Calcular MRR ---
        System.out.println("=== MRR (Monthly Recurring Revenue) ===");
        // Solo debe sumar los planes de Cristian (19.99) y Ana (9.99) porque Beto está inactivo.
        System.out.println("MRR Actual: $" + netpolix.calcularMRR());

        // --- PRUEBA 2: Generar Facturas ---
        System.out.println("\n=== FACTURACIÓN MENSUAL ===");
        List<FacturaDTO> facturas = netpolix.generarFacturacionMensual();
        facturas.forEach(f -> System.out.println("Factura para: " + f.nombre() + " | Empresa: " + f.empresa() + " | Total: $" + f.montoPagar()));

        // --- PRUEBA 3: Cambiar Plan (Éxito) ---
        System.out.println("\n=== CAMBIO DE PLAN: ÉXITO ===");
        netpolix.cambiarPlanUsuario("U-02", planEstandar); // Ana sube a Estándar
        System.out.println("El MRR subió a: $" + netpolix.calcularMRR());

        // --- PRUEBA 4: Cambiar Plan (Falla - Usuario Inactivo) ---
        System.out.println("\n=== CAMBIO DE PLAN: FALLA (INACTIVO) ===");
        try {
            netpolix.cambiarPlanUsuario("U-03", planPremium); // Beto está inactivo
        } catch (UsuarioInactivoException e) {
            System.err.println("Capturado correctamente: " + e.getMessage());
        }

        // --- PRUEBA 5: Cambiar Plan (Falla - No existe) ---
        System.out.println("\n=== CAMBIO DE PLAN: FALLA (NO EXISTE) ===");
        try {
            netpolix.cambiarPlanUsuario("U-99", planBasico);
        } catch (UsuarioNoEncontradoException e) {
            System.err.println("Capturado correctamente: " + e.getMessage());
        }
    }

}
