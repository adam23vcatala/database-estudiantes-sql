package pkg_control;

import pkg_conexion.Conexion;
import pkg_modelo.Estudiante;
import pkg_modelo.EstudianteDAOImpl;
import pkg_vista.EntradaSalidaDatos;
import pkg_vista.EstudianteVista;

public class EstudianteControl {
    private Conexion con;
    private EstudianteDAOImpl edi;
    private EstudianteVista ev;
    private EntradaSalidaDatos esd;

    public EstudianteControl(Conexion con) {
        edi = new EstudianteDAOImpl(con);
        ev = new EstudianteVista();
        esd = new EntradaSalidaDatos();
    }

    public void agregarAlumno() {
        Estudiante e = ev.pedirDatosEstudiante();
        int resultado = edi.agregarAlumno(e);
        esd.mostrarResultado(resultado);
    }
    
}
