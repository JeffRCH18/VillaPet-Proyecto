package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class ProveedorDAO {
    private static final String PROCEDURE_INSERT_PROVEEDOR = "{CALL INSERTAR_PROVEEDOR_SP(?, ?, ?)}";
    public void insertarProveedor(String Nombre_Proveedor, int Telefono, String Direccion) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_PROVEEDOR)) {
            statement.setString(1, Nombre_Proveedor);
            statement.setInt(2, Telefono);
            statement.setString(3, Direccion);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_PROVEEDOR = "{CALL LISTAR_PROVEEDOR_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Proveedor> ListarProveedor() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Proveedor> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_PROVEEDOR);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Proveedor para almacenar los datos de un proveedor recuperado de la DB*/
            Proveedor proveedor = new Proveedor();
            /*Establece los atributos del objeto Proveedor utilizando los valores recuperados del ResultSet*/
            proveedor.setID_Proveedor(rs.getInt("ID_PROVEEDOR"));
            proveedor.setNombre_Proveedor(rs.getString("NOMBRE_PROVEEDOR"));
            proveedor.setTelefono_Proveedor(rs.getString("TELEFONO_PROVEEDOR"));
            proveedor.setDireccion_Proveedor(rs.getString("DIRECCION_PROVEEDOR"));
            /*Agrega el objeto Proveedor a la lista de proveedors*/
            lista.add(proveedor);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de proveedors recuperada de la DB*/
    return lista;
    }
    
    private static final String PROCEDURE_DELETE_PROVEEDOR = "{CALL ELIMINAR_PROVEEDOR_SP(?)}";
    public void eliminarProveedor(int idProveedor){
        // Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_PROVEEDOR);
            statement.setInt(1, idProveedor);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_PROVEEDOR = "{CALL ACTUALIZAR_PROVEEDOR_SP(?, ?, ?, ?)}";
    public void actualizarProveedor(int ID_Proveedor, String Nombre_Proveedor, int Telefono, String Direccion) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_PROVEEDOR);
            statement.setInt(1, ID_Proveedor);
            statement.setString(2, Nombre_Proveedor);
            statement.setInt(3, Telefono);
            statement.setString(4, Direccion);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static String obtenerDescripcionProveedorPorID(int idProveedor, List<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getID_Proveedor() == idProveedor) {
                return proveedor.getNombre_Proveedor();
            }
        }
        return null; // Devuelve null si no se encuentra el proveedor con el ID especificado
    }
    
    public static int obtenerIdPorDescripcionp(String descripcionProveedor,List<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombre_Proveedor().equalsIgnoreCase(descripcionProveedor)) {
                return proveedor.getID_Proveedor(); // Devolver el ID del proveedor encontrado
            }
        }
        return -1; // Si no se encuentra el proveedor, devolver -1 o lanzar una excepción
    }
    
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
