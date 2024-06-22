package views;

import service.AgenteSaudeService;
import service.PacienteService;

import javax.swing.*;
import java.awt.*;

public class AgenteSaudeHub {

    public AgenteSaudeHub() {
        service = new AgenteSaudeService();

        JFrame frame = new JFrame("Paciente App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel listPanel = getPaciente(tabbedPane);

        JPanel cadastroPanel = setPaciente();

        tabbedPane.addTab("Lista de Pacientes", listPanel);
        tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
