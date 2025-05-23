
package clases;

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

/**
 *
 * @author shand
 */
public class Ventadet extends javax.swing.JFrame {

    /**
     * Creates new form ClientList
     */
    public Ventadet() {
        initComponents();
        mostrardatos("Todas");
        this.setLocationRelativeTo(null);
    }
    public void limpiarpantalla(){
    }
    public void mostrardatos(String periodo){
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("FOLIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("TOTAL");
        modelo.addColumn("GANANCIA");
        TbClientes.setModel(modelo);
        String sql="";
        String sql1="";
        String sql2="";
        if (periodo.equals("Todas")){
        sql="SELECT * FROM venta_detalle";
        sql1="SELECT SUM(Ganancia) AS TotalGanancia FROM venta_detalle;";
        sql2="SELECT SUM(Total) AS TotalGanancia FROM venta_detalle;";
        }else if(periodo.equals("semana")){
        sql="SELECT * FROM venta_detalle WHERE WEEK(Fecha) = WEEK(CURDATE()) AND YEAR(Fecha) = YEAR(CURDATE());";
        sql1="SELECT SUM(Ganancia) AS TotalGanancia FROM venta_detalle WHERE WEEK(Fecha) = WEEK(CURDATE()) AND YEAR(Fecha) = YEAR(CURDATE());";
        sql2="SELECT SUM(Total) AS TotalGanancia FROM venta_detalle WHERE WEEK(Fecha) = WEEK(CURDATE()) AND YEAR(Fecha) = YEAR(CURDATE());";
        }else if(periodo.equals("dia")){
        sql="SELECT * FROM venta_detalle WHERE DATE(Fecha) = CURDATE();";
        sql1="SELECT SUM(Ganancia) AS TotalGanancia FROM venta_detalle WHERE DATE(Fecha) = CURDATE();";
        sql2="SELECT SUM(Total) AS TotalGanancia FROM venta_detalle WHERE DATE(Fecha) = CURDATE();";
        }
        else if(periodo.equals("mes")){
        sql="SELECT * FROM venta_detalle WHERE Fecha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";   
        
        sql1="SELECT SUM(Ganancia) AS TotalGanancia FROM venta_detalle WHERE Fecha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";
        sql1="SELECT SUM(Total) AS TotalGanancia FROM venta_detalle WHERE Fecha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";
        }
        try{
        Object [] datos=new Object [4];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        float ganancia=0, totalv=0;
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            totalv =totalv+Float.parseFloat(rs.getString(3));
            datos[3]=rs.getString(4);
            ganancia =ganancia+Float.parseFloat(rs.getString(4));
            modelo.addRow(datos); }
        
        /*rs=st.executeQuery(sql1);
        float ganancia = rs.getFloat("TotalGanancia");*/
        JT1.setText(ganancia+"");
        JT2.setText(totalv+"");
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        }catch (SQLException ex){
            Logger.getLogger(Ventadet.class.getName()).log(Level.SEVERE,null,ex);
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
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        JT1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JT2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

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

        TbClientes.setBackground(new java.awt.Color(0, 204, 204));
        TbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbClientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TbClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 450, 380));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Corte de caja");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 40));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 90, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Periodo de corte");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 150, 30));

        jButton1.setBackground(new java.awt.Color(25, 214, 210));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Semana");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, -1));

        jButton2.setBackground(new java.awt.Color(25, 214, 210));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Dia");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 90, -1));

        jButton4.setBackground(new java.awt.Color(25, 214, 210));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Mes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 90, -1));
        jPanel1.add(JT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 110, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ganancia");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));
        jPanel1.add(JT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 110, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total venta");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed

    }//GEN-LAST:event_SeleccionarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrardatos("semana");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        mostrardatos("dia");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mostrardatos("mes");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventadet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventadet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JT1;
    private javax.swing.JTextField JT2;
    private javax.swing.JMenuItem Seleccionar;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=cc.conexion();
}
