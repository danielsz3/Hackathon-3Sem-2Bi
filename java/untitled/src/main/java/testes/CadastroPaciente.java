/*package testes;

import model.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CadastroPaciente extends JFrame {

    private JTextField txtNome, txtDataNascimento, txtCPF, txtEmail, txtCNS, txtCelular, txtNomeDoCuidador, txtTelefoneDoCuidador;
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

        panel.add(new JLabel("Nome do Cuidador:"));
        txtNomeDoCuidador = new JTextField();
        panel.add(txtNomeDoCuidador);

        panel.add(new JLabel("Telefone do Cuidador:"));
        txtTelefoneDoCuidador = new JTextField();
        panel.add(txtTelefoneDoCuidador);

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

    private void salvarPaciente(){
        new Paciente(txtNome.getText(), txtCPF.getText(), txtCelular.getText(), Date.valueOf(txtDataNascimento.getText()),
                txtCNS.getText(), txtEmail.getText(), txtNomeDoCuidador.getText(), txtTelefoneDoCuidador.getText());
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
        String url = "jdbc:mysql://localhost:3306/dbvacinacao";
        String usuario = "root";
        String senha = "";

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
*/