package pkg_modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    private List<String> clases;
    private boolean graduado;

    public Estudiante(String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(nombre, apellido, nif, fecha_nacimiento);
    }

    public Estudiante(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(id, nombre, apellido, nif, fecha_nacimiento);
    }

    public Estudiante(String nombre, String apellido, String nif, LocalDate fecha_nacimiento, boolean graduado) {
        super(nombre, apellido, nif, fecha_nacimiento);
        this.clases = new ArrayList();
        this.graduado = graduado;
    }

    public List<String> getClases() {
        return clases;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Estudiante{" + super.toString() + "clases=" + clases + ", graduado=" + graduado + '}';
    }

}
