import views.PacienteHub;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PacienteHub();
        });
    }
}