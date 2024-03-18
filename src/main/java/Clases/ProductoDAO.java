package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ProductoDAO {

    private static final String FUNCTION_PRODUCTOS_EN_STOCK = "{ ? = call ProductosenStock }";

    public int obtenerTotalProductosEnStock() {
        int totalStock = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_PRODUCTOS_EN_STOCK)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            totalStock = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalStock;
    }

    private static final String FUNCTION_PRODUCTOS_AGOTADOS = "{ ? = call ProductosAgotados }";

    public String obtenerProductosAgotados() {
        String listaAgotados = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_PRODUCTOS_AGOTADOS)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.VARCHAR);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            listaAgotados = statement.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAgotados;
    }

}
