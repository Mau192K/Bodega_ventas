
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MostrarProduct extends javax.swing.JFrame {
    String Catalog;
    public MostrarProduct() {
        initComponents();
        mostrardatos("Vacio");
        this.setLocationRelativeTo(null);
        
    }
   
    private void isANumber(java.awt.event.KeyEvent evt){
      char keytyped = evt.getKeyChar();
      if (!((keytyped >= '0') && (keytyped <= '9') || keytyped==Character.MIN_VALUE) || (keytyped == '\u0000') || (keytyped == '\0') ) {
       //getToolkit().beep(); sonido de error de windows
        evt.consume();
      }
    }
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
        if (Valor.equals("Vacio")) {
        sql="SELECT * FROM productos";    
        } else {
            if (CKName(Valor)) {
            sql="SELECT * FROM productos where IDP="+Valor+"";   
            }else{
            sql="SELECT * FROM productos WHERE Nompreproducto='" + Valor + "'"; 
            }
            
        }
        try{
        Object [] datos=new Object [8];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);    
            
            if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No se encontro el producto con ese nombre o ID");   
            } else {
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
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
            } }
        }catch (SQLException ex){
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public static boolean CKName(String Valor){
        for (char c : Valor.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1130, 290));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Inventario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, -1, -1));

        Buscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 160, -1));

        Bus.setText("Buscar");
        Bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusActionPerformed(evt);
            }
        });
        jPanel1.add(Bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        Mos.setText("Mostrar todos los productos");
        Mos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MosActionPerformed(evt);
            }
        });
        jPanel1.add(Mos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MosActionPerformed
        mostrardatos("Vacio");
        Buscar.setText("");
    }//GEN-LAST:event_MosActionPerformed

    private void BusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusActionPerformed
        String b=Buscar.getText();
        if (b.equals("")) {
            JOptionPane.showMessageDialog(null, "Inserte un dato de busqueda primero"); 
        } else {
        mostrardatos(Buscar.getText());
        Buscar.setText("");
        } 
    }//GEN-LAST:event_BusActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TbClientesMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MostrarProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bus;
    private javax.swing.JTextField Buscar;
    private javax.swing.JButton Mos;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=cc.conexion();
}
