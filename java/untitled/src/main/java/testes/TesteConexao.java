package testes;

import java.sql.*;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbvacinacao2";
        String usuario = "root";
        String senha = "";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");

            // Fechar a conexão
            conn.close();
        } catch (SQLException e) {
            System.out.println("Falha na conexão:");
            e.printStackTrace();
        }
    }
}
