/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clases;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import static clases.UpdateProduct.CKName;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class PrintTiket extends javax.swing.JFrame {

    public void mostrardatos(String Valor){
        TbClientes.setDefaultRenderer(Object.class, new TablaImagen());
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Folio");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");
        TbClientes.setModel(modelo);
        String sql="";
        if (Valor.equals("")) {
        sql="SELECT * FROM venta_detalle order by Folio DESC";    
        } else {
            if (CKName(Valor)) {
            sql="SELECT * FROM venta_detalle where Folio="+Valor+"";    
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
            modelo.addRow(datos);
        }
        TbClientes.setModel(modelo);
        TbClientes.setRowHeight(100);
        }catch (SQLException ex){
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    String usuario="";
    public PrintTiket(String User) {
        initComponents();
        this.usuario=User;
        mostrardatos("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JT1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JT2 = new javax.swing.JTextField();
        JT3 = new javax.swing.JTextField();
        JT4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 870, 290));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Ventas realizadas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 40));

        JT1.setEditable(false);
        JT1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(JT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 130, -1));

        jButton2.setBackground(new java.awt.Color(25, 214, 210));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        jButton3.setBackground(new java.awt.Color(25, 214, 210));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Ganancia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Folio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        JT2.setEditable(false);
        JT2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(JT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 140, -1));

        JT3.setEditable(false);
        JT3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(JT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 160, -1));

        JT4.setEditable(false);
        JT4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(JT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 140, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Fecha");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Total");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientesMouseClicked
        // TODO add your handling code here:
        int fila= TbClientes.getSelectedRow();
        int op=0;
        if (fila>=0){
            JT1.setText(TbClientes.getValueAt(fila, 0).toString());
            JT2.setText(TbClientes.getValueAt(fila,1).toString());
            JT3.setText(TbClientes.getValueAt(fila, 2).toString());
}else{
            JOptionPane.showMessageDialog(null, "No se seleccionó fila"); }
    }//GEN-LAST:event_TbClientesMouseClicked
    
    /*ArrayList<String> Cantidad = new ArrayList<>();
    ArrayList<String> Precio = new ArrayList<>();
    ArrayList<String> PrecioTot = new ArrayList<>();
    //Para sacar los IDP
    ArrayList<String> IDP = new ArrayList<>();
    public int NuLi=9;
    public void CheckDat(String Folio){
    String sql="SELECT * FROM venta where Folio="+Folio+"";
    try{
    Statement st= cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
        IDP.add(rs.getString(2));
        Cantidad.add(rs.getString(4));
        Precio.add(rs.getString(5));
        PrecioTot.add(rs.getString(6));
        NuLi=NuLi+1;}
    }catch(Exception e){
        System.out.println(e); }  }*/
    
    //Para sacar los IDP
    
    
       
    /*ArrayList<String> Nom = new ArrayList<>();
    public void CheckNom(String elemento){
    String sql;
    
    sql="SELECT Nompreproducto FROM `productos` WHERE IDP="+elemento+"";
    try{
    Statement st= cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
        Nom.add(rs.getString(1));}
    }catch(Exception e){
        System.out.println(e); }  
    
    }
    public String Ganancia;
    public void CheckDet(String Folio){
    String sql;
    sql="SELECT Total FROM `venta_detalle` WHERE Folio="+Folio+"";
    try{
    Statement st= cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
        Ganancia=rs.getString(1);}
    }catch(Exception e){
        System.out.println(e); }  
    
    }*/
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //PrinterMatrix printer = new PrinterMatrix();
    String Folio= JT1.getText();
    String Fecha= JT2.getText();
    String Total= JT3.getText();
    ClVen.Impr(Folio, Fecha, Total, usuario);
    
    //Se lee la informacion
    //CheckDat(Folio);
    //Se consulta el nombre del producto
    /*for (String elemento : IDP) {
        CheckNom(elemento);
        }
    CheckDet(Folio);
    Extenso e = new Extenso();

    e.setNumber(101.85);*/

//Se declara el tamaño de la hoja
//En este caso es de 58 milímetros
//Las filas son el primer numero y se las añadiremos contando según el numero de productos
/*printer.setOutSize(NuLi+4,32);
//Se escribe el mismo carácter en la primera linea
printer.printCharAtCol(1,1,32,"-");
 printer.printTextWrap(1,2,7,32, "TICKET DE LA VENTA");
 printer.printTextWrap(2,3,9,32, "MISELANEA MARY");
 printer.printTextWrap(3,3,1,32, "Lazaro cardenas Nu. 30");
 printer.printTextWrap(4,3,1,32, "Tepecoacuilco");
 printer.printTextWrap(5,3,1,32, "FOLIO: "+Folio);
 printer.printTextWrap(6,3,1,32, "FECHA& HORA:"+Fecha);
 printer.printTextWrap(7,3,1,32, "Nom Cantid Precio Total");
int Lin=9;
    for (int i = 0; i < IDP.size(); i++) {
    printer.printTextWrap(Lin,1,1,32,Nom.get(i)+"    "+Cantidad.get(i)+"    "+Precio.get(i)+"    "+PrecioTot.get(i));
    Lin++;
    }   
printer.printTextWrap(Lin+1,3,15,32,"Total:"+Ganancia);    
NuLi=9;
Nom.clear();
Cantidad.clear();
Precio.clear();
PrecioTot.clear();
IDP.clear();
Lin=6;
Ganancia="";
//Se debe tomar la impresora principal
printer.toFile("impresion.txt");
FileInputStream inputStream=null;
try{
inputStream = new FileInputStream("impresion.txt");
} catch(FileNotFoundException ex){
ex.printStackTrace();
}

DocFlavor docFormat= DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc document = new SimpleDoc(inputStream,docFormat,null);

PrintRequestAttributeSet attibuteset = new HashPrintRequestAttributeSet();
PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService!=null) {
        DocPrintJob printJob = defaultPrintService.createPrintJob();    
        try{
        printJob.print(document, attibuteset);    
        }catch(Exception c){
            System.out.println(c);    
        }        
        } else {
            System.out.println("Impresora no encontrar");
        }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int op=JOptionPane.showConfirmDialog(null, "¿Realmente desea abandonar \n esta página?", "Confirmar salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (op==0){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    conectar cc=new conectar();
Connection cn=cc.conexion();
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
            java.util.logging.Logger.getLogger(PrintTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintTiket("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JT1;
    private javax.swing.JTextField JT2;
    private javax.swing.JTextField JT3;
    private javax.swing.JTextField JT4;
    private javax.swing.JTable TbClientes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
