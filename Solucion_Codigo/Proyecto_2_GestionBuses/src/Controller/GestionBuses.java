package Controller;

import Model.LineaBus;
import Model.ParadaBus;
import Model.Horario;
import Model.RutaBus;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionBuses {

        private List<LineaBus> lineasAutobus;

        public GestionBuses() {
            lineasAutobus = new ArrayList<>();
        }

        public List<LineaBus> getLineasAutobus() {
            return lineasAutobus;
        }

        public void cargarDesdeArchivoTexto(String archivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println("Reading line: " + linea);  // Debug print
                    if (linea.trim().isEmpty()) {
                        continue;  // Ignorar líneas vacías
                    }
                    String[] partes = linea.split(";");
                    if (partes.length >= 4) {
                        String nombreLinea = partes[0];
                        String nombreParada = partes[1];
                        String ubicacionParada = partes[2];
                        String horarioParada = partes[3];

                        ParadaBus paradaBus = new ParadaBus(nombreParada, ubicacionParada, horarioParada);

                        // Busca si la línea ya existe
                        LineaBus lineaBus = null;
                        for (LineaBus lb : lineasAutobus) {
                            if (lb.getNombreLinea().equals(nombreLinea)) {
                                lineaBus = lb;
                                break;
                            }
                        }
                        if (lineaBus == null) {
                            lineaBus = new LineaBus(nombreLinea, new RutaBus(new ArrayList<>()), new ArrayList<>());
                            lineasAutobus.add(lineaBus);
                        }

                        // Añadir la parada a la línea
                        lineaBus.getRuta().getParadas().add(paradaBus);

                        // Añadir horarios (por simplicidad, usando datos fijos)
                        // Aquí deberías tener una lógica para extraer horarios si están en el archivo.
                        if (partes.length >= 7) {
                            String horaSalida = partes[4];
                            String horaLlegada = partes[5];
                            String diasServicio = partes[6];
                            Horario horario = new Horario(horaSalida, horaLlegada, diasServicio);
                            lineaBus.getHorarios().add(horario);
                        }
                    }
                }
                System.out.println("Total lines read: " + lineasAutobus.size());  // Debug print
            }
        }

        // Implementa los métodos guardarDatos, cargarDatos, etc.
    }

