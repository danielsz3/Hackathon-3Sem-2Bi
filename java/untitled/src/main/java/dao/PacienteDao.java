package dao;

import model.Endereco;
import model.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private Connection connection;

    public PacienteDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3333/dbvacinacao?useTimezone=true&serverTimezone=UTC", "root", "daniel");
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
                    rs.getDate("dataNascimento"),
                    rs.getString("cpf"),
                    rs.getString("cns"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("nomeCuidador"),
                    rs.getString("telefoneCuidador")
            );
            pacientes.add(paciente);
        }

        return pacientes;
    }

    private void exibirResultadosNaTabela(List<Paciente> pacientes, JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Data de Nascimento");
        model.addColumn("CPF");
        model.addColumn("CNS");
        model.addColumn("Celular");
        model.addColumn("Email");
        model.addColumn("Nome do Cuidador");
        model.addColumn("Telefone do Cuidador");

        for (Paciente paciente : pacientes) {
            Object[] row = {
                    paciente.getId(),
                    paciente.getNome(),
                    paciente.getDataNascimento(),
                    paciente.getCpf(),
                    paciente.getCns(),
                    paciente.getCelular(),
                    paciente.getEmail(),
                    paciente.getNomeCuidador(),
                    paciente.getTelefoneCuidador()
            };
            model.addRow(row);
        }

        table.setModel(model);
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
