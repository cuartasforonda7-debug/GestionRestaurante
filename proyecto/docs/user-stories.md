# Historias de Usuario — Restaurante de Mar

Las siguientes historias de usuario hacen parte del Product Backlog del proyecto.

Cada historia contiene un identificador, responsable, descripción y criterios de aceptación.

---

# ÉPICA 1 — Usuarios y autenticación

**Responsable:** Juan José

## HU-01 — Registrar usuario

**Como** usuario del sistema,  
**quiero** registrarme,  
**para** poder acceder a las funcionalidades correspondientes a mi cuenta.

### Criterios de aceptación

- El sistema debe permitir ingresar los datos necesarios del usuario.
- El sistema debe validar la información ingresada.
- El sistema debe evitar registros duplicados.
- El usuario debe quedar registrado correctamente.

---

## HU-02 — Iniciar sesión

**Como** usuario registrado,  
**quiero** iniciar sesión,  
**para** acceder al sistema.

### Criterios de aceptación

- El sistema debe solicitar las credenciales del usuario.
- El sistema debe validar las credenciales.
- El sistema debe permitir el acceso cuando las credenciales sean correctas.
- El sistema debe informar cuando las credenciales sean incorrectas.

---

## HU-03 — Gestionar empleados y roles

**Como** administrador,  
**quiero** gestionar empleados y sus roles,  
**para** organizar el acceso y las responsabilidades dentro del sistema.

### Criterios de aceptación

- El administrador debe poder registrar empleados.
- El administrador debe poder consultar empleados.
- El administrador debe poder asignar roles.
- El sistema debe almacenar correctamente la información.

---

## HU-04 — Controlar permisos según el rol

**Como** administrador,  
**quiero** controlar los permisos según el rol,  
**para** limitar el acceso a las funcionalidades correspondientes.

### Criterios de aceptación

- Cada usuario debe tener un rol.
- El sistema debe identificar el rol del usuario.
- El sistema debe controlar el acceso según los permisos establecidos.
- Un usuario no debe acceder a funcionalidades no autorizadas.

---

# ÉPICA 2 — Productos, inventario y menús

**Responsable:** Cristian

## HU-05 — Registrar productos

**Como** empleado autorizado,  
**quiero** registrar productos,  
**para** mantener actualizado el catálogo del restaurante.

### Criterios de aceptación

- El sistema debe permitir registrar un producto.
- El producto debe almacenar su información correspondiente.
- El sistema debe validar los datos requeridos.
- El producto debe quedar disponible para su consulta.

---

## HU-06 — Consultar y actualizar productos

**Como** empleado autorizado,  
**quiero** consultar y actualizar productos,  
**para** mantener la información del catálogo actualizada.

### Criterios de aceptación

- El sistema debe permitir consultar productos.
- El sistema debe permitir seleccionar un producto.
- El sistema debe permitir modificar su información.
- Los cambios deben quedar almacenados.

---

## HU-07 — Gestionar existencias

**Como** empleado autorizado,  
**quiero** gestionar las existencias de los productos,  
**para** conocer y actualizar las cantidades disponibles.

### Criterios de aceptación

- El sistema debe permitir consultar existencias.
- El sistema debe permitir registrar movimientos de inventario.
- Las cantidades deben actualizarse correctamente.
- El sistema debe conservar la información de los movimientos.

---

## HU-08 — Controlar disponibilidad de productos

**Como** empleado,  
**quiero** conocer la disponibilidad de los productos,  
**para** evitar ofrecer productos que no estén disponibles.

### Criterios de aceptación

- El sistema debe identificar productos disponibles.
- El sistema debe identificar productos no disponibles.
- La disponibilidad debe relacionarse con las existencias.
- El estado debe poder consultarse antes de realizar un pedido.

---

## HU-09 — Crear y administrar menús

**Como** empleado autorizado,  
**quiero** crear y administrar menús,  
**para** organizar los productos ofrecidos por el restaurante.

### Criterios de aceptación

- El sistema debe permitir crear un menú.
- El sistema debe permitir asociar productos al menú.
- El sistema debe permitir modificar la información del menú.
- El sistema debe permitir consultar los menús registrados.

---

## HU-10 — Consultar menús disponibles

**Como** empleado,  
**quiero** consultar los menús disponibles,  
**para** conocer los productos que puede ofrecer el restaurante.

### Criterios de aceptación

- El sistema debe mostrar los menús disponibles.
- El sistema debe mostrar los productos asociados.
- El sistema debe mostrar la información necesaria para realizar un pedido.

---

# ÉPICA 3 — Pedidos y ventas

**Responsable:** Darwin

## HU-11 — Registrar pedido

**Como** empleado,  
**quiero** registrar un pedido,  
**para** llevar control de los productos solicitados por el cliente.

### Criterios de aceptación

- El sistema debe permitir crear un pedido.
- El pedido debe tener un identificador.
- El pedido debe registrar la información necesaria.
- El pedido debe quedar almacenado.

---

## HU-12 — Agregar productos y detalles al pedido

**Como** empleado,  
**quiero** agregar productos y cantidades a un pedido,  
**para** registrar correctamente lo solicitado por el cliente.

### Criterios de aceptación

- El sistema debe permitir agregar productos.
- El sistema debe permitir indicar cantidades.
- El sistema debe calcular la información correspondiente del pedido.
- Los productos deben quedar asociados al pedido.

---

## HU-13 — Gestionar estados del pedido

**Como** empleado,  
**quiero** gestionar el estado de un pedido,  
**para** conocer su progreso dentro del restaurante.

### Criterios de aceptación

- El pedido debe tener un estado.
- El sistema debe permitir actualizar el estado.
- El estado debe poder consultarse.
- El sistema debe conservar el estado actual del pedido.

---

## HU-14 — Convertir pedido en venta

**Como** empleado,  
**quiero** convertir un pedido en una venta,  
**para** registrar la operación comercial realizada.

### Criterios de aceptación

- El sistema debe permitir seleccionar un pedido válido.
- El pedido debe poder convertirse en una venta.
- La venta debe conservar la información del pedido.
- La operación debe quedar registrada.

---

## HU-15 — Registrar venta directa

**Como** empleado,  
**quiero** registrar una venta directa,  
**para** registrar ventas que no provengan de un pedido previamente creado.

### Criterios de aceptación

- El sistema debe permitir registrar una venta.
- La venta debe incluir los productos correspondientes.
- El sistema debe calcular el valor de la venta.
- La venta debe quedar almacenada.

---

# ÉPICA 4 — Pagos

**Responsable:** Ricardo

## HU-16 — Registrar pago

**Como** empleado,  
**quiero** registrar el pago de una venta,  
**para** dejar constancia de la transacción realizada.

### Criterios de aceptación

- El sistema debe permitir registrar un pago.
- El pago debe asociarse a una venta.
- Debe registrarse el valor correspondiente.
- El pago debe quedar almacenado.

---

## HU-17 — Confirmar o rechazar pago

**Como** empleado autorizado,  
**quiero** confirmar o rechazar un pago,  
**para** mantener actualizado el estado de las transacciones.

### Criterios de aceptación

- El sistema debe permitir consultar el estado del pago.
- El sistema debe permitir confirmar un pago.
- El sistema debe permitir rechazar un pago.
- El estado debe quedar registrado.

---

## HU-18 — Registrar comprobante de transferencia

**Como** empleado,  
**quiero** registrar el comprobante de una transferencia,  
**para** tener evidencia del pago realizado.

### Criterios de aceptación

- El sistema debe permitir asociar un comprobante al pago.
- El comprobante debe quedar relacionado con la transacción.
- El sistema debe permitir consultar la información registrada.

---

# ÉPICA 5 — Domicilios

**Responsable:** Ricardo

## HU-19 — Registrar información del domicilio

**Como** empleado,  
**quiero** registrar la información de un domicilio,  
**para** gestionar correctamente la entrega del pedido.

### Criterios de aceptación

- El sistema debe permitir registrar los datos necesarios para la entrega.
- El domicilio debe asociarse al pedido correspondiente.
- La información debe quedar almacenada.

---

## HU-20 — Gestionar entrega del pedido

**Como** empleado,  
**quiero** gestionar el estado de entrega de un domicilio,  
**para** conocer el progreso de la entrega.

### Criterios de aceptación

- El sistema debe permitir consultar los domicilios.
- El sistema debe permitir actualizar su estado.
- El estado debe quedar registrado correctamente.

---

## HU-21 — Registrar liquidación del domiciliario

**Como** empleado autorizado,  
**quiero** registrar la liquidación del domiciliario,  
**para** controlar el dinero asociado a los domicilios entregados.

### Criterios de aceptación

- El sistema debe permitir registrar una liquidación.
- La liquidación debe estar asociada al domiciliario.
- La información debe quedar almacenada.

---

## HU-22 — Calcular diferencia de dinero

**Como** empleado autorizado,  
**quiero** calcular la diferencia de dinero de la liquidación,  
**para** identificar posibles diferencias entre el dinero esperado y el dinero entregado.

### Criterios de aceptación

- El sistema debe permitir registrar los valores correspondientes.
- El sistema debe calcular la diferencia.
- El resultado debe poder consultarse.

---

# ÉPICA 6 — Integración y calidad

**Responsables:** Todo el equipo

## HU-23 — Exponer funcionalidades mediante API REST

**Como** usuario de la aplicación,  
**quiero** que las funcionalidades estén disponibles mediante una API REST,  
**para** permitir la comunicación entre el frontend y el backend.

### Criterios de aceptación

- Las funcionalidades seleccionadas deben estar disponibles mediante endpoints.
- Los endpoints deben responder correctamente.
- La API debe utilizar métodos HTTP apropiados.

---

## HU-24 — Manejar errores de la API

**Como** usuario de la aplicación,  
**quiero** recibir respuestas adecuadas cuando ocurra un error,  
**para** conocer el resultado de las operaciones realizadas.

### Criterios de aceptación

- La API debe identificar errores.
- La API debe devolver respuestas apropiadas.
- Los errores deben ser comprensibles.
- La aplicación debe poder manejar las respuestas de error.

---

## HU-25 — Integrar los cuatro módulos

**Como** equipo de desarrollo,  
**queremos** integrar los módulos desarrollados,  
**para** construir un sistema funcional.

### Criterios de aceptación

- Los módulos deben comunicarse correctamente.
- Las funcionalidades desarrolladas deben poder utilizarse conjuntamente.
- No deben existir conflictos que impidan la ejecución del sistema.

---

## HU-26 — Probar el flujo completo

**Como** equipo de desarrollo,  
**queremos** probar el flujo completo del sistema,  
**para** verificar que las funcionalidades principales funcionen correctamente.

### Criterios de aceptación

- Se debe ejecutar el flujo principal del sistema.
- Se deben identificar errores.
- Los errores encontrados deben ser corregidos o documentados.
- El flujo debe poder demostrarse.

---

## HU-27 — Documentar la API

**Como** equipo de desarrollo,  
**queremos** documentar la API,  
**para** facilitar su comprensión y utilización.

### Criterios de aceptación

- Los endpoints principales deben estar documentados.
- Deben indicarse los métodos HTTP utilizados.
- Deben documentarse los datos necesarios.
- Deben documentarse las respuestas principales.

---

## HU-28 — Preparar demostración del MVP

**Como** equipo de desarrollo,  
**queremos** preparar una demostración del MVP,  
**para** presentar el funcionamiento principal del proyecto.

### Criterios de aceptación

- Debe existir un flujo funcional para demostrar.
- Deben estar preparados los datos necesarios.
- Los integrantes deben conocer las funcionalidades desarrolladas.
- La demostración debe representar el estado actual del MVP.