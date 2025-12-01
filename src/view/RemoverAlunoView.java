package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.UITheme;

public class RemoverAlunoView extends JFrame {
    private JTextField txtIdAluno;
    private JButton btnBuscar, btnRemover, btnVoltar;
    private JLabel lblNome, lblCpf, lblRg;

    public RemoverAlunoView() {
        setTitle("Remover Aluno");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 350);
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

        JLabel lblId = new JLabel("ID do Aluno:");
        lblId.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblId);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        panel.add(lblId, gbc);

        txtIdAluno = new JTextField();
        UITheme.styleField(txtIdAluno);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.5;
        panel.add(txtIdAluno, gbc);

        btnBuscar = new JButton("Buscar");
        UITheme.styleButton(btnBuscar);
        gbc.gridx = 2; gbc.gridy = 0; gbc.weightx = 0.2;
        panel.add(btnBuscar, gbc);

        JLabel lblNomeLabel = new JLabel("Nome:");
        lblNomeLabel.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblNomeLabel);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panel.add(lblNomeLabel, gbc);

        lblNome = new JLabel("");
        UITheme.styleLabel(lblNome);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2; gbc.weightx = 0.7;
        panel.add(lblNome, gbc);

        JLabel lblCpfLabel = new JLabel("CPF:");
        lblCpfLabel.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblCpfLabel);
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3; gbc.gridwidth = 1;
        panel.add(lblCpfLabel, gbc);

        lblCpf = new JLabel("");
        UITheme.styleLabel(lblCpf);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 0.7;
        panel.add(lblCpf, gbc);

        JLabel lblRgLabel = new JLabel("RG:");
        lblRgLabel.setPreferredSize(new Dimension(120, 32));
        UITheme.styleLabel(lblRgLabel);
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3; gbc.gridwidth = 1;
        panel.add(lblRgLabel, gbc);

        lblRg = new JLabel("");
        UITheme.styleLabel(lblRg);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 0.7;
        panel.add(lblRg, gbc);

        JLabel lblAviso = new JLabel("Tem certeza que deseja remover?");
        lblAviso.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblAviso.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3;
        panel.add(lblAviso, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnRemover = new JButton("Remover");
        UITheme.styleButton(btnRemover);
        btnVoltar = new JButton("Voltar");
        UITheme.styleButton(btnVoltar);
        buttonPanel.add(btnRemover);
        buttonPanel.add(btnVoltar);
        add(buttonPanel, BorderLayout.SOUTH);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controller busca aluno pelo ID
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controller valida dependências e remove
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public String getIdAluno() {
        return txtIdAluno.getText();
    }

    public void exibirAluno(String nome, String cpf, String rg) {
        lblNome.setText(nome);
        lblCpf.setText(cpf);
        lblRg.setText(rg);
    }

    public void limparCampos() {
        txtIdAluno.setText("");
        lblNome.setText("");
        lblCpf.setText("");
        lblRg.setText("");
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnRemover() {
        return btnRemover;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
