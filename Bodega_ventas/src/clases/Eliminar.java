package clases;

import static clases.ProductList.CKName;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Eliminar extends javax.swing.JFrame {

 public static boolean CKName(String Valor){
        for (char c : Valor.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public Eliminar() {
        initComponents();
        mostrardatos("");
        this.setLocationRelativeTo(null);
    }
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        CP = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        Bus = new javax.swing.JButton();
        Mos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 242, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbClientes.setBackground(new java.awt.Color(255, 204, 153));
        TbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 810, 290));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        CP.setEditable(false);
        CP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 160, -1));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jButton4.setBackground(new java.awt.Color(25, 214, 210));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Clave del producto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        Buscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 160, -1));

        Bus.setText("Buscar");
        Bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusActionPerformed(evt);
            }
        });
        jPanel1.add(Bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, -1, -1));

        Mos.setText("Mostrar todos los productos");
        Mos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MosActionPerformed(evt);
            }
        });
        jPanel1.add(Mos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea borrar este producto?", "Confirmar borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op==0){
            try{
                PreparedStatement pst=(PreparedStatement) cn.prepareStatement("DELETE FROM productos WHERE IDP ='"+CP.getText()+"'");
                pst.executeUpdate();
               mostrardatos("");
            }catch(Exception e){

            }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientesMouseClicked
         int fila= TbClientes.getSelectedRow();
        int op=0;
        String category="";
        if (fila>=0){
        CP.setText(TbClientes.getValueAt(fila, 0).toString());
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó fila");
        }
    }//GEN-LAST:event_TbClientesMouseClicked

    private void BusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusActionPerformed
        mostrardatos(Buscar.getText());
    }//GEN-LAST:event_BusActionPerformed

    private void MosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MosActionPerformed
        mostrardatos("");
    }//GEN-LAST:event_MosActionPerformed

    
    public void mostrardatos(String Valor){
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Clave Producto");
        modelo.addColumn("Descripción");
        modelo.addColumn("Categoría");
        modelo.addColumn("Existencias");
        modelo.addColumn("Precio de compra");
        modelo.addColumn("Precio de venta");
        modelo.addColumn("Ganancia");
        modelo.addColumn("Clave del proveedor");
        TbClientes.setModel(modelo);
        String sql="";
        if (Valor.equals("")) {
        sql="SELECT * FROM productos";    
        } else {
            if (CKName(Valor)) {
            sql="SELECT * FROM productos where IDP="+Valor+"";    
            }else if(!CKName(Valor)){
            sql="SELECT * FROM productos where Nompreproducto="+Valor+"";    
            }else{
             JOptionPane.showMessageDialog(null, "Articulo no encontrado");         
                    }
            
        }
        try{
        Object [] datos=new Object [8];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            datos[5]=rs.getString(6);
            datos[6]=rs.getString(7);
            datos[7]=rs.getString(8);
            modelo.addRow(datos);
        }
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        }catch (SQLException ex){
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }
conectar cc=new conectar();
Connection cn=cc.conexion();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bus;
    private javax.swing.JTextField Buscar;
    private javax.swing.JTextField CP;
    private javax.swing.JButton Mos;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
