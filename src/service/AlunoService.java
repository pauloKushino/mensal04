package service;

import dao.AlunoDAO;
import model.Aluno;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {

    private AlunoDAO alunoDAO = new AlunoDAO();

    // Métodos de update, delete, buscar, listar
    public void cadastrarAluno(Aluno aluno) throws SQLException {
        // Validação de dados pode ser feita aqui
        alunoDAO.inserir(aluno);
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        // Validação de dados pode ser feita aqui
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
