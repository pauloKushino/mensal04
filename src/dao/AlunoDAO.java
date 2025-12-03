package dao;

import util.ConnectionFactory;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, cpf, rg, endereco_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getRg());
            stmt.setInt(4, aluno.getEndereco().getId());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: CPF ou RG já cadastrado.", e);
        }
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET nome = ?, cpf = ?, rg = ?, endereco_id = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getRg());
            stmt.setInt(4, aluno.getEndereco().getId());
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: CPF ou RG já cadastrado.", e);
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Aluno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                int enderecoId = rs.getInt("endereco_id");
                dao.EnderecoDAO enderecoDAO = new dao.EnderecoDAO();
                model.Endereco endereco = enderecoDAO.buscarPorId(enderecoId);
                aluno.setEndereco(endereco);
                return aluno;
            }
        }
        return null;
    }

    public List<Aluno> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        dao.EnderecoDAO enderecoDAO = new dao.EnderecoDAO();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                int enderecoId = rs.getInt("endereco_id");
                model.Endereco endereco = enderecoDAO.buscarPorId(enderecoId);
                aluno.setEndereco(endereco);
                alunos.add(aluno);
            }
        }
        return alunos;
    }
}
