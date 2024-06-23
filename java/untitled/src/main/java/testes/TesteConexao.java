package testes;

import java.sql.*;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3333/dbvacinacao";
        String usuario = "root";
        String senha = "daniel";

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
