package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion;

public class VillaPet {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try (Connection conexion = Conexion.obtenerConexion()) {
            String consulta = "SELECT * FROM Tab_cliente";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                try (ResultSet resultado = statement.executeQuery()) {
                    while (resultado.next()) {
                        String Nombre = resultado.getString("Nombre_Cliente");
                        System.out.println(Nombre);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
