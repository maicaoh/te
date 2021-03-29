package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection getConexao() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", "root", "");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Acessar Banco!");
        }
        return conn;
    }

}
