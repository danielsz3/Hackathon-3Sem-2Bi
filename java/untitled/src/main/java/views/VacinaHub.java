package views;

import service.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class VacinaHub extends JFrame{
    //private PacienteService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelDescricao;
    private JTextField campoDescricao;

    private JButton botaoSalvar;
    private JButton botaoCancelar;

    public VacinaHub() {
        //service = new PacienteService();

        setTitle("Vacina App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel painelEntrada = montarPainelEntrada();

        JPanel painelSaida = montarPainelSaida();

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        //pack();
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

        campoDescricao = new JFormattedTextField();
        campoDescricao.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDescricao, constraints);

        botaoCancelar = new JButton("Cancelar");
        //botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        //botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(botaoSalvar, constraints);

        botaoSalvar = new JButton("Deletar");
        //botaoSalvar.addActionListener(e -> salvar());
        constraints.gridx = 2;
        constraints.gridy = 3;
        painelEntrada.add(botaoSalvar, constraints);

        return painelEntrada;
    }

    private JPanel montarPainelSaida() {
        JPanel painelSaida = new JPanel(new BorderLayout());
        var tabela = new JTable();
        tabela.setModel(modelo());
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class,null);
        //tabela.getSelectionModel().addListSelectionListener();
        JScrollPane scrollPane = new JScrollPane(tabela);
        painelSaida.add(scrollPane, BorderLayout.CENTER);
        return painelSaida;
    }

    private TableModel modelo() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID:");
        model.addColumn("Nome:");
        model.addColumn("Descrição:");

        return model;
    }
}
