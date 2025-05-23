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
        boolean salir = false;
        do {
            esd.mostrarCadena("MENÚ\n"
                    + "\t1. Insertar alumno nuevo\n"
                    + "\t2. Modificar alumno existente\n"
                    + "\t3. Eliminar alumno\n"
                    + "\t4. Mostrar todos los alumnos\n"
                    + "\t99. Salir\n"
                    + "Introduce una opción: ");
            int opcion = esd.pedirValorEnteroPositivo();
            switch (opcion) {
                case 1: // AGREGAR ALUMNO
                    ec.agregarAlumno();
                    break;
                case 2: // MODIFICAR ALUMNO
                    ec.modificarAlumno();
                    break;
                case 3: // ELIMINAR ALUMNO
                    ec.eliminarAlumno();
                    break;
                case 4: // MOSTRAR TODOS LOS ALUMNOS
                    ec.mostrarAlumnos();
                    break;
                case 99: // SALIR
                    con.cerrarConexion();
                    salir = true;
                    break;
                default:
                    esd.mostrarCadena("¡Opción no válida!");
            }
        } while (!salir);
    }
}
