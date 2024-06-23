package testes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CadastroPaciente extends JFrame {

    private JTextField txtNome, txtDataNascimento, txtCPF, txtEmail, txtCNS, txtCelular;
    private JButton btnSalvar;

    public CadastroPaciente() {
        setTitle("Cadastro de Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

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

            String sql = "INSERT INTO paciente (id_endereco, nome, dataNascimento, cpf, email, cns, celular) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1); // Usando id_endereco = 1 por padrão
            stmt.setString(2, nome);
            stmt.setString(3, dataNascimento);
            stmt.setString(4, cpf);
            stmt.setString(5, email);
            stmt.setString(6, cns);
            stmt.setString(7, celular);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar paciente.");
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
