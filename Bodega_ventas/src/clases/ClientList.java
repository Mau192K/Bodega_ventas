
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
public class ClientList extends javax.swing.JFrame {

    /**
     * Creates new form ClientList
     */
    public ClientList() {
        initComponents();
        mostrardatos();
        this.setLocationRelativeTo(null);
    }
    public void limpiarpantalla(){
        Fotoclient.setIcon(null);
        Rutaimg.setText("");
        Nombreclient.setText("");
        IDClient.setText("");
        ClaveClient.setText("");
    }
    public void mostrardatos(){
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("ID");
        modelo.addColumn("Clave");
        modelo.addColumn("RUTA");
        modelo.addColumn("FOTO");
        TbClientes.setModel(modelo);
        String sql="SELECT * FROM clientes";
        try{
        Object [] datos=new Object [5];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            Blob blob = rs.getBlob(5);
            try{
            byte []data = blob.getBytes(1, (int)blob.length());
            BufferedImage image = null;
            InputStream in=new ByteArrayInputStream(data);
            image= ImageIO.read(in);
            ImageIcon imgi= new ImageIcon(image.getScaledInstance(110, 110, 0));
            datos[4]= new JLabel(imgi);
            }catch(Exception ex){
                datos[4]="No Imagen";
            }
            modelo.addRow(datos);
            
        }
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        }catch (SQLException ex){
            Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE,null,ex);
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
        jLabel2 = new javax.swing.JLabel();
        Rutaimg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IDClient = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fotoclient = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nombreclient = new javax.swing.JTextField();
        Rutaarch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ClaveClient = new javax.swing.JTextField();
        Limpiar = new javax.swing.JButton();

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
        jLabel1.setText("Lista de clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("ID del cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        Rutaimg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Rutaimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 180, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Nombre del cliente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        IDClient.setEditable(false);
        IDClient.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(IDClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 160, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Ruta:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, -1));

        Fotoclient.setBackground(new java.awt.Color(0, 204, 204));
        Fotoclient.setOpaque(true);
        jPanel1.add(Fotoclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 160, 160));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Foto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Nombreclient.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Nombreclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 160, -1));

        Rutaarch.setBackground(new java.awt.Color(25, 214, 210));
        Rutaarch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Rutaarch.setForeground(new java.awt.Color(255, 255, 255));
        Rutaarch.setText("Seleccionar foto");
        Rutaarch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Rutaarch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaarchActionPerformed(evt);
            }
        });
        jPanel1.add(Rutaarch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 150, 40));

        jButton1.setBackground(new java.awt.Color(25, 214, 210));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 420, 80, -1));

        jButton2.setBackground(new java.awt.Color(25, 214, 210));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 90, -1));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

        jButton4.setBackground(new java.awt.Color(25, 214, 210));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 450, 80, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Clave del cliente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, -1));
        jPanel1.add(ClaveClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 160, -1));

        Limpiar.setBackground(new java.awt.Color(25, 214, 210));
        Limpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RutaarchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaarchActionPerformed
        // TODO add your handling code here:
        JFileChooser archivo= new JFileChooser();
        int ventana= archivo.showOpenDialog(null);
        if (ventana== JFileChooser.APPROVE_OPTION){
            File file=archivo.getSelectedFile();
            Rutaimg.setText(String.valueOf(file));
            Image foto=getToolkit().getImage(Rutaimg.getText());
            foto=foto.getScaledInstance(160, 160, Image.SCALE_DEFAULT);
            Fotoclient.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_RutaarchActionPerformed

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        // TODO add your handling code here:
        int fila=TbClientes.getSelectedRow();
        if (fila>=0){
            Nombreclient.setText(TbClientes.getValueAt(fila,0).toString());
            IDClient.setText(TbClientes.getValueAt(fila,1).toString());
            ClaveClient.setText(TbClientes.getValueAt(fila,2).toString());
            Rutaimg.setText(TbClientes.getValueAt(fila,3).toString());
            Statement st;
            try {
                st = cn.createStatement();
                ResultSet rs=st.executeQuery("SELECT * FROM clientes WHERE ID='"+IDClient.getText()+"'");
                try{
                BufferedImage image=null;
                if (rs.next()) {
                    com.mysql.jdbc.Blob bytesImagen = (com.mysql.jdbc.Blob) rs.getBlob(5);
                    byte[] data = bytesImagen.getBytes(1, (int) bytesImagen.length());
                    InputStream in= new ByteArrayInputStream(data);
                    image= ImageIO.read(in);
                    ImageIcon imgi=new ImageIcon(image.getScaledInstance(160, 160, 0));
                    Fotoclient.setIcon(imgi);
                }
                }catch(Exception ex){
                    System.out.println();
                        }
            } catch (SQLException ex) {
                Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó fila");
        }
    }//GEN-LAST:event_SeleccionarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea borrar este cliente?", "Confirmar borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       
        if (op==0){
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM clientes WHERE ID ='"+IDClient.getText()+"'");
            pst.executeUpdate();
            mostrardatos ();
            limpiarpantalla();
        }catch(Exception e){
            
        }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
           
            FileInputStream archivofoto;
            PreparedStatement pst= (PreparedStatement)cn.prepareStatement("UPDATE clientes SET Nombre= ?,ID= ?,Clave=?,Ruta=?, Imagen=? WHERE ID='"+IDClient.getText()+"'");
        pst.setString(1, Nombreclient.getText());
        pst.setString(2, IDClient.getText());
        pst.setString(3, ClaveClient.getText());
        pst.setString(4, Rutaimg.getText());
        archivofoto = new FileInputStream (Rutaimg.getText());
        pst.setBinaryStream(5, archivofoto);
        pst.executeUpdate();
        mostrardatos();
        limpiarpantalla();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            String i="SELECT*FROM `clientes` order by ID desc limit 1;";
            int ID=0;
            com.mysql.jdbc.Statement st=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs=st.executeQuery(i);
            while (rs.next()) {
            ID=Integer.parseInt(rs.getString(2))+1;}
            com.mysql.jdbc.Statement st2=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs2=st2.executeQuery("SELECT*FROM `clientes`");
            while (rs2.next()) {
            String datos=rs2.getString(3);
                if (datos.equals(ClaveClient.getText())) {
                    nuevo=false;
                    break;
                }
            }
            if(nuevo){
            FileInputStream archivofoto;
            PreparedStatement pst= cn.prepareStatement("INSERT INTO clientes (Nombre,ID,Clave,Ruta,Imagen)values(?,?,?,?,?)");
            pst.setString(1, Nombreclient.getText());
            pst.setString(2, ID+"");
            pst.setString(3, ClaveClient.getText());
            pst.setString(4, Rutaimg.getText());
            archivofoto = new FileInputStream(Rutaimg.getText());
            pst.setBinaryStream(5, archivofoto);
            pst.executeUpdate();
            mostrardatos();
            limpiarpantalla();
            }else{
               JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa clave"); 
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Foto de perfil pesada para el sistema");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:
        limpiarpantalla();
    }//GEN-LAST:event_LimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClaveClient;
    private javax.swing.JLabel Fotoclient;
    private javax.swing.JTextField IDClient;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextField Nombreclient;
    private javax.swing.JButton Rutaarch;
    private javax.swing.JTextField Rutaimg;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=cc.conexion();
}
