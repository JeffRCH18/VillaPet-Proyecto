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

public class EmpleadoDAO {
private static final String PROCEDURE_INSERT_EMPLEADO = "{CALL Insertar_Empleado_SP(?, ?, ?, ?, ?, ?, ?, ?)}";
    public void insertarEmpleado(int ID_Puesto,int ID_Rol, String Nombre_Empleado, String Apellido, String Correo, String Contrasena, int Salario, int ID_Sucursal) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_EMPLEADO)) {
            statement.setInt(1, ID_Puesto);
            statement.setInt(2, ID_Rol);
            statement.setString(3, Nombre_Empleado);
            statement.setString(4, Apellido);
            statement.setString(5, Correo);
            statement.setString(6, Contrasena );
            statement.setInt(7, Salario);
            statement.setInt(8, ID_Sucursal);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_EMPLEADO = "{CALL Listar_Empleado_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Empleado> ListarEmpleado (){
    /*Crea una lista vacía para almacenar los objetos */   
    List<Empleado> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_EMPLEADO);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Empleado empleado = new Empleado();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            empleado.setID_Empleado(rs.getInt("ID_EMPLEADO"));
            empleado.setID_Puesto(rs.getInt("ID_PUESTO"));
            empleado.setID_Rol(rs.getInt("ID_ROL"));
            empleado.setID_Sucursal(rs.getInt("ID_SUCURSAL"));
            empleado.setNombre_Empleado(rs.getString("NOMBRE_EMPLEADO"));
            empleado.setApellido(rs.getString("APELLIDO"));
            empleado.setCorreo(rs.getString("CORREO"));
            empleado.setContrasena(rs.getString("CONTRASENA"));
            empleado.setSalario(rs.getInt("SALARIO"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(empleado);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
}
    private static final String PROCEDURE_DELETE_EMPLEADO = "{CALL Eliminar_Empleado_SP(?)}";
    public void eliminarEmpleado(int ID_Empleado){
        //Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_EMPLEADO);
            statement.setInt(1, ID_Empleado);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
}
