# Vista 2: Alcance del Sistema

Define claramente los límites de la primera versión del sistema, especificando qué módulos se construirán y cuáles quedan fuera de este desarrollo para mantener un enfoque realista y evitar sobreingeniería.

```mermaid
flowchart LR
    subgraph DENTRO [Dentro del Alcance del Sistema]
        direction TB
        D1(Usuarios y Roles)
        D2(Gestión de Clientes)
        D3(Productos e Inventario)
        D4(Menús y Recetas)
        D5(Pedidos y Ventas)
        D6(Pagos y Domicilios)
        D7(Liquidación de Efectivo)
        D8(Historial y Estadísticas Básicas)
    end

    subgraph FUERA [Fuera del Alcance Inicial]
        direction TB
        F1(Digitalización de Cocina - Pantallas)
        F2(Dispositivos para Cocineros)
        F3(Contabilidad y Nómina)
        F4(Facturación Electrónica Real)
        F5(Integración Bancaria Automática API)
        F6(IoT o Hardware Especializado)
    end
```