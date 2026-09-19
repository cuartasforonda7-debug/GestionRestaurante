# Vista 3: Mapa de Actores y Funcionalidades (Casos de Uso)

Representa la interacción de cada tipo de usuario con los módulos del sistema. Se omiten explícitamente a los cocineros en las interacciones directas, ya que su operación seguirá siendo física.

```mermaid
flowchart LR
    ActorCliente([Cliente])
    ActorCajera([Cajera])
    ActorDomiciliario([Domiciliario])
    ActorJefa([Jefa])
    ActorDueno([Dueño])

    ActorCocinero[("Cocineros (Operación Física - Sin acceso)")]

    subgraph CasosDeUso [Gestión del Sistema]
        direction TB
        CU_Cliente[Consultar menú, hacer pedido, ver estado, cancelar]
        CU_Cajera[Gestionar ventas, clientes, pedidos, pagos, liquidaciones, inventario]
        CU_Dom[Ver pedidos asignados, actualizar estado, registrar pago/comprobante]
        CU_Jefa[Gestión operativa: Menús, stock, productos, operación general]
        CU_Dueno[Control Total: Usuarios, KPIs, Estadísticas, Historial, Admin general]
    end

    ActorCliente --> CU_Cliente
    ActorCajera --> CU_Cajera
    ActorDomiciliario --> CU_Dom
    ActorJefa --> CU_Jefa
    ActorDueno --> CU_Dueno
```