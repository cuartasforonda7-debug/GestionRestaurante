package dominio.puertos.salida;

import dominio.entidades.Rol;
import java.util.List;
import java.util.Optional;

public interface RolRepositoryPort {

    void registrarRol(Rol rol);

    Optional<Rol> buscarPorId(int idRol);

    Optional<Rol> buscarPorNombre(String nombre);

    List<Rol> listarTodos();

    boolean existePorId(int idRol);
}

