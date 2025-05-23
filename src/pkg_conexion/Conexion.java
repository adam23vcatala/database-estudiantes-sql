package pkg_conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection con = null;

    public Conexion() {
        try {
            con = getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String usuario = "root";
        String contrasena = "1234";

        Class.forName(driver);
        return DriverManager.getConnection(url, usuario, contrasena);
    }
    
    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
