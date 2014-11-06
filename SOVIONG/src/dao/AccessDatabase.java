package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AccessDatabase implements IDatabase {

    @Override
    public Connection conectar() {

        try {

            String url = "jdbc:mysql://localhost/bd_mergead";
            //String url = "jdbc:mysql://server01/bd_oficinasimples";
            String usuario = "root";
            String senha = "slipclown";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexão não estabelecida: " + e.getMessage(), "Mensagem do Programa",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }
        return null;
    }

}
