package bean;

import java.util.ArrayList;

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

	public ArrayList carregar(int id) {
		ArrayList to = dao.carregar(id);
		return to;
	}

	public CardapioTO carregarUm(int id) {
		CardapioTO to = dao.carregarUm(id);
		return to;
	}

	public CardapioDAO getDao() {
		return dao;
	}

	@Override
	public String toString() {
		return "CardapioService [dao=" + dao + ", getDao()=" + getDao() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}