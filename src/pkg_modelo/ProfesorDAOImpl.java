package pkg_modelo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public int eliminarProfesor(int id) {
        PreparedStatement statement = null;
        int filasEliminadas = 0;
        String sql = "DELETE FROM profes WHERE id = ?";
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
                    Logger.getLogger(ProfesorDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return filasEliminadas;
    }

    public List<Profesor> obtenerTodosProfesores() {
        List<Profesor> profesores = new ArrayList();
        Statement statement = null;
        ResultSet resultado = null;
        String sql = "SELECT * FROM profes";
        try {
            statement = con.getConnection().createStatement();
            resultado = statement.executeQuery(sql);
            while (resultado.next()) {                
                profesores.add(new Profesor(resultado.getInt("id"), 
                        resultado.getString("nombre"), 
                        resultado.getString("apellido"), 
                        resultado.getString("nif"), 
                        resultado.getDate("fecha_nacimiento").toLocalDate(), 
                        resultado.getString("clase"), 
                        resultado.getBoolean("empleado")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al devolver los registros: " + e.getMessage());
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
        return profesores;
    }

    public int eliminarProfesoresDespedidos() {
        Statement statement = null;
        int registrosEliminados = 0;
        String sql = "DELETE FROM profes WHERE empleado = false";
        try {
            statement = con.getConnection().createStatement();
            registrosEliminados = statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se han podido eliminar los registros: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfesorDAOImpl.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return registrosEliminados;
    }

    public int despedirProfesor(int id) {
        PreparedStatement statement = null;
        int registrosModificados = 0;
        String sql = "UPDATE profes SET empleado = ? WHERE id = ?";
        try {
            statement = con.getConnection().prepareStatement(sql);
            statement.setBoolean(1, false);
            statement.setInt(2, id);
            registrosModificados = statement.executeUpdate();
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
        return registrosModificados;
    }
    
    
}
