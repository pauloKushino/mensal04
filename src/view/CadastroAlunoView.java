package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;

public class CadastroAlunoView extends JFrame {
    private JTextField txtNome, txtCpf, txtRg, txtCep, txtRua, txtBairro, txtCidade;
    private JButton btnBuscarCep, btnSalvar, btnVoltar;

    public CadastroAlunoView() {
        setTitle("Cadastro de Aluno");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        UITheme.styleFrame(this);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblNome);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        panel.add(lblNome, gbc);
        txtNome = new JTextField();
        UITheme.styleField(txtNome);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        panel.add(txtNome, gbc);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblCpf);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panel.add(lblCpf, gbc);
        txtCpf = new JTextField();
        UITheme.styleField(txtCpf);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        panel.add(txtCpf, gbc);

        JLabel lblRg = new JLabel("RG:");
        lblRg.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblRg);
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panel.add(lblRg, gbc);
        txtRg = new JTextField();
        UITheme.styleField(txtRg);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        panel.add(txtRg, gbc);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblCep);
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        panel.add(lblCep, gbc);
        txtCep = new JTextField();
        UITheme.styleField(txtCep);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.7;
        panel.add(txtCep, gbc);

        btnBuscarCep = new JButton("Buscar CEP");
        UITheme.styleButton(btnBuscarCep);
        gbc.gridx = 2; gbc.gridy = 3; gbc.weightx = 0;
        panel.add(btnBuscarCep, gbc);

        JLabel lblRua = new JLabel("Rua:");
        lblRua.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblRua);
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.3;
        panel.add(lblRua, gbc);
        txtRua = new JTextField();
        UITheme.styleField(txtRua);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 0.7; gbc.gridwidth = 2;
        panel.add(txtRua, gbc);

        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblBairro);
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0.3; gbc.gridwidth = 1;
        panel.add(lblBairro, gbc);
        txtBairro = new JTextField();
        UITheme.styleField(txtBairro);
        gbc.gridx = 1; gbc.gridy = 5; gbc.weightx = 0.7; gbc.gridwidth = 2;
        panel.add(txtBairro, gbc);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblCidade);
        gbc.gridx = 0; gbc.gridy = 6; gbc.weightx = 0.3; gbc.gridwidth = 1;
        panel.add(lblCidade, gbc);
        txtCidade = new JTextField();
        UITheme.styleField(txtCidade);
        gbc.gridx = 1; gbc.gridy = 6; gbc.weightx = 0.7; gbc.gridwidth = 2;
        panel.add(txtCidade, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSalvar = new JButton("Salvar");
        UITheme.styleButton(btnSalvar);
        btnVoltar = new JButton("Voltar");
        UITheme.styleButton(btnVoltar);
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnVoltar);
        add(buttonPanel, BorderLayout.SOUTH);

        btnBuscarCep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controller chama ViaCEP para buscar endereço
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controller valida e salva aluno
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtCep.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
    }

    public String getNome() { return txtNome.getText(); }
    public String getCpf() { return txtCpf.getText(); }
    public String getRg() { return txtRg.getText(); }
    public String getCep() { return txtCep.getText(); }
    public String getRua() { return txtRua.getText(); }
    public String getBairro() { return txtBairro.getText(); }
    public String getCidade() { return txtCidade.getText(); }

    public void preencherEndereco(String rua, String bairro, String cidade) {
        txtRua.setText(rua);
        txtBairro.setText(bairro);
        txtCidade.setText(cidade);
        revalidate();
        repaint();
    }

    public JButton getBtnBuscarCep() {
        return btnBuscarCep;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
