package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ProveedorDAO {

    public String listarProveedoresConProductos() {
        String listaProveedores = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarProveedoresConProductos_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaProveedores = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaProveedores;
    }

    public String listarProveedoresConTotalPagos() {
        String listaProveedores = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarProveedoresConTotalPagos_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaProveedores = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaProveedores;
    }
}
