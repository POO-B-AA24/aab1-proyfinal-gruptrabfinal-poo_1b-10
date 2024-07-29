package Controller;

import java.time.LocalTime;

public abstract class GestionBuses {

    public int id_ruta;
    public String ruta;
    public LocalTime horaSalida;

    public GestionBuses(int id_ruta, String ruta, LocalTime horaSalida) {
        this.id_ruta = id_ruta;
        this.ruta = ruta;
        this.horaSalida = horaSalida;
    }

    public int getID_Ruta() {
        return id_ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public abstract void mostrarInformacion();
}
