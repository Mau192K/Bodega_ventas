
package clases;


import static clases.ProductList.CKName;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class ReaVent extends javax.swing.JFrame {
public int ID=0;
conectar cc=new conectar();
Connection cn=cc.conexion();
int Exis;
public String IDP="";
public String Nom="";
String usuario;
    public ReaVent(String User) {
        this.usuario=User;
        initComponents();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    TbClientes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
    TbClientes.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
    TbClientes.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
    TbClientes.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
    TbClientes.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        mostrardatos("Vacio");
         
         
    }
     public static boolean CKName(String Valor){
        for (char c : Valor.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
     public void Obdet(String Valor){
        String sql="";
            if (CKName(Valor)) {
            sql="SELECT * FROM productos where IDP="+Valor+"";   
            }else{
            sql="SELECT * FROM productos WHERE Nompreproducto='" + Valor + "'"; 
            }
        
        try{
        Object [] datos=new Object [8];
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);    
            
            if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No se encontro el producto con ese nombre o ID");   
            } else {
            while(rs.next()){
            //IDP
            datos[0]=rs.getString(1);
            IDP=(String)datos[0];
            //Nombre
            datos[1]=rs.getString(2);
            Nom=(String)datos[1];
            //Existencias
            datos[3]=rs.getString(4);
            //Precio Venta
            datos[5]=rs.getString(6);
            Pre.setText(datos[5].toString());
            //Ganancia
            datos[6]=rs.getString(7);
            Pre2.setText(datos[6].toString());
            } }
        }catch (SQLException ex){
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
   
    public void mostrardatos(String Valor){
    String sentencia = "Vacio";    
     
            try{
     String i="SELECT*FROM `venta` order by Folio desc limit 1;";
     com.mysql.jdbc.Statement st=(com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs=st.executeQuery(i);
            
            while (rs.next()) {
            ID=Integer.parseInt(rs.getString(1))+1;}
            Clavepro.setText(ID+"");
        }catch(Exception e){
            System.out.println(e);
        
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        Clavepro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JT2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JT1 = new javax.swing.JTextField();
        Ven = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Pre = new javax.swing.JTextField();
        Pre1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Pre2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pre3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        Ven1 = new javax.swing.JButton();
        Ven2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 242, 224));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dolar.png"))); // NOI18N
        jLabel1.setText("Realiza Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 40));

        jButton6.setBackground(new java.awt.Color(25, 214, 210));
        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Volver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 90, 30));

        Clavepro.setEditable(false);
        Clavepro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(Clavepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 3, 130, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ganancia total");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, -1, -1));

        JT2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT2ActionPerformed(evt);
            }
        });
        JT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JT2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JT2KeyTyped(evt);
            }
        });
        jPanel1.add(JT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 180, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Agregar producto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 150, -1));

        JT1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JT1ActionPerformed(evt);
            }
        });
        JT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JT1KeyTyped(evt);
            }
        });
        jPanel1.add(JT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 180, 30));

        Ven.setBackground(new java.awt.Color(25, 214, 210));
        Ven.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Ven.setForeground(new java.awt.Color(255, 255, 255));
        Ven.setText("Realizar Venta");
        Ven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenActionPerformed(evt);
            }
        });
        jPanel1.add(Ven, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Folio de la venta");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        Buscar.setBackground(new java.awt.Color(25, 214, 210));
        Buscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar producto");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, 160, 30));
        jPanel1.add(Pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 570, 100, 30));

        Pre1.setToolTipText("");
        jPanel1.add(Pre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Precio Unitario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        Add.setBackground(new java.awt.Color(25, 214, 210));
        Add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Agregar");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, 90, 30));

        Pre2.setToolTipText("");
        jPanel1.add(Pre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 170, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Precio total");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ganancia por unidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

        Pre3.setToolTipText("");
        jPanel1.add(Pre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 130, 30));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 90, 30));

        TbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDP", "Cantidad", "Precio", "Total", "Ganancia", "Producto"
            }
        ));
        jScrollPane3.setViewportView(TbClientes);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 810, 490));

        Ven1.setBackground(new java.awt.Color(25, 214, 210));
        Ven1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Ven1.setForeground(new java.awt.Color(255, 255, 255));
        Ven1.setText("Ver tickets");
        Ven1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ven1ActionPerformed(evt);
            }
        });
        jPanel1.add(Ven1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 660, 140, 30));

        Ven2.setBackground(new java.awt.Color(25, 214, 210));
        Ven2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Ven2.setForeground(new java.awt.Color(255, 255, 255));
        Ven2.setText("Consultar productos");
        Ven2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ven2ActionPerformed(evt);
            }
        });
        jPanel1.add(Ven2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    public void DIS(int cantidad, int idp) {
    String str1 = String.valueOf(idp);
    int NeVal = consuCan(str1) - cantidad;
    String updateQuery = "UPDATE productos SET Existencias='"+NeVal+"' WHERE IDP='"+idp+"'";
    try (PreparedStatement pst = cn.prepareStatement(updateQuery)) {
        pst.executeUpdate();  // Ajustar el valor de ExistenciAA
        int affectedRows = pst.executeUpdate(); // Ejecutar la actualizació
        if (affectedRows > 0) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No se encontró el producto con IDP: " + str1);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
    
    
    
    private void VenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenActionPerformed
    float Tot=0, ganancia=0;
    java.util.Date miObjetoJavaUtilDate = new java.util.Date();
    Timestamp timeestamp = new Timestamp(miObjetoJavaUtilDate.getTime());
    int idp=0; int cantidad=0; float precio=0; float total=0; 
    
    try{
    PreparedStatement pst= cn.prepareStatement("INSERT INTO venta (Folio,IDP,Fecha,Cantidad,Precio,Precio_total)values(?,?,?,?,?,?)"); 
    for (int fila = 0; fila < TbClientes.getRowCount(); fila++) {
            for (int columna = 0; columna < TbClientes.getColumnCount(); columna++) {
            Object valor = TbClientes.getValueAt(fila, columna);   
                System.out.println(columna);
                switch(columna){
                    case 0:
                    idp =  Integer.parseInt(valor.toString());  
                    break;
                    case 1:
                    cantidad =  Integer.parseInt(valor.toString());
                    System.out.println("La cantidad a agregar es:"+cantidad);
                    DIS(cantidad, idp);
                    break;
                    
                    case 2:
                    precio =  Float.parseFloat(valor.toString());
                    break;
                    
                    case 3:
                    Tot = Float.parseFloat(""+valor);
                    total = total+Float.parseFloat(""+valor);      
                    break;
                    
                    case 4:
                    ganancia = ganancia+Float.parseFloat(""+valor);
                    break;
                 } }
            System.out.println("Entro aca");
            int IDEE=Integer.parseInt(Clavepro.getText());
            pst.setString(1, IDEE+"");
            pst.setString(2, ""+idp);
            pst.setTimestamp(3, timeestamp);
            pst.setString(4, ""+cantidad);
            pst.setString(5, ""+precio);
            pst.setString(6, ""+Tot);
            pst.executeUpdate();
            }
    pst= cn.prepareStatement("INSERT INTO venta_detalle (Folio,Fecha,Total,Ganancia)values(?,?,?,?)"); 
    int IDEE=Integer.parseInt(Clavepro.getText());
    pst.setString(1, IDEE+"");
         pst.setTimestamp(2, timeestamp);
            pst.setString(3, ""+total);
            pst.setString(4, ""+ganancia);
            pst.executeUpdate();
    
    DefaultTableModel dm = (DefaultTableModel)TbClientes.getModel();
    dm.getDataVector().removeAllElements();
    dm.fireTableDataChanged();
    
    int CLV=Integer.parseInt(Clavepro.getText());
    ClVen.Impr(""+CLV, ""+timeestamp, ""+total, usuario);
    Clavepro.setText(""+(CLV+1));
    }
catch(Exception e){
    System.out.println(e);}

     
    }//GEN-LAST:event_VenActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
    Obdet(JT1.getText());    
    }//GEN-LAST:event_BuscarActionPerformed
    public int consuCan(String IDP) {
    String sentencia = "SELECT * FROM productos WHERE IDP = ?";
    int cantid = 0;

    try {
        // Usamos PreparedStatement para evitar inyección SQL
        PreparedStatement pst = cn.prepareStatement(sentencia);
        pst.setInt(1, Integer.parseInt(IDP));  // Asumimos que IDP es un String. Convierte si es necesario.

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Verificamos si hay resultados antes de acceder
            cantid = rs.getInt(4); // Asumimos que el cuarto campo es de tipo int
        }

        // Cerramos ResultSet y PreparedStatement
        rs.close();
        pst.close();

    } catch (Exception e) {
        System.out.println(e);
    }

    return cantid;
}
    
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        int cantid = 0;
        int a = 0;
        try {
            a = Integer.parseInt(JT2.getText());
            cantid=consuCan(IDP);
            System.out.println(cantid);
            if (a > cantid || cantid <= 0) {
                JOptionPane.showMessageDialog(null, "Cantidad insuficiente o nula");
            } else {
            String Valor= JT1.getText();    
                if (CKName(Valor)) {   
            DefaultTableModel model = (DefaultTableModel) TbClientes.getModel();
                model.addRow(new Object[]{JT1.getText(), JT2.getText(), Pre.getText(), Pre1.getText(), Pre3.getText(),Nom});
                JT1.setText("");
                JT2.setText("");
                Pre1.setText("");
                Pre.setText("");
                Pre3.setText("");
                Pre2.setText("");
            }else if(!CKName(Valor)){
            String x=CKID(JT1.getText());  
            DefaultTableModel model = (DefaultTableModel) TbClientes.getModel();
                model.addRow(new Object[]{x, JT2.getText(), Pre.getText(), Pre1.getText(), Pre3.getText(),Nom});
                JT1.setText("");
                JT2.setText("");
                Pre1.setText("");
                Pre.setText("");
                Pre3.setText("");
                Pre2.setText("");
            }
                
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }    
    
    }//GEN-LAST:event_AddActionPerformed
    
   
 
    public String CKID(String ID){
    String IDP1="";
    String SQL = "SELECT * FROM productos WHERE Nompreproducto ='"+ID+"'";  
    try{
    Statement st1= cn.createStatement();
    ResultSet rs1=st1.executeQuery(SQL);
      while(rs1.next()){
      IDP1=rs1.getString(1);   
      }
    
   
    }catch(Exception e){
        System.out.println(e);   
    }
    return IDP1;
    }
    
    
    
    private void JT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT2ActionPerformed
    
    
    }//GEN-LAST:event_JT2ActionPerformed

    private void JT2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT2KeyPressed
    int a=0, b=0, c=0;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        a=Integer.parseInt(JT2.getText());
        b=Integer.parseInt(Pre.getText());
        c=Integer.parseInt(Pre2.getText());
    }
        Pre1.setText(""+(a*b));
        Pre3.setText(""+(a*c));
    }//GEN-LAST:event_JT2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    DefaultTableModel TBMODEL = (DefaultTableModel) TbClientes.getModel();
        if (TbClientes.getSelectedRowCount()==1) {
        TBMODEL.removeRow(TbClientes.getSelectedRow());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT1KeyTyped
   /*char c= evt.getKeyChar();
    if (c<'0'||c>'9') evt.consume();*/
    }//GEN-LAST:event_JT1KeyTyped

    private void JT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JT2KeyTyped
    char c= evt.getKeyChar();
    if (c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_JT2KeyTyped

    private void Ven1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ven1ActionPerformed
    PrintTiket obj = new PrintTiket(usuario);
    obj.setVisible(true);
    }//GEN-LAST:event_Ven1ActionPerformed

    private void Ven2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ven2ActionPerformed
    MostrarProduct obj= new MostrarProduct();
        obj.setVisible(true);
    }//GEN-LAST:event_Ven2ActionPerformed

    private void JT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JT1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReaVent("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField Clavepro;
    private javax.swing.JTextField JT1;
    private javax.swing.JTextField JT2;
    private javax.swing.JTextField Pre;
    private javax.swing.JTextField Pre1;
    private javax.swing.JTextField Pre2;
    private javax.swing.JTextField Pre3;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton Ven;
    private javax.swing.JButton Ven1;
    private javax.swing.JButton Ven2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
