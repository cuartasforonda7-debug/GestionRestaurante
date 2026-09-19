# Vista 6: Flujo de Inventario y Recetas

Explica la relación entre productos (insumos físicos), recetas (composición del menú comercial) y la actualización del stock. 

**Nota de Diseño:** No se crea una tabla separada e innecesaria de "Inventario", el Producto posee su stock actual y los cambios se guardan como movimientos, asegurando alta cohesión y evitando datos duplicados.

```mermaid
flowchart TD
    P[PRODUCTO 
 Almacena el Stock Actual]

    M[MOVIMIENTO DE INVENTARIO 
 Registra Historial y Trazabilidad]
    P -->|1:N| M

    M1(Entrada de Proveedor) --> M
    M2(Ajuste / Desperdicio) --> M
    M3(Salida por Venta) --> M

    V[VENTA CONFIRMADA] --> DV[DETALLES DE VENTA]
    
    DV -->|Si el detalle es un Menú| R[RECETA / COMPOSICIÓN]
    DV -->|Si el detalle es un Producto Directo| M3

    R -->|Calcula consumos de insumos| M3
    M3 -->|Descuenta cantidades| P
```