package pkg_modelo;

import java.time.LocalDate;

public class Profesor extends Persona{
    private String clase;
    private boolean empleado;

    public Profesor(String nombre, String apellido, String nif, LocalDate fecha_nacimiento, String clase) {
        super(nombre, apellido, nif, fecha_nacimiento);
        this.clase = clase;
    }

    public Profesor(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento, String clase) {
        super(id, nombre, apellido, nif, fecha_nacimiento);
        this.clase = clase;
    }

    public Profesor(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento, String clase, boolean empleado) {
        this(id, nombre, apellido, nif, fecha_nacimiento, clase);
        this.empleado = true;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Profesor{" + super.toString() + "clase=" + clase + ", empleado=" + empleado + '}';
    }

}
