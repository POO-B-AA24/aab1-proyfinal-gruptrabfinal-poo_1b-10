package View;

import Controller.Data_Base;
import Controller.Servicio_Buses;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            
            System.out.println("Sistema de Gestión de Autobuses UTPL:");
            System.out.println("1. Mostrar rutas de buses");
            System.out.println("2. Agregar nueva ruta de bus");
            System.out.println("3. Eliminar ruta de bus");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    Data_Base.informacionRutas();
                    break;
                case 2:
                    System.out.print("¿Es una ruta que no empieza en el campus de la UTPL? (true/false): ");
                    boolean ruta_fuera_del_Campus = scanner.nextBoolean();
                    scanner.nextLine(); 
                    System.out.print("Número de ruta: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ruta: ");
                    String ruta = scanner.nextLine();
                    System.out.print("Hora de salida (HH:MM): ");
                    String horaSalida = scanner.nextLine();
                    System.out.print("Hora de fin (HH:MM): ");
                    String horaFin = scanner.nextLine();

                    Servicio_Buses.agregarRuta(ruta_fuera_del_Campus, numero, ruta, horaSalida, horaFin);
                    break;
                case 3:
                    System.out.print("¿Es una ruta que empieza fuera del Campus de la UTPL? (true/false): ");
                    ruta_fuera_del_Campus = scanner.nextBoolean();
                    System.out.print("ID de la ruta a eliminar: ");
                    int id = scanner.nextInt();

                    Servicio_Buses.eliminarRuta(ruta_fuera_del_Campus, id);
                    break;
                case 4:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
