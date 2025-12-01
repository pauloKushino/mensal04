package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Aluno;
import model.Endereco;
import service.AlunoService;
import service.EnderecoService;

public class CadastroAlunoView extends JFrame {

    private EnderecoService enderecoService = new EnderecoService();
    private AlunoService alunoService = new AlunoService();
    private JButton btnSalvar;
    private JTextField txtNome, txtCpf, txtRg, txtRua, txtBairro, txtCidade, txtCep;

    public CadastroAlunoView() {

        setLayout(new GridLayout(8, 2));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setTitle("Cadastro de Aluno");

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        add(new JLabel("RG:"));
        txtRg = new JTextField();
        add(txtRg);

        add(new JLabel("Rua:"));
        txtRua = new JTextField();
        add(txtRua);

        add(new JLabel("Bairro:"));
        txtBairro = new JTextField();
        add(txtBairro);

        add(new JLabel("Cidade:"));
        txtCidade = new JTextField();
        add(txtCidade);

        add(new JLabel("CEP:"));
        txtCep = new JTextField();
        add(txtCep);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        // Adicionando listener ao botão Salvar para cadastrar aluno e endereço
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Endereco endereco = new Endereco();
                    endereco.setRua(txtRua.getText());
                    endereco.setBairro(txtBairro.getText());
                    endereco.setCidade(txtCidade.getText());
                    endereco.setCep(txtCep.getText());

                    enderecoService.cadastrarEndereco(endereco);
                    // O id do endereço é preenchido após o insert
                    Aluno aluno = new Aluno();
                    aluno.setNome(txtNome.getText());
                    aluno.setCpf(txtCpf.getText());
                    aluno.setRg(txtRg.getText());
                    aluno.setEndereco(endereco);
                    alunoService.cadastrarAluno(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });
    }
}
