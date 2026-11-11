package app.backend.infraestructura.adaptadores.memoria;

import dominio.entidades.Rol;
import dominio.puertos.salida.RolRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRolRepositoryAdapter implements RolRepositoryPort {

    private final List<Rol> roles = new ArrayList<>();

    public InMemoryRolRepositoryAdapter() {
        precargarRoles();
    }

    private void precargarRoles() {
        roles.add(new Rol(1, Rol.ROL_ADMINISTRADOR, "Administrador del sistema con acceso total"));
        roles.add(new Rol(2, Rol.ROL_MESERO, "Atención a mesas y registro de pedidos"));
        roles.add(new Rol(3, Rol.ROL_COCINERO, "Preparación y despacho de comandas"));
        roles.add(new Rol(4, Rol.ROL_CAJERO, "Cobro de cuentas, facturación y pagos"));
        roles.add(new Rol(5, Rol.ROL_DOMICILIARIO, "Reparto de pedidos a domicilio"));
        roles.add(new Rol(6, Rol.ROL_CLIENTE, "Cliente del restaurante"));
    }

    @Override
    public void registrarRol(Rol rol) {
        if (rol.getIdRol() == 0) {
            rol.setIdRol(roles.size() + 1);
        }
        roles.add(rol);
    }

    @Override
    public Optional<Rol> buscarPorId(int idRol) {
        return roles.stream()
                .filter(r -> r.getIdRol() == idRol)
                .findFirst();
    }

    @Override
    public Optional<Rol> buscarPorNombre(String nombre) {
        if (nombre == null) return Optional.empty();
        return roles.stream()
                .filter(r -> r.getNombre().equalsIgnoreCase(nombre.trim()))
                .findFirst();
    }

    @Override
    public List<Rol> listarTodos() {
        return new ArrayList<>(roles);
    }

    @Override
    public boolean existePorId(int idRol) {
        return roles.stream().anyMatch(r -> r.getIdRol() == idRol);
    }
}

