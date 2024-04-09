package exampleconexionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login_Update_JDBC {
    
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/bdsolutronic";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Update_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("Update usuarios set nombre = 'Pablo Neruda' Where nombre = 'Ricardo Caballero'");

            
            rs = statement.executeQuery("Select * from usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario") + " : " + rs.getString("Nombre") + " : " + rs.getString("Contraseña"));
            }while(rs.next());
        
        } catch (SQLException ex) {
            Logger.getLogger(Login_Update_JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
