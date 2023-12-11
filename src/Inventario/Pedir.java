/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import Metodos.Conexion;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Rodrigo
 */
public class Pedir extends javax.swing.JFrame {
    
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    Conexion conexion = new Conexion();
    
    Map<String, Integer> mapa = new HashMap<>(0);
    Map<Integer, Integer> stock = new HashMap<>(0);
    
    public Pedir() {
        initComponents();
        iniciarCombobox();
        this.setLocationRelativeTo(null);
    }
    
    private void iniciarCombobox() {
        ResultSet rs = null;
        rs = conexion.TablaInventario(rs, true);
        
        try {
            while (rs.next()) {
                mapa.put(rs.getString("nombre"), rs.getInt("id"));
                stock.put(rs.getInt("id"), rs.getInt("cantidad_stock"));
                //id = rs.getString("id");
                model.addElement(rs.getString("nombre"));
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        
        AutoCompleteDecorator.decorate(comboProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStockActual = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        spinnerCantidad = new javax.swing.JSpinner();
        comboProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cantidad:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, -1));

        txtStockActual.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txtStockActual.setForeground(new java.awt.Color(0, 0, 0));
        txtStockActual.setText("Stock actual: 0");
        getContentPane().add(txtStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jButton4.setBackground(new java.awt.Color(235, 198, 83));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Regresar");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 198, 83)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, 30));

        btnAgregar.setBackground(new java.awt.Color(235, 198, 83));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 90, -1));

        spinnerCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(235, 198, 83), 2, true));
        getContentPane().add(spinnerCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 50, 30));

        comboProducto.setBackground(new java.awt.Color(153, 153, 0));
        comboProducto.setEditable(true);
        comboProducto.setModel(model);
        comboProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(235, 198, 83), 3, true));
        comboProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProductoItemStateChanged(evt);
            }
        });
        getContentPane().add(comboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 170, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario.PNG"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Inventario abrir=new Inventario();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProductoItemStateChanged
        //System.out.println(mapa.get(comboProducto.getSelectedItem()));
        txtStockActual.setText("Stock actual: " + stock.get(mapa.get(comboProducto.getSelectedItem())));
    }//GEN-LAST:event_comboProductoItemStateChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int id = mapa.get(comboProducto.getSelectedItem().toString());
        Conexion conexionStock = new Conexion();
        
        conexionStock.addStock(id, (Integer) spinnerCantidad.getValue());
        stock.put(id, conexionStock.getStock(mapa.get(comboProducto.getSelectedItem().toString())));
        txtStockActual.setText("Stock actual: " + stock.get(mapa.get(comboProducto.getSelectedItem().toString())));
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JLabel txtStockActual;
    // End of variables declaration//GEN-END:variables
}
