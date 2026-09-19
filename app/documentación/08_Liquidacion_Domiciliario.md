# Vista 8: Liquidación del Domiciliario

Describe el proceso administrativo de control de caja para el domiciliario, garantizando auditoría clara sobre el dinero en efectivo que fluye fuera de las instalaciones del restaurante.

```mermaid
flowchart TD
    A([Inicio Turno Logístico]) --> B[Cajera registra BASE ENTREGADA 
 Ej: $50.000]

    B --> C[Operación Logística 
 Entregas y Recaudos del Domiciliario]

    C --> D[Sistema calcula DINERO ESPERADO 
 Base + Suma de Pagos en Efectivo Confirmados]

    D --> E([Fin Turno / Cierre])
    E --> F[Domiciliario reporta y entrega DINERO FÍSICO]

    F --> G{Cálculo de DIFERENCIA 
 Esperado vs Entregado}

    G -- Diferencia = 0 --> H[ESTADO: CORRECTO]
    G -- Entregó Menos --> I[ESTADO: FALTANTE]
    G -- Entregó Más --> J[ESTADO: SOBRANTE]

    H & I & J --> K([Registro de Liquidación e Historial para Auditoría])
```