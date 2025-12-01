package controller;

import view.RemoverAlunoView;
import service.AlunoService;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverAlunoController {
    private RemoverAlunoView view;
    private AlunoService alunoService;

    public RemoverAlunoController(RemoverAlunoView view) {
        this.view = view;
        this.alunoService = new AlunoService();
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAluno();
            }
        });

        view.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerAluno();
            }
        });
    }

    private void buscarAluno() {
        try {
            String idStr = view.getIdAluno();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite um ID!");
                return;
            }

            int id = Integer.parseInt(idStr);
            Aluno aluno = alunoService.buscarAlunoPorId(id);

            if (aluno != null) {
                view.exibirAluno(aluno.getNome(), aluno.getCpf(), aluno.getRg());
            } else {
                JOptionPane.showMessageDialog(view, "Aluno não encontrado!");
                view.limparCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "ID deve ser um número!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar aluno: " + ex.getMessage());
        }
    }

    private void removerAluno() {
        try {
            String idStr = view.getIdAluno();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite um ID!");
                return;
            }

            int id = Integer.parseInt(idStr);
            int resultado = JOptionPane.showConfirmDialog(view, 
                "Tem certeza que deseja remover este aluno?", 
                "Confirmação", 
                JOptionPane.YES_NO_OPTION);

            if (resultado == JOptionPane.YES_OPTION) {
                alunoService.removerAluno(id);
                JOptionPane.showMessageDialog(view, "Aluno removido com sucesso!");
                view.limparCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao remover aluno: " + ex.getMessage());
        }
    }
}
