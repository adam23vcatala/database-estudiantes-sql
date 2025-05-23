package pkg_modelo;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg_conexion.Conexion;

public class EstudianteDAOImpl {
    private Conexion con;

    public EstudianteDAOImpl(Conexion con) {
        this.con = con;
    }

    public int agregarAlumno(Estudiante a) {
        PreparedStatement statement = null;
        int filasAgregadas = 0;
        String sql = "INSERT INTO alumnos (nombre, apellido, nif, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try {
            statement = con.getConnection().prepareStatement(sql);
            LocalDate fecha = a.getFecha_nacimiento();
            statement.setString(1, a.getNombre());
            statement.setString(2, a.getApellido());
            statement.setString(3, a.getNif());
            statement.setDate(4, new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth()));
            filasAgregadas = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido insertar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasAgregadas;
    }
    
    
}
