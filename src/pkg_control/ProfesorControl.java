package pkg_control;

import pkg_conexion.Conexion;
import pkg_modelo.Profesor;
import pkg_modelo.ProfesorDAOImpl;
import pkg_vista.EntradaSalidaDatos;
import pkg_vista.ProfesorVista;

public class ProfesorControl {
    private Conexion con;
    private ProfesorVista pv;
    private ProfesorDAOImpl pdi;
    private EntradaSalidaDatos esd;

    public ProfesorControl(Conexion con) {
        this.con = con;
        pv = new ProfesorVista();
        pdi = new ProfesorDAOImpl(con);
        esd = new EntradaSalidaDatos();
    }

    public void agregarProfe() {
        Profesor p = pv.pedirDatosProfesor();
        int resultado = pdi.agregarProfesor(p);
        esd.mostrarResultado(resultado);
    }

    public void modificarProfe() {
        esd.mostrarCadena("Introduce el nif del profesor a buscar: ");
        String nif = esd.pedirCadena();
        Profesor p = pdi.buscarProfesor(nif);
        Profesor p1 = pv.pedirDatosNuevoProfesor(p);
        int resultado = pdi.modificarProfesor(p1, p.getId());
        esd.mostrarResultado(resultado);
    }

    public void eliminarProfe() {
        esd.mostrarCadena("Introduce el nif del profesor a buscar: ");
        String nif = esd.pedirCadena();
        Profesor p = pdi.buscarProfesor(nif);
        int resultado = pdi.eliminarProfesor(p.getId());
        esd.mostrarResultado(resultado);
    }

    public void mostrarProfes() {
        pv.mostrarListaProfes(pdi.obtenerTodosProfesores());
    }

    public void eliminarProfesDespedidos() {
        int resultado = pdi.eliminarProfesoresDespedidos();
        esd.mostrarResultado(resultado);
    }

    public void despedirProfe() {
        esd.mostrarCadena("Introduce el nif del profesor a buscar: ");
        String nif = esd.pedirCadena();
        Profesor p = pdi.buscarProfesor(nif);
        int resultado = pdi.despedirProfesor(p.getId());
        esd.mostrarResultado(resultado);
    }
    
}
