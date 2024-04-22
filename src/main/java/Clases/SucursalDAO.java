package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class SucursalDAO {
    private static final String PROCEDURE_INSERT_SUCURSAL = "{CALL INSERTAR_SUCURSAL_SP(?,?,?,?)}";
    public void insertarSucursal(String correo, int telefono, String nombre, String direccion) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_SUCURSAL)) {
            statement.setString(1,correo);
            statement.setInt(2,telefono);
            statement.setString(3,nombre);
            statement.setString(4,direccion);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    
    /*Llamada del procedimiento almacenado que recibi 1 parametro*/
    private static final String PROCEDURE_LIST_SUCURSAL = "{CALL LISTAR_SUCURSAL_SP(?)}";
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
                sucursal.setNombre_Sucursal(rs.getString("NOMBRE_SUCURSAL"));
                sucursal.setDireccion_Sucursal(rs.getString("DIRECCION_SUCURSAL"));
                sucursal.setTelefono_Sucursal(rs.getString("TELEFONO_SUCURSAL"));
                
                
                /*Agrega el objeto Cliente a la lista de clientes*/
                lista.add(sucursal);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        /*Devuelve la lista de clientes recuperada de la DB*/
        return lista;
    }

    private static final String PROCEDURE_DELETE_SUCURSAL = "{CALL ELIMINAR_SUCURSAL_SP(?)}";
    public void eliminarSucursal(int idSucursal){
        // Llamar al procedimiento almacenado para eliminar la sucursal
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_SUCURSAL);
            statement.setInt(1, idSucursal);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_SUCURSAL = "{CALL Actualizar_Sucursal_SP(?, ?, ?, ?, ?)}";
    public void actualizarSucursal(int idSucursal,String correo, int telefono, String nombre, String direccion) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_SUCURSAL);
            statement.setInt(1, idSucursal);
            statement.setString(2, correo);
            statement.setInt(3, telefono);
            statement.setString(4, nombre);
            statement.setString(5, direccion);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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

    public String totalEmpleadosPorSucursal() {
        String listaEmpleadosPorSucursal = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call TotalEmpleadosPorSucursal_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaEmpleadosPorSucursal = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaEmpleadosPorSucursal;
    }
}
