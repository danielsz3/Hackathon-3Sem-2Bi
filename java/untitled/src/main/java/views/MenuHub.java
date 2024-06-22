package views;

import javax.swing.*;
import java.awt.*;

public class MenuHub extends JFrame {
    private JButton botaoAgenda;
    private JButton botaoPaciente;

    public MenuHub() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        JPanel painelEntrada = montarPainel();
        setLocationRelativeTo(null);
        getContentPane().add(painelEntrada, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel montarPainel() {
        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        botaoAgenda = new JButton("Agenda");
        JButton botaoAgenda = new JButton("Agenda");
        botaoAgenda.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            AgendaHub form = new AgendaHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(botaoAgenda, constraints);

        botaoPaciente = new JButton("Paciente");
        JButton botaoPaciente = new JButton("Paciente");
        botaoPaciente.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            PacienteHub form = new PacienteHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoPaciente, constraints);
        return painelEntrada;
    }
}
