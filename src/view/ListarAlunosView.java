package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarAlunosView extends JFrame {

    private JTable tabelaAlunos;
    private JButton btnVoltar;

    public ListarAlunosView() {
        setTitle("Listar Alunos");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Tabela de alunos
        tabelaAlunos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        add(scrollPane, BorderLayout.CENTER);

        // Botão Voltar
        btnVoltar = new JButton("Voltar");
        add(btnVoltar, BorderLayout.SOUTH);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public JTable getTabelaAlunos() {
        return tabelaAlunos;
    }
}
