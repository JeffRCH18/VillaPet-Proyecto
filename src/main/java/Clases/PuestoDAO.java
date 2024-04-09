package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class PuestoDAO {
     private static final String PROCEDURE_LIST_PUESTO = "{CALL LISTAR_PUESTO(?)}";
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
            System.out.println("Se ha agregado un puesto: " + puesto.getID_Puesto() + " - " + puesto.getDescripcion_Puesto());
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de clientes recuperada de la DB*/
    return lista;
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
}
