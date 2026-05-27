package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aula;
import utils.DBConnection;

public class AulaDAO {

	public void salvar(Aula aula) throws SQLException {
		String sql = "INSERT INTO aula (data_aula, descricao) VALUES (?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			// Converte o LocalDate do Java para o Date
			stmt.setDate(1, Date.valueOf(aula.getDataAula()));
			stmt.setString(2, aula.getDescricao());
			stmt.executeUpdate();
		}
	}

	public List<Aula> listarTodas() throws SQLException {
		List<Aula> lista = new ArrayList<>();
		String sql = "SELECT * from aula ORDER BY data_aula DESC";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Aula a = new Aula();
				a.setId(rs.getInt("id"));
				// Converte de volta para LocalDate
				a.setDataAula(rs.getDate("data_aula").toLocalDate());
				a.setDescricao(rs.getString("descricao"));
				lista.add(a);
			}
		}
		return lista;
	}

	public Aula buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM aula WHERE id = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					Aula aula = new Aula();
					aula.setId(rs.getInt("id"));
					aula.setDataAula(rs.getDate("data_aula").toLocalDate());
					aula.setDescricao(rs.getString("descricao"));
					return aula;
				}
			}
		}
		return null;
	}

	public void atualizar(Aula aula) throws SQLException {
		String sql = "UPDATE aula SET data_aula = ?, descricao = ? WHERE id = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDate(1, java.sql.Date.valueOf(aula.getDataAula()));
			stmt.setString(2, aula.getDescricao());
			stmt.setInt(3, aula.getId());
			stmt.executeUpdate();
		}
	}

	public void excluir(int id) throws SQLException {
		try (Connection conn = DBConnection.getConnection()) {
			String sqlPresenca = "DELETE FROM presenca WHERE aula_id = ?";
			try (PreparedStatement stmtPresenca = conn.prepareStatement(sqlPresenca)) {
				stmtPresenca.setInt(1, id);
				stmtPresenca.executeUpdate();
			}
			String sqlAula = "DELETE FROM aula WHERE id = ?";
			try (PreparedStatement stmtAula = conn.prepareStatement(sqlAula)) {
				stmtAula.setInt(1, id);
				stmtAula.executeUpdate();
			}
		}
	}
}