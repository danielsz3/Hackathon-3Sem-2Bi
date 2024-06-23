package views;

import dao.VacinaDao;
import model.Vacina;
import service.VacinaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class AgendaHub extends JFrame {
    private VacinaService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelDataVisita;
    private JFormattedTextField campoDataVisita;
    private JLabel labelSituacao;
    private JComboBox<String> menuSituacao;
    private JLabel labelAgente;
    private JComboBox<String> menuAgente;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    String[] status = {
            "EM ABERTO",
            "ANDAMENTO",
            "CANCELADO",
            "FINALIZADO"
    };
    String[] agentes = {
            "Agente 1",
            "Agente 2",
            "Agente 3",
            "Agente 4"
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

    private JPanel mostrarVacinas(){
        JPanel painelSaida = new JPanel(new BorderLayout());
        JTable tabela = new JTable();
        tabela.setModel(carregarDados());

        // Adiciona a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        JLabel titulo = new JLabel("Prontuário");
        painelSaida.setLayout(new BorderLayout());
        painelSaida.add(titulo, BorderLayout.NORTH);
        painelSaida.add(scrollPane, BorderLayout.SOUTH);
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

        labelSituacao = new JLabel("Situação:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(labelSituacao, constraints);

        menuSituacao = new JComboBox<>(status);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(menuSituacao, constraints);

        labelAgente = new JLabel("Agente:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(labelAgente, constraints);

        menuAgente = new JComboBox<>(agentes);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painel.add(menuAgente, constraints);

        botaoCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        constraints.gridx = 1;
        constraints.gridy = 4;
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

        JTable table = new JTable(new DefaultTableModel(new Object[]{"ID", "SITUAÇÃO", "DATA VISITA", "CPF PACIENTE", "NOME AGENTE", "AÇÃO"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);

        listPanel.add(searchPanel, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        return listPanel;
    }

    private DefaultTableModel carregarDados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Descrição");
        service.listarTodos().forEach(vacina -> model.addRow(new Object[]{vacina.getId(), vacina.getNomeVacina(), vacina.getDescricao(),false}));
        return model;

    }
}
