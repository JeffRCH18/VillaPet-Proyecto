package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class VentaDAO {
    
    public int obtenerVentasPorSucursal(int idSucursal) {
        int ventas = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call VentasporSucursal_FN(?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idSucursal);
            statement.execute();
            ventas = statement.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ventas;
    }
    
     public String listarVentasPorEmpleadoSucursal() {
        String listaVentas = "";
        try (Connection connection = Conexion.obtenerConexion();
             CallableStatement statement = connection.prepareCall("{ ? = call ListarVentasPorEmpleadoSucursal_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaVentas = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaVentas;
    }
    
}