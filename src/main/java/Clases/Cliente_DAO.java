package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;
public class Cliente_DAO extends Cliente{
    /*Llamada del procedimiento almacenado que recibi 5 parametros*/
    private static final String PROCEDURE_INSERT_CLIENTE = "{CALL insertar_cliente(?, ?, ?, ?, ?)}";
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
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        }
    }
    /*Llamada del procedimiento almacenado que recibi 1 parametro*/
    private static final String PROCEDURE_LIST_CLIENTE = "{CALL LISTAR_CLIENTE(?)}";
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


    
}
