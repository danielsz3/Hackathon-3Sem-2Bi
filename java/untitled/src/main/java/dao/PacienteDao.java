package dao;

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
        ps.setString(1, diretor.getNome());
        ps.setInt(2, diretor.getPremiacao());
        ps.setString(3, diretor.getNacionalidade());
        ps.setDate(4, Date.valueOf(diretor.getDataInicioCarreira()));
        ps.execute();
    }

    public List<Diretor> listarTodos() throws SQLException {
        List<Diretor> Diretores = new ArrayList<Diretor>();

        ResultSet rs = connection.prepareStatement("select * from diretor").executeQuery();
        while (rs.next()) {
            Diretores.add(new Diretor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("premiacao"),
                    rs.getString("nacionalidade"),
                    rs.getDate("data_inicio_carreira")));
        }
        rs.close();

        return Diretores;
    }

    public void atualizar(Diretor Diretor) throws SQLException {
        String sql = "update Diretor set nome = ?, premiacao = ?,nacionalidade = ?,data_inicio_carreira = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, Diretor.getNome());
        ps.setInt(2, Diretor.getPremiacao());
        ps.setString(3, Diretor.getNacionalidade());
        ps.setDate(4, Date.valueOf(Diretor.getDataInicioCarreira()));
        ps.setInt(5, Diretor.getId());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from Diretor where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

}
