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

public class ProductoDAO {
    private static final String PROCEDURE_INSERT_PRODUCTO = "{CALL CRUD_producto_PKG.INSERTAR_PRODUCTO_SP(?, ?, ?, ?, ?)}";
    public void insertarProducto(int ID_Categoria, int ID_Proveedor, String Descripcion, int Precio, int Stock) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_PRODUCTO)) {
            statement.setInt(1, ID_Categoria);
            statement.setInt(2, ID_Proveedor);
            statement.setString(3, Descripcion);
            statement.setInt(4, Precio);
            statement.setInt(5, Stock);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_PRODUCTO = "{CALL CRUD_producto_PKG.LISTAR_PRODUCTO_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Producto> ListarProducto() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Producto> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_PRODUCTO);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Producto para almacenar los datos de un producto recuperado de la DB*/
            Producto producto = new Producto();
            /*Establece los atributos del objeto Producto utilizando los valores recuperados del ResultSet*/
            producto.setID_Producto(rs.getInt("ID_PRODUCTO"));
            producto.setID_Categoria(rs.getInt("ID_CATEGORIA"));
            producto.setID_Proveedor(rs.getInt("ID_PROVEEDOR"));
            producto.setDescripcion(rs.getString("DESCRIPCION"));
            producto.setPrecio(rs.getInt("PRECIO"));
            producto.setStock(rs.getInt("STOCK"));
            /*Agrega el objeto Producto a la lista de productos*/
            lista.add(producto);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de productos recuperada de la DB*/
    return lista;
    }
    
    private static final String PROCEDURE_DELETE_PRODUCTO = "{CALL CRUD_producto_PKG.ELIMINAR_PRODUCTO_SP(?)}";
    public void eliminarProducto(int idProducto){
        // Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_PRODUCTO);
            statement.setInt(1, idProducto);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_PRODUCTO = "{CALL CRUD_producto_PKG.ACTUALIZAR_PRODUCTO_SP(?, ?, ?, ?, ?, ?)}";
    public void actualizarProducto(int ID_Producto, int ID_Categoria, int ID_Proveedor, String Descripcion, int Precio, int Stock) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_PRODUCTO);
            statement.setInt(1, ID_Producto);
            statement.setInt(2, ID_Categoria);
            statement.setInt(3, ID_Proveedor);
            statement.setString(4, Descripcion);
            statement.setInt(5, Precio);
            statement.setInt(6, Stock);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
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
