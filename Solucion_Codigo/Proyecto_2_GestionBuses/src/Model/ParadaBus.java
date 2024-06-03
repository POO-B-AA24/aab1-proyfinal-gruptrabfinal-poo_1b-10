package Model;

import java.io.Serializable;

public class ParadaBus implements Serializable {

    private String nombre;
    private String ubicacion;
    private String horario;

    public ParadaBus(String nombre, String ubicacion, String horario) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horario = horario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;

    }
}
