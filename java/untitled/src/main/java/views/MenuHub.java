package views;

import javax.swing.*;
import java.awt.*;

public class MenuHub extends JFrame {

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

        JButton botaoAgenda = new JButton("Agenda");
        botaoAgenda.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            AgendaHub form = new AgendaHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(botaoAgenda, constraints);

        JButton botaoPaciente = new JButton("Paciente");
        botaoPaciente.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            PacienteHub form = new PacienteHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoPaciente, constraints);

        JButton botaoVacina = new JButton("Vacina");
        botaoVacina.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            VacinaHub form = new VacinaHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoVacina, constraints);

        JButton botaoAgente = new JButton("Agente");
        botaoAgente.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            AgenteSaudeHub form = new AgenteSaudeHub();
            form.setVisible(true);
        }));
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(botaoAgente, constraints);

        return painelEntrada;
    }
}