package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import utils.DBConnection;

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
}