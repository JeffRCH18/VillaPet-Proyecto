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

public class PagoDAO {
    private static final String PROCEDURE_INSERT_PAGO = "{CALL CRUD_pago_PKG.INSERTAR_PAGO_SP(?, ?, ?)}";
    public void insertarPago(int ID_Proveedor, int Monto, LocalDate fecha) {
        try (Connection connection = Conexion.obtenerConexion();
            /*Se verifica la conexion y se prepara una consulta con los datos recibidos en el metodo desde la interfaz*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_PAGO)) {
            statement.setInt(1, ID_Proveedor);
            statement.setInt(2, Monto);
            java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);
            statement.setDate(3, sqlDate);
            /*Se ejecuta el procedimiento almacenado que tiene la consulta insertando en la tsbla sql*/
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pago insertado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        }
    }
    
    private static final String PROCEDURE_LIST_PAGO = "{CALL CRUD_pago_PKG.LISTAR_PAGO_SP(?)}";
    /*Metodo que devuelve una lista de objetos*/
    public List<Pago> ListarPago() {
        /*Crea una lista vacía para almacenar los objetos */   
        List<Pago> lista = new ArrayList<>();
        try (Connection connection = Conexion.obtenerConexion()) {
            /*Se verifica la conexion y se prepara una consulta de los datos*/
            CallableStatement statement = connection.prepareCall(PROCEDURE_LIST_PAGO);
            /*Registra el primer parámetro de salida de la llamada al procedimiento almacenado como un cursor sql*/
            statement.registerOutParameter(1, OracleTypes.CURSOR);
             /*Se ejecuta el procedimiento almacenado*/
            statement.execute();
            /*Obtiene el resultado del procedimiento almacenado en un objeto ResultSet, que contiene los resultados de la consulta a la BD*/
            ResultSet rs = (ResultSet) statement.getObject(1);
            /*Itera sobre cada fila del ResultSet*/
            while (rs.next()) {
                /*Crea un nuevo objeto Cliente para almacenar los datos de un cliente recuperado de la DB*/
                Pago pago = new Pago();
                /*Establece los atributos del objeto Cliente utilizando los valores recuperados del ResultSet*/
                pago.setCod_Pago(rs.getInt("COD_PAGO"));
                pago.setID_Proveedor(rs.getInt("ID_PROVEEDOR"));
                pago.setMonto(rs.getInt("MONTO"));
                Date fechaSql = rs.getDate("FECHA");
                if (fechaSql != null) {
                    pago.setFecha(fechaSql.toLocalDate());
                }
                /*Agrega el objeto Cliente a la lista de clientes*/
                lista.add(pago);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        /*Devuelve la lista de clientes recuperada de la DB*/
        return lista;
    }
    
    private static final String PROCEDURE_DELETE_PAGO = "{CALL CRUD_pago_PKG.ELIMINAR_PAGO_SP(?)}";
    public void eliminarPago(int idPago){
        // Llamar al procedimiento almacenado para eliminar el cliente
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_DELETE_PAGO);
            statement.setInt(1, idPago);
            statement.execute();
        
        } catch (SQLException e) {
        System.out.println(e.toString());
        }
    }
    
    private static final String PROCEDURE_UPDATE_PAGO = "{CALL CRUD_pago_PKG.ACTUALIZAR_PAGO_SP(?, ?, ?)}";
    public void actualizarPago(int COD_Pago, int ID_Proveedor, int Monto) {
        try (Connection connection = Conexion.obtenerConexion()) {
            CallableStatement statement = connection.prepareCall(PROCEDURE_UPDATE_PAGO);
            statement.setInt(1, COD_Pago);
            statement.setInt(2, ID_Proveedor);
            statement.setInt(3, Monto);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public int obtenerPagosProveedor(int idProveedor) {
        int total = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call PagosaProveedor_FN(?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setInt(2, idProveedor);
            statement.execute();
            total = statement.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public int obtenerPagosPorPeriodo(Date fechaInicio, Date fechaFin) {
        int total = 0;
        try ( Connection connection = Conexion.obtenerConexion();  CallableStatement statement = connection.prepareCall("{ ? = call PagosporPeriodo_FN(?, ?) }")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setDate(2, fechaInicio);
            statement.setDate(3, fechaFin);
            statement.execute();
            total = statement.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
}
