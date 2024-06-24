package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Prontuario;

public class AgendaDao {
    private Connection connection;

    public AgendaDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3333/dbvacinacao2?useTimezone=true&serverTimezone=UTC", "root", "daniel");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserirProntuario(Prontuario prontuario) throws SQLException {
        String sql = "INSERT INTO prontuario (id_vacina, id_agendamentoVisita) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, prontuario.getIdVacina());
        ps.setInt(2, prontuario.getIdAgendamentoVisita());
        ps.execute();
    }

    public List<Prontuario> listarTodosProntuarios() throws SQLException {
        List<Prontuario> prontuarios = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("SELECT id_vacina, id_agendamentoVisita FROM prontuario").executeQuery();
        while (rs.next()) {
            prontuarios.add(new Prontuario(
                    rs.getInt("id_vacina"),
                    rs.getInt("id_agendamentoVisita")));
        }
        rs.close();

        return prontuarios;
    }

    public void atualizarProntuario(Prontuario prontuario) throws SQLException {
        String sql = "UPDATE prontuario SET id_vacina = ? WHERE id_agendamentoVisita = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, prontuario.getIdVacina());
        ps.setInt(2, prontuario.getIdAgendamentoVisita());
        ps.execute();
    }

    public void deletarProntuario(int idVacina, int idAgendamentoVisita) throws SQLException {
        String sql = "DELETE FROM prontuario WHERE id_vacina = ? AND id_agendamentoVisita = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idVacina);
        ps.setInt(2, idAgendamentoVisita);
        ps.execute();
    }

    public void fechar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
