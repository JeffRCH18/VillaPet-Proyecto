package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl"; // URL de conexión
    private static final String USUARIO = "VILLAPET"; // Nombre de usuario
    private static final String CONTRASEÑA = "12345"; // Contraseña

    public static Connection obtenerConexion() throws SQLException {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Obtener la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error al conectar con la base de datos", e);
        }
        return conexion;
    }
    }

