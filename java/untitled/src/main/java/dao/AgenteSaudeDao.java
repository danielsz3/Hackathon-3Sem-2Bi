package dao;

import model.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgenteSaudeDao {
    private Connection connection;

    public AgenteSaudeDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbvacinacao?useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Endereco endereco) throws SQLException {
        String sql = "insert into agenteSaude(nome,cpf,celular,) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, endereco.getCep());
        ps.setString(2, endereco.getLogradouro());
        ps.setString(3, endereco.getNumero());
        ps.setString(4, endereco.getComplemento());
        ps.setString(5, endereco.getBairro());
        ps.setString(6, endereco.getCidade());
        ps.setString(7, endereco.getEstado());

        ps.execute();
    }
}
