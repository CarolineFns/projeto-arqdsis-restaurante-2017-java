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
		String sqlInsert = "INSERT INTO cardapio(id, tipo, disponibilidade, descricao, preco) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getTipo());
			stm.setString(3, to.getDisponibilidade());
			stm.setString(4, to.getDescricao());
			stm.setDouble(5, to.getPreco());
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

	public CardapioTO carregarUm(int id) {
		ArrayList retorno = new ArrayList();
		CardapioTO to = new CardapioTO();
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

					to = new CardapioTO(id, rs.getString("tipo"), rs.getString("disponibilidade"),
							rs.getString("descricao"), rs.getDouble("preco"));
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
		return to;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregarUS(int id) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT tipo, disponibilidade, descricao, preco FROM cardapio WHERE cardapioUS.id = ?";
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
	public ArrayList carregarES(int id) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT tipo, disponibilidade, descricao, preco FROM cardapio WHERE cardapioES.id = ?";
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregarPelaDescricaoUS(String descricao) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT id, tipo, disponibilidade, preco FROM cardapio WHERE cardapioUS.descricao = ?";
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregarPelaDescricaoES(String descricao) {
		ArrayList retorno = new ArrayList();
		String sqlSelect = "SELECT id, tipo, disponibilidade, preco FROM cardapio WHERE cardapioES.descricao = ?";
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList carregarPratosDisponiveis(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapio WHERE "
				+ "disponibilidade like 'Disponível' and"
				+ " tipo like 'Principal' or tipo like 'Sobremesa' or tipo like 'Entrada';";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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
	public ArrayList carregarPratosDisponiveisUS(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapioUS WHERE "
				+ "disponibilidade like 'Disponível' and"
				+ " tipo like 'Principal' or tipo like 'Sobremesa' or tipo like 'Entrada';";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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
	public ArrayList carregarPratosDisponiveisES(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapioES WHERE "
				+ "disponibilidade like 'Disponível' and"
				+ " tipo like 'Principal' or tipo like 'Sobremesa' or tipo like 'Entrada';";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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
	public ArrayList carregarBebidasDisponiveis(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapio WHERE "
				+ "disponibilidade like 'Disponível' and tipo like 'Bebida'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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
	public ArrayList carregarBebidasDisponiveisUS(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapioUS WHERE "
				+ "disponibilidade like 'Disponível' and tipo like 'Bebida'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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
	public ArrayList carregarBebidasDisponiveisES(String tipo) {
		ArrayList retorno = new ArrayList();

		String sqlSelect = "SELECT id, disponibilidade, descricao, preco FROM cardapioES WHERE "
				+ "disponibilidade like 'Disponível' and tipo like 'Bebida'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, tipo);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					retorno.add(rs.getInt("id"));
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

}
