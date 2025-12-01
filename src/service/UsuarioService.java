package service;

import dao.UsuarioDAO;
import model.Usuario;
import java.sql.SQLException;

public class UsuarioService {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticar(String nome, String senha) throws SQLException {
        // Pode adicionar hash de senha aqui
        return usuarioDAO.autenticar(nome, senha);
    }

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.inserir(usuario);
    }

    public void atualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.atualizar(usuario);
    }

    public void removerUsuario(int id) throws SQLException {
        usuarioDAO.deletar(id);
    }

    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        return usuarioDAO.buscarPorId(id);
    }

    public java.util.List<Usuario> listarTodosUsuarios() throws SQLException {
        return usuarioDAO.buscarTodos();
    }
}
