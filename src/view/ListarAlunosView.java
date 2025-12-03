package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;

public class ListarAlunosView extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnEditar, btnRemover, btnAtualizar, btnVoltar;

    public ListarAlunosView() {
        setTitle("Listar Alunos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        UITheme.styleFrame(this);
        initComponents();
    }

    private void initComponents() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(245, 245, 245));
        JLabel lblTitulo = new JLabel("Lista de Alunos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        UITheme.styleLabel(lblTitulo);
        topPanel.add(lblTitulo);
        add(topPanel, BorderLayout.NORTH);

        String[] colunas = {"ID", "Nome", "CPF", "RG", "CEP"};
        model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(680, 350));
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAtualizar = new JButton("Atualizar Lista");
        UITheme.styleButton(btnAtualizar);
        btnEditar = new JButton("Editar Selecionado");
        UITheme.styleButton(btnEditar);
        btnRemover = new JButton("Remover");
        UITheme.styleButton(btnRemover);
        btnVoltar = new JButton("Voltar");
        UITheme.styleButton(btnVoltar);

        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnEditar);
        buttonPanel.add(btnRemover);
        buttonPanel.add(btnVoltar);
        add(buttonPanel, BorderLayout.SOUTH);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void adicionarAluno(String id, String nome, String cpf, String rg, String cep) {
        model.addRow(new Object[]{id, nome, cpf, rg, cep});
    }

    public void limparTabela() {
        model.setRowCount(0);
    }

    public String getIdAlunoSelecionado() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            return model.getValueAt(row, 0).toString();
        }
        return null;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
