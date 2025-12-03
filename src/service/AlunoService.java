package service;

import dao.AlunoDAO;
import model.Aluno;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {

    private AlunoDAO alunoDAO = new AlunoDAO();

    public void cadastrarAluno(Aluno aluno) throws SQLException {
        alunoDAO.inserir(aluno);
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        alunoDAO.atualizar(aluno);
    }

    public void removerAluno(int id) throws SQLException {
        alunoDAO.deletar(id);
    }

    public Aluno buscarAlunoPorId(int id) throws SQLException {
        return alunoDAO.buscarPorId(id);
    }

    public List<Aluno> listarTodosAlunos() throws SQLException {
        return alunoDAO.buscarTodos();
    }
}
