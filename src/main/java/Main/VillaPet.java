package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion;
import Swing.JFAcceso;

public class VillaPet {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        iniciarAPP();
    }
    
    public static void iniciarAPP(){
        JFAcceso Login = new JFAcceso();
        Login.setVisible(true);
        Login.setLocationRelativeTo(null);
    }
}
