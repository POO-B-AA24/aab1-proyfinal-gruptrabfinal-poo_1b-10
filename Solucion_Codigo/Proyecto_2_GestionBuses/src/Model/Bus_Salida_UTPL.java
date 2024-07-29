package Model;

import Controller.GestionBuses;
import java.time.LocalTime;

public class Bus_Salida_UTPL extends GestionBuses {

    private LocalTime horaFin;

    public Bus_Salida_UTPL(int numero, String ruta, LocalTime horaSalida, LocalTime horaFin) {
        super(numero, ruta, horaSalida);
        this.horaFin = horaFin;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Bus Dentro del Campus:");
        System.out.println("Número: " + getID_Ruta());
        System.out.println("Ruta: " + getRuta());
        System.out.println("Hora de Salida: " + getHoraSalida());
        System.out.println("Hora de Fin: " + getHoraFin());
    }
}
