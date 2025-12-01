package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarAlunoView extends JFrame {

    private JTextField txtIdAluno, txtNome, txtCpf, txtRg;
    private JButton btnSalvar, btnVoltar;

    public EditarAlunoView() {
        setTitle("Editar Aluno");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID do Aluno:"));
        txtIdAluno = new JTextField();
        add(txtIdAluno);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        add(new JLabel("RG:"));
        txtRg = new JTextField();
        add(txtRg);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnVoltar = new JButton("Voltar");
        add(btnVoltar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar alterações do aluno
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
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
