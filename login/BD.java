package login;

import java.sql.*;
import javax.swing.JOptionPane;

public class BD {

    private static Connection Conexion;
    private static final String url = "jdbc:mysql://localhost/prueba";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConexion() {
        try {
            Conexion = DriverManager.getConnection(url, user, password);
            // JOptionPane.showMessageDialog(null, "Conexion establecida");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion en la base de datos");
        }
        return Conexion;
    }

}
