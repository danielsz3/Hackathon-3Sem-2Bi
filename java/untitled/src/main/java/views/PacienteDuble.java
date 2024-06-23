package views;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PacienteDuble extends JFrame {
    // Classe de modelo Paciente
package model;

import java.sql.Date;

    public class Paciente {
        private Long id;
        private String nome;
        private String cpf;
        private String celular;
        private Date dataNascimento;
        private String cns;
        private String email;
        private String nomeCuidador;
        private String telefoneCuidador;

        // Construtor sem ID
        public Paciente(String nome, String cpf, String celular, Date dataNascimento, String cns, String email, String nomeCuidador, String telefoneCuidador) {
            this.nome = nome;
            this.cpf = cpf;
            this.celular = celular;
            this.dataNascimento = dataNascimento;
            this.cns = cns;
            this.email = email;
            this.nomeCuidador = nomeCuidador;
            this.telefoneCuidador = telefoneCuidador;
        }

        // Construtor com ID
        public Paciente(Long id, String nome, Date dataNascimento, String cpf, String cns, String celular, String email, String nomeCuidador, String telefoneCuidador) {
            this.id = id;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
            this.cns = cns;
            this.celular = celular;
            this.email = email;
            this.nomeCuidador = nomeCuidador;
            this.telefoneCuidador = telefoneCuidador;
        }

        // Getters e setters omitidos para brevidade
    }

// Classe Duble PacienteServiceDouble
package service;

import model.Paciente;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

    public class PacienteServiceDouble {

        public List<Paciente> getPacientes() {
            List<Paciente> pacientes = new ArrayList<>();
            pacientes.add(new Paciente(1L, "João Silva", Date.valueOf("1980-01-01"), "123.456.789-00", "123456789012345", "987654321", "joao@gmail.com", "Maria Silva", "987654321"));
            pacientes.add(new Paciente(2L, "Ana Souza", Date.valueOf("1990-02-02"), "234.567.890-11", "234567890123456", "876543210", "ana@gmail.com", "José Souza", "876543210"));
            pacientes.add(new Paciente(3L, "Carlos Pereira", Date.valueOf("1975-03-03"), "345.678.901-22", "345678901234567", "765432109", "carlos@gmail.com", "Fernanda Pereira", "765432109"));
            return pacientes;
        }
    }

// Classe PacienteHub modificada
package views;

import model.Paciente;
import service.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

    public class PacienteHub extends JFrame {
        private PacienteServiceDouble service;
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
            service = new PacienteServiceDouble();

            setTitle("Paciente App");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(800, 600);

            JTabbedPane tabbedPane = new JTabbedPane();

            JPanel listPanel = getPaciente(tabbedPane);
            JPanel cadastroPanel = setPaciente();

            tabbedPane.addTab("Lista de Pacientes", listPanel);
            tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

            add(tabbedPane, BorderLayout.CENTER);
            setLocationRelativeTo(null);
        }

        private JPanel setPaciente() {
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

        private JPanel getPaciente(JTabbedPane tabbedPane) {
            JPanel listPanel = new JPanel(new BorderLayout());

            JPanel searchPanel = new JPanel();
            JLabel searchLabel = new JLabel("Buscar por CPF:");
            JTextField searchField = new JTextField(15);
            JButton searchButton = new JButton("Buscar");

            searchPanel.add(searchLabel);
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

            JTable table = new JTable(new DefaultTableModel(new Object[]{"ID", "Nome", "CPF"}, 0));
            JScrollPane scrollPane = new JScrollPane(table);

            List<Paciente> pacientes = service.getPacientes();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (Paciente p : pacientes) {
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getCpf()});
            }

            listPanel.add(searchPanel, BorderLayout.NORTH);
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
                System.out.println("Mensagem");
                service.salvar(construirPaciente());
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
                        Long.parseLong(campoId.getText()),
                        campoNome.getText(),
                        parseDate(campoDataNascimento.getText()),
                        campoCpf.getText(),
                        campoCns.getText(),
                        campoCelular.getText(),
                        campoEmail.getText(),
                        campoNomeCuidador.getText(),
                        campoTelefoneCuidador.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
