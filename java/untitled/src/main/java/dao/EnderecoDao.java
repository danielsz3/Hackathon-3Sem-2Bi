package dao;

import model.Endereco;

import java.sql.*;

public class EnderecoDao {

    private Connection connection;

    public EnderecoDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbvacinacao2?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Endereco endereco) throws SQLException {
        String sql = "insert into endereco(cep,logradouro,numero,complemento,bairro,cidade,estado) values(?,?,?,?,?,?,?)";
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

    public Long consultarIdPorCep(String cep) throws SQLException {
        String sql = "select id from endereco where cep = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cep);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return (long) rs.getInt("id");
        } else {
            return (long) -1; // Retorna -1 se não encontrar o CEP
        }
    }

    public Long consultarMaiorId() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM endereco";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return (long) rs.getInt("max_id");
            } else {
                return (long) -1; // Retorna -1 se não houver registros na tabela
            }
        }
    }
}
