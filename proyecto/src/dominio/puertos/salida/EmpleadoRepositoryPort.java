package dominio.puertos.salida;

import dominio.entidades.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoRepositoryPort {

    void registrarEmpleado(Empleado empleado);

    Optional<Empleado> buscarPorId(int idEmpleado);

    List<Empleado> listarTodos();

    List<Empleado> listarPorRol(int idRol);

    void actualizar(Empleado empleado);

    void eliminar(int idEmpleado);

    /**
     * Devuelve el total de empleados activos en el restaurante.
     */
    int contarEmpleados();
}

