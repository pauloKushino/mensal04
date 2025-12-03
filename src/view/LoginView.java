package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public LoginView() {
        setTitle("Sistema de Alunos - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        UITheme.styleFrame(this);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        UITheme.styleLabel(lblTitulo);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuário:");
        UITheme.styleLabel(lblUsuario);
        lblUsuario.setPreferredSize(new Dimension(100, 32));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0.3;
        panel.add(lblUsuario, gbc);

        txtUsuario = new JTextField();
        UITheme.styleField(txtUsuario);
        txtUsuario.setPreferredSize(new Dimension(200, 32));
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        panel.add(txtUsuario, gbc);

        JLabel lblSenha = new JLabel("Senha:");
        UITheme.styleLabel(lblSenha);
        lblSenha.setPreferredSize(new Dimension(100, 32));
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panel.add(lblSenha, gbc);

        txtSenha = new JPasswordField();
        UITheme.styleField(txtSenha);
        txtSenha.setPreferredSize(new Dimension(200, 32));
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        panel.add(txtSenha, gbc);

        btnEntrar = new JButton("Entrar");
        UITheme.styleButton(btnEntrar);
        btnEntrar.setPreferredSize(new Dimension(100, 40));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 0;
        panel.add(btnEntrar, gbc);

        add(panel, BorderLayout.CENTER);
    };

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    public void limparCampos() {
        txtUsuario.setText("");
        txtSenha.setText("");
    }

    public void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro de Login", JOptionPane.ERROR_MESSAGE);
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }
}
