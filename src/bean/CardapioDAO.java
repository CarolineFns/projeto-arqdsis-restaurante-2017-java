package bean;

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
		return DriverManager.getConnection("jdbc:mysql://localhost/Restaurante?user=alunos&password=alunos");
	}

	public void incluir(CardapioTO to) {
		String sqlInsert = "INSERT INTO cardapio(id, tipo, disponibilidade, descricao, preco) VALUES (0, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//			stm.setInt(1, to.getId());
			stm.setString(1, to.getTipo());
			stm.setString(2, to.getDisponibilidade());
			stm.setString(3, to.getDescricao());
			stm.setDouble(4, to.getPreco());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CardapioTO to) {
		String sqlUpdate = "UPDATE cardapio SET tipo=?, disponibilidade=?, descricao=?, preco=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getTipo());
			stm.setString(2, to.getDisponibilidade());
			stm.setString(3, to.getDescricao());
			stm.setDouble(4, to.getPreco());
			stm.setInt(5, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(CardapioTO to) {
		String sqlDelete = "DELETE FROM cardapio WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
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

	public CardapioTO carregarUltimo() {
		CardapioTO to = new CardapioTO();
		String sqlSelect = "select * from cardapio order by id desc limit 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					to = new CardapioTO(rs.getInt("id"), rs.getString("tipo"), rs.getString("disponibilidade"),
							rs.getString("descricao"), rs.getDouble("preco"));
				} else {
					
				to = new CardapioTO(0,"Não Encontrado","Não Encontrado","Não Encontrado",0.0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

}
