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

    public Estudiante buscarAlumno(String nif) {
        PreparedStatement statement = null;
        ResultSet resultado = null;
        Estudiante a = null;
        String sql = "SELECT * FROM alumnos WHERE nif = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setString(1, nif);
            resultado = statement.executeQuery();
            while (resultado.next()) {                
                a = new Estudiante(resultado.getInt("id"), 
                        resultado.getString("nombre"), 
                        resultado.getString("apellido"), 
                        resultado.getString("nif"), 
                        resultado.getDate("fecha_nacimiento").toLocalDate());
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido identificar al alumno: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    resultado.close();
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return a;
    }

    public int modificarAlumno(Estudiante a, int id) {
        PreparedStatement statement = null;
        int filasModificadas = 0;
        LocalDate fecha = a.getFecha_nacimiento();
        String sql = "UPDATE alumnos SET nombre = ?, apellido = ?, nif = ?, fecha_nacimiento = ? WHERE id = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setString(1, a.getNombre());
            statement.setString(2, a.getApellido());
            statement.setString(3, a.getNif());
            statement.setDate(4, new Date(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth()));
            statement.setInt(5, id);
            filasModificadas = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido modificar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasModificadas;
    }

    public int eliminarAlumno(int id) {
        PreparedStatement statement = null;
        int filasEliminadas = 0;
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            filasEliminadas = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido eliminar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasEliminadas;
    }
    
    
}
