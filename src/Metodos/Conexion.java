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

    public static ResultSet TablaInventario(ResultSet rs, boolean porcentaje) {
        if (porcentaje) {
            try {
                rs = st.executeQuery("SELECT * FROM productos");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                rs = st.executeQuery("SELECT * FROM productos where cantidad_stock < 40");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return rs;
    }

    public static int getStock(int id) {
        int stock = 0;

        try {
            ResultSet rs = st.executeQuery("SELECT cantidad_stock FROM productos WHERE id = " + id);
            rs.next();
            stock = rs.getInt("cantidad_stock");
        } catch (Exception e) {
            System.out.println(e);
        }

        return stock;
    }

    public static void addStock(int id, int cantidad) {
        try {
            st.executeUpdate("UPDATE productos SET cantidad_stock = cantidad_stock + " + cantidad + " where id = " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void comprar(TablaProductos tabla, int cantidad) {
        int id = tabla.getId();
        String nombre = tabla.getNombre();
        double precio_unidad = tabla.getPrecio();
        int stock = getStock(id);
        
        try {
            st.executeUpdate("UPDATE productos SET cantidad_stock = cantidad_stock - " + cantidad + " where id = " + id);
            
            st.executeUpdate("INSERT into venta(id_producto, nombre, precio_unidad, cantidad, precio_total, stock_anterior, stock_nuevo) "
                    + "VALUES(" + id + ", '" + nombre + "', " + precio_unidad + ", " + cantidad + ", " + (cantidad * precio_unidad) + ", " + stock + ", " + (stock - cantidad) + ")");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ResultSet TablaHistorial(ResultSet rs) {
        try {
            rs = st.executeQuery("Select * from venta");
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

}
