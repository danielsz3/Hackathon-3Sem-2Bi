package views;

import service.AgenteSaudeService;
import service.PacienteService;

import javax.swing.*;
import java.awt.*;

public class AgenteSaudeHub {
    private AgenteSaudeService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JTextField campoCpf;
    private JLabel labelCelular;
    private JTextField campoCelular;
    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public AgenteSaudeHub() {
        service = new AgenteSaudeService();

        JFrame frame = new JFrame("Paciente App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel listPanel = getAgente(tabbedPane);

        JPanel cadastroPanel = setAgente();

        tabbedPane.addTab("Lista de Pacientes", listPanel);
        tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getAgente(JTabbedPane tabbedPane) {
        // Panel da Lista de Pacientes
        JPanel listPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        listPanel.add(scrollPane, BorderLayout.SOUTH);
        return listPanel;
    }

    private JPanel setAgente() {
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

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCpf, constraints);

        labelCelular = new JLabel("Celular:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelCelular, constraints);

        campoCelular = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoCelular, constraints);

        botaoCancelar = new JButton("Cancelar");
        //botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 16;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        //botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }
}
