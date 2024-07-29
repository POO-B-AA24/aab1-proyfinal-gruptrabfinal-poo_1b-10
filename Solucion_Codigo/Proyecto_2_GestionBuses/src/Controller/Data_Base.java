package Controller;

import java.sql.*;

/**
 *
 * @author jdgua
 */
public class Data_Base {

    private static final String URL = "jdbc:sqlite:C:/Users/jdgua/OneDrive/Escritorio/Uni/BaseDatos/Ruta_Buses.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void informacionRutas() {
        try (Connection conn = connect(); Statement statement = conn.createStatement()) {
            String queryFueraDelCampus = "SELECT * FROM Buses_Salida_Fuera_Del_CampusUTPL";
            ResultSet resultSetFueraDelCampus = statement.executeQuery(queryFueraDelCampus);

            System.out.println("Datos de la tabla Buses_Salida_Fuera_Del_CampusUTPL:");
            while (resultSetFueraDelCampus.next()) {
                int id = resultSetFueraDelCampus.getInt("id");
                int numero = resultSetFueraDelCampus.getInt("numero");
                String ruta = resultSetFueraDelCampus.getString("ruta");
                String hora_salida = resultSetFueraDelCampus.getString("hora_salida");
                String hora_fin = resultSetFueraDelCampus.getString("hora_fin");

                System.out.println("ID: " + id + ", Número: " + numero + ", Ruta: " + ruta + ", Hora de Salida: " + hora_salida + ", Hora de Fin: " + hora_fin);
            }

            String queryUTPL = "SELECT * FROM Buses_Salida_UTPL";
            ResultSet resultSetUTPL = statement.executeQuery(queryUTPL);

            System.out.println("Datos de la tabla Buses_Salida_UTPL:");
            while (resultSetUTPL.next()) {
                int id = resultSetUTPL.getInt("id");
                int numero = resultSetUTPL.getInt("numero");
                String ruta = resultSetUTPL.getString("ruta");
                String hora_salida = resultSetUTPL.getString("hora_salida");
                String hora_fin = resultSetUTPL.getString("hora_fin");

                System.out.println("ID: " + id + ", Número: " + numero + ", Ruta: " + ruta + ", Hora de Salida: " + hora_salida + ", Hora de Fin: " + hora_fin);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void agregarRuta(boolean ruta_fuera_del_Campus, int numero, String ruta, String hora_salida, String hora_fin) {
        String tableName = ruta_fuera_del_Campus ? "Buses_Salida_Fuera_Del_CampusUTPL" : "Buses_Salida_UTPL";
        String sql = "INSERT INTO " + tableName + "(numero, ruta, hora_salida, hora_fin) VALUES(?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numero);
            pstmt.setString(2, ruta);
            pstmt.setString(3, hora_salida);
            pstmt.setString(4, hora_fin);
            pstmt.executeUpdate();
            System.out.println("Nueva ruta agregada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarRuta(boolean ruta_fuera_del_Campus, int id) {
        String tableName = ruta_fuera_del_Campus ? "Buses_Salida_Fuera_Del_CampusUTPL" : "Buses_Salida_UTPL";
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Ruta eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
