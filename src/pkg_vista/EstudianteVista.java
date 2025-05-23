package pkg_vista;

import java.time.LocalDate;
import java.util.List;
import pkg_modelo.Estudiante;

public class EstudianteVista {
    private EntradaSalidaDatos esd;

    public EstudianteVista() {
        esd = new EntradaSalidaDatos();
    }
    
    public Estudiante pedirDatosEstudiante() {
        esd.mostrarCadena("Introduce el nombre del estudiante: ");
        String nombre = esd.pedirCadena();
        esd.mostrarCadena("Introduce el apellido del estudiante: ");
        String apellido = esd.pedirCadena();
        esd.mostrarCadena("Introduce el nif del estudiante: ");
        String nif = esd.pedirCadena();
        esd.mostrarCadena("Introduce la fecha de nacimiento del estudiante: ");
        LocalDate fecha = pasarStringFecha(esd.pedirCadena());
        return new Estudiante(nombre, apellido, nif, fecha);
    }
    
    public Estudiante pedirDatosNuevoEstudiante(Estudiante e) {
        esd.mostrarCadena("Introduce el nombre del estudiante: ");
        String nombre = esd.pedirCadena();
        if (e.getNombre().equals("")) {
            e.setNombre(nombre);
        }
        esd.mostrarCadena("Introduce el apellido del estudiante: ");
        String apellido = esd.pedirCadena();
        if (e.getApellido().equals("")) {
            e.setApellido(apellido);
        }
        esd.mostrarCadena("Introduce el nif del estudiante: ");
        String nif = esd.pedirCadena();
        if (e.getNif().equals("")) {
            e.setNif(nif);
        }
        esd.mostrarCadena("Introduce la fecha de nacimiento del estudiante: ");
        LocalDate fecha = pasarStringFecha(esd.pedirCadena());
        if (e.getFecha_nacimiento().equals("")) {
            e.setFecha_nacimiento(fecha);
        }
        return new Estudiante(nombre, apellido, nif, fecha);
    }
    
    public LocalDate pasarStringFecha(String fechaTexto) { // DD-MM-AAAA
        LocalDate fecha = null;
        if (fechaTexto.length() == 10 && fechaTexto.charAt(2) == '-' && fechaTexto.charAt(5) == '-') {
            String[] datos = fechaTexto.split("-");
            fecha = LocalDate.of(Integer.parseInt(datos[2]), 
                    Integer.parseInt(datos[1]), 
                    Integer.parseInt(datos[0]));
        }
        return fecha;
    }

    public void mostrarListaEstudiantes(List<Estudiante> estudiantes) {
        for (Estudiante e : estudiantes) {
            System.out.println("ID: " + e.getId()
                    + ",Nombre: " + e.getNombre()
                    + ",Apellido: " + e.getApellido()
                    + ",NIF: " + e.getNif()
                    + ",Fecha de nacimiento: " + e.getFecha_nacimiento());
        }
    }
    
}
