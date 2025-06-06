
package clases;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shand
 */
public class Carrito extends javax.swing.JFrame {

    /**
     * Creates new form Carrito
     */
    public Carrito() {
        initComponents();
        mostrardatos();
        this.setLocationRelativeTo(null);
    }
    public void borrar(){
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM ventas");
            pst.executeUpdate();
            mostrardatos ();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void mostrardatos(){
        double total=0;
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("ID Vendedor");
        modelo.addColumn("Clave cliente");
        modelo.addColumn("Clave producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        TbClientes.setModel(modelo);
         String sql="SELECT * FROM ventas";
         try{
        String [] datos=new String [8];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
            modelo.addRow(datos);
            if(datos[4].equals("")){
                total=0;
            }else{
                total=total+Double.parseDouble(datos[4]);
            }
        }
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        Total.setText("$"+Double.toString(total));
        
    }catch(SQLException ex){
                System.out.println(ex);
                }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Borrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        Borrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cruz.png"))); // NOI18N
        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Borrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 242, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbClientes.setBackground(new java.awt.Color(153, 153, 255));
        TbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbClientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TbClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 560, 290));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito-de-compras.png"))); // NOI18N
        jLabel1.setText(" Carrito");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Total:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, 30));

        Total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 90, 30));

        jButton4.setBackground(new java.awt.Color(25, 214, 210));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Confirmar compra");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, 30));

        jButton5.setBackground(new java.awt.Color(25, 214, 210));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Vaciar carrito");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 130, 30));

        jButton6.setBackground(new java.awt.Color(25, 214, 210));
        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Volver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "Confirmar compra", "Confirmar compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op==0){
        int cantidadprod=0,cantidadtotal=0;
        String Stock,Codpro;
        try{
        int filatotal=TbClientes.getRowCount();
        for(int i=0;i<=filatotal;i++){
            int ID=0;
            com.mysql.jdbc.Statement st1=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs1=st1.executeQuery("SELECT*FROM `ventacomp` order by IDventa desc limit 1;");
            while (rs1.next()) {
            ID=Integer.parseInt(rs1.getString(2))+1;
            }
            cantidadprod=Integer.parseInt(TbClientes.getValueAt(i, 3).toString());
            java.sql.PreparedStatement pst1= cn.prepareStatement("INSERT INTO ventacomp (IDUser,IDventa,ClaveCli,ClavePro,Cantidad,Precio)values(?,?,?,?,?,?)");
            pst1.setString(1, TbClientes.getValueAt(i, 0).toString());
            pst1.setString(2, ID+"");
            pst1.setString(3, TbClientes.getValueAt(i, 1).toString());
            pst1.setString(4, TbClientes.getValueAt(i, 2).toString());
            Codpro=TbClientes.getValueAt(i, 2).toString();
            pst1.setString(5, TbClientes.getValueAt(i, 3).toString());
            String precio=TbClientes.getValueAt(i, 4).toString();
            pst1.setString(6,precio);
            Statement st=(Statement) cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT*FROM productos WHERE Codpro='"+Codpro+"'");
            if(rs.next()){
               cantidadtotal=Integer.parseInt(rs.getString(4));  
            }
            Stock=cantidadtotal-cantidadprod+"";
            java.sql.PreparedStatement pst=(PreparedStatement) cn.prepareStatement("UPDATE productos SET Stock='"+Stock+"' WHERE Codpro='"+Codpro+"'");
            pst.executeUpdate();
            pst1.executeUpdate();
            
        }
        }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Compra realizada exitosamente");
               borrar();
                       }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea vaciar el carrito?", "Confirmar vaciar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op==0){
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM ventas");
            pst.executeUpdate();
            mostrardatos ();
        }catch(Exception e){
            System.out.println(e);
        }}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Ventas obj= new Ventas();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este articulo?", "Confirmar borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op==0){
        int fila= TbClientes.getSelectedRow();
        System.out.println(fila);
        String cod=TbClientes.getValueAt(fila, 2).toString();
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM ventas WHERE ClavePro='"+cod+"'");
            pst.executeUpdate();
            mostrardatos ();
        }catch(Exception e){
            System.out.println(e);
        }}
    }//GEN-LAST:event_BorrarActionPerformed

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
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Borrar;
    private javax.swing.JTable TbClientes;
    private javax.swing.JLabel Total;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=(Connection) cc.conexion();
}
