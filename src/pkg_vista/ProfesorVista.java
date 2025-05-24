package pkg_vista;

import java.time.LocalDate;
import pkg_modelo.Profesor;

public class ProfesorVista {
    private EntradaSalidaDatos esd;

    public ProfesorVista() {
        esd = new EntradaSalidaDatos();
    }

    public Profesor pedirDatosProfesor() {
        esd.mostrarCadena("Introduce el nombre del profesor: ");
        String nombre = esd.pedirCadena();
        esd.mostrarCadena("Introduce el apellido del profesor: ");
        String apellido = esd.pedirCadena();
        esd.mostrarCadena("Introduce el nif del profesor: ");
        String nif = esd.pedirCadena();
        esd.mostrarCadena("Introduce la clase del profesor: ");
        String clase = esd.pedirCadena();
        esd.mostrarCadena("Introduce la fecha de nacimiento del profesor: ");
        LocalDate fecha = pasarStringFecha(esd.pedirCadena());
        return new Profesor(nombre, apellido, nif, fecha, clase);
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
}
