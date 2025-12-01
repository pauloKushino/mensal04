package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverAlunoView extends JFrame {

    private JTextField txtIdAluno;
    private JButton btnRemover, btnVoltar;

    public RemoverAlunoView() {
        setTitle("Remover Aluno");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID do Aluno:"));
        txtIdAluno = new JTextField();
        add(txtIdAluno);

        btnRemover = new JButton("Remover");
        add(btnRemover);

        btnVoltar = new JButton("Voltar");
        add(btnVoltar);

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover aluno
                JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
