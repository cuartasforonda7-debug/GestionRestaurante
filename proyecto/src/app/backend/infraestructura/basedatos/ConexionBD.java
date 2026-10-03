package app.backend.infraestructura.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

        public static Connection obtenerConexion() throws SQLException {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=Bajofuegodb;encrypt=true;trustServerCertificate=true";
        String usuario = "sa";
        String password = "cris1020305617";

        return DriverManager.getConnection(url, usuario, password);
    } 
} 