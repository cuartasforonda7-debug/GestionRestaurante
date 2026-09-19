# Vista 7: Flujo de Pagos y Comprobantes

Detalla el ciclo de vida de un pago. El comprobante no requiere inicialmente una entidad separada sobre-ingenierizada; se asocia funcionalmente al pago para permitir su posterior verificación por la cajera.

```mermaid
flowchart TD
    A[Generación de PAGO 
 asociado a Pedido/Venta] --> B{Tipo de Pago}

    B -- Efectivo --> C[Registro de Monto Recibido]
    B -- Transferencia/Tarjeta --> D[Registro de Monto y Referencia]

    D --> E[Adjuntar Captura / Comprobante de Banco Ej. BBVA]

    C --> F[Estado: PENDIENTE DE VERIFICACIÓN]
    E --> F

    F --> G[Cajera valida el ingreso del dinero en el sistema]

    G --> H{¿Validación Exitosa?}
    H -- Sí --> I[Estado: CONFIRMADO]
    H -- No --> J[Estado: RECHAZADO]

    I --> K([Habilita consolidación de Venta y Cierre de Pedido])
```