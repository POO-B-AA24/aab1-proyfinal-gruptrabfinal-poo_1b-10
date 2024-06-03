package Model;

import java.io.Serializable;

public class Horario implements Serializable {

    private String horaSalida;
    private String horaLlegada;
    private String diasServicio;

    public Horario(String horaSalida, String horaLlegada, String diasServicio) {
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasServicio = diasServicio;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDiasServicio() {
        return diasServicio;
    }

    public void setDiasServicio(String diasServicio) {
        this.diasServicio = diasServicio;
    }
}
