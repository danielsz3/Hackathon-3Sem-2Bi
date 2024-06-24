package dao;

import model.AgenteSaude;
import model.Endereco;
import model.Paciente;
import model.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenteSaudeDao {
    private Connection connection;

    public AgenteSaudeDao() throws SQLException {
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

    public void inserir(AgenteSaude agenteSaude) throws SQLException {
        String sql = "insert into agenteSaude(nome,cpf,celular) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agenteSaude.getNome());
        ps.setString(2, agenteSaude.getCpf());
        ps.setString(3, agenteSaude.getCelular());


        ps.execute();
    }

    public List<AgenteSaude> listarTodos() throws SQLException {
        List<AgenteSaude> agenteSaudes = new ArrayList<AgenteSaude>();

        ResultSet rs = connection.prepareStatement("select * from agenteSaude").executeQuery();
        while (rs.next()) {
            agenteSaudes.add(new AgenteSaude(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("celular")));
        }
        rs.close();

        return agenteSaudes;
    }

    public String[] listarTodes() throws SQLException {
        ArrayList<String> agenteSaudes = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from agenteSaude").executeQuery();
        while (rs.next()) {
            agenteSaudes.add(rs.getString("nome"));
        }

        rs.close();
        // Converte o ArrayList<String> para String[] antes de retornar
        return agenteSaudes.toArray(new String[0]);
    }

    public void atualizar(AgenteSaude agenteSaude) throws SQLException {
        String sql = "update agenteSaude set nome = ?, cpf = ?, celular = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agenteSaude.getNome());
        ps.setString(2, agenteSaude.getCpf());
        ps.setString(3, agenteSaude.getCelular());
        ps.setLong(4, agenteSaude.getId());
        ps.execute();
    }

    public void deletar(Long id) throws SQLException {
        String sql = "delete from agenteSaude where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
    }

    public AgenteSaude consultarId(Long id) throws SQLException {
        AgenteSaude agenteSaude = null;
        String sql = "SELECT id FROM agenteSaude WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                agenteSaude = new AgenteSaude(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("celular"));
            }
            ;
        }
        return agenteSaude;
    }
}
