package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
 
    public static Connection getConexao(){
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aposta","root","");
            System.out.println("Conectado com Sucesso");
        }catch (SQLException e){
            System.out.println("Erro ao conectar");
        }
        return conn;
    }
 
}
