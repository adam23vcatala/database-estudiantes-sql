package pkg_modelo;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg_conexion.Conexion;

public class ProfesorDAOImpl {
    private Conexion con;

    public ProfesorDAOImpl(Conexion con) {
        this.con = con;
    }

    public int agregarProfesor(Profesor p) {
        PreparedStatement statement = null;
        LocalDate fecha = p.getFecha_nacimiento();
        int filasAgregadas = 0;
        String sql = "INSERT INTO profes (nombre, apellido, nif, clase, fecha_nacimiento, empleado) VALUES (?, ?, ?, ?, ?, true)";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getApellido());
            statement.setString(3, p.getNif());
            statement.setString(4, p.getClase());
            statement.setDate(5, new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth()));
            statement.setBoolean(6, p.isEmpleado());
            filasAgregadas = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido insertar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfesorDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasAgregadas;
    }
    
    
}
