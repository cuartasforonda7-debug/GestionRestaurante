package app.backend.infraestructura.adaptadores;

import app.backend.infraestructura.basedatos.ConexionBD;
import app.backend.infraestructura.excepciones.InfraestructuraException;
import dominio.entidades.Rol;
import dominio.puertos.salida.RolRepositoryPort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RolRepositorySQLAdapter implements RolRepositoryPort {

    @Override
    public void registrarRol(Rol rol) {
        String sql = "INSERT INTO Roles (nombre, descripcion) VALUES (?, ?)";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, rol.getNombre());
            ps.setString(2, rol.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al registrar rol en SQL Server", e);
        }
    }

    @Override
    public Optional<Rol> buscarPorId(int idRol) {
        String sql = "SELECT idRol, nombre, descripcion FROM Roles WHERE idRol = ?";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Rol(rs.getInt("idRol"), rs.getString("nombre"), rs.getString("descripcion")));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al buscar rol por ID en SQL Server", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Rol> buscarPorNombre(String nombre) {
        String sql = "SELECT idRol, nombre, descripcion FROM Roles WHERE LOWER(nombre) = LOWER(?)";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Rol(rs.getInt("idRol"), rs.getString("nombre"), rs.getString("descripcion")));
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al buscar rol por nombre en SQL Server", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Rol> listarTodos() {
        String sql = "SELECT idRol, nombre, descripcion FROM Roles ORDER BY idRol ASC";
        List<Rol> lista = new ArrayList<>();
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lista.add(new Rol(rs.getInt("idRol"), rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al listar roles en SQL Server", e);
        }
        return lista;
    }

    @Override
    public boolean existePorId(int idRol) {
        String sql = "SELECT COUNT(*) FROM Roles WHERE idRol = ?";
        try (
            Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql)
        ) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new InfraestructuraException("Error al verificar existencia de rol", e);
        }
        return false;
    }
}

