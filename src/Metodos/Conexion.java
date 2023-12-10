package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private static Connection con;
    private static Statement st;

    private static String Usuario = "root";
    private static String Password = "Marisol12";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/papeleria", Usuario, Password);
            st = con.createStatement();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static boolean LogIn(String usuario, String contraseña) {
        try {
            usuario = usuario.toUpperCase();
            ResultSet rs = st.executeQuery("SELECT * FROM empleado WHERE usuario = '" + usuario + "' and contraseña ='" + contraseña + "'");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static boolean SignUp(String usuario, String contraseña) {
        try {
            usuario = usuario.toUpperCase();
            ResultSet rs = st.executeQuery("SELECT * FROM empleado WHERE usuario = '" + usuario + "'");
            if (rs.next()) {
                return false;
            } else {
                st.executeUpdate("INSERT INTO empleado(usuario, contraseña) VALUES('" + usuario + "', '" + contraseña + "')");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public static ResultSet TablaInventario(ResultSet rs) {
        try {
            rs = st.executeQuery("SELECT * FROM productos");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

}
