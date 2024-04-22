package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class CategoriaDAO {
    private static final String PROCEDURE_INSERT_CATEGORIA = "{CALL CRUD_catogorias_PKG.INSERTAR_CATEGORIA_SP(?)}";
    public void insertarCategoria(String descripcion) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_CATEGORIA)) {
            statement.setString(1, descripcion);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e.toString());
        }
    }
    /*Llamada del procedimiento almacenado que recibi 1 parametro*/
    private static final String PROCEDURE_LIST_CATEGORIA = "{CALL CRUD_categorias_PKG.LISTAR_CATEGORIA_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Categoria> ListarCategoria() {
    /*Crea una lista vacía para almacenar los objetos */   
    List<Categoria> lista = new ArrayList<>();
    try (Connection connection = Conexion.obtenerConexion()) {
        /*Se verifica la conexion y se prepara una consulta de los datos*/
        CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_CATEGORIA);
        /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
        statement.registerOutParameter(1, OracleTypes.CURSOR);
         /*Se ejecuta el procedimiento almacenado*/
        statement.execute();
        /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
        ResultSet rs = (ResultSet) statement.getObject(1);
        /*Itera sobre cada fila del ResultSet*/
        while (rs.next()) {
            /*Crea un nuevo objeto Categoria para almacenar los datos de un categoria recuperado de la DB*/
            Categoria categoria = new Categoria();
            /*Establece los atributos del objeto Categoria utilizando los valores recuperados del ResultSet*/
            categoria.setID_Categoria(rs.getInt("ID_CATEGORIA"));
            categoria.setDescripcion_Categoria(rs.getString("DESCRIPCION_CATEGORIA"));
            /*Agrega el objeto Categoria a la lista de categorias*/
            lista.add(categoria);
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
    /*Devuelve la lista de categorias recuperada de la DB*/
    return lista;
}
    private static final String PROCEDURE_DELETE_CATEGORIA = "{CALL CRUD_categorias_PKG.ELIMINAR_CATEGORIA_SP(?)}";
    public void eliminarCategoria(int idCategoria){
        // Llamar al procedimiento almacenado para eliminar el categoria
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_CATEGORIA);
            statement.setInt(1, idCategoria);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_CATEGORIA = "{CALL CRUD_categorias_PKG.ACTUALIZAR_CATEGORIA_SP(?, ?)}";
    public void actualizarCategoria(int idCategoria, String descripcion) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_CATEGORIA);
            statement.setInt(1, idCategoria); // Primer parámetro: ID del categoria
            statement.setString(2, descripcion);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static String obtenerDescripcionCategoriaPorID(int idCategoria, List<Categoria> categorias) {
        for (Categoria categoria : categorias) {
            if (categoria.getID_Categoria() == idCategoria) {
                return categoria.getDescripcion_Categoria();
            }
        }
        return null; // Devuelve null si no se encuentra la sucursal con el ID especificado
    }
    
    public static int obtenerIdPorDescripcion(String descripcionCategoria, List<Categoria> categorias) {
        for (Categoria categoria : categorias) {
            if (categoria.getDescripcion_Categoria().equalsIgnoreCase(descripcionCategoria)) {
                return categoria.getID_Categoria(); // Devolver el ID del rol encontrado
            }
        }
        return -1; 
        }
}

