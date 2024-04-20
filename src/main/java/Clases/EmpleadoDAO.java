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
private static final String PROCEDURE_INSERT_EMPLEADO = "{CALL INSERTAR_EMPLEADO_SP(?, ?, ?, ?, ?, ?, ?, ?)}";
    public void insertarEmpleado(int ID_Puesto,int ID_Rol, String Nombre_Empleado, String Apellido, String Correo, String Contraseña, int Salario, int ID_Sucursal) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_EMPLEADO)) {
            statement.setInt(1, ID_Puesto);
            statement.setInt(2, ID_Rol);
            statement.setString(3, Nombre_Empleado);
            statement.setString(4, Apellido);
            statement.setString(5, Correo);
            statement.setString(6, Contraseña );
            statement.setInt(7, Salario);
            statement.setInt(8, ID_Sucursal);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_EMPLEADO = "{CALL LISTAR_EMPLEADO_SP(?)}";
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
    private static final String PROCEDURE_DELETE_EMPLEADO = "{CALL ELIMINAR_EMPLEADO_SP(?)}";
    public void eliminarEmpleado(int idEmpleado){
        // Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_EMPLEADO);
            statement.setInt(1, idEmpleado);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_EMPLEADO = "{CALL ACTUALIZAR_EMPLEADO_SP(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
    public void actualizarEmpleado(int ID_Empleado, int ID_Puesto,int ID_Rol, String Nombre_Empleado, String Apellido, String Correo, String Contraseña, int Salario, int ID_Sucursal) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_EMPLEADO);
            statement.setInt(1, ID_Empleado);
            statement.setInt(2, ID_Puesto);
            statement.setInt(3, ID_Rol);
            statement.setString(4, Nombre_Empleado);
            statement.setString(5, Apellido);
            statement.setString(6, Correo);
            statement.setString(7,Contraseña);
            statement.setInt(8,Salario);
            statement.setInt(9,ID_Sucursal );
            
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static int obtenerIdPorNombre(String nombre,List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre_Empleado().equalsIgnoreCase(nombre)) {
                return empleado.getID_Empleado(); // Devolver el ID del rol encontrado
            }
        }
        return -1; // Si no se encuentra el rol, devolver -1 o lanzar una excepción
    }
    
    public static String obtenerNombrePorID(int idEmpleado, List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.getID_Empleado() == idEmpleado) {
                return empleado.getNombre_Empleado();
            }
        }
        return null; // Devuelve null si no se encuentra el rol con el ID especificado
    }

    public String listarEmpleadosPorRangoSalario(double salarioMinimo, double salarioMaximo) {
        String listaEmpleados = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call ListarEmpleadosPorRangoSalario_FN(?, ?) }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setDouble(2, salarioMinimo);
            statement.setDouble(3, salarioMaximo);
            statement.execute();
            listaEmpleados = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaEmpleados;
    }
    
    private static final String FUNCTION_EMPLEADOS_POR_SUCURSAL = "{ ? = call EmpleadosporSucursal(?) }";
    public int contarEmpleadosPorSucursal(int idSucursal) {
        int conteoEmpleados = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall(FUNCTION_EMPLEADOS_POR_SUCURSAL)) {
            // Configuración de parámetros
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idSucursal);
            // Ejecución de la llamada
            statement.execute();
            // Obtención del resultado
            conteoEmpleados = statement.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conteoEmpleados;
    }
}


