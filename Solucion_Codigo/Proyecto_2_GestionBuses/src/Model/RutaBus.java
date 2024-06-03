package Model;

import java.io.Serializable;
import java.util.List;

public class RutaBus implements Serializable {

    private List<ParadaBus> paradas;

    public RutaBus(List<ParadaBus> paradas) {
        this.paradas = paradas;
    }

    public List<ParadaBus> getParadas() {
        return paradas;
    }

    public void setParadas(List<ParadaBus> paradas) {
        this.paradas = paradas;
    }
}
