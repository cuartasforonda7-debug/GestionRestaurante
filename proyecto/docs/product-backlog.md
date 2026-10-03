# Product Backlog — Restaurante de Mar

El Product Backlog contiene las funcionalidades que potencialmente serán desarrolladas durante el proyecto.

Las historias de usuario están organizadas mediante Épicas y Features. Cada historia cuenta con una estimación inicial en Story Points.

---

# 🔵 ÉPICA 1 — Usuarios y autenticación

**Responsable:** Juan José

## Feature 1.1 — Gestión de usuarios

* **HU-01:** Registrar usuario — **5 SP**
* **HU-02:** Iniciar sesión — **5 SP**

## Feature 1.2 — Roles y empleados

* **HU-03:** Gestionar empleados y roles — **8 SP**
* **HU-04:** Controlar permisos según el rol — **8 SP**

**Total Épica 1: 26 SP**

---

# 🟢 ÉPICA 2 — Productos, inventario y menús

**Responsable:** Cristian

## Feature 2.1 — Productos

* **HU-05:** Registrar productos — **5 SP**
* **HU-06:** Consultar y actualizar productos — **5 SP**

## Feature 2.2 — Inventario

* **HU-07:** Gestionar existencias — **8 SP**
* **HU-08:** Controlar disponibilidad de productos — **5 SP**

## Feature 2.3 — Menús

* **HU-09:** Crear y administrar menús — **8 SP**
* **HU-10:** Consultar menús disponibles — **3 SP**

**Total Épica 2: 34 SP**

---

# 🟣 ÉPICA 3 — Pedidos y ventas

**Responsable:** Darwin

## Feature 3.1 — Pedidos

* **HU-11:** Registrar pedido — **8 SP**
* **HU-12:** Agregar productos y detalles al pedido — **5 SP**
* **HU-13:** Gestionar estados del pedido — **5 SP**

## Feature 3.2 — Ventas

* **HU-14:** Convertir pedido en venta — **8 SP**
* **HU-15:** Registrar venta directa — **5 SP**

**Total Épica 3: 31 SP**

---

# 🟠 ÉPICA 4 — Pagos

**Responsable:** Ricardo

## Feature 4.1 — Gestión de pagos

* **HU-16:** Registrar pago — **5 SP**
* **HU-17:** Confirmar o rechazar pago — **5 SP**
* **HU-18:** Registrar comprobante de transferencia — **5 SP**

**Total Épica 4: 15 SP**

---

# 🟠 ÉPICA 5 — Domicilios

**Responsable:** Ricardo

## Feature 5.1 — Gestión del domicilio

* **HU-19:** Registrar información del domicilio — **5 SP**
* **HU-20:** Gestionar entrega del pedido — **8 SP**

## Feature 5.2 — Liquidación

* **HU-21:** Registrar liquidación del domiciliario — **5 SP**
* **HU-22:** Calcular diferencia de dinero — **3 SP**

**Total Épica 5: 21 SP**

---

# 🔴 ÉPICA 6 — Integración y calidad

**Responsables:** Todo el equipo

## Feature 6.1 — API

* **HU-23:** Exponer funcionalidades mediante API REST — **13 SP**
* **HU-24:** Manejar errores de la API — **5 SP**

## Feature 6.2 — Integración

* **HU-25:** Integrar los cuatro módulos — **13 SP**
* **HU-26:** Probar el flujo completo — **8 SP**

## Feature 6.3 — Entrega

* **HU-27:** Documentar la API — **5 SP**
* **HU-28:** Preparar demostración del MVP — **3 SP**

**Total Épica 6: 47 SP**

---

# Resumen general

| Épica                         | Story Points |
| ----------------------------- | -----------: |
| Usuarios y autenticación      |           26 |
| Productos, inventario y menús |           34 |
| Pedidos y ventas              |           31 |
| Pagos                         |           15 |
| Domicilios                    |           21 |
| Integración y calidad         |           47 |
| **Total estimado**            |   **174 SP** |

> **Nota:** Las estimaciones son iniciales y pueden cambiar cuando el equipo revise las historias, sus criterios de aceptación, dependencias y complejidad durante el desarrollo.

---

# Resumen visual

```text
ÉPICAS

│
├── 1. USUARIOS Y AUTENTICACIÓN
│   ├── Gestión de usuarios
│   │   ├── HU-01 Registrar usuario ............. 5 SP
│   │   └── HU-02 Iniciar sesión ................ 5 SP
│   │
│   └── Roles y empleados
│       ├── HU-03 Gestionar empleados ........... 8 SP
│       └── HU-04 Controlar permisos ............ 8 SP
│
├── 2. PRODUCTOS, INVENTARIO Y MENÚS
│   ├── Productos
│   │   ├── HU-05 Registrar productos ........... 5 SP
│   │   └── HU-06 Consultar/actualizar .......... 5 SP
│   │
│   ├── Inventario
│   │   ├── HU-07 Gestionar existencias ......... 8 SP
│   │   └── HU-08 Controlar disponibilidad ...... 5 SP
│   │
│   └── Menús
│       ├── HU-09 Crear/administrar menús ....... 8 SP
│       └── HU-10 Consultar menús ............... 3 SP
│
├── 3. PEDIDOS Y VENTAS
│   ├── Pedidos
│   │   ├── HU-11 Registrar pedido .............. 8 SP
│   │   ├── HU-12 Agregar detalles .............. 5 SP
│   │   └── HU-13 Gestionar estados ............. 5 SP
│   │
│   └── Ventas
│       ├── HU-14 Convertir pedido en venta ..... 8 SP
│       └── HU-15 Registrar venta directa ....... 5 SP
│
├── 4. PAGOS
│   └── Gestión de pagos
│       ├── HU-16 Registrar pago ................ 5 SP
│       ├── HU-17 Confirmar/rechazar pago ....... 5 SP
│       └── HU-18 Registrar comprobante ......... 5 SP
│
├── 5. DOMICILIOS
│   ├── Gestión del domicilio
│   │   ├── HU-19 Registrar información ......... 5 SP
│   │   └── HU-20 Gestionar entrega ............ 8 SP
│   │
│   └── Liquidación
│       ├── HU-21 Registrar liquidación ......... 5 SP
│       └── HU-22 Calcular diferencia .......... 3 SP
│
└── 6. INTEGRACIÓN Y CALIDAD
    ├── API
    │   ├── HU-23 Exponer API REST ............. 13 SP
    │   └── HU-24 Manejar errores ............... 5 SP
    │
    ├── Integración
    │   ├── HU-25 Integrar módulos ............. 13 SP
    │   └── HU-26 Probar flujo completo ......... 8 SP
    │
    └── Entrega
        ├── HU-27 Documentar API ................ 5 SP
        └── HU-28 Preparar demostración ......... 3 SP
```
