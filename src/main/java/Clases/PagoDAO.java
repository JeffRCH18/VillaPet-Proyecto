package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class PagoDAO {

    private static final String FUNCTION_PAGOS_A_PROVEEDOR = "{ ? = call PagosaProveedor(?) }";

    public double calcularPagosAProveedor(int idProveedor) {
        double totalPagos = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_PAGOS_A_PROVEEDOR)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.DOUBLE);
            statement.setInt(2, idProveedor);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            totalPagos = statement.getDouble(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalPagos;
    }

    private static final String FUNCTION_PAGOS_POR_PERIODO = "{ ? = call PagosporPeriodo(?, ?) }";

    public double calcularPagosPorPeriodo(Date fechaInicio, Date fechaFin) {
        double totalPagos = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_PAGOS_POR_PERIODO)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.DOUBLE);
            statement.setDate(2, fechaInicio);
            statement.setDate(3, fechaFin);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            totalPagos = statement.getDouble(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalPagos;
    }
}
