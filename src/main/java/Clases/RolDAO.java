package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class RolDAO {
    private static final String PROCEDURE_INSERT_ROL = "{CALL CRUD_roles_PKG.Insertar_Rol_SP(?)}";
    public void insertarRol(String nombre) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_ROL)) {
            statement.setString(1, nombre);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rol insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_ROLES = "{CALL CRUD_roles_PKG.Listar_Rol_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Rol> Listarrol() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Rol> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_ROLES);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Rol rol = new Rol();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            rol.setID_Rol(rs.getInt("ID_ROL"));
            rol.setDescripcion_Rol(rs.getString("Descripcion_Rol"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(rol);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
    }

    private static final String PROCEDURE_DELETE_ROL = "{CALL CRUD_roles_PKG.Eliminar_Rol_SP(?)}";
    public void eliminarRol(int idRol){
        // Llamar al procedimiento almacenado para eliminar el Rol
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_ROL);
            statement.setInt(1, idRol);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_ROL = "{CALL CRUD_roles_PKG.Actualizar_Rol_SP(?,?)}";
    public void actualizarRol(int idRol, String nombre) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_ROL);
            statement.setInt(1, idRol); // Primer parámetro: ID del cliente
            statement.setString(2, nombre);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static String obtenerDescripcionRolPorID(int idRol, List<Rol> roles) {
        for (Rol rol : roles) {
            if (rol.getID_Rol() == idRol) {
                return rol.getDescripcion_Rol();
            }
        }
        return null; // Devuelve null si no se encuentra el rol con el ID especificado
    }
    
    public static int obtenerIdPorDescripcionr(String descripcionRol,List<Rol> roles) {
        for (Rol rol : roles) {
            if (rol.getDescripcion_Rol().equalsIgnoreCase(descripcionRol)) {
                return rol.getID_Rol(); // Devolver el ID del rol encontrado
            }
        }
        return -1; // Si no se encuentra el rol, devolver -1 o lanzar una excepción
    }
}
