package controller;

import view.ListarAlunosView;
import view.EditarAlunoView;
import view.RemoverAlunoView;
import service.AlunoService;
import model.Aluno;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ListarAlunosController {
    private ListarAlunosView view;
    private AlunoService alunoService;

    public ListarAlunosController(ListarAlunosView view) {
        this.view = view;
        this.alunoService = new AlunoService();
        addEventListeners();
        carregarAlunos();
    }

    private void addEventListeners() {
        view.getBtnAtualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarAlunos();
            }
        });

        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarSelecionado();
            }
        });

        view.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerSelecionado();
            }
        });
    }

    public void carregarAlunos() {
        try {
            view.limparTabela();
            List<Aluno> alunos = alunoService.listarTodosAlunos();
            
            for (Aluno aluno : alunos) {
                String cep = aluno.getEndereco() != null ? aluno.getEndereco().getCep() : "";
                view.adicionarAluno(
                    String.valueOf(aluno.getId()),
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getRg(),
                    cep
                );
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar alunos: " + ex.getMessage());
        }
    }

    private void editarSelecionado() {
        String id = view.getIdAlunoSelecionado();
        if (id != null) {
            EditarAlunoView editarView = new EditarAlunoView();
            EditarAlunoController controller = new EditarAlunoController(editarView);
            controller.carregarAluno(Integer.parseInt(id));
            editarView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Selecione um aluno para editar!");
        }
    }

    private void removerSelecionado() {
        String id = view.getIdAlunoSelecionado();
        if (id != null) {
            RemoverAlunoView removerView = new RemoverAlunoView();
            new RemoverAlunoController(removerView);
            removerView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Selecione um aluno para remover!");
        }
    }
}
