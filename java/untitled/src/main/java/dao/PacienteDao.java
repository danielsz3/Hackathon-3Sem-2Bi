package dao;

import model.Endereco;
import model.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PacienteDao {

    private Connection connection;

    public PacienteDao() throws SQLException {
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

    public List<Paciente> buscarPacientesPorCPF(String cpf) throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();

        String sql = "SELECT * FROM paciente WHERE cpf LIKE ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + cpf + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Paciente paciente = new Paciente(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("celular"),
                    rs.getString("cns"),
                    rs.getString("nomeCuidador"),
                    rs.getString("telefoneCuidador")
            );
            pacientes.add(paciente);
        }


        return pacientes;
    }

    public Paciente buscarPacientesPorCns(String cns) throws SQLException {
        Paciente paciente = null;

        String sql = "SELECT * FROM paciente WHERE cns = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cns);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            paciente = new Paciente(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("celular"),
                    rs.getString("cns"),
                    rs.getString("nomeCuidador"),
                    rs.getString("telefoneCuidador")
            );
        }
        return paciente;
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

    public void editar(Paciente paciente) throws SQLException {
        String sql = "UPDATE paciente SET nome=?, dataNascimento=?, cpf=?, cns=?, celular=?, email=?, nomeCuidador=?, telefoneCuidador=? WHERE id=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setDate(2, Date.valueOf(paciente.getDataNascimento()));
            ps.setString(3, paciente.getCpf());
            ps.setString(4, paciente.getCns());
            ps.setString(5, paciente.getCelular());
            ps.setString(6, paciente.getEmail());
            ps.setString(7, paciente.getNomeCuidador());
            ps.setString(8, paciente.getTelefoneCuidador());
            ps.setLong(9, paciente.getId());

            ps.executeUpdate();
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id=?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, id);

        ps.execute();
    }

    public List<Paciente> listarTodos() throws SQLException {
        List<Paciente> Pacientes = new ArrayList<Paciente>();

        ResultSet rs = connection.prepareStatement("select * from paciente").executeQuery();
        while (rs.next()) {
            Pacientes.add(new Paciente(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("celular"),
                    rs.getString("cns"),
                    rs.getString("nomeCuidador"),
                    rs.getString("telefoneCuidador")
            ));
        }
        rs.close();

        return Pacientes;
    }

    public Paciente buscarPorId(Long id) throws SQLException {
        Paciente paciente = null;
        String sql = "SELECT p.*, e. * FROM paciente p JOIN endereco e ON p.id_endereco = e.id WHERE p.id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setLong(1, id);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                paciente = new Paciente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("celular"),
                        rs.getDate("dataNascimento"),
                        rs.getString("cns"),
                        rs.getString("email"),
                        rs.getString("nomeCuidador"),
                        rs.getString("telefoneCuidador"),
                        new Endereco(rs.getString("cep"),
                                rs.getString("logradouro"),
                                rs.getString("numero"),
                                rs.getString("complemento"),
                                rs.getString("bairro"),
                                rs.getString("cidade"),
                                rs.getString("estado")
                        )
                );
            }
        }
        return paciente;
    }
}
