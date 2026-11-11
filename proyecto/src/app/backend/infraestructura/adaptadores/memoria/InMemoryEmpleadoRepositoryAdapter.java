package app.backend.infraestructura.adaptadores.memoria;

import dominio.entidades.Empleado;
import dominio.entidades.Rol;
import dominio.puertos.salida.EmpleadoRepositoryPort;
import dominio.seguridad.SeguridadUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryEmpleadoRepositoryAdapter implements EmpleadoRepositoryPort {

    private final List<Empleado> empleados = new ArrayList<>();
    private int contadorId = 100;

    public InMemoryEmpleadoRepositoryAdapter() {
        precargarDatosPrueba();
    }

    private void precargarDatosPrueba() {
        Rol rolMesero = new Rol(2, Rol.ROL_MESERO, "Atención a mesas");
        Empleado mesero = new Empleado(
                contadorId++,
                "Carlos Gómez",
                "carlos.mesero@restaurantedemar.com",
                "3109876543",
                SeguridadUtil.hashearContrasena("Mesero123*"),
                true,
                LocalDateTime.now(),
                LocalDateTime.now().minusMonths(6),
                rolMesero
        );
        empleados.add(mesero);

        Rol rolCocinero = new Rol(3, Rol.ROL_COCINERO, "Preparación de platos");
        Empleado cocinero = new Empleado(
                contadorId++,
                "Ana Martínez",
                "ana.cocina@restaurantedemar.com",
                "3123456789",
                SeguridadUtil.hashearContrasena("Cocina123*"),
                true,
                LocalDateTime.now(),
                LocalDateTime.now().minusMonths(12),
                rolCocinero
        );
        empleados.add(cocinero);
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        if (empleado.getIdUsuario() == 0) {
            empleado.setIdUsuario(contadorId++);
        }
        empleados.add(empleado);
    }

    @Override
    public Optional<Empleado> buscarPorId(int idEmpleado) {
        return empleados.stream()
                .filter(e -> e.getIdUsuario() == idEmpleado)
                .findFirst();
    }

    @Override
    public List<Empleado> listarTodos() {
        return new ArrayList<>(empleados);
    }

    @Override
    public List<Empleado> listarPorRol(int idRol) {
        return empleados.stream()
                .filter(e -> e.getRol() != null && e.getRol().getIdRol() == idRol)
                .collect(Collectors.toList());
    }

    @Override
    public void actualizar(Empleado empleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getIdUsuario() == empleado.getIdUsuario()) {
                empleados.set(i, empleado);
                return;
            }
        }
    }

    @Override
    public void eliminar(int idEmpleado) {
        empleados.removeIf(e -> e.getIdUsuario() == idEmpleado);
    }

    @Override
    public int contarEmpleados() {
        return empleados.size();
    }
}

