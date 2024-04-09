// Nombre del Proyecto 
package exampleconexionjdbc;

// Paquete para utlizar un conjunto de clases para trabajar con la base de datos mysql
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//Nombre de la clase 
public class Login_Insert_JDBC {

  public static void main(String[] args) {
        
      // Variables para establecer la conexion con la base de datos 
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/bdsolutronic";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        //Instanciar el driver conector de JAVA para JDBC de mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Insert_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Metodos para hacer consultas e insertar datos sql sobre la conexion establecida 
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement ();
            statement.executeUpdate("Insert into usuarios (nombre,contraseña,correo) values('DIEGO PIAMBA','ABC123','DIEGO@GMAIL.COM')");
            rs = statement.executeQuery("select * from usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario")+" : "+rs.getString("nombre"));
            }while(rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Insert_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
