package pkg_control;

import java.util.List;
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

    public void modificarAlumno() {
        esd.mostrarCadena("Introduce el nif del alumno a modificar: ");
        String nif = esd.pedirCadena();
        Estudiante e = edi.buscarAlumno(nif);
        Estudiante e1 = ev.pedirDatosNuevoEstudiante(e);
        int resultado = edi.modificarAlumno(e1, e.getId());
        esd.mostrarResultado(resultado);
    }

    public void eliminarAlumno() {
        esd.mostrarCadena("Introduzca el nif del alumno a eliminar: ");
        String nif = esd.pedirCadena();
        Estudiante e = edi.buscarAlumno(nif);
        int resultado = edi.eliminarAlumno(e.getId());
        esd.mostrarResultado(resultado);
    }

    public void mostrarAlumnos() {
        ev.mostrarListaEstudiantes(edi.obtenerAlumnos());
    }
    
}
