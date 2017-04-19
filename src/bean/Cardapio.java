package bean;

import java.util.ArrayList;

public class Cardapio {

	private int id;
	private String tipo, disponibilidade, descricao;
	private double preco;
	// private CardapioDAO cardapio;

	public Cardapio(int id, String tipo, String disponibilidade, String descricao, double preco) {
		this.id = id;
		this.tipo = tipo;
		this.disponibilidade = disponibilidade;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Cardapio() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void criar() {

		CardapioDAO dao = new CardapioDAO();
		CardapioTO to = new CardapioTO();
		to.setId(id);
		to.setTipo(tipo);
		to.setDisponibilidade(disponibilidade);
		to.setDescricao(descricao);
		to.setPreco(preco);
		dao.incluir(to);
	}

	public void atualizar() {
		CardapioDAO dao = new CardapioDAO();
		CardapioTO to = new CardapioTO();
		to.setId(id);
		to.setTipo(tipo);
		to.setDisponibilidade(disponibilidade);
		to.setDescricao(descricao);
		to.setPreco(preco);
		dao.atualizar(to);
	}

	public void excluir() {
		CardapioDAO dao = new CardapioDAO();
		CardapioTO to = new CardapioTO();
		dao.excluir(to);
	}

	public void carregar() {
		CardapioDAO dao = new CardapioDAO();
		@SuppressWarnings("rawtypes")
		ArrayList dados = dao.carregar(id);
		id = (int) dados.get(0);
		tipo = (String) dados.get(1);
		disponibilidade = (String) dados.get(2);
		descricao = (String) dados.get(3);
		preco = (double) dados.get(4);
	}
	
	public CardapioTO carregarUltimo() {
		CardapioDAO dao = new CardapioDAO();
		@SuppressWarnings("rawtypes")
		CardapioTO dados = dao.carregarUltimo();
	return dados;
	}

	@Override
	public String toString() {
		return "Cardapio [id=" + id + ", tipo=" + tipo + ", disponibilidade=" + disponibilidade + ", descricao="
				+ descricao + ", preco=" + preco + "]";
	}

}
