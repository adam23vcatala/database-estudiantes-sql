package pkg_modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String nif;
    private LocalDate fecha_nacimiento;

    public Estudiante(String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Estudiante(int id, String nombre, String apellido, String nif, LocalDate fecha_nacimiento) {
        this(nombre, apellido, nif, fecha_nacimiento);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nif, other.nif);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nif=" + nif + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
}
