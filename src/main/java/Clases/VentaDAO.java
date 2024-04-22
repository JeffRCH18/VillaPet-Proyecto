package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class VentaDAO {
    private static final String PROCEDURE_INSERT_VENTA = "{CALL CRUD_venta_PKG.INSERTAR_VENTA_SP(?, ?, ?, ?)}";
    public void insertarVenta(int ID_Cliente, int ID_Sucursal, int Monto_Venta, LocalDate fecha) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_VENTA)) {
            statement.setInt(1, ID_Cliente);
            statement.setInt(2, ID_Sucursal);
            statement.setInt(3, Monto_Venta);
            java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);
            statement.setDate(4, sqlDate);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venta insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        }
    }
    
    private static final String PROCEDURE_LIST_VENTA = "{CALL CRUD_venta_PKG.LISTAR_VENTA_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Venta> ListarVenta() {
        /*Crea una lista vacía para almacenar los objetos */   
        List<Venta> lista = new ArrayList<>();
        try (Connection connection = Conexion.obtenerConexion()) {
            /*Se verifica la conexion y se prepara una consulta de los datos*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_VENTA);
            /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
            statement.registerOutParameter(1, OracleTypes.CURSOR);
             /*Se ejecuta el procedimiento almacenado*/
            statement.execute();
            /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
            ResultSet rs = (ResultSet) statement.getObject(1);
            /*Itera sobre cada fila del ResultSet*/
            while (rs.next()) {
                /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
                Venta venta = new Venta();
                /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
                venta.setNum_Factura(rs.getInt("NUM_FACTURA"));
                venta.setID_Cliente(rs.getInt("ID_CLIENTE"));
                venta.setID_Sucursal(rs.getInt("ID_SUCURSAL"));
                venta.setMonto_Venta(rs.getInt("MONTO_VENTA"));
                Date fechaSql = rs.getDate("FECHA");
                if (fechaSql != null) {
                    venta.setFecha(fechaSql.toLocalDate());
                }
                /*Agrega el objeto Cliente a la lista de clientes*/
                lista.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        /*Devuelve la lista de clientes recuperada de la DB*/
        return lista;
    }
    
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
    
    private static final String CALL_VISTA_SERVICIO_PRODUCTO = "{CALL CRUD_venta_PKG.PRODUCTO_SERVICIO_SP(?)}";
    public List<Object> usarVista() {
        List<Object> lista = new ArrayList<>(); // Lista para almacenar productos y servicios

        try (Connection connection = Conexion.obtenerConexion();
             CallableStatement statement = connection.prepareCall(CALL_VISTA_SERVICIO_PRODUCTO)) {

            // Establece parámetro de salida para el cursor
            statement.registerOutParameter(1, OracleTypes.CURSOR);

            // Ejecuta el procedimiento almacenado
            statement.execute();

            // Obtiene el cursor resultante
            ResultSet rs = (ResultSet) statement.getObject(1);

            // Itera sobre los resultados y procesa productos y servicios
            while (rs.next()) {
                if (rs.getString("TIPO").equals("Producto")) {
                    Producto producto = new Producto();
                    producto.setID_Producto(rs.getInt("ID"));
                    producto.setDescripcion(rs.getString("DESCRIPCION"));
                    producto.setPrecio(rs.getInt("PRECIO"));
                    producto.setStock(rs.getInt("STOCK"));
                    lista.add(producto); // Agrega producto a la lista
                } else if (rs.getString("TIPO").equals("Servicio")) {
                    Servicio servicio = new Servicio();
                    servicio.setID_Servicio(rs.getInt("ID"));
                    servicio.setDescripcion_Servicio(rs.getString("DESCRIPCION"));
                    servicio.setNombre_Servicios(rs.getString("DETALLE"));
                    servicio.setPrecio(rs.getInt("PRECIO"));
                    lista.add(servicio); // Agrega servicio a la lista
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista; // Devuelve la lista de productos y servicios
    }
     
    private static final String PROCEDURE_GET_MAX_VENTA_ID = "{CALL CRUD_venta_PKG.VENTA_ID_SP(?)}";
    public int IdVenta() {
    int id = 0;
    try (Connection connection = Conexion.obtenerConexion();
         CallableStatement statement = connection.prepareCall(PROCEDURE_GET_MAX_VENTA_ID)) {
        // Configurar el parámetro de salida del procedimiento almacenado
        statement.registerOutParameter(1, Types.INTEGER);
        // Ejecutar el procedimiento almacenado
        statement.execute();
        // Obtener el valor del parámetro de salida
        id = statement.getInt(1);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }

    return id;
}
}