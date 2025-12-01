package service;

import dao.EnderecoDAO;
import model.Endereco;
import java.sql.SQLException;

public class EnderecoService {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public void cadastrarEndereco(Endereco endereco) throws SQLException {
        enderecoDAO.inserir(endereco);
    }

    public void atualizarEndereco(Endereco endereco) throws SQLException {
        enderecoDAO.atualizar(endereco);
    }

    public void removerEndereco(int id) throws SQLException {
        enderecoDAO.deletar(id);
    }

    public Endereco buscarEnderecoPorId(int id) throws SQLException {
        return enderecoDAO.buscarPorId(id);
    }

    public java.util.List<Endereco> listarTodosEnderecos() throws SQLException {
        return enderecoDAO.buscarTodos();
    }
}
