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
                    + "\t5. Eliminar alumnos graduados\n"
                    + "\t6. Insertar profe nuevo\n"
                    + "\t7. Modificar profe existente\n"
                    + "\t8. Eliminar profe\n"
                    + "\t9. Mostrar todos los profes\n"
                    + "\t10. Eliminar profes despedidos\n"
                    + "\t11. Graduar alumnos de una clase\n"
                    + "\t12. Despedir a un profesor\n"
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
                case 5: // ELIMINAR ALUMNOS GRADUADOS
                    ec.eliminarAlumnosGraduados();
                    break;
                case 6: // AGREGAR PROFE
                    break;
                case 7: // MODIFICAR PROFE
                    break;
                case 8: // ELIMINAR PROFE
                    break;
                case 9: // MOSTRAR TODOS LOS PROFES
                    break;
                case 10: // ELIMINAR PROFES DESPEDIDOS
                    break;
                case 11: // GRADUAR A UNA CLASE
                    ec.graduarClase();
                    break;
                case 12: // DESPEDIR A UN PROFE
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
