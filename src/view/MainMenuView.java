package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;
import controller.*;

public class MainMenuView extends JFrame {
    private JButton btnCadastrar, btnEditar, btnRemover, btnListar, btnSair;

    public MainMenuView() {
        setTitle("Sistema de Alunos - Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        UITheme.styleFrame(this);
        initComponents();
    }

    private void initComponents() {
        JPanel navbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        navbar.setBackground(UITheme.PRIMARY_COLOR);
        navbar.setPreferredSize(new Dimension(1280, 60));

        JLabel lblTitulo = new JLabel("Sistema de Gestão de Alunos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        navbar.add(lblTitulo);

        navbar.add(Box.createHorizontalStrut(40));

        btnCadastrar = new JButton("Cadastrar");
        UITheme.styleButton(btnCadastrar);
        btnCadastrar.setPreferredSize(new Dimension(120, 40));
        navbar.add(btnCadastrar);

        btnEditar = new JButton("Editar");
        UITheme.styleButton(btnEditar);
        btnEditar.setPreferredSize(new Dimension(120, 40));
        navbar.add(btnEditar);

        btnRemover = new JButton("Remover");
        UITheme.styleButton(btnRemover);
        btnRemover.setPreferredSize(new Dimension(120, 40));
        navbar.add(btnRemover);

        btnListar = new JButton("Listar");
        UITheme.styleButton(btnListar);
        btnListar.setPreferredSize(new Dimension(120, 40));
        navbar.add(btnListar);

        navbar.add(Box.createHorizontalGlue());

        btnSair = new JButton("Sair");
        UITheme.styleButton(btnSair);
        btnSair.setPreferredSize(new Dimension(100, 40));
        navbar.add(btnSair);

        add(navbar, BorderLayout.NORTH);

        JPanel centerPanel = UITheme.criarPainelComFundo("src/resources/mensal04.jpg", 1280, 660);
        add(centerPanel, BorderLayout.CENTER);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAlunoView view = new CadastroAlunoView();
                new CadastroAlunoController(view);
                view.setVisible(true);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarAlunosView view = new ListarAlunosView();
                new ListarAlunosController(view);
                view.setVisible(true);
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoverAlunoView view = new RemoverAlunoView();
                new RemoverAlunoController(view);
                view.setVisible(true);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarAlunosView view = new ListarAlunosView();
                new ListarAlunosController(view);
                view.setVisible(true);
            }
        });


        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
