package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class PagoDAO {

     public int obtenerPagosProveedor(int idProveedor) {
        int total = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call PagosaProveedor_FN(?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idProveedor);
            statement.execute();
            total = statement.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public int obtenerPagosPorPeriodo(Date fechaInicio, Date fechaFin) {
        int total = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call PagosporPeriodo_FN(?, ?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setDate(2, fechaInicio);
            statement.setDate(3, fechaFin);
            statement.execute();
            total = statement.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
}
