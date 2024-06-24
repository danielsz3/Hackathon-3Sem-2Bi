package views;

import model.Vacina;
import service.VacinaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class VacinaHub extends JFrame {
    private VacinaService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDescricao;
    private JTextField campoDescricao;

    private JButton botaoSalvar;
    private JButton botaoDeletar;
    private JButton botaoCancelar;

    private JTable tabela;
    private DefaultTableModel tableModel;

    public VacinaHub() {
        service = new VacinaService();

        setTitle("Vacina App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel painelEntrada = montarPainelEntrada();
        JPanel painelSaida = montarPainelSaida();

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private JPanel montarPainelEntrada() {
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

        labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelDescricao = new JLabel("Descrição:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelDescricao, constraints);

        campoDescricao = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDescricao, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(botaoSalvar, constraints);

        botaoDeletar = new JButton("Deletar");
        botaoDeletar.addActionListener(e -> excluir());
        constraints.gridx = 2;
        constraints.gridy = 3;
        painelEntrada.add(botaoDeletar, constraints);

        return painelEntrada;
    }

    private JPanel montarPainelSaida() {
        JPanel painelSaida = new JPanel(new BorderLayout());
        tabela = new JTable();
        tabela.setModel(modelo());
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getSelectionModel().addListSelectionListener(e -> preencherCampos());
        JScrollPane scrollPane = new JScrollPane(tabela);
        painelSaida.add(scrollPane, BorderLayout.CENTER);
        return painelSaida;
    }

    private TableModel modelo() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID:");
        tableModel.addColumn("Nome:");
        tableModel.addColumn("Descrição:");

        atualizarTabela();

        return tableModel;
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Vacina> vacinas = service.listarTodos();
        for (Vacina vacina : vacinas) {
            tableModel.addRow(new Object[]{vacina.getId(), vacina.getNomeVacina(), vacina.getDescricao()});
        }
    }

    private void salvar() {
        String nome = campoNome.getText();
        String descricao = campoDescricao.getText();
        Integer id = campoId.getText().isEmpty() ? null : Integer.parseInt(campoId.getText());

        Vacina vacina = new Vacina(id, nome, descricao);
        service.salvar(vacina);
        atualizarTabela();
        limparCampos();
    }

    private void excluir() {
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            Integer id = (Integer) tableModel.getValueAt(row, 0);
            service.excluir(id);
            atualizarTabela();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma vacina para deletar.");
        }
    }

    private void preencherCampos() {
        int row = tabela.getSelectedRow();
        if (row >= 0) {
            campoId.setText(tableModel.getValueAt(row, 0).toString());
            campoNome.setText(tableModel.getValueAt(row, 1).toString());
            campoDescricao.setText(tableModel.getValueAt(row, 2).toString());
        }
    }

    private void limparCampos() {
        campoId.setText("");
        campoNome.setText("");
        campoDescricao.setText("");
        tabela.clearSelection();
    }
}