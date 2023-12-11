/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleria;

import Metodos.Conexion;
import Metodos.TablaProductos;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Rodrigo
 */
public class Historial extends javax.swing.JFrame {

    DefaultTableModel modelTabla;
    Conexion conexion = new Conexion();

    Map<Integer, TablaProductos> productos = new HashMap<Integer, TablaProductos>();
    Map<String, Integer> mapa = new HashMap<>(0);
    Map<Integer, Integer> mapaCantidad = new HashMap<>();

    /**
     * Creates new form Vender
     */
    public Historial() {
        initComponents();
        iniciarCombobox();
        iniciarTabla();
        this.setLocationRelativeTo(null);
        /*
        for (Map.Entry<Integer, TablaProductos> entry : productos.entrySet()) {
            System.out.println(entry.getValue().getNombre());
        }*/
    }

    private void iniciarCombobox() {
        String Nombre = "";
        double PrecioU = 0.0;
        int id = 0, Stock = 0;

        ResultSet rs = null;
        rs = conexion.TablaInventario(rs, true);

        try {
            while (rs.next()) {
                id = rs.getInt("id");
                Nombre = rs.getString("nombre");
                PrecioU = rs.getDouble("precio_unitario");
                Stock = rs.getInt("cantidad_stock");

                mapa.put(rs.getString("nombre"), rs.getInt("id"));
                productos.put(id, new TablaProductos(id, Stock, PrecioU, Nombre));

            }
        } catch (Exception err) {
            System.out.println(err);
        }

    }

    private void iniciarTabla() {
        modelTabla = new DefaultTableModel();
        tablaCarrito.setModel(modelTabla);

        modelTabla.addColumn("id");
        modelTabla.addColumn("Nombre");
        modelTabla.addColumn("Precio/U");
        modelTabla.addColumn("Cantidad");
        modelTabla.addColumn("Precio/T");

        TableColumnModel columnModel = tablaCarrito.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(0).setMaxWidth(50);

        //modelTabla.addRow(new Object[]{});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaCarrito.setBackground(new java.awt.Color(235, 198, 83));
        tablaCarrito.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaCarrito.setForeground(new java.awt.Color(0, 0, 0));
        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Pieza/U", "Pieza/T"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCarrito.setCellSelectionEnabled(true);
        tablaCarrito.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaCarrito);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 800, 170));

        btnVolver.setBackground(new java.awt.Color(235, 198, 83));
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 198, 83)));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario2.PNG"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Ventas abrir = new Ventas();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCarrito;
    // End of variables declaration//GEN-END:variables

}
