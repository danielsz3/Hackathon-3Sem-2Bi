package views;

import model.AgenteSaude;
import model.Endereco;
import model.Paciente;
import service.AgenteSaudeService;
import service.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static javax.swing.JOptionPane.showMessageDialog;

public class AgenteSaudeHub extends JFrame{
    private AgenteSaudeService service = new AgenteSaudeService();
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JTextField campoCpf;
    private JLabel labelCelular;
    private JTextField campoCelular;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JTable tabela = new JTable();
    private JTabbedPane tabbedPane = new JTabbedPane();

    public AgenteSaudeHub() {
        setTitle("Agente App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);

        JPanel listPanel = getAgente(tabbedPane);

        JPanel cadastroPanel = setAgente();

        tabbedPane.addTab("Lista de Agentes", listPanel);
        tabbedPane.addTab("Cadastro de Agentes", cadastroPanel);

        add(tabbedPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);

    }

    private JPanel getAgente(JTabbedPane tabbedPane) {
        JPanel listPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("Buscar por CPF:");
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Buscar");

        //searchButton.addActionListener(e -> service.buscarPorCpf(searchField.getText()));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);


        tabela.setModel(carregarDados());
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getColumn("Ações").setCellRenderer(new AgenteSaudeHub.ButtonRenderer());
        tabela.getColumn("Ações").setCellEditor(new AgenteSaudeHub.ButtonEditor(new JCheckBox(), this));
        JScrollPane scrollPane = new JScrollPane(tabela);

        listPanel.add(searchPanel, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        return listPanel;
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private JTable table;
        private AgenteSaudeHub agenteSaudeHub;

        public ButtonEditor(JCheckBox checkBox, AgenteSaudeHub agenteSaudeHub) {
            super(checkBox);
            this.agenteSaudeHub = agenteSaudeHub;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            this.table = table;
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "Editar" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int row = table.getSelectedRow();
                AgenteSaude agenteSaude = agenteSaudeHub.getAgenteFromTable(row);
                agenteSaudeHub.carregarDadosAgente(agenteSaude);
                agenteSaudeHub.setSelectedTab(1); // Mudando para a aba de cadastro
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private void carregarDadosAgente(AgenteSaude agenteSaude) {
            campoId.setText(String.valueOf(agenteSaude.getId()));
            campoNome.setText(agenteSaude.getNome());
            campoCpf.setText(agenteSaude.getCpf());
            campoCelular.setText(agenteSaude.getCelular());
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Editar" : value.toString());
            return this;
        }
    }

    public AgenteSaude getAgenteFromTable(int row) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        return service.buscarPorId((Long) model.getValueAt(row, 0));
    }

    public void setSelectedTab(int index) {
        tabbedPane.setSelectedIndex(index);
    }

    private DefaultTableModel carregarDados() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Permitir edição apenas na coluna "Ações"
            }
        };
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("Ações");

        service.listarTodos().forEach(agenteSaude -> model.addRow(new Object[]{agenteSaude.getId(), agenteSaude.getNome(), agenteSaude.getCpf(), agenteSaude.getCelular(), "Editar"}));
        return model;
    }

    private JPanel setAgente() {
        // Painel de Cadastro de Pacientes
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

        labelNome = new JLabel("Nome Completo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCpf, constraints);

        labelCelular = new JLabel("Celular:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelCelular, constraints);

        campoCelular = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoCelular, constraints);

        botaoCancelar = new JButton("Cancelar");
        //botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 16;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }

    private void salvar() {
        try {
            service.salvar(construirAgente());
            //limparCampos();
            JOptionPane.showMessageDialog(this,"Agente Cadastrado ! !");
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private AgenteSaude construirAgente() {
        try {
            return campoId.getText().isEmpty() ?
                    new AgenteSaude(
                            campoNome.getText(),
                            campoCpf.getText(),
                            campoCelular.getText()
                    ):
                    new AgenteSaude(
                            Long.parseLong(campoId.getText()),
                            campoNome.getText(),
                            campoCpf.getText(),
                            campoCelular.getText()
                    );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir o objeto Paciente: " + e.getMessage());
        }
    }

}
