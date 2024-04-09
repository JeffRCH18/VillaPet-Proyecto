package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class SucursalDAO {
     
    /*Llamada del procedimiento almacenado que recibi 1 parametro*/
    private static final String PROCEDURE_LIST_SUCURSAL = "{CALL Listar_Sucursal_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Sucursal> ListarSucursal() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Sucursal> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_SUCURSAL);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Sucursal sucursal = new Sucursal();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            sucursal.setID_Sucursal(rs.getInt("ID_SUCURSAL"));
            sucursal.setCorreo_sucursal(rs.getString("CORREO_SUCURSAL"));
            sucursal.setTelefono_Sucursal(rs.getString("TELEFONO_SUCURSAL"));
            sucursal.setNombre_Sucursal(rs.getString("NOMBRE_SUCURSAL"));
            sucursal.setDireccion_Sucursal(rs.getString("DIRECCION_SUCURSAL"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(sucursal);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
}
 
    public static String obtenerDescripcionSucursalPorID(int idSucursal, List<Sucursal> sucursales) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getID_Sucursal() == idSucursal) {
                return sucursal.getNombre_Sucursal();
            }
        }
        return null; // Devuelve null si no se encuentra la sucursal con el ID especificado
    }
    
    public static int obtenerIdPorDescripcions(String descripcionSucursal, List<Sucursal> sucursales) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre_Sucursal().equalsIgnoreCase(descripcionSucursal)) {
                return sucursal.getID_Sucursal(); // Devolver el ID del rol encontrado
            }
        }
        return -1; 
        }
}
