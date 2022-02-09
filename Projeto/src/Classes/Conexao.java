package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
      public Connection conectaBD(){
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto","root","1234");
    }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
            return conn;
        }
      
}
