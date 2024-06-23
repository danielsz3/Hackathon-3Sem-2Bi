package testes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CadastroPaciente extends JFrame {

    private JTextField txtNome, txtDataNascimento, txtCPF, txtEmail, txtCNS, txtCelular;
    private JTextField txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, txtEstado, txtCEP;
    private JButton btnSalvar;

    public CadastroPaciente() {
        setTitle("Cadastro de Paciente");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(13, 2));

        // Campos de paciente
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("Data de Nascimento (yyyy-mm-dd):"));
        txtDataNascimento = new JTextField();
        panel.add(txtDataNascimento);

        panel.add(new JLabel("CPF:"));
        txtCPF = new JTextField();
        panel.add(txtCPF);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("CNS:"));
        txtCNS = new JTextField();
        panel.add(txtCNS);

        panel.add(new JLabel("Celular:"));
        txtCelular = new JTextField();
        panel.add(txtCelular);

        // Campos de endereço
        panel.add(new JLabel("Logradouro:"));
        txtLogradouro = new JTextField();
        panel.add(txtLogradouro);

        panel.add(new JLabel("Número:"));
        txtNumero = new JTextField();
        panel.add(txtNumero);

        panel.add(new JLabel("Complemento:"));
        txtComplemento = new JTextField();
        panel.add(txtComplemento);

        panel.add(new JLabel("Bairro:"));
        txtBairro = new JTextField();
        panel.add(txtBairro);

        panel.add(new JLabel("Cidade:"));
        txtCidade = new JTextField();
        panel.add(txtCidade);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);

        panel.add(new JLabel("CEP:"));
        txtCEP = new JTextField();
        panel.add(txtCEP);

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarPaciente();
            }
        });
        panel.add(btnSalvar);

        add(panel);
        setVisible(true);
    }

    private void salvarPaciente() {
        String url = "jdbc:mysql://127.0.0.1:3333/dbvacinacao";
        String usuario = "root";
        String senha = "daniel";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);

            String nome = txtNome.getText();
            String dataNascimento = txtDataNascimento.getText();
            String cpf = txtCPF.getText();
            String email = txtEmail.getText();
            String cns = txtCNS.getText();
            String celular = txtCelular.getText();

            String logradouro = txtLogradouro.getText();
            String numero = txtNumero.getText();
            String complemento = txtComplemento.getText();
            String bairro = txtBairro.getText();
            String cidade = txtCidade.getText();
            String estado = txtEstado.getText();
            String cep = txtCEP.getText();

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
                    stmtPaciente.setString(3, dataNascimento);
                    stmtPaciente.setString(4, cpf);
                    stmtPaciente.setString(5, email);
                    stmtPaciente.setString(6, cns);
                    stmtPaciente.setString(7, celular);

                    int rowsAffectedPaciente = stmtPaciente.executeUpdate();
                    if (rowsAffectedPaciente > 0) {
                        JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao cadastrar paciente.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar endereço.");
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.");
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtDataNascimento.setText("");
        txtCPF.setText("");
        txtEmail.setText("");
        txtCNS.setText("");
        txtCelular.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtCEP.setText("");
    }

    public static void main(String[] args) {
        // Teste de conexão
        String url = "jdbc:mysql://127.0.0.1:3333/dbvacinacao";
        String usuario = "root";
        String senha = "daniel";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");

            // Fechar a conexão de teste
            conn.close();
        } catch (SQLException e) {
            System.out.println("Falha na conexão:");
            e.printStackTrace();
            return; // Se a conexão de teste falhar, encerre o programa
        }

        // Se a conexão de teste for bem-sucedida, inicie a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente();
            }
        });
    }
}
