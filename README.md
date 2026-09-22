# 🏢 Motor de Facturación SaaS (Suscripciones)

## 📌 Descripción del Proyecto
Motor de reglas de negocio para una plataforma de Software as a Service (SaaS). El sistema modela la relación entre una Empresa, sus Usuarios y los Planes de suscripción que estos poseen. Se encarga de evaluar el estado de los clientes a fin de mes para generar facturación dinámica y calcular métricas clave como el MRR (Monthly Recurring Revenue).

## 🏢 El Problema Empresarial Resolvido
En modelos de suscripción, es crítico separar las entidades de dominio de los datos que se exponen hacia afuera (como una API). Este proyecto implementa el patrón DTO (Data Transfer Object) para asegurar que el sistema de facturación solo reciba los datos exactos que necesita, protegiendo la información sensible del usuario.

## 🛠️ Tecnologías y Conceptos Aplicados
*   **Agregación y Composición (POO):** Modelado de relaciones donde un `Usuario` contiene un `Plan`, y una `Empresa` contiene una `List<Usuario>`.
*   **Java Records (DTOs):** Implementación de Records introducidos en Java 14+ (`FacturaDTO`) para crear estructuras de datos inmutables de forma limpia y concisa.
*   **Excepciones Personalizadas (Unchecked):** Creación de excepciones de negocio (`UsuarioNoEncontradoException`, `UsuarioInactivoException`) heredadas de `RuntimeException` para controlar el flujo de la aplicación sin sobrecargar la firma de los métodos.
*   **Stream API Avanzado:** Uso de `.filter()`, `.map()` y `.mapToDouble().sum()` para extraer métricas financieras a partir de colecciones de objetos complejos.