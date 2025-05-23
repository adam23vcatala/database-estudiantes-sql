package pkg_control;

import pkg_conexion.Conexion;
import pkg_modelo.EstudianteDAOImpl;

public class EstudianteControl {
    private Conexion con;
    private EstudianteDAOImpl edi;

    public EstudianteControl(Conexion con) {
        edi = new EstudianteDAOImpl(con);
    }
    
}
