
package clases;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.util.Timer;
import java.util.TimerTask;



public class Login extends javax.swing.JFrame { 
    
public Timer timer = new Timer();

 public void BegCro(){
        // Tarea programada para ejecutarse después de 2 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intentos++;
                Crono=false;
                JOptionPane.showMessageDialog(null, "Ya puede tratar de ingresar sus datos otra vez");
            }
        },15000);    
 }
    private byte Intentos=3;

    private boolean Crono=false;
    public Login() {
        initComponents();
        this.OcultarPass.setVisible(false);
        TextPrompt placeholder = new TextPrompt("Usuario", Usuario);
        TextPrompt placeholder2 = new TextPrompt("Contraseña", Contraseña);
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Sistema = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Inicio_sesion = new javax.swing.JButton();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VerPass = new javax.swing.JLabel();
        OcultarPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 65, 100, 80));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 250, 270));

        Sistema.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Sistema.setText("Sistema ventasPro777");
        jPanel1.add(Sistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 319, 392));

        jPanel2.setBackground(new java.awt.Color(189, 242, 224));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Inicio_sesion.setBackground(new java.awt.Color(25, 214, 210));
        Inicio_sesion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Inicio_sesion.setForeground(new java.awt.Color(255, 255, 255));
        Inicio_sesion.setText("Iniciar sesión");
        Inicio_sesion.setBorder(null);
        Inicio_sesion.setBorderPainted(false);
        Inicio_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inicio_sesionActionPerformed(evt);
            }
        });
        jPanel2.add(Inicio_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 190, 30));

        Usuario.setBackground(new java.awt.Color(189, 242, 224));
        Usuario.setBorder(null);
        jPanel2.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 170, 37));

        Contraseña.setBackground(new java.awt.Color(189, 242, 224));
        Contraseña.setBorder(null);
        jPanel2.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 140, 37));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Iniciar sesión");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 31));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("¿Olvidó su contraseña?");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 170, 30));

        jButton1.setBackground(new java.awt.Color(25, 214, 210));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 60, -1));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 230, 10));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 10));

        jLabel7.setBackground(new java.awt.Color(189, 242, 224));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        jLabel7.setOpaque(true);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 32, 32));

        jLabel8.setBackground(new java.awt.Color(189, 242, 224));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jLabel8.setOpaque(true);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 32, 32));

        VerPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerPassMouseClicked(evt);
            }
        });
        jPanel2.add(VerPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 195, 32, 32));

        OcultarPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OcultarPassMouseClicked(evt);
            }
        });
        jPanel2.add(OcultarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 195, 32, 32));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -4, 338, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "Realmente desea salir?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op==0){
        System.exit(0);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ImageIcon obj=new ImageIcon(getClass().getResource("/Imagenes/Logo.png"));
        ImageIcon icono=new ImageIcon(obj.getImage().getScaledInstance(Logo.getWidth(), Logo.getHeight(), Image.SCALE_AREA_AVERAGING));
        Logo.setIcon(icono);
        ImageIcon obj2=new ImageIcon(getClass().getResource("/Imagenes/ojos-cruzados.png"));
        ImageIcon icono2=new ImageIcon(obj2.getImage().getScaledInstance(OcultarPass.getWidth(), OcultarPass.getHeight(), Image.SCALE_AREA_AVERAGING));
        OcultarPass.setIcon(icono2);
        ImageIcon obj3=new ImageIcon(getClass().getResource("/Imagenes/ojo.png"));
        ImageIcon icono3=new ImageIcon(obj3.getImage().getScaledInstance(VerPass.getWidth(), VerPass.getHeight(), Image.SCALE_AREA_AVERAGING));
        VerPass.setIcon(icono3); 
        
    }//GEN-LAST:event_formWindowActivated

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        boolean Band=true;
        String ref=JOptionPane.showInputDialog("Ingrese su nombre de usuario");
        try{
        if (cn==null) {
            JOptionPane.showMessageDialog(null, "No Conectado");
        } else {
        String []datos=new String[2];
        Statement st=(Statement) cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM Usuarios");
        while (rs.next()) {
        datos[0]=rs.getString(2);
        if(datos[0].equals(ref)){
        datos[1]=rs.getString(3);
        JOptionPane.showMessageDialog(null, "Su contraseña es: "+datos[1]);
        Band=false;
        break;
        }
        }
        if(Band){
        JOptionPane.showMessageDialog(null, "No existe un usuario con ese nombre");    
        }
        }
        }catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void VerPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerPassMouseClicked
        // TODO add your handling code here:
        VerPass.setVisible(false);
        OcultarPass.setVisible(true);
        Contraseña.setEchoChar((char)0);
    }//GEN-LAST:event_VerPassMouseClicked

    private void OcultarPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OcultarPassMouseClicked
        // TODO add your handling code here:
        VerPass.setVisible(true);
        OcultarPass.setVisible(false);
        Contraseña.setEchoChar('*');
    }//GEN-LAST:event_OcultarPassMouseClicked
    static void loadLookAndFeel() {
    try {
        UIManager.put("Menu.background", Color.decode("#BDF2E0"));
        UIManager.put("Menu.foreground", new Color(27, 100, 20));
        
        UIManager.put("Menu.selectionBackground", Color.decode("#90F2E0"));
        UIManager.put("Menu.selectionForeground", Color.BLACK);
        
        UIManager.put("MenuItem.background", Color.decode("#BDF2E0"));
        UIManager.put("MenuItem.selectionBackground", Color.decode("#95FF95"));
        UIManager.put("MenuItem.selectionForeground", Color.BLACK);
        
        UIManager.put("Table.selectionBackground", Color.decode("#BDF2E0"));
        UIManager.put("Table.selectionForeground", Color.BLACK);
              
        UIManager.setLookAndFeel(new MetalLookAndFeel());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    //Aqui se validan los datos
    private void Inicio_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio_sesionActionPerformed

        if (Intentos<=0) {
           if (!Crono) {
            BegCro();    
            Crono=true;
            }
        JOptionPane.showMessageDialog(null, "Número de intentos revasado, por favor espere a la notificacion que indica");    
        } else {
            Intentos--;
            try{
        AdminNegocio obj= new AdminNegocio();  
        if (cn==null) {
            JOptionPane.showMessageDialog(null, "No Conectado");
        }else{
            String []datos=new String[4];
            Statement st=(Statement) cn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM Usuarios");
            while (rs.next()) {
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
                if (datos[1].equals(Usuario.getText())) {
                    if (datos[2].equals(Contraseña.getText())) {
                        this.setVisible(false);
                        obj.setVisible(true);
                        obj.setConfiguracion(datos[1]);
                        obj.setID(datos[0]);
                    }
                }
            }if (this.isVisible()) {
                    JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecta, quedan "+(Intentos)+" intentos");
                }
        }
        }catch (Exception e){
            
        }
        }
        
    }//GEN-LAST:event_Inicio_sesionActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
        loadLookAndFeel();
    });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JButton Inicio_sesion;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel OcultarPass;
    private javax.swing.JLabel Sistema;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel VerPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=(Connection) cc.conexion();
}
