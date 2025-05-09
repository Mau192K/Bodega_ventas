
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectar {
Connection conectar=null;
public Connection conexion(){
try{
Class.forName("com.mysql.jdbc.Driver");
conectar=DriverManager.getConnection("jdbc:mysql://localhost/punto_venta?user=root&password=");
}catch(ClassNotFoundException|SQLException e){
    System.out.println(e.getMessage());
}
return conectar;
}   
}
