package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class EmpleadoDAO {

    private static final String FUNCTION_EMPLEADOS_POR_SUCURSAL = "{ ? = call EmpleadosporSucursal(?) }";
    public int contarEmpleadosPorSucursal(int idSucursal) {
        int conteoEmpleados = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_EMPLEADOS_POR_SUCURSAL)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idSucursal);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            conteoEmpleados = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conteoEmpleados;
    }
}
