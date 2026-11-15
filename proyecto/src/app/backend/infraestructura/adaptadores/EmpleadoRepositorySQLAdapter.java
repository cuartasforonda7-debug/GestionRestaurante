package app.backend.infraestructura.adaptadores;

import app.backend.infraestructura.basedatos.ConexionBD;
import app.backend.infraestructura.excepciones.InfraestructuraException;
import dominio.entidades.Empleado;
import dominio.entidades.Rol;
import dominio.puertos.salida.EmpleadoRepositoryPort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoRepositorySQLAdapter implements EmpleadoRepositoryPort {

    @Override
    public void registrarEmpleado(Empleado empleado) {
        String sqlUsuario = """
            INSERT INTO Usuarios (nombre, email, telefono, contrasena, estado, fechaRegistro, idRol)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
        String sqlEmpleado = """
            INSERT INTO Empleados (idUsuario, fechaIngreso)
            VALUES (?, ?)
            """;

        Connection conexion = null;
        try {
            conexion = ConexionBD.obtenerConexion();
            conexion.setAutoCommit(false); // Transacción atómica

            // 1. Insertar en Usuarios
            int idGenerado = 0;
            try (PreparedStatement psU = conexion.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {
                psU.setString(1, empleado.getNombre());
                psU.setString(2, empleado.getEmail());
                psU.setString(3, empleado.getTelefono());
                psU.setString(4, empleado.getContrasena());
                psU.setBoolean(5, empleado.isEstado());
                psU.setTimestamp(6, Timestamp.valueOf(empleado.getFechaRegistro() != null ? empleado.getFechaRegistro() : LocalDateTime.now()));
                if (empleado.getRol() != null) {
                    psU.setInt(7, empleado.getRol().getIdRol());
                } else {
                    psU.setNull(7, java.sql.Types.INTEGER);
                }

                psU.executeUpdate();
                try (ResultSet keys = psU.getGeneratedKeys()) {
                    if (keys.next()) {
                        idGenerado = keys.getInt(1);
                        empleado.setIdUsuario(idGenerado);
                    }
                }
            }

            // 2. Insertar en Empleados
            try (PreparedStatement psE = conexion.prepareStatement(sqlEmpleado)) {
                psE.setInt(1, idGenerado);
                psE.setTimestamp(2, Timestamp.valueOf(empleado.getFechaIngreso() != null ? empleado.getFechaIngreso() : LocalDateTime.now()));
                psE.executeUpdate();
            }

            conexion.commit();
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException rollbackEx) {
                    // Log o ignorar
                }
            }
            throw new InfraestructuraException("Error al registrar empleado en SQL Server", e);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ignored) {}
            }
        }
    }

    @Override
    public Optional<Empleado> buscarPorId(int idEmpleado) {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   e.fechaIngreso,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Empleados e
            INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario
            LEFT JOIN Roles r ON u.idRol = r.idRol
            WHERE e.idUsuario = ?
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idEmpleado);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearEmpleado(rs));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al buscar empleado por ID en SQL Server", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Empleado> listarTodos() {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   e.fechaIngreso,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Empleados e
            INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario
            LEFT JOIN Roles r ON u.idRol = r.idRol
            ORDER BY u.idUsuario ASC
            """;
        List<Empleado> lista = new ArrayList<>();
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lista.add(mapearEmpleado(rs));
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al listar empleados en SQL Server", e);
        }
        return lista;
    }

    @Override
    public List<Empleado> listarPorRol(int idRol) {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   e.fechaIngreso,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Empleados e
            INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario
            LEFT JOIN Roles r ON u.idRol = r.idRol
            WHERE u.idRol = ?
            ORDER BY u.idUsuario ASC
            """;
        List<Empleado> lista = new ArrayList<>();
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearEmpleado(rs));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al listar empleados por rol en SQL Server", e);
        }
        return lista;
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = """
            UPDATE Usuarios
            SET nombre = ?, email = ?, telefono = ?, estado = ?, idRol = ?
            WHERE idUsuario = ?
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getEmail());
            ps.setString(3, empleado.getTelefono());
            ps.setBoolean(4, empleado.isEstado());
            if (empleado.getRol() != null) {
                ps.setInt(5, empleado.getRol().getIdRol());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            ps.setInt(6, empleado.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al actualizar empleado en SQL Server", e);
        }
    }

    @Override
    public void eliminar(int idEmpleado) {
        String sql = "UPDATE Usuarios SET estado = 0 WHERE idUsuario = ?";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idEmpleado);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al inactivar empleado en SQL Server", e);
        }
    }

    @Override
    public int contarEmpleados() {
        String sql = """
            SELECT COUNT(*) FROM Empleados e
            INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario
            WHERE u.estado = 1
            """;
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al contar empleados en SQL Server", e);
        }
        return 0;
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        Rol rol = null;
        int idRol = rs.getInt("idRol");
        if (!rs.wasNull()) {
            rol = new Rol(idRol, rs.getString("rolNombre"), rs.getString("rolDescripcion"));
        }

        Timestamp tsReg = rs.getTimestamp("fechaRegistro");
        LocalDateTime fechaRegistro = tsReg != null ? tsReg.toLocalDateTime() : null;

        Timestamp tsIng = rs.getTimestamp("fechaIngreso");
        LocalDateTime fechaIngreso = tsIng != null ? tsIng.toLocalDateTime() : null;

        return new Empleado(
                rs.getInt("idUsuario"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("contrasena"),
                rs.getBoolean("estado"),
                fechaRegistro,
                fechaIngreso,
                rol
        );
    }
}

