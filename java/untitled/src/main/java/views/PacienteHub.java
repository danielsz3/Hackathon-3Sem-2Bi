package views;

import model.Endereco;
import model.Paciente;
import service.PacienteService;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showMessageDialog;

public class PacienteHub extends JFrame {
    private PacienteService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDataNascimento;
    private JFormattedTextField campoDataNascimento;
    private JLabel labelCpf;
    private JTextField campoCpf;
    private JLabel labelCns;
    private JTextField campoCns;
    private JLabel labelCelular;
    private JTextField campoCelular;
    private JLabel labelEmail;
    private JTextField campoEmail;
    private JLabel labelNomeCuidador;
    private JTextField campoNomeCuidador;
    private JLabel labelTelefoneCuidador;
    private JTextField campoTelefoneCuidador;
    private JLabel labelCep;
    private JTextField campoCep;
    private JLabel labelLogradouro;
    private JTextField campoLogradouro;
    private JLabel labelNumero;
    private JTextField campoNumero;
    private JLabel labelComplemento;
    private JTextField campoComplemento;
    private JLabel labelBairro;
    private JTextField campoBairro;
    private JLabel labelCidade;
    private JTextField campoCidade;
    private JLabel labelEstado;
    private JTextField campoEstado;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return new Date(format.parse(date).getTime());
    }

    public PacienteHub() {
        service = new PacienteService();

        JFrame frame = new JFrame("Paciente App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel listPanel = getPaciente(tabbedPane);

        JPanel cadastroPanel = setPaciente();

        tabbedPane.addTab("Lista de Pacientes", listPanel);
        tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
        setLocationRelativeTo(null);
    }

    private JPanel setPaciente() {
        // Painel de Cadastro de Pacientes
        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelId = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelId, constraints);

        campoId = new JTextField(20);
        campoId.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(campoId, constraints);

        labelNome = new JLabel("Nome Completo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelDataNascimento = new JLabel("Data Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JFormattedTextField();
        campoDataNascimento.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDataNascimento, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCpf, constraints);

        labelCns = new JLabel("CNS:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelCns, constraints);

        campoCns = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoCns, constraints);

        labelCelular = new JLabel("Celular:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelCelular, constraints);

        campoCelular = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoCelular, constraints);

        labelEmail = new JLabel("E-mail:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoEmail, constraints);

        labelNomeCuidador = new JLabel("Nome Cuidador:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        painelEntrada.add(labelNomeCuidador, constraints);

        campoNomeCuidador = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(campoNomeCuidador, constraints);

        labelTelefoneCuidador = new JLabel("Telefone Cuidador:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        painelEntrada.add(labelTelefoneCuidador, constraints);

        campoTelefoneCuidador = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        painelEntrada.add(campoTelefoneCuidador, constraints);

        labelCep = new JLabel("CEP:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        painelEntrada.add(labelCep, constraints);

        campoCep = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 9;
        painelEntrada.add(campoCep, constraints);

        labelLogradouro = new JLabel("Endereço:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        painelEntrada.add(labelLogradouro, constraints);

        campoLogradouro = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 10;
        painelEntrada.add(campoLogradouro, constraints);

        labelNumero = new JLabel("Nº:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        painelEntrada.add(labelNumero, constraints);

        campoNumero = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 11;
        painelEntrada.add(campoNumero, constraints);

        labelComplemento = new JLabel("Complemento:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        painelEntrada.add(labelComplemento, constraints);

        campoComplemento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 12;
        painelEntrada.add(campoComplemento, constraints);

        labelBairro = new JLabel("Bairro:");
        constraints.gridx = 0;
        constraints.gridy = 13;
        painelEntrada.add(labelBairro, constraints);

        campoBairro = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 13;
        painelEntrada.add(campoBairro, constraints);

        labelCidade = new JLabel("Cidade:");
        constraints.gridx = 0;
        constraints.gridy = 14;
        painelEntrada.add(labelCidade, constraints);

        campoCidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 14;
        painelEntrada.add(campoCidade, constraints);

        labelEstado = new JLabel("Estado:");
        constraints.gridx = 0;
        constraints.gridy = 15;
        painelEntrada.add(labelEstado, constraints);

        campoEstado = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 15;
        painelEntrada.add(campoEstado, constraints);

        botaoCancelar = new JButton("Cancelar");
        //botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 16;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }

    private static JPanel getPaciente(JTabbedPane tabbedPane) {
        // Panel da Lista de Pacientes
        JPanel listPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        listPanel.add(scrollPane, BorderLayout.CENTER);
        return listPanel;
    }

    private void limparCampos() {
        campoNome.setText("");
        campoDataNascimento.setText("");
        campoCpf.setText("");
        campoCns.setText("");
        campoCelular.setText("");
        campoEmail.setText("");
        campoNomeCuidador.setText("");
        campoTelefoneCuidador.setText("");
        campoCep.setText("");
        campoLogradouro.setText("");
        campoNumero.setText("");
        campoComplemento.setText("");
        campoBairro.setText("");
        campoEstado.setText("");
        campoId.setText("");
    }

    private void salvar() {
        try {
            service.salvar(construirEndereco(),construirPaciente());
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Paciente construirPaciente() {
        try {
            return campoId.getText().isEmpty()
                    ? new Paciente(
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoCelular.getText(),
                    parseDate(campoDataNascimento.getText()),
                    campoCns.getText(),
                    campoEmail.getText(),
                    campoNomeCuidador.getText(),
                    campoTelefoneCuidador.getText())
                    : new Paciente(
                    (long) parseInt(campoId.getText()),
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoCelular.getText(),
                    parseDate(campoDataNascimento.getText()),
                    campoCns.getText(),
                    campoEmail.getText(),
                    campoNomeCuidador.getText(),
                    campoTelefoneCuidador.getText());
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private Endereco construirEndereco() {
        return new Endereco(
                campoCep.getText(),
                campoLogradouro.getText(),
                campoNumero.getText(),
                campoComplemento.getText(),
                campoBairro.getText(),
                campoCidade.getText(),
                campoEstado.getText());
    }
}



