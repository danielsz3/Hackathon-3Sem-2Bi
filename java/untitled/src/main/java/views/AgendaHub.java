package views;

import javax.swing.*;
import java.awt.*;

public class AgendaHub extends JFrame {
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelDataVisita;
    private JTextField campoDataVisita;
    private JLabel labelDescricao;
    private JTextField campoDescricao;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    String[] status = {
            "EM ABERTO",
            "ANDAMENTO",
            "CANCELADO",
            "FINALIZADO"
    };

    public AgendaHub() {
        setTitle("Agenda App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);

        JTabbedPane abasAgenda = new JTabbedPane();

        JPanel listPanel = getAgendamentos();
        JPanel cadastroPanel = setAgenda();

        abasAgenda.addTab("Agendamentos", listPanel);
        abasAgenda.addTab("Agenda", cadastroPanel);

        add(abasAgenda, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private JPanel setAgenda() {
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

        labelDataVisita = new JLabel("Data Visita:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelDataVisita, constraints);

        campoDataVisita = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoDataVisita, constraints);

        JComboBox<String> comboBox = new JComboBox<>(status);
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(comboBox, constraints);

        botaoCancelar = new JButton("Cancelar");
        constraints.gridx = 0;
        constraints.gridy = 16;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        constraints.gridx = 1;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }

    private JPanel getAgendamentos() {
        JPanel listPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        listPanel.add(scrollPane, BorderLayout.CENTER);
        return listPanel;
    }
}
