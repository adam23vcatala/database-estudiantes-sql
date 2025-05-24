package pkg_modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona{
    private List<String> clases;
    private boolean empleado;

    public Profesor(String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(nombre, apellido, nif, fecha_nacimiento);
    }

    public Profesor(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        super(id, nombre, apellido, nif, fecha_nacimiento);
    }

    public Profesor(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento, List<String> clases, boolean empleado) {
        this(id, nombre, apellido, nif, fecha_nacimiento);
        this.clases = new ArrayList();
        this.empleado = empleado;
    }

    public List<String> getClases() {
        return clases;
    }

    public void setClases(List<String> clases) {
        this.clases = clases;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Profesor{" + super.toString() + "clases=" + clases + ", empleado=" + empleado + '}';
    }

}
