package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class VentaDAO {

    private static final String FUNCTION_VENTAS_POR_SUCURSAL = "{ ? = call VentasporSucursal(?) }";

    public int contarVentasPorSucursal(int idSucursal) {
        int conteoVentas = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_VENTAS_POR_SUCURSAL)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idSucursal);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            conteoVentas = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conteoVentas;
    }

    private static final String FUNCTION_VENTAS_POR_DIA = "{ ? = call VentasporDia(?) }";

    public int obtenerVentasPorDia(Date fecha) {
        int totalVentas = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_VENTAS_POR_DIA)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setDate(2, fecha);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            totalVentas = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalVentas;
    }

    private static final String FUNCTION_VENTAS_POR_CATEGORIA = "{ ? = call VentasporCategoria(?) }";

    public int obtenerVentasPorCategoria(int idCategoria) {
        int totalVentas = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_VENTAS_POR_CATEGORIA)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idCategoria);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            totalVentas = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalVentas;
    }
}