package app.backend.infraestructura.adaptadores;

import app.backend.infraestructura.basedatos.ConexionBD;
import app.backend.infraestructura.excepciones.InfraestructuraException;
import dominio.entidades.Rol;
import dominio.entidades.Usuario;
import dominio.puertos.salida.UsuarioRepositoryPort;

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

public class UsuarioRepositorySQLAdapter implements UsuarioRepositoryPort {

    @Override
    public void registrarUsuario(Usuario usuario) {
        String sql = """
            INSERT INTO Usuarios (nombre, email, telefono, contrasena, estado, fechaRegistro, idRol)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getContrasena());
            ps.setBoolean(5, usuario.isEstado());
            ps.setTimestamp(6, Timestamp.valueOf(usuario.getFechaRegistro() != null ? usuario.getFechaRegistro() : LocalDateTime.now()));
            if (usuario.getRol() != null) {
                ps.setInt(7, usuario.getRol().getIdRol());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setIdUsuario(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al registrar el usuario en SQL Server: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Usuario> buscarPorId(int idUsuario) {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Usuarios u
            LEFT JOIN Roles r ON u.idRol = r.idRol
            WHERE u.idUsuario = ?
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al buscar usuario por ID en SQL Server", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Usuarios u
            LEFT JOIN Roles r ON u.idRol = r.idRol
            WHERE LOWER(u.email) = LOWER(?)
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al buscar usuario por email en SQL Server", e);
        }
        return Optional.empty();
    }

    @Override
    public boolean existePorEmail(String email) {
        String sql = "SELECT COUNT(*) FROM Usuarios WHERE LOWER(email) = LOWER(?)";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al verificar existencia de email en SQL Server", e);
        }
        return false;
    }

    @Override
    public List<Usuario> listarTodos() {
        String sql = """
            SELECT u.idUsuario, u.nombre, u.email, u.telefono, u.contrasena, u.estado, u.fechaRegistro,
                   r.idRol, r.nombre AS rolNombre, r.descripcion AS rolDescripcion
            FROM Usuarios u
            LEFT JOIN Roles r ON u.idRol = r.idRol
            ORDER BY u.idUsuario ASC
            """;
        List<Usuario> lista = new ArrayList<>();

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lista.add(mapearUsuario(rs));
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al listar usuarios en SQL Server", e);
        }
        return lista;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = """
            UPDATE Usuarios
            SET nombre = ?, email = ?, telefono = ?, estado = ?, idRol = ?
            WHERE idUsuario = ?
            """;

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefono());
            ps.setBoolean(4, usuario.isEstado());
            if (usuario.getRol() != null) {
                ps.setInt(5, usuario.getRol().getIdRol());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            ps.setInt(6, usuario.getIdUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al actualizar usuario en SQL Server", e);
        }
    }

    @Override
    public void eliminar(int idUsuario) {
        // Borrado lógico recomendado en gestión de usuarios
        String sql = "UPDATE Usuarios SET estado = 0 WHERE idUsuario = ?";

        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al eliminar (inactivar) usuario en SQL Server", e);
        }
    }

    @Override
    public int contarUsuarios() {
        String sql = "SELECT COUNT(*) FROM Usuarios WHERE estado = 1";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al contar usuarios en SQL Server", e);
        }
        return 0;
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Rol rol = null;
        int idRol = rs.getInt("idRol");
        if (!rs.wasNull()) {
            rol = new Rol(idRol, rs.getString("rolNombre"), rs.getString("rolDescripcion"));
        }

        Timestamp ts = rs.getTimestamp("fechaRegistro");
        LocalDateTime fechaReg = ts != null ? ts.toLocalDateTime() : null;

        return new Usuario(
                rs.getInt("idUsuario"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("contrasena"),
                rs.getBoolean("estado"),
                fechaReg,
                rol
        );
    }
}

