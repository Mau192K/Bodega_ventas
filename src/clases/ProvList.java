package clases;

import static clases.ProductList.CKName;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProvList extends javax.swing.JFrame {

    public ProvList() {
        initComponents();
        mostrardatos("vacio");
        this.setLocationRelativeTo(null);
    }
public void limpiarpantalla(){
        Nombreprov.setText("");
        Claveprov.setText("");
    }
    public void mostrardatos(String valor){
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Clave");
        modelo.addColumn("Proveedor");
        TbClientes.setModel(modelo);
        String sql="";
        if (valor.equals("vacio")| valor.equals("")|valor.equals(null)) {
        sql="SELECT * FROM proveedores";    
        } else {
            if (CKName(valor)) {
            sql="SELECT * FROM proveedores where Claveprov="+valor+"";   
            }else{
            sql="SELECT * FROM proveedores WHERE Nombreprov='" + valor + "'"; 
            }
            
        }
        try{
        Object [] datos=new Object [2];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
         if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No se encontro el proveedor con ese nombre o ID");   
            }else{
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            modelo.addRow(datos);
               
        
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        }}}catch (SQLException ex){
            Logger.getLogger(ProvList.class.getName()).log(Level.SEVERE,null,ex);
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
        Seleccionar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Claveprov = new javax.swing.JTextField();
        Nombreprov = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        limp = new javax.swing.JButton();
        Busqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MT = new javax.swing.JButton();
        Buscar1 = new javax.swing.JButton();

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Seleccionar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(189, 242, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbClientes.setBackground(new java.awt.Color(172, 255, 255));
        TbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbClientes.setComponentPopupMenu(jPopupMenu1);
        TbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 470, 290));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Lista de proveedores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Buscar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        Claveprov.setEditable(false);
        Claveprov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Claveprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 160, -1));

        Nombreprov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Nombreprov, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 160, -1));

        jButton2.setBackground(new java.awt.Color(25, 214, 210));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Clave del proveedor:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        limp.setBackground(new java.awt.Color(25, 214, 210));
        limp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        limp.setForeground(new java.awt.Color(255, 255, 255));
        limp.setText("Limpiar");
        limp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpActionPerformed(evt);
            }
        });
        jPanel1.add(limp, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, -1));

        Busqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 140, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Nombre del proveedor:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        MT.setBackground(new java.awt.Color(25, 214, 210));
        MT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MT.setForeground(new java.awt.Color(255, 255, 255));
        MT.setText("Mostrar Todos");
        MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTActionPerformed(evt);
            }
        });
        jPanel1.add(MT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        Buscar1.setBackground(new java.awt.Color(25, 214, 210));
        Buscar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Buscar1.setForeground(new java.awt.Color(255, 255, 255));
        Buscar1.setText("Buscar");
        Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       
        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            boolean nuevo=true;
        String i="SELECT*FROM `proveedores` order by ClaveProv desc limit 1;";
        int ID=0;
        com.mysql.jdbc.Statement st=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs=st.executeQuery(i);
            while (rs.next()) {
            ID=Integer.parseInt(rs.getString(1))+1;}
            com.mysql.jdbc.Statement st2=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs2=st2.executeQuery("SELECT*FROM `proveedores`");
            while (rs2.next()) {
            String datos=rs2.getString(2);
                if (datos.equals(Nombreprov.getText())) {
                    nuevo=false;
                    break;
                }
            }
            if(nuevo){
            PreparedStatement pst= cn.prepareStatement("INSERT INTO proveedores (ClaveProv,Nombreprov)values(?,?)");
            pst.setString(1, ID+"");
            pst.setString(2, Nombreprov.getText());

            pst.executeUpdate();
            mostrardatos("");
            limpiarpantalla();}
            else{
                JOptionPane.showMessageDialog(null, "Proveedor ya registrado anteriormente");
            }
        }catch(Exception e){
            System.out.println(e);
             
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpActionPerformed
        // TODO add your handling code here:
        limpiarpantalla();
    }//GEN-LAST:event_limpActionPerformed

    private void TbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientesMouseClicked
                int fila=TbClientes.getSelectedRow();
        if (fila>=0){           
            Claveprov.setText(TbClientes.getValueAt(fila,0).toString());
            Nombreprov.setText(TbClientes.getValueAt(fila,1).toString());     
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó fila");
        }
    }//GEN-LAST:event_TbClientesMouseClicked

    private void MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTActionPerformed
        // TODO add your handling code here:
        mostrardatos("vacio");
    }//GEN-LAST:event_MTActionPerformed

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        // TODO add your handling code here:
        mostrardatos(Busqueda.getText());
    }//GEN-LAST:event_Buscar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProvList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProvList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProvList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProvList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProvList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar1;
    private javax.swing.JTextField Busqueda;
    private javax.swing.JTextField Claveprov;
    private javax.swing.JButton MT;
    private javax.swing.JTextField Nombreprov;
    private javax.swing.JMenuItem Seleccionar;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limp;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=cc.conexion();
}
