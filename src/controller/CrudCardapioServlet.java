package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cardapio;
import bean.CardapioService;
import bean.CardapioTO;

/**
 * Servlet implementation class CrudCardapioServlet
 */
@WebServlet("/crudCardapio")
public class CrudCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudCardapioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tipo = request.getParameter("tipo");
		String disponibilidade = request.getParameter("disponibilidade");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));
		String oQueFazer = request.getParameter("oQueFazer");

		Cardapio cardapio = new Cardapio(id, tipo, disponibilidade, descricao, preco);
		CardapioTO to = new CardapioTO(id, tipo, disponibilidade, descricao, preco);
		CardapioService service = new CardapioService();
		ArrayList<CardapioTO> toList = new ArrayList<>();
		
		switch (oQueFazer) {
		case "Cadastrar":
			service.criar(to);
			
			to = service.carregarUm(to.getId());
			
			//enviar para o jsp
			request.setAttribute("cardapio", to);
			RequestDispatcher view =
			request.getRequestDispatcher("cardapio.jsp");
			view.forward(request, response);
			
			break;
		case "Consultar":
			to = service.carregarUm(to.getId());
			
				System.out.println("ID"+to.getId());
				System.out.println("Tipo"+to.getTipo());
				System.out.println("Descricao"+to.getDescricao());
				System.out.println("Preco"+to.getPreco());
				System.out.println("Disponibilidade"+to.getDisponibilidade());
			break;
		case "Remover":
			service.excluir(to);
			break;
		case "Atualizar":
			service.atualizar(to);
			break;
		}

		PrintWriter out = response.getWriter();
		out.println("Operação realizada com sucesso");
	}
}
