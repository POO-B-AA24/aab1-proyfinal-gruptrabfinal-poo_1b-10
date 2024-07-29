package Controller;

import Model.Bus_Salida_Afuera_UTPL;
import Model.Bus_Salida_UTPL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jdgua
 */
public class Servicio_Buses {

    public static ArrayList<Bus_Salida_UTPL> getBusesDentroDelCampus() {
        ArrayList<Bus_Salida_UTPL> buses = new ArrayList<>();
        String sql = "SELECT numero, ruta, hora_salida, hora_fin FROM Buses_Salida_UTPL";

        try (Connection conn = Data_Base.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id_ruta = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                LocalTime horaFin = LocalTime.parse(rs.getString("hora_fin"));
                buses.add(new Bus_Salida_UTPL(id_ruta, ruta, horaSalida, horaFin));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return buses;
    }

    public static ArrayList<Bus_Salida_Afuera_UTPL> getBusesFueraDelCampus() {
        ArrayList<Bus_Salida_Afuera_UTPL> buses = new ArrayList<>();
        String sql = "SELECT numero, ruta, hora_salida, hora_fin FROM Buses_Salida_Fuera_Del_CampusUTPL";

        try (Connection conn = Data_Base.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id_ruta = rs.getInt("numero");
                String ruta = rs.getString("ruta");
                LocalTime horaSalida = LocalTime.parse(rs.getString("hora_salida"));
                LocalTime horaFin = LocalTime.parse(rs.getString("hora_fin"));
                buses.add(new Bus_Salida_Afuera_UTPL(id_ruta, ruta, horaSalida, horaFin));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return buses;
    }

    public static void agregarRuta(boolean ruta_fuera_del_Campus, int numero, String ruta, String hora_salida, String hora_fin) {
        Data_Base.agregarRuta(ruta_fuera_del_Campus, numero, ruta, hora_salida, hora_fin);
    }

    public static void eliminarRuta(boolean ruta_fuera_del_Campus, int id) {
        Data_Base.eliminarRuta(ruta_fuera_del_Campus, id);
    }
}
