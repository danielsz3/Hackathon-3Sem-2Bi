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
                    "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Paciente paciente) throws SQLException {
        String sql = "insert into paciente(nome,premiacao,nacionalidade,data_inicio_carreira) values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

    }



}
