package Model;

import java.io.Serializable;
import java.util.List;

public class LineaBus {

    private String nombreLinea;
    private RutaBus ruta;
    private List<Horario> horarios;

    public LineaBus(String nombreLinea, RutaBus ruta, List<Horario> horarios) {
        this.nombreLinea = nombreLinea;
        this.ruta = ruta;
        this.horarios = horarios;
    }

    // Getters y Setters
    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public RutaBus getRuta() {
        return ruta;
    }

    public void setRuta(RutaBus ruta) {
        this.ruta = ruta;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
