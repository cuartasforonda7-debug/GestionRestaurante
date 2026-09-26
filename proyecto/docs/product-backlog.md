# Product Backlog — Restaurante de Mar

El Product Backlog contiene las funcionalidades que potencialmente serán desarrolladas durante el proyecto.

Las historias de usuario están organizadas mediante Épicas y Features.

---

# 🔵 ÉPICA 1 — Usuarios y autenticación

**Responsable:** Juan José

## Feature 1.1 — Gestión de usuarios

- **HU-01:** Registrar usuario.
- **HU-02:** Iniciar sesión.

## Feature 1.2 — Roles y empleados

- **HU-03:** Gestionar empleados y roles.
- **HU-04:** Controlar permisos según el rol.

---

# 🟢 ÉPICA 2 — Productos, inventario y menús

**Responsable:** Cristian

## Feature 2.1 — Productos

- **HU-05:** Registrar productos.
- **HU-06:** Consultar y actualizar productos.

## Feature 2.2 — Inventario

- **HU-07:** Gestionar existencias.
- **HU-08:** Controlar disponibilidad de productos.

## Feature 2.3 — Menús

- **HU-09:** Crear y administrar menús.
- **HU-10:** Consultar menús disponibles.

---

# 🟣 ÉPICA 3 — Pedidos y ventas

**Responsable:** Darwin

## Feature 3.1 — Pedidos

- **HU-11:** Registrar pedido.
- **HU-12:** Agregar productos y detalles al pedido.
- **HU-13:** Gestionar estados del pedido.

## Feature 3.2 — Ventas

- **HU-14:** Convertir pedido en venta.
- **HU-15:** Registrar venta directa.

---

# 🟠 ÉPICA 4 — Pagos

**Responsable:** Ricardo

## Feature 4.1 — Gestión de pagos

- **HU-16:** Registrar pago.
- **HU-17:** Confirmar o rechazar pago.
- **HU-18:** Registrar comprobante de transferencia.

---

# 🟠 ÉPICA 5 — Domicilios

**Responsable:** Ricardo

## Feature 5.1 — Gestión del domicilio

- **HU-19:** Registrar información del domicilio.
- **HU-20:** Gestionar entrega del pedido.

## Feature 5.2 — Liquidación

- **HU-21:** Registrar liquidación del domiciliario.
- **HU-22:** Calcular diferencia de dinero.

---

# 🔴 ÉPICA 6 — Integración y calidad

**Responsables:** Todo el equipo

## Feature 6.1 — API

- **HU-23:** Exponer funcionalidades mediante API REST.
- **HU-24:** Manejar errores de la API.

## Feature 6.2 — Integración

- **HU-25:** Integrar los cuatro módulos.
- **HU-26:** Probar el flujo completo.

## Feature 6.3 — Entrega

- **HU-27:** Documentar la API.
- **HU-28:** Preparar demostración del MVP.

---

# Resumen visual

```text
ÉPICAS
│
├── 1. USUARIOS
│   ├── Gestión de usuarios
│   │   ├── Registrar usuario
│   │   └── Iniciar sesión
│   │
│   └── Roles y empleados
│       ├── Gestionar empleados
│       └── Controlar permisos
│
├── 2. PRODUCTOS, INVENTARIO Y MENÚS
│   ├── Productos
│   ├── Inventario
│   └── Menús
│
├── 3. PEDIDOS Y VENTAS
│   ├── Pedidos
│   └── Ventas
│
├── 4. PAGOS
│   └── Gestión de pagos
│
├── 5. DOMICILIOS
│   ├── Gestión del domicilio
│   └── Liquidación
│
└── 6. INTEGRACIÓN Y CALIDAD
    ├── API
    ├── Integración
    └── Entrega