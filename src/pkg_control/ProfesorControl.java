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
    
    
}
