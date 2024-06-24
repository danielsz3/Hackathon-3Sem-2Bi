package views;

import model.Endereco;
import model.Paciente;
import service.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class PacienteHub extends JFrame {
    private PacienteService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDataNascimento;
    private JFormattedTextField campoDataNascimento;
    private JLabel labelCpf;
    private JTextField campoCpf;
    private JLabel labelCns;
    private JTextField campoCns;
    private JLabel labelCelular;
    private JTextField campoCelular;
    private JLabel labelEmail;
    private JTextField campoEmail;
    private JLabel labelNomeCuidador;
    private JTextField campoNomeCuidador;
    private JLabel labelTelefoneCuidador;
    private JTextField campoTelefoneCuidador;
    private JLabel labelCep;
    private JTextField campoCep;
    private JLabel labelLogradouro;
    private JTextField campoLogradouro;
    private JLabel labelNumero;
    private JTextField campoNumero;
    private JLabel labelComplemento;
    private JTextField campoComplemento;
    private JLabel labelBairro;
    private JTextField campoBairro;
    private JLabel labelCidade;
    private JTextField campoCidade;
    private JLabel labelEstado;
    private JTextField campoEstado;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    private JTable tabela;
    private JTabbedPane tabbedPane;
    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return new Date(format.parse(date).getTime());
    }

    public PacienteHub() {
        service = new PacienteService();

        setTitle("Paciente App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);

        tabbedPane = new JTabbedPane();

        JPanel listPanel = getPaciente(tabbedPane);
        JPanel cadastroPanel = setPaciente();

        tabbedPane.addTab("Lista de Pacientes", listPanel);
        tabbedPane.addTab("Cadastro de Pacientes", cadastroPanel);

        add(tabbedPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private JPanel setPaciente() {
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

        labelDataNascimento = new JLabel("Data Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JFormattedTextField();
        campoDataNascimento.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDataNascimento, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCpf, constraints);

        labelCns = new JLabel("CNS:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelCns, constraints);

        campoCns = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoCns, constraints);

        labelCelular = new JLabel("Celular:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelCelular, constraints);

        campoCelular = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoCelular, constraints);

        labelEmail = new JLabel("E-mail:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoEmail, constraints);

        labelNomeCuidador = new JLabel("Nome Cuidador:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        painelEntrada.add(labelNomeCuidador, constraints);

        campoNomeCuidador = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(campoNomeCuidador, constraints);

        labelTelefoneCuidador = new JLabel("Telefone Cuidador:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        painelEntrada.add(labelTelefoneCuidador, constraints);

        campoTelefoneCuidador = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        painelEntrada.add(campoTelefoneCuidador, constraints);

        labelCep = new JLabel("CEP:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        painelEntrada.add(labelCep, constraints);

        campoCep = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 9;
        painelEntrada.add(campoCep, constraints);

        labelLogradouro = new JLabel("Endereço:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        painelEntrada.add(labelLogradouro, constraints);

        campoLogradouro = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 10;
        painelEntrada.add(campoLogradouro, constraints);

        labelNumero = new JLabel("Nº:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        painelEntrada.add(labelNumero, constraints);

        campoNumero = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 11;
        painelEntrada.add(campoNumero, constraints);

        labelComplemento = new JLabel("Complemento:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        painelEntrada.add(labelComplemento, constraints);

        campoComplemento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 12;
        painelEntrada.add(campoComplemento, constraints);

        labelBairro = new JLabel("Bairro:");
        constraints.gridx = 0;
        constraints.gridy = 13;
        painelEntrada.add(labelBairro, constraints);

        campoBairro = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 13;
        painelEntrada.add(campoBairro, constraints);

        labelCidade = new JLabel("Cidade:");
        constraints.gridx = 0;
        constraints.gridy = 14;
        painelEntrada.add(labelCidade, constraints);

        campoCidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 14;
        painelEntrada.add(campoCidade, constraints);

        labelEstado = new JLabel("Estado:");
        constraints.gridx = 0;
        constraints.gridy = 15;
        painelEntrada.add(labelEstado, constraints);

        campoEstado = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 15;
        painelEntrada.add(campoEstado, constraints);

        botaoCancelar = new JButton("Cancelar");
        //botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 16;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> limparCampos());
        constraints.gridx = 1;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        botaoSalvar = new JButton("Deletar");
        botaoSalvar.addActionListener(e -> deletar());
        constraints.gridx = 3;
        constraints.gridy = 16;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }

    private void deletar(){
        try {
            service.deletar(Long.valueOf(campoId.getText()));
            limparCampos();
            JOptionPane.showMessageDialog(this,"Paciente Deletado ! !");
        } catch (Exception e){
            showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoDataNascimento.setText("");
        campoCpf.setText("");
        campoCns.setText("");
        campoCelular.setText("");
        campoEmail.setText("");
        campoNomeCuidador.setText("");
        campoTelefoneCuidador.setText("");
        campoCep.setText("");
        campoLogradouro.setText("");
        campoNumero.setText("");
        campoComplemento.setText("");
        campoBairro.setText("");
        campoCidade.setText("");
        campoEstado.setText("");
        campoId.setText("");
    }

    private void salvar() {
        try {
            service.salvar(construirPaciente());
            limparCampos();
            JOptionPane.showMessageDialog(this,"Paciente Cadastrado ! !");
        } catch (Exception e) {
            showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Paciente construirPaciente() {
        try {
            return campoId.getText().isEmpty() ?
                    new Paciente(
                            campoNome.getText(),
                            campoCpf.getText(),
                            campoCelular.getText(),
                            new Endereco(campoCep.getText(),
                                    campoLogradouro.getText(),
                                    campoNumero.getText(),
                                    campoComplemento.getText(),
                                    campoBairro.getText(),
                                    campoCidade.getText(),
                                    campoEstado.getText()),
                            parseDate(campoDataNascimento.getText()),
                            campoCns.getText(),
                            campoEmail.getText(),
                            campoNomeCuidador.getText(),
                            campoTelefoneCuidador.getText()
                    ):
                    new Paciente(
                            Long.parseLong(campoId.getText()),
                            campoNome.getText(),
                            campoCpf.getText(),
                            campoCelular.getText(),
                            parseDate(campoDataNascimento.getText()),
                            campoCns.getText(),
                            campoEmail.getText(),
                            campoNomeCuidador.getText(),
                            campoTelefoneCuidador.getText(),
                            new Endereco(campoCep.getText(),
                                    campoLogradouro.getText(),
                                    campoNumero.getText(),
                                    campoComplemento.getText(),
                                    campoBairro.getText(),
                                    campoCidade.getText(),
                                    campoEstado.getText())
                    );
        } catch (NumberFormatException | ParseException e) {
            throw new RuntimeException("Erro ao construir o objeto Paciente: " + e.getMessage());
        }
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


    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private JTable table;
        private PacienteHub pacienteHub;

        public ButtonEditor(JCheckBox checkBox, PacienteHub pacienteHub) {
            super(checkBox);
            this.pacienteHub = pacienteHub;
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
                Paciente paciente = pacienteHub.getPacienteFromTable(row);
                pacienteHub.carregarDadosPaciente(paciente);
                pacienteHub.setSelectedTab(1); // Mudando para a aba de cadastro
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

    public Paciente getPacienteFromTable(int row) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        return service.buscarPorId((Long) model.getValueAt(row, 0));
    }

    public void carregarDadosPaciente(Paciente paciente) {
        campoId.setText(String.valueOf(paciente.getId()));
        campoNome.setText(paciente.getNome());
        campoDataNascimento.setText(paciente.getDataNascimento().toString());
        campoCpf.setText(paciente.getCpf());
        campoCns.setText(paciente.getCns());
        campoCelular.setText(paciente.getCelular());
        campoEmail.setText(paciente.getEmail());
        campoNomeCuidador.setText(paciente.getNomeCuidador());
        campoTelefoneCuidador.setText(paciente.getTelefoneCuidador());
        campoCep.setText(paciente.getEndereco().getCep());
        campoLogradouro.setText(paciente.getEndereco().getLogradouro());
        campoNumero.setText(paciente.getEndereco().getNumero());
        campoComplemento.setText(paciente.getEndereco().getComplemento());
        campoBairro.setText(paciente.getEndereco().getBairro());
        campoCidade.setText(paciente.getEndereco().getCidade());
        campoEstado.setText(paciente.getEndereco().getEstado());
    }

    public void setSelectedTab(int index) {
        tabbedPane.setSelectedIndex(index);
    }
    private DefaultTableModel carregarDados() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // Permitir edição apenas na coluna "Ações"
            }
        };
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("CNS");
        model.addColumn("Nome Cuidador");
        model.addColumn("Telefone Cuidador");
        model.addColumn("Ações");

        service.buscar().forEach(paciente -> model.addRow(new Object[]{paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getCelular(), paciente.getCns(),paciente.getNomeCuidador(),paciente.getTelefoneCuidador(), "Editar"}));
        return model;
    }

    private JPanel getPaciente(JTabbedPane tabbedPane) {
        JPanel listPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        JLabel searchLabel = new JLabel("Buscar por CPF:");
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Buscar");

        searchButton.addActionListener(e -> service.buscarPorCpf(searchField.getText()));

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        tabela = new JTable();
        tabela.setModel(carregarDados());
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getColumn("Ações").setCellRenderer(new ButtonRenderer());
        tabela.getColumn("Ações").setCellEditor(new ButtonEditor(new JCheckBox(), this));
        JScrollPane scrollPane = new JScrollPane(tabela);

        listPanel.add(searchPanel, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        return listPanel;
    }


}