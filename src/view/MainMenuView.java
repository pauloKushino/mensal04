package view;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    public MainMenuView() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
        JButton btnEditarAluno = new JButton("Editar Aluno");
        JButton btnRemoverAluno = new JButton("Remover Aluno");
        JButton btnListarAlunos = new JButton("Listar Alunos");
        JButton btnBuscarCEP = new JButton("Buscar CEP");

        add(btnCadastroAluno);
        add(btnEditarAluno);
        add(btnRemoverAluno);
        add(btnListarAlunos);
        add(btnBuscarCEP);

        btnCadastroAluno.addActionListener(e -> new CadastroAlunoView().setVisible(true));
        btnEditarAluno.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade de edição não implementada!"));
        btnRemoverAluno.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade de remoção não implementada!"));
        btnListarAlunos.addActionListener(e -> new ListarAlunosView().setVisible(true));
        btnBuscarCEP.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade de busca de CEP não implementada!"));
    }
}
