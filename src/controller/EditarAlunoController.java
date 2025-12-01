package controller;

import view.EditarAlunoView;
import service.AlunoService;
import service.EnderecoService;
import model.Aluno;
import model.Endereco;
import util.ViaCEPUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarAlunoController {
    private EditarAlunoView view;
    private AlunoService alunoService;
    private EnderecoService enderecoService;

    public EditarAlunoController(EditarAlunoView view) {
        this.view = view;
        this.alunoService = new AlunoService();
        this.enderecoService = new EnderecoService();
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnBuscarCep().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCEP();
            }
        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarEdicao();
            }
        });
    }

    public void carregarAluno(int id) {
        try {
            Aluno aluno = alunoService.buscarAlunoPorId(id);
            if (aluno != null) {
                Endereco endereco = aluno.getEndereco();
                view.preencherFormulario(
                    String.valueOf(aluno.getId()),
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getRg(),
                    endereco != null ? endereco.getCep() : "",
                    endereco != null ? endereco.getRua() : "",
                    endereco != null ? endereco.getBairro() : "",
                    endereco != null ? endereco.getCidade() : ""
                );
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar aluno: " + ex.getMessage());
        }
    }

    private void buscarCEP() {
        try {
            String cep = view.getCep();
            if (cep.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite um CEP!");
                return;
            }

            String json = ViaCEPUtil.buscarEnderecoPorCEP(cep);
            
            if (json.contains("\"error\"")) {
                JOptionPane.showMessageDialog(view, "CEP não encontrado!");
                return;
            }

            String rua = extrairCampo(json, "logradouro");
            String bairro = extrairCampo(json, "bairro");
            String cidade = extrairCampo(json, "localidade");

            view.preencherRua(rua);
            view.preencherBairro(bairro);
            view.preencherCidade(cidade);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar CEP: " + ex.getMessage());
        }
    }

    private void salvarEdicao() {
        try {
            int id = Integer.parseInt(view.getIdAluno());
            String nome = view.getNome();
            String cpf = view.getCpf();
            String rg = view.getRg();
            String cep = view.getCep();
            String rua = view.getRua();
            String bairro = view.getBairro();
            String cidade = view.getCidade();

            if (nome.isEmpty() || cpf.isEmpty() || rg.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha todos os campos obrigatórios!");
                return;
            }

            Aluno aluno = alunoService.buscarAlunoPorId(id);
            if (aluno != null) {
                aluno.setNome(nome);
                aluno.setCpf(cpf);
                aluno.setRg(rg);

                Endereco endereco = aluno.getEndereco();
                if (endereco == null) {
                    endereco = new Endereco();
                }
                endereco.setCep(cep);
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                enderecoService.atualizarEndereco(endereco);

                aluno.setEndereco(endereco);
                alunoService.atualizarAluno(aluno);

                JOptionPane.showMessageDialog(view, "Aluno atualizado com sucesso!");
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Aluno não encontrado!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar aluno: " + ex.getMessage());
        }
    }

    private String extrairCampo(String json, String campo) {
        String busca = "\"" + campo + "\":\"";
        int ini = json.indexOf(busca);
        if (ini < 0) return "";
        ini += busca.length();
        int fim = json.indexOf("\"", ini);
        if (fim < 0) return "";
        return json.substring(ini, fim);
    }
}
