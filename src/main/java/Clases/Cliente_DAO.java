package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
public class Cliente_DAO extends Cliente{
    /*private static final String SQL_INSERT_CLIENTE = "INSERT INTO Tab_Cliente (Nombre_Cliente,Apellido,Direccion_Cliente,Correo_Cliente,Telefono_Cliente) VALUES (?,?,?,?,?)" ;
       public void registrar_cliente(String nombre, String apellido, String direccion, String correo, int telefono) {
        try {
            PreparedStatement ps = Conexion.obtenerConexion().prepareStatement(SQL_INSERT_CLIENTE);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, direccion);
            ps.setString(4, correo);
            ps.setInt(5,telefono);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }*/
    private static final String PROCEDURE_INSERT_CLIENTE = "{CALL insertar_cliente(?, ?, ?, ?, ?)}";
    public void insertarCliente(String nombre, String apellido, String direccion, String correo, int telefono) {
        try (Connection connection = Conexion.obtenerConexion();
            CallableStatement statement = connection.prepareCall(PROCEDURE_INSERT_CLIENTE)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, direccion);
            statement.setString(4, correo);
            statement.setInt(5, telefono);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e.getMessage());
        }
    }
       
}
