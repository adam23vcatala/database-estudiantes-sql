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

    public Profesor buscarProfesor(String nif) {
        PreparedStatement statement = null;
        ResultSet resultado = null;
        Profesor p = null;
        String sql = "SELECT * FROM profes WHERE nif = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setString(1, nif);
            resultado = statement.executeQuery();
            while (resultado.next()) {                
                p = new Profesor(resultado.getInt("id"), 
                        resultado.getString("nombre"), 
                        resultado.getString("apellido"), 
                        resultado.getString("nif"), 
                        resultado.getDate("fecha_nacimiento").toLocalDate(), 
                        resultado.getString("clase"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido devolver los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    resultado.close();
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfesorDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return p;
    }

    public int modificarProfesor(Profesor p, int id) {
        PreparedStatement statement = null;
        LocalDate fecha = p.getFecha_nacimiento();
        int filasModificadas = 0;
        String sql = "UPDATE profes SET nombre = ?, apellido = ?, nif = ?, clase = ?, fecha_nacimiento = ? WHERE id = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getApellido());
            statement.setString(3, p.getNif());
            statement.setString(4, p.getClase());
            statement.setDate(5, new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth()));
            statement.setInt(6, id);
            filasModificadas = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido modificar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfesorDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasModificadas;
    }
    
    
}
