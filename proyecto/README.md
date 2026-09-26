# Restaurante de Mar

Sistema de gestión para un restaurante de comida, desarrollado como proyecto integrador del programa Técnico Laboral como Asistente en Desarrollo de Software de CESDE.

## Descripción del proyecto

Restaurante de Mar es una aplicación orientada a apoyar la gestión de las operaciones principales de un restaurante.

El sistema busca centralizar procesos relacionados con usuarios, empleados, productos, inventario, menús, pedidos, ventas, pagos y domicilios.

El proyecto se desarrolla como un MVP utilizando una arquitectura basada en una API REST y una aplicación web.

## Problema

El restaurante necesita mejorar la organización y el control de sus procesos operativos.

Actualmente pueden presentarse dificultades relacionadas con:

- Registro y seguimiento de pedidos.
- Control de productos e inventario.
- Gestión de menús.
- Registro de ventas.
- Control de pagos.
- Gestión de domicilios.
- Organización de usuarios, empleados y roles.
- Consulta de información para apoyar la operación del restaurante.

El proyecto busca proporcionar una solución digital que permita centralizar estas operaciones.

## Objetivo

Desarrollar un sistema de gestión para Restaurante de Mar que permita administrar las operaciones principales del restaurante mediante una aplicación web conectada a una API REST.

## Equipo

| Integrante | Responsabilidad principal |
|---|---|
| Juan José | Usuarios, autenticación, empleados y roles |
| Cristian | Productos, inventario y menús |
| Darwin | Pedidos y ventas |
| Ricardo | Pagos y domicilios |

## Metodología

El proyecto se desarrolla utilizando la metodología Scrum.

El trabajo se organiza mediante:

- Épicas.
- Features.
- Historias de usuario.
- Product Backlog.
- Sprint Backlog.
- Sprints.
- Revisiones de Sprint.

## Tecnologías

Las tecnologías utilizadas o contempladas para el desarrollo del proyecto incluyen:

- Java
- JavaScript
- HTML
- CSS
- Docker
- Git
- GitHub
- API REST

## Organización del repositorio

```text
proyecto/
│
├── README.md
├── .gitignore
│
├── docs/
│   ├── product-backlog.md
│   ├── user-stories.md
│   └── sprints/
│       └── sprint-01/
│           ├── sprint-backlog.md
│           └── sprint-review.md
│
└── src/
    ├── dominio/
    │   └── entidades/
    │
    └── app/
        └── backend/
            ├── infraestructura/
            ├── presentacion/
            └── servicio/