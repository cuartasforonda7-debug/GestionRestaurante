package dominio.puertos.entrada;

import dominio.entidades.Empleado;
import java.util.List;

/**
 * PUERTO DE ENTRADA (Inbound Port)
 * Define lo que el sistema PUEDE hacer con los Empleados y sus Roles.
 */
public interface GestionarEmpleadoPort {

    Empleado registrarEmpleado(Empleado empleado, int idRol);

    List<Empleado> consultarEmpleados();

    Empleado buscarPorId(int idEmpleado);

    List<Empleado> listarPorRol(int idRol);

    void asignarRol(int idEmpleado, int nuevoIdRol);

    int totalEmpleados();
}

