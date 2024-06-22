package dao;

import model.Endereco;
import model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private Connection connection;

    public PacienteDao() throws SQLException {
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

    public void inserir(Paciente paciente) throws SQLException {
        String sql = "insert into paciente(id_endereco,nome,dataNascimento,cpf,cns,celular,email,nomeCuidador,telefoneCuidador) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, paciente.getEndereco().getId());
        ps.setString(2, paciente.getNome());
        ps.setDate(3, Date.valueOf(paciente.getDataNascimento()));
        ps.setString(4, paciente.getCpf());
        ps.setString(5, paciente.getCns());
        ps.setString(6, paciente.getCelular());
        ps.setString(7, paciente.getEmail());
        ps.setString(8, paciente.getNomeCuidador());
        ps.setString(9, paciente.getTelefoneCuidador());

        ps.execute();

    }



}
