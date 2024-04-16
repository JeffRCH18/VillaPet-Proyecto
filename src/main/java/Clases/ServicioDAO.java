package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ServicioDAO {

    public String listarEmpleadosParaServicio(String nombreServicio) {
        String listaEmpleadosServicio = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarEmpleadosParaServicio_FN(?) }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(2, nombreServicio);
            statement.execute();
            listaEmpleadosServicio = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaEmpleadosServicio;
    }

    public String listarServiciosPorTodasSucursales() {
        String listaServiciosSucursal = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarServiciosPorTodasSucursales_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaServiciosSucursal = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaServiciosSucursal;
    }
}
