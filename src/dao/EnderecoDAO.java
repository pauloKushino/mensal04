package dao;

import model.Endereco;
import util.ConnectionFactory;

import java.sql.*;

public class EnderecoDAO {
    public void inserir(Endereco endereco) throws SQLException {
        // Insere um novo endereço no banco de dados
        String sql = "INSERT INTO endereco (rua, bairro, cidade, cep) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getCep());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    endereco.setId(rs.getInt(1));
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: CEP já cadastrado.", e);
        }
    }

    public void atualizar(Endereco endereco) throws SQLException {
        // Atualiza os dados de um endereço existente
        String sql = "UPDATE endereco SET rua = ?, bairro = ?, cidade = ?, cep = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getCep());
            stmt.setInt(5, endereco.getId());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("Erro: CEP já cadastrado.", e);
        }
    }

    public void deletar(int id) throws SQLException {
        // Remove um endereço pelo id
        String sql = "DELETE FROM endereco WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Endereco buscarPorId(int id) throws SQLException {
        // Busca um endereço pelo id
        String sql = "SELECT * FROM endereco WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Endereco endereco = new Endereco();
                    endereco.setId(rs.getInt("id"));
                    endereco.setRua(rs.getString("rua"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setCep(rs.getString("cep"));
                    return endereco;
                }
            }
        }
        return null;
    }

    public java.util.List<Endereco> buscarTodos() throws SQLException {
        // Busca todos os endereços
        String sql = "SELECT * FROM endereco";
        java.util.List<Endereco> lista = new java.util.ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));
                lista.add(endereco);
            }
        }
        return lista;
    }
}
