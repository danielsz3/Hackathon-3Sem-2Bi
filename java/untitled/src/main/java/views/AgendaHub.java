package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AgendaHub extends JFrame{
    //private PacienteService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelDataVisita;
    private JFormattedTextField campoDataVisita;
    private JLabel labelSituacao;
    private JComboBox<String> menuSituacao;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    String[] status = {
            "EM ABERTO",
            "ANDAMENTO",
            "CANCELADO",
            "FINALIZADO"
    };

    public AgendaHub() {
        super("Agenda App"); // Define o título do JFrame atual
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JTabbedPane abasAgenda = new JTabbedPane();

        JPanel listPanel = getAgendamentos(abasAgenda);

        JPanel cadastroPanel = setAgenda();

        abasAgenda.addTab("Agendamentos", listPanel);
        abasAgenda.addTab("Agenda", cadastroPanel);

        getContentPane().add(abasAgenda, BorderLayout.CENTER);
        setLocationRelativeTo(null); // Centraliza o JFrame
    }

    private JPanel setAgenda() {
        JPanel painel = new JPanel();
        painel.add(cadastroPaciente(), BorderLayout.NORTH);
        painel.add(mostrarVacinas(), BorderLayout.SOUTH);
        return painel;
    }

    private JPanel mostrarVacinas() {
        JPanel painelSaida = new JPanel(new BorderLayout());
        /// Define os dados da tabela
        String[] columnNames = {"Selecionado", "Item", "Descrição"};
        Object[][] data = {
                {false, "Item 1", "Descrição"},
                {false, "Item 2", "Descrição"},
                {false, "Item 3", "Descrição"},
                {false, "Item 4", "Descrição"},
                {false, "Item 5", "Descrição"},
                {false, "Item 6", "Descrição"},
        };

        // Cria o modelo da tabela
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Somente a coluna de checkboxes é editável
            }
        };

        // Cria a JTable com o modelo
        JTable table = new JTable(model);

        // Adiciona a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        JLabel titulo = new JLabel("Prontuário");
        painelSaida.setLayout(new BorderLayout());
        painelSaida.add(titulo, BorderLayout.NORTH);
        painelSaida.add(scrollPane,BorderLayout.SOUTH);
        return painelSaida;
    }

    private JPanel cadastroPaciente() {
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelId = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelId, constraints);

        campoId = new JTextField(20);
        campoId.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(campoId, constraints);

        labelDataVisita = new JLabel("Data Visita:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(labelDataVisita, constraints);

        campoDataVisita = new JFormattedTextField();
        campoDataVisita.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(campoDataVisita, constraints);

        labelDataVisita = new JLabel("Situação:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(labelDataVisita, constraints);

        menuSituacao = new JComboBox<>(status);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(menuSituacao, constraints);

        botaoCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        constraints.gridx = 1;
        constraints.gridy = 3;
        painel.add(botaoSalvar, constraints);
        return painel;
    }

    private JPanel getAgendamentos(JTabbedPane abasAgenda) {
        JPanel listPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        JLabel situacaoLabel = new JLabel("Situação:");
        JLabel dataLabel = new JLabel("Data:");
        campoDataVisita = new JFormattedTextField();
        campoDataVisita.setColumns(20);
        menuSituacao = new JComboBox<>(status);
        JButton searchButton = new JButton("Buscar");

        searchPanel.add(situacaoLabel);
        searchPanel.add(menuSituacao);
        searchPanel.add(dataLabel);
        searchPanel.add(campoDataVisita);
        searchPanel.add(searchButton);

        JTable table = new JTable(new DefaultTableModel(new Object[]{"ID", "SITUAÇÃO", "DATA VISITA","CPF PACIENTE","NOME AGENTE","AÇÃO"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);

        listPanel.add(searchPanel, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        return listPanel;
    }
}
