package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import utils.DBConnection;
import java.util.*;


public class AlunoDAO {
    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, matricula, ativo) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setBoolean(3, aluno.isAtivo());
            stmt.executeUpdate();
        }
    }

    public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
                a.setAtivo(rs.getBoolean("ativo"));
                lista.add(a);
            }
        }
        return lista;
    }
    
    public List<Aluno> listarPorAula(int aulaId) throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT a.id, a.nome, a.matricula, p.presente " +
                     "FROM aluno a " +
                     "INNER JOIN presenca p ON a.id = p.aluno_id " +
                     "WHERE p.aula_id = ?";
                     
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, aulaId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setMatricula(rs.getString("matricula"));
                    a.setAtivo(rs.getBoolean("presente")); 
                    lista.add(a);
                }
            }
        }
        return lista;
    }
    
    public Aluno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setMatricula(rs.getString("matricula"));
                    a.setAtivo(rs.getBoolean("ativo"));
                    return a;
                }
            }
        }
        return null;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET nome = ?, matricula = ?, ativo = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setBoolean(3, aluno.isAtivo());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sqlPresenca = "DELETE FROM presenca WHERE aluno_id = ?";
            try (PreparedStatement stmtPresenca = conn.prepareStatement(sqlPresenca)) {
                stmtPresenca.setInt(1, id);
                stmtPresenca.executeUpdate();
            }
            String sqlAluno = "DELETE FROM aluno WHERE id = ?";
            try (PreparedStatement stmtAluno = conn.prepareStatement(sqlAluno)) {
                stmtAluno.setInt(1, id);
                stmtAluno.executeUpdate();
            }
        }
    }
}