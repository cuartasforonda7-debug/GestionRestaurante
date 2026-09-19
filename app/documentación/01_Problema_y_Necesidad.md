# Vista 1: Resumen del Problema y Necesidad

Esta vista presenta el contexto actual del restaurante de comida de mar, identificando la raíz de los problemas operativos y cómo la solución propuesta se alinea con las necesidades del negocio.

```mermaid
flowchart TD
    subgraph ACTUALIDAD [Situación Actual]
        P1[Procesos manuales y en papel]
        P2[Pedidos distribuidos por WhatsApp y físicos]
    end

    subgraph CAUSAS [Causas Principales]
        C1[Falta de centralización de datos]
        C2[Desconexión entre el pedido y el inventario]
        C3[Control de caja y domicilios de forma manual]
    end

    subgraph CONSECUENCIAS [Impacto en el Negocio]
        E1[Errores al registrar pedidos]
        E2[Pérdida de información y descuadres]
        E3[Venta de productos sin stock disponible]
        E4[Difícil control del efectivo del domiciliario]
    end

    subgraph NECESIDAD [Necesidad de Negocio]
        N1[Control centralizado e integrado]
        N2[Trazabilidad en tiempo real]
    end

    subgraph SOLUCION [Solución Propuesta]
        S1[Sistema de Gestión Administrativa Centralizado]
        S2[Automatización del flujo: Pedido -> Pago -> Venta -> Inventario]
    end

    ACTUALIDAD --> CAUSAS
    CAUSAS --> CONSECUENCIAS
    CONSECUENCIAS --> NECESIDAD
    NECESIDAD --> SOLUCION
```