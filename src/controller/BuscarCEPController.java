package controller;

import view.BuscarCEPView;
import util.ViaCEPUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCEPController {
    private BuscarCEPView view;

    public BuscarCEPController(BuscarCEPView view) {
        this.view = view;
        System.out.println("BuscarCEPController inicializado");
        addEventListeners();
    }

    private void addEventListeners() {
        System.out.println("Registrando listener no botão Buscar");
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Buscar clicado!");
                buscarCEP();
            }
        });
    }

    private void buscarCEP() {
        try {
            String cep = view.getCep();
            System.out.println("CEP digitado: " + cep);
            
            if (cep.isEmpty()) {
                view.exibirErro("Digite um CEP!");
                return;
            }

            if (!cep.matches("\\d{8}")) {
                view.exibirErro("CEP deve conter apenas 8 dígitos!");
                return;
            }

            System.out.println("Buscando CEP na ViaCEP...");
            String json = ViaCEPUtil.buscarEnderecoPorCEP(cep);
            System.out.println("Resposta: " + json);
            
            if (json.contains("\"error\"")) {
                view.exibirErro("CEP não encontrado!");
                return;
            }

            String rua = extrairCampo(json, "logradouro");
            String bairro = extrairCampo(json, "bairro");
            String cidade = extrairCampo(json, "localidade");

            System.out.println("Rua: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade);
            view.exibirEndereco(rua, bairro, cidade);
        } catch (Exception ex) {
            System.out.println("Erro na busca: " + ex.getMessage());
            ex.printStackTrace();
            view.exibirErro("Erro ao buscar CEP: " + ex.getMessage());
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
