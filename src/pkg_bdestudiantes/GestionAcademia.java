package pkg_bdestudiantes;

import pkg_conexion.Conexion;
import pkg_control.EstudianteControl;
import pkg_vista.EntradaSalidaDatos;

public class GestionAcademia {
    private Conexion con;
    private EstudianteControl ec;
    private EntradaSalidaDatos esd;

    public GestionAcademia() {
        con = new Conexion();
        ec = new EstudianteControl(con);
        esd = new EntradaSalidaDatos();
    }
    
    
    public void menu() {

    }
}
