package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Presenca;
import utils.DBConnection;

public class PresencaDAO {

    public void salvarPresenca(Presenca presenca) throws SQLException {
        String sql = "INSERT INTO presenca (aluno_id, aula_id, presente) VALUES (?, ?, ?) "
                   + "ON DUPLICATE KEY UPDATE presente = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, presenca.getAlunoId());
            stmt.setInt(2, presenca.getAulaId());
            stmt.setBoolean(3, presenca.isPresente());
            stmt.setBoolean(4, presenca.isPresente());
            stmt.executeUpdate();
        }
    }
}