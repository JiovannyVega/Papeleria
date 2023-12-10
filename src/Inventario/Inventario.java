/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import Metodos.Conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import papeleria.Menu;
import papeleria.Ventas;

/**
 *
 * @author Rodrigo
 */
public class Inventario extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    DefaultTableModel model;
    
    private TableRowSorter tabInventario;

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        iniciarTabla();
        setFiltro();
        this.setLocationRelativeTo(null);
    }

    private void iniciarTabla() {
        String id = "", Nombre = "", PrecioU = "";
        int Stock = 0;

        
        model = new DefaultTableModel();
        tablaInventario.setModel(model);

        model.addColumn("id");
        model.addColumn("Nombre");
        model.addColumn("Precio/U");
        model.addColumn("Stock");
        
        ResultSet rs = null;
        rs = conexion.TablaInventario(rs);
        
        try {
            while (rs.next()) {
                id = rs.getString("id");
                Nombre = rs.getString("nombre");
                PrecioU = rs.getString("precio_unitario");
                Stock = rs.getInt("cantidad_stock");
                
                model.addRow(new Object[]{id, Nombre, "$" + PrecioU, Stock});
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        
        TableColumnModel columnModel = tablaInventario.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(0).setMaxWidth(50);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(2).setMaxWidth(60);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(3).setMaxWidth(40);
    }
    
    private void setFiltro() {
        tabInventario = new TableRowSorter(tablaInventario.getModel());
        tablaInventario.setRowSorter(tabInventario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        btnProductos = new javax.swing.JButton();
        btnMaterial = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBucar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        check40 = new java.awt.Checkbox();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaInventario.setBackground(new java.awt.Color(235, 198, 83));
        tablaInventario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaInventario.setForeground(new java.awt.Color(0, 0, 0));
        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio/U", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaInventario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 560, 130));

        btnProductos.setBackground(new java.awt.Color(235, 198, 83));
        btnProductos.setForeground(new java.awt.Color(0, 0, 0));
        btnProductos.setText("Nuevos Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 410, -1, -1));

        btnMaterial.setBackground(new java.awt.Color(235, 198, 83));
        btnMaterial.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterial.setText("Pedir Material");
        btnMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialActionPerformed(evt);
            }
        });
        getContentPane().add(btnMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(235, 198, 83));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        txtBucar.setBackground(new java.awt.Color(235, 198, 83));
        txtBucar.setForeground(new java.awt.Color(0, 0, 0));
        txtBucar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBucar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBucarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBucarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBucarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBucar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿Que articulos desea agregar a su inventario?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 350, 16));

        btnRegresar.setBackground(new java.awt.Color(235, 198, 83));
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 198, 83)));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 30));

        check40.setBackground(new java.awt.Color(235, 198, 83));
        check40.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        check40.setLabel("40% Producto");
        getContentPane().add(check40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario2.PNG"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        Pedir abrir = new Pedir();
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        Añadir abrir = new Añadir();
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu abrir = new Menu();
        abrir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtBucarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBucarKeyTyped
        tabInventario.setRowFilter(RowFilter.regexFilter(txtBucar.getText(), 1));
    }//GEN-LAST:event_txtBucarKeyTyped

    private void txtBucarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBucarKeyPressed
        //tabInventario.setRowFilter(RowFilter.regexFilter(txtBucar.getText(), 1));
    }//GEN-LAST:event_txtBucarKeyPressed

    private void txtBucarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBucarKeyReleased
        //tabInventario.setRowFilter(RowFilter.regexFilter(txtBucar.getText(), 1));
    }//GEN-LAST:event_txtBucarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMaterial;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRegresar;
    private java.awt.Checkbox check40;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JTextField txtBucar;
    // End of variables declaration//GEN-END:variables
}
