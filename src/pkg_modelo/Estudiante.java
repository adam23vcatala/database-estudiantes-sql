package pkg_modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    private String clase;
    private boolean graduado;

    public Estudiante(String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(nombre, apellido, nif, fecha_nacimiento);
    }

    public Estudiante(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(id, nombre, apellido, nif, fecha_nacimiento);
    }

    public Estudiante(String nombre, String apellido, String nif, LocalDate fecha_nacimiento, String clase, boolean graduado) {
        super(nombre, apellido, nif, fecha_nacimiento);
        this.clase = clase;
        this.graduado = false;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Estudiante{" + super.toString() + "clase=" + clase + ", graduado=" + graduado + '}';
    }

}
