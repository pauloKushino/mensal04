package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;

public class BuscarCEPView extends JFrame {
    private JTextField txtCep;
    private JLabel lblRua, lblBairro, lblCidade;
    private JButton btnBuscar, btnVoltar;

    public BuscarCEPView() {
        setTitle("Buscar CEP");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
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

        JLabel lblTitulo = new JLabel("Busca de CEP via ViaCEP");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        UITheme.styleLabel(lblTitulo);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        panel.add(lblTitulo, gbc);

        JLabel lblCepLabel = new JLabel("CEP:");
        lblCepLabel.setPreferredSize(new Dimension(100, 32));
        UITheme.styleLabel(lblCepLabel);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0.2;
        panel.add(lblCepLabel, gbc);

        txtCep = new JTextField();
        UITheme.styleField(txtCep);
        txtCep.setPreferredSize(new Dimension(200, 32));
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.6;
        panel.add(txtCep, gbc);

        btnBuscar = new JButton("Buscar");
        UITheme.styleButton(btnBuscar);
        btnBuscar.setPreferredSize(new Dimension(80, 32));
        gbc.gridx = 2; gbc.gridy = 1; gbc.weightx = 0.2;
        panel.add(btnBuscar, gbc);

        JLabel lblRuaLabel = new JLabel("Rua:");
        lblRuaLabel.setPreferredSize(new Dimension(100, 32));
        UITheme.styleLabel(lblRuaLabel);
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.2; gbc.gridwidth = 1;
        panel.add(lblRuaLabel, gbc);

        lblRua = new JLabel("");
        UITheme.styleLabel(lblRua);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.8; gbc.gridwidth = 2;
        panel.add(lblRua, gbc);

        JLabel lblBairroLabel = new JLabel("Bairro:");
        lblBairroLabel.setPreferredSize(new Dimension(100, 32));
        UITheme.styleLabel(lblBairroLabel);
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.2; gbc.gridwidth = 1;
        panel.add(lblBairroLabel, gbc);

        lblBairro = new JLabel("");
        UITheme.styleLabel(lblBairro);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.8; gbc.gridwidth = 2;
        panel.add(lblBairro, gbc);

        JLabel lblCidadeLabel = new JLabel("Cidade:");
        lblCidadeLabel.setPreferredSize(new Dimension(100, 32));
        UITheme.styleLabel(lblCidadeLabel);
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.2; gbc.gridwidth = 1;
        panel.add(lblCidadeLabel, gbc);

        lblCidade = new JLabel("");
        UITheme.styleLabel(lblCidade);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 0.8; gbc.gridwidth = 2;
        panel.add(lblCidade, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnVoltar = new JButton("Voltar");
        UITheme.styleButton(btnVoltar);
        buttonPanel.add(btnVoltar);
        add(buttonPanel, BorderLayout.SOUTH);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public String getCep() {
        return txtCep.getText();
    }

    public void exibirEndereco(String rua, String bairro, String cidade) {
        lblRua.setText(rua);
        lblBairro.setText(bairro);
        lblCidade.setText(cidade);
        revalidate();
        repaint();
    }

    public void limparCampos() {
        txtCep.setText("");
        lblRua.setText("");
        lblBairro.setText("");
        lblCidade.setText("");
    }

    public void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro ao buscar CEP", JOptionPane.ERROR_MESSAGE);
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
