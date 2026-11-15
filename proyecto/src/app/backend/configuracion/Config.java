package app.backend.configuracion;

import app.aplicacion.servicios.ControlAccesoService;
import app.aplicacion.servicios.EmpleadoService;
import app.aplicacion.servicios.ProductoService;
import app.aplicacion.servicios.UsuarioService;
import app.backend.presentacion.controlador.UsuarioController;
import app.backend.infraestructura.adaptadores.EmpleadoRepositorySQLAdapter;
import app.backend.infraestructura.adaptadores.ProductoRepositoryAdapter;
import app.backend.infraestructura.adaptadores.RolRepositorySQLAdapter;
import app.backend.infraestructura.adaptadores.UsuarioRepositorySQLAdapter;
import app.backend.infraestructura.adaptadores.memoria.InMemoryEmpleadoRepositoryAdapter;
import app.backend.infraestructura.adaptadores.memoria.InMemoryRolRepositoryAdapter;
import app.backend.infraestructura.adaptadores.memoria.InMemoryUsuarioRepositoryAdapter;
import dominio.puertos.salida.EmpleadoRepositoryPort;
import dominio.puertos.salida.RolRepositoryPort;
import dominio.puertos.salida.UsuarioRepositoryPort;

public class Config {

    // Repositorios compartidos en memoria (Singleton para la ejecución en memoria)
    private static final InMemoryRolRepositoryAdapter MEM_ROL_REPO = new InMemoryRolRepositoryAdapter();
    private static final InMemoryUsuarioRepositoryAdapter MEM_USUARIO_REPO = new InMemoryUsuarioRepositoryAdapter();
    private static final InMemoryEmpleadoRepositoryAdapter MEM_EMPLEADO_REPO = new InMemoryEmpleadoRepositoryAdapter();

    public ProductoService obtenerProductoService() {
        ProductoRepositoryAdapter adapter = new ProductoRepositoryAdapter();
        return new ProductoService(adapter);
    }

    // ==========================================
    // SERVICIOS EN MEMORIA (Para pruebas rápidas y sustentación)
    // ==========================================
    public UsuarioService obtenerUsuarioServiceEnMemoria() {
        return new UsuarioService(MEM_USUARIO_REPO, MEM_ROL_REPO);
    }

    public EmpleadoService obtenerEmpleadoServiceEnMemoria() {
        return new EmpleadoService(MEM_EMPLEADO_REPO, MEM_USUARIO_REPO, MEM_ROL_REPO);
    }

    public RolRepositoryPort obtenerRolRepositoryEnMemoria() {
        return MEM_ROL_REPO;
    }

    public ControlAccesoService obtenerControlAccesoService() {
        return new ControlAccesoService();
    }

    // ==========================================
    // SERVICIOS SQL SERVER (Persistencia en base de datos real)
    // ==========================================
    public UsuarioService obtenerUsuarioServiceSQL() {
        UsuarioRepositoryPort usuarioRepo = new UsuarioRepositorySQLAdapter();
        RolRepositoryPort rolRepo = new RolRepositorySQLAdapter();
        return new UsuarioService(usuarioRepo, rolRepo);
    }

    public EmpleadoService obtenerEmpleadoServiceSQL() {
        EmpleadoRepositoryPort empleadoRepo = new EmpleadoRepositorySQLAdapter();
        UsuarioRepositoryPort usuarioRepo = new UsuarioRepositorySQLAdapter();
        RolRepositoryPort rolRepo = new RolRepositorySQLAdapter();
        return new EmpleadoService(empleadoRepo, usuarioRepo, rolRepo);
    }

    // ==========================================
    // CONTROLADORES (Capa de Presentación)
    // ==========================================
    public UsuarioController obtenerUsuarioControllerEnMemoria() {
        return new UsuarioController(obtenerUsuarioServiceEnMemoria(), obtenerEmpleadoServiceEnMemoria());
    }

    public UsuarioController obtenerUsuarioControllerSQL() {
        return new UsuarioController(obtenerUsuarioServiceSQL(), obtenerEmpleadoServiceSQL());
    }
}
