import views.PacienteHub;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Main Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Options");
            JMenuItem menuItem = new JMenuItem("Open Paciente Hub");

            menuItem.addActionListener(e -> {
                PacienteHub pacienteHub = new PacienteHub();
                pacienteHub.setVisible(true);
            });

            menu.add(menuItem);
            menuBar.add(menu);
            frame.setJMenuBar(menuBar);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
