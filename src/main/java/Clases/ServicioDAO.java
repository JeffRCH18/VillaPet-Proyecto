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

public class ServicioDAO {
    private static final String PROCEDURE_INSERT_SERVICIO = "{CALL INSERTAR_SERVICIO_SP(?, ?, ?, ?)}";
    public void insertarServicio(int idEmpleado, String nombre, String descripcion, int precio) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_SERVICIO)) {
            statement.setInt(1, idEmpleado);
            statement.setString(2, nombre);
            statement.setString(3, descripcion);
            statement.setInt(4, precio);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Servicio insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_SERVICIO = "{CALL LISTAR_SERVICIO_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Servicio> Listarservicio() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Servicio> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_SERVICIO);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Servicio servicio = new Servicio();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            servicio.setID_Servicio(rs.getInt("ID_SERVICIO"));
            servicio.setID_Empleado(rs.getInt("ID_EMPLEADO"));
            servicio.setNombre_Servicios(rs.getString("NOMBRE_SERVICIOS"));
            servicio.setDescripcion_Servicio(rs.getString("DESCRIPCION_SERVICIO"));
            servicio.setPrecio(rs.getInt("PRECIO"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(servicio);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
    }
    
    private static final String PROCEDURE_DELETE_SERVICIO = "{CALL Eliminar_Servicio_SP(?)}";
    public void eliminarServicio(int idServicio){
        // Llamar al procedimiento almacenado para eliminar el Rol
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_SERVICIO);
            statement.setInt(1, idServicio);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_SERVICIO = "{CALL Actualizar_Servicio_SP(?, ?, ?,?,?)}";
    public void actualizarServicio(int idServicio, int idEmpleado, String nombre, String descripcion, int precio) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_SERVICIO);
            statement.setInt(1, idServicio);
            statement.setInt(2, idEmpleado);
            statement.setString(3, nombre);
            statement.setString(4, descripcion);
            statement.setInt(5, precio);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
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
