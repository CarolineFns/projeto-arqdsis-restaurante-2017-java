package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardapioDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
	}

	public void incluir(int id, String tipo, String disponibilidade, String descricao, double preco) {
		String sqlInsert = "INSERT INTO cardapio(id, tipo, disponibilidade, descricao, preco) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			stm.setString(2, tipo);
			stm.setString(3, disponibilidade);
			stm.setString(4, descricao);
			stm.setDouble(5, preco);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void incluirUS(int id, String tipo, String disponibilidade, String descricao, double preco) {
		String sqlInsert = "INSERT INTO cardapioUS(id, tipo, disponibilidade, descricao, preco) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			stm.setString(2, tipo);
			stm.setString(3, disponibilidade);
			stm.setString(4, descricao);
			stm.setDouble(5, preco);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void incluirES(int id, String tipo, String disponibilidade, String descricao, double preco) {
		String sqlInsert = "INSERT INTO cardapioES(id, tipo, disponibilidade, descricao, preco) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id);
			stm.setString(2, tipo);
			stm.setString(3, disponibilidade);
			stm.setString(4, descricao);
			stm.setDouble(5, preco);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(int id, String tipo, String disponibilidade, String descricao, double preco) {
		String sqlUpdate = "UPDATE cardapio SET tipo=?, disponibilidade=?, descricao=?, preco=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, tipo);
			stm.setString(2, disponibilidade);
			stm.setString(3, descricao);
			stm.setDouble(4, preco);
			stm.setInt(5, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cardapio WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregar(int id) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT tipo, disponibilidade, descricao, preco FROM cardapio WHERE cardapio.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getString("tipo"));
					retorno.add(rs.getString("disponibilidade"));
					retorno.add(rs.getString("descricao"));
					retorno.add(rs.getDouble("preco"));
				} else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return retorno;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregarPelaDescricao(String descricao) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT id, tipo, disponibilidade, preco FROM cardapio WHERE cardapio.descricao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, descricao);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
					retorno.add(rs.getString("tipo"));
					retorno.add(rs.getString("disponibilidade"));
					retorno.add(rs.getDouble("preco"));
				} else {
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
					retorno.add(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return retorno;
	}

}
