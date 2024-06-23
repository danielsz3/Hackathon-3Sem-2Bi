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

    public void salvarPaciente(Paciente paciente) throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/dbvacinacao";
            String usuario = "root";
            String senha = "";

            Connection conn = DriverManager.getConnection(url, usuario, senha);

            String nome = paciente.getNome();
            LocalDate dataNascimento = paciente.getDataNascimento();
            String cpf = paciente.getCpf();
            String email = paciente.getEmail();
            String cns = paciente.getCns();
            String celular = paciente.getCelular();

            String logradouro = paciente.getEndereco().getLogradouro();
            String numero = paciente.getEndereco().getNumero();
            String complemento = paciente.getEndereco().getComplemento();
            String bairro = paciente.getEndereco().getBairro();
            String cidade = paciente.getEndereco().getCidade();
            String estado = paciente.getEndereco().getEstado();
            String cep = paciente.getEndereco().getCep();

            // Inserir o endereço
            String sqlEndereco = "INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            stmtEndereco.setString(1, logradouro);
            stmtEndereco.setString(2, numero);
            stmtEndereco.setString(3, complemento);
            stmtEndereco.setString(4, bairro);
            stmtEndereco.setString(5, cidade);
            stmtEndereco.setString(6, estado);
            stmtEndereco.setString(7, cep);
            int rowsAffectedEndereco = stmtEndereco.executeUpdate();

            if (rowsAffectedEndereco > 0) {
                ResultSet rs = stmtEndereco.getGeneratedKeys();
                if (rs.next()) {
                    int idEndereco = rs.getInt(1);

                    // Inserir o paciente
                    String sqlPaciente = "INSERT INTO paciente (id_endereco, nome, dataNascimento, cpf, email, cns, celular) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmtPaciente = conn.prepareStatement(sqlPaciente);
                    stmtPaciente.setInt(1, idEndereco); // Usar o id_endereco gerado
                    stmtPaciente.setString(2, nome);
                    stmtPaciente.setDate(3, Date.valueOf(dataNascimento));
                    stmtPaciente.setString(4, cpf);
                    stmtPaciente.setString(5, email);
                    stmtPaciente.setString(6, cns);
                    stmtPaciente.setString(7, celular);

                    int rowsAffectedPaciente = stmtPaciente.executeUpdate();

                }
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
          throw new Exception("Erro ao conectar ao banco de dados.");
        }
    }
}

/*

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

 */
