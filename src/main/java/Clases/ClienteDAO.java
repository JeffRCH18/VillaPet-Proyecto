package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;
public class ClienteDAO extends Cliente{
    /*Llamada del procedimiento almacenado que recibi 5 parametros*/
    private static final String PROCEDURE_INSERT_CLIENTE = "{CALL Insertar_Cliente_SP(?, ?, ?, ?, ?)}";
    public void insertarCliente(String nombre, String apellido, String direccion, String correo, int telefono) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_CLIENTE)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, direccion);
            statement.setString(4, correo);
            statement.setInt(5, telefono);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        }
    }
    
    /*Llamada del procedimiento almacenado que recibi 1 parametro*/
    private static final String PROCEDURE_LIST_CLIENTE = "{CALL LISTAR_CLIENTE_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Cliente> ListarCliente() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Cliente> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_CLIENTE);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Cliente cliente = new Cliente();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            cliente.setID_Cliente(rs.getInt("ID_CLIENTE"));
            cliente.setNombre_Cliente(rs.getString("NOMBRE_CLIENTE"));
            cliente.setApellido_Cliente(rs.getString("APELLIDO"));
            cliente.setDireccion_Cliente(rs.getString("DIRECCION_CLIENTE"));
            cliente.setTelefono_Cliente(rs.getInt("TELEFONO_CLIENTE"));
            cliente.setCorreo_Cliente(rs.getString("CORREO_CLIENTE"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(cliente);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
}
    private static final String PROCEDURE_DELETE_CLIENTE = "{CALL ELIMINAR_CLIENTE_SP(?)}";
    public void eliminarCliente(int idCliente){
        // Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_CLIENTE);
            statement.setInt(1, idCliente);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_CLIENTE = "{CALL ACTUALIZAR_CLIENTE_SP(?, ?, ?, ?, ?, ?)}";
    public void actualizarCliente(int idCliente, String nombre, String apellido, String direccion, String telefono, String correo) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_CLIENTE);
            statement.setInt(1, idCliente); // Primer parámetro: ID del cliente
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, direccion);
            statement.setString(5, telefono);
            statement.setString(6, correo);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public static int obtenerIdPorDescripcionc(String nombreCliente, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre_Cliente().equalsIgnoreCase(nombreCliente)) {
                return cliente.getID_Cliente(); // Devolver el ID del rol encontrado
            }
        }
        return -1; 
        }
    
    private static final String PROCEDURE_BUSCAR_CLIENTE = "{CALL BUSCAR_CLIENTE_SP(?, ?)}";
    public static Cliente buscarClientePorId(int id) {
        Cliente cliente = null;
        try (Connection connection = Conexion.obtenerConexion();
            CallableStatement statement = connection.prepareCall(PROCEDURE_BUSCAR_CLIENTE)) {
            statement.setInt(1, id);
            statement.registerOutParameter(2, OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet) statement.getObject(2);
            if (rs.next()) {
                // Crear un nuevo objeto Cliente y configurar sus atributos con los datos recuperados del ResultSet
                cliente = new Cliente();
                cliente.setNombre_Cliente(rs.getString("NOMBRE_CLIENTE"));
                cliente.setApellido_Cliente(rs.getString("APELLIDO"));
                cliente.setCorreo_Cliente(rs.getString("CORREO_CLIENTE"));
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar cliente por ID: " + e.getMessage());
            }
            return cliente;
    }      

    public String listarClientesConCompras() {
        String listaClientes = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarClientesConCompras_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaClientes = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    public String listarClientesConTotalCompras() {
        String listaClientes = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarClientesConTotalCompras_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaClientes = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }
    
}
