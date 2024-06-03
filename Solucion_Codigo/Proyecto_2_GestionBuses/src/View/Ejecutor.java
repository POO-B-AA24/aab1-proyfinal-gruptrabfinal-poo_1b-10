package View;

import java.io.*;
import java.util.Scanner;

public class Ejecutor {

    private static SistemaDeGestionDeAutobuses sistema = new SistemaDeGestionDeAutobuses();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    mostrarLineasDeAutobus();
                    break;
                case 2:
                    guardarDatos();
                    break;
                case 3:
                    cargarDatos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("Sistema de Gestión de Autobuses UTPL");
        System.out.println("1. Mostrar líneas de autobús");
        System.out.println("2. Guardar datos");
        System.out.println("3. Cargar datos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarLineasDeAutobus() {
        System.out.print("Nombre del archivo a mostrar: ");
        String archivo = scanner.nextLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void guardarDatos() {
        System.out.print("Nombre del archivo para guardar: ");
        String archivo = scanner.nextLine();
        try {
            sistema.guardarDatos(archivo);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    private static void cargarDatos() {
        System.out.print("Nombre del archivo a cargar: ");
        String archivo = scanner.nextLine();
        try {
            sistema.cargarDatos(archivo);
            System.out.println("Datos cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}

class SistemaDeGestionDeAutobuses {

    public void guardarDatos(String archivo) throws IOException {
        // Implementación del método para guardar datos
    }

    public void cargarDatos(String archivo) throws IOException, ClassNotFoundException {
        // Implementación del método para cargar datos
    }
}
