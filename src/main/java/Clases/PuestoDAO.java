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

public class PuestoDAO {
    private static final String PROCEDURE_INSERT_PUESTO = "{CALL Insertar_Puesto_SP(?)}";
    public void insertarPuesto(String nombre) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_PUESTO)) {
            statement.setString(1, nombre);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Puesto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private static final String PROCEDURE_LIST_PUESTO = "{CALL Listar_Puesto_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Puesto> ListarPuesto() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Puesto> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_PUESTO);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
            Puesto puesto = new Puesto();
            /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
            puesto.setID_Puesto(rs.getInt("ID_Puesto"));
            puesto.setDescripcion_Puesto(rs.getString("Descripcion_Puesto"));
            /*Agrega el objeto Cliente a la lista de clientes*/
            lista.add(puesto);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
    }
    
    private static final String PROCEDURE_DELETE_PUESTO = "{CALL Eliminar_Puesto_SP(?)}";
    public void eliminarPuesto(int idPuesto){
        // Llamar al procedimiento almacenado para eliminar el Rol
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_PUESTO);
            statement.setInt(1, idPuesto);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_PUESTO = "{CALL Actualizar_Puesto_SP(?, ?)}";
    public void actualizarPuesto(int idPuesto, String nombre) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_PUESTO);
            statement.setInt(1, idPuesto);
            statement.setString(2, nombre);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static String obtenerDescripcionPuestoPorID(int idPuesto, List<Puesto> puestos) {
        for (Puesto puesto : puestos) {
            if (puesto.getID_Puesto() == idPuesto) {
                return puesto.getDescripcion_Puesto();
            }
        }
        return null; // Devuelve null si no se encuentra el puesto con el ID especificado
    }
    
    public static int obtenerIdPorDescripcionp(String descripcionPuesto, List<Puesto> puestos){
        for (Puesto puesto : puestos) {
            if (puesto.getDescripcion_Puesto().equalsIgnoreCase(descripcionPuesto)) {
                return puesto.getID_Puesto(); // Devolver el ID del rol encontrado
            }
        }
        return -1; // Si no se encuentra el rol, devolver -1 o lanzar una excepción según el caso
    }
    
     public String promedioSalarioPorPuesto() {
        String listaPromediosSalarios = "";
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call PromedioSalarioPorPuesto_FN }")) {
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.execute();
            listaPromediosSalarios = statement.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaPromediosSalarios;
    }
}
