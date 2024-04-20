package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DetalleDAO {
    private static final String PROCEDURE_INSERT_DETALLE = "{CALL insertar_detalle_sp(?, ?, ?, ?,?)}";
    public void insertarDetalleVenta(String tipoElemento, int idElemento, int cantidad, int precio, int idVenta) {
    try (Connection connection = Conexion.obtenerConexion();
         CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_DETALLE)) {

        // Configurar los parámetros del procedimiento almacenado
        statement.setString(1, tipoElemento);
        statement.setInt(2, idElemento);
        statement.setInt(3, cantidad);
        statement.setInt(4, precio);
        statement.setInt(5, idVenta);

        // Ejecutar el procedimiento almacenado
        statement.executeUpdate();
        System.out.println("Detalle de venta insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de venta: " + e.getMessage());
        }
    }
}
