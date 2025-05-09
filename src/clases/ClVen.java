
package clases;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;


public class ClVen {
    
    
   static conectar cc=new conectar();
   static Connection cn=cc.conexion();

    static ArrayList<String> Cantidad = new ArrayList<>();
    static ArrayList<String> Precio = new ArrayList<>();
    static ArrayList<String> PrecioTot = new ArrayList<>();
    //Para sacar los IDP
    static ArrayList<String> IDP = new ArrayList<>();
    public static int NuLi=9;
    public static void CheckDat(String Folio){
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
        System.out.println(e); }  }



static ArrayList<String> Nom = new ArrayList<>();
public static void CheckNom(String elemento){
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
    static public String Ganancia;
    public static void CheckDet(String Folio){
    String sql;
    sql="SELECT Total FROM `venta_detalle` WHERE Folio="+Folio+"";
    try{
    Statement st= cn.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
        Ganancia=rs.getString(1);}
    }catch(Exception e){
        System.out.println(e); }  
    
    }
    
    public void setuser (String user){
        this.User=user;
        
    }
    static public String User;
    
   public static void Impr(String Folio, String Fecha, String Total, String User){
   PrinterMatrix printer = new PrinterMatrix();
    /*String Folio= JT1.getText();
    String Fecha= JT2.getText();
    String Total= JT3.getText();*/
    //Se lee la informacion
    CheckDat(Folio);
    //Se consulta el nombre del producto
    for (String elemento : IDP) {
        CheckNom(elemento);
        }
    CheckDet(Folio);
    Extenso e = new Extenso();

    e.setNumber(101.85);

//Se declara el tamaño de la hoja
//En este caso es de 58 milímetros
//Las filas son el primer numero y se las añadiremos contando según el numero de productos
printer.setOutSize(NuLi+5,32);
//Se escribe el mismo carácter en la primera linea
printer.printCharAtCol(1,1,32,"-");
 printer.printTextWrap(1,2,7,32, "TICKET DE LA VENTA");
 printer.printTextWrap(2,3,9,32, "MISELANEA MARY");
 printer.printTextWrap(3,3,1,32, "Lazaro cardenas Nu. 30");
 printer.printTextWrap(4,3,1,32, "Tepecoacuilco");
 printer.printTextWrap(5,3,1,32, "FOLIO: "+Folio);
 printer.printTextWrap(6,3,1,32, "FECHA& HORA:"+Fecha);
 printer.printTextWrap(7,3,1,32, "Usuario despachador:"+User);
 printer.printTextWrap(8,3,1,3, "Nom");
 printer.printTextWrap(8,3,11,16, "Cantid");
 printer.printTextWrap(8,3,18,23, "Precio");
 printer.printTextWrap(8,3,25,29, "Total"); 
int Lin=9;
    for (int i = 0; i < IDP.size(); i++) {
     printer.printTextWrap(Lin,1,1,10, Nom.get(i)); 
    printer.printTextWrap(Lin,1,12,16, Cantidad.get(i));  
    printer.printTextWrap(Lin,1,18,23, Precio.get(i)); 
    printer.printTextWrap(Lin,1,25,29, PrecioTot.get(i)); 
    //printer.printTextWrap(Lin,1,1,32,Nom.get(i)+"    "+Cantidad.get(i)+"    "+Precio.get(i)+"    "+PrecioTot.get(i));
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
        }
        Cantidad.clear();
        Precio.clear();
        PrecioTot.clear();
        IDP.clear();
   }  
}



