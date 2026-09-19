# Vista 10: Arquitectura del Sistema (Diseño por Capas)

Propuesta de arquitectura basada en Domain-Driven Design (DDD) simplificado / Clean Architecture. Proporciona separación de responsabilidades para mantener el software escalable y facilitar las pruebas, sin la sobrecarga de patrones extremadamente complejos innecesarios para el tamaño del negocio.

```mermaid
flowchart TD
    subgraph CapaPresentacion [Presentación / Interfaces de Usuario]
        UI[Frontend: React / Vue / Angular 
 Interfaces de Cajera, Cliente, Admin]
    end

    subgraph CapaAplicacion [Capa de Aplicación y API]
        API[Controladores / Rutas REST API]
        REQ[Requests y Validaciones]
        SRV[Servicios de Aplicación 
 Orquestación de Casos de Uso]
    end

    subgraph CapaDominio [Capa de Dominio / Core Business]
        ENT[Entidades Core 
 Venta, Pedido, Producto, Liquidación]
        REG[Reglas de Negocio 
 Ej. Restringir venta sin stock]
        INT[Interfaces de Repositorios]
    end

    subgraph CapaInfraestructura [Infraestructura y Persistencia]
        REP[Implementación de Repositorios 
 ORM]
        DB[(Base de Datos Relacional 
 PostgreSQL / MySQL)]
        STOR[Almacenamiento de Archivos 
 Comprobantes y Fotos]
    end

    UI -->|Peticiones HTTP/JSON| API
    API --> REQ
    REQ --> SRV
    SRV -->|Inyección de Dependencia| INT
    SRV -->|Modela y Valida| ENT
    SRV -->|Aplica| REG
    REP -.->|Implementa| INT
    REP --> DB
    REP --> STOR
```