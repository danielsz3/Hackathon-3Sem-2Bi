package views;

import model.AgendamentoVisita;
import model.Vacina;
import service.VacinaService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgendaHub extends JFrame{
    private VacinaService service = new VacinaService();
    //private AgendaService serviceAgenda = new AgendaService();

    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelCns;
    private JTextField campoCns;
    private JLabel labelDataVisita;
    private JFormattedTextField campoDataVisita;
    private JLabel labelHoraVisita;
    private JFormattedTextField campoHoraVisita;
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
        setTitle("Agenda App"); // Define o título do JFrame atual
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

        DefaultTableModel model = carregarDados();

        JTable tabela = new JTable(model) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 3) { // Índice da coluna Checkbox
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }
        };

        // Configurar renderizador e editor de célula para a coluna "Checkbox"
        tabela.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Boolean) {
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setSelected((Boolean) value);
                    checkBox.setHorizontalAlignment(SwingConstants.CENTER);
                    return checkBox;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });

        tabela.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(tabela);

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

        labelHoraVisita = new JLabel("Hora Visita:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(labelHoraVisita, constraints);

        campoHoraVisita = new JFormattedTextField();
        campoHoraVisita.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(campoHoraVisita, constraints);

        labelSituacao = new JLabel("Situação:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(labelSituacao, constraints);

        menuSituacao = new JComboBox<>(status);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painel.add(menuSituacao, constraints);

        labelAgente = new JLabel("Agente:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(labelAgente, constraints);

        menuAgente = new JComboBox<>(agentes);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painel.add(menuAgente, constraints);

        labelCns = new JLabel("CNS Paciente:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painel.add(labelCns, constraints);

        campoCns = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painel.add(campoCns, constraints);

        botaoCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painel.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        constraints.gridx = 1;
        constraints.gridy = 6;
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

    private void salvar(){

    }

    private AgendamentoVisita construirAgenda() {
        String dateText = campoDataVisita.getText().trim();
        String timeText = campoHoraVisita.getText().trim();
        Date result = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateText + " " + timeText, formatter);
            result = Date.valueOf(dateTime.toLocalDate());
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data ou hora inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            return campoId.getText().isEmpty() ?
                    new AgendamentoVisita(
                            result,
                            menuSituacao.getSelectedItem().toString(),
                            menuAgente.getSelectedItem().toString(),
                            campoCns.getText(),
                            getSelectedItems(carregarDados())
                    ):
                    new AgendamentoVisita(
                            Long.parseLong(campoId.getText()),
                            result,
                            menuSituacao.getSelectedItem().toString(),
                            menuAgente.getSelectedItem().toString(),
                            campoCns.getText(),
                            getSelectedItems(carregarDados())
                    );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir o objeto Agenda: " + e.getMessage());
        }
    }

    private DefaultTableModel carregarDados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Descrição");
        model.addColumn("Checkbox");

        service.listarTodos().forEach(vacina->model.addRow(new Object[]{
                vacina.getId(),
                vacina.getNomeVacina(),
                vacina.getDescricao(),
                false,
                }));
        return model;
    }

    private static JList<Vacina> getSelectedItems(DefaultTableModel model) {
        DefaultListModel<Vacina> vacinas = new DefaultListModel<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 3);
            if (isChecked != null && isChecked) {
                Vacina vacina = new Vacina(
                        (Long) model.getValueAt(i, 0),
                        (String) model.getValueAt(i, 1),
                        (String) model.getValueAt(i, 2)
                );
                vacinas.addElement(vacina);
            }
        }

        return new JList<>(vacinas);
    }
}
