package views;

import service.PacienteService;

import javax.swing.*;
import java.awt.*;

public class VacinaHub{
    //private PacienteService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDescricao;
    private JTextField campoDescricao;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public VacinaHub() {
        //service = new PacienteService();

        JFrame frame = new JFrame("Paciente App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel listPanel = getVacina(tabbedPane);

        JPanel cadastroPanel = setVacina();

        tabbedPane.addTab("Lista de Pacientes", listPanel);
        tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private JPanel setVacina() {
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

        labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelDescricao = new JLabel("Descrição:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelDescricao, constraints);

        campoDescricao = new JFormattedTextField();
        campoDescricao.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDescricao, constraints);

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

    private JPanel getVacina(JTabbedPane tabbedPane) {
        // Panel da Lista de Pacientes
        JPanel listPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        listPanel.add(scrollPane, BorderLayout.CENTER);
        return listPanel;
    }
}
