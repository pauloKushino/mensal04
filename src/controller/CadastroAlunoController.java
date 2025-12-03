package controller;

import view.CadastroAlunoView;
import service.AlunoService;
import service.EnderecoService;
import model.Aluno;
import model.Endereco;
import util.ViaCEPUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAlunoController {
    private CadastroAlunoView view;
    private AlunoService alunoService;
    private EnderecoService enderecoService;

    public CadastroAlunoController(CadastroAlunoView view) {
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
                salvarAluno();
            }
        });
    }

    private void buscarCEP() {
        try {
            String cep = view.getCep();
            System.out.println("[CadastroAlunoController] Botão Buscar CEP clicado!");
            System.out.println("[CadastroAlunoController] CEP: " + cep);
            if (cep.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite um CEP!");
                return;
            }

            System.out.println("[CadastroAlunoController] Buscando CEP...");
            String json = ViaCEPUtil.buscarEnderecoPorCEP(cep);
            System.out.println("[CadastroAlunoController] Resposta: " + json);
            
            if (json.contains("\"error\"")) {
                JOptionPane.showMessageDialog(view, "CEP não encontrado!");
                return;
            }

            String rua = extrairCampo(json, "logradouro");
            String bairro = extrairCampo(json, "bairro");
            String cidade = extrairCampo(json, "localidade");

            System.out.println("[CadastroAlunoController] Rua extraída: '" + rua + "'");
            System.out.println("[CadastroAlunoController] Bairro extraído: '" + bairro + "'");
            System.out.println("[CadastroAlunoController] Cidade extraída: '" + cidade + "'");

            view.preencherEndereco(rua, bairro, cidade);
            System.out.println("[CadastroAlunoController] Campos preenchidos na view!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar CEP: " + ex.getMessage());
        }
    }

    private void salvarAluno() {
        try {
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

            Endereco endereco = new Endereco();
            endereco.setCep(cep);
            endereco.setRua(rua);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            enderecoService.cadastrarEndereco(endereco);

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setCpf(cpf);
            aluno.setRg(rg);
            aluno.setEndereco(endereco);
            alunoService.cadastrarAluno(aluno);

            JOptionPane.showMessageDialog(view, "Aluno cadastrado com sucesso!");
            view.limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar aluno: " + ex.getMessage());
        }
    }

    private String extrairCampo(String json, String campo) {
        String busca = "\"" + campo + "\"";
        int ini = json.indexOf(busca);
        if (ini < 0) return "";
        
        ini = json.indexOf(":", ini);
        if (ini < 0) return "";
        ini++;
        
        while (ini < json.length() && (json.charAt(ini) == ' ' || json.charAt(ini) == '\n' || json.charAt(ini) == '\r' || json.charAt(ini) == '\t')) {
            ini++;
        }
        
        if (ini < json.length() && json.charAt(ini) == '"') {
            ini++;
            int fim = json.indexOf("\"", ini);
            if (fim < 0) return "";
            return json.substring(ini, fim);
        }
        
        return "";
    }
}
