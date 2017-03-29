package service;

public class CardapioService {
	CardapioDAO dao;

	public CardapioService() {
		dao = new CardapioDAO();
	}

	public void criar(CardapioTO to) {
		dao.incluir(to);
	}

	public void atualizar(CardapioTO to) {
		dao.atualizar(to);
	}

	public void excluir(CardapioTO to) {
		dao.excluir(to);
	}

	public Cardapio carregar(int id) {
		Cardapio to = dao.carregar(id);
		return to;
	}

	@Override
	public String toString() {
		return "CardapioService [dao=" + dao + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}