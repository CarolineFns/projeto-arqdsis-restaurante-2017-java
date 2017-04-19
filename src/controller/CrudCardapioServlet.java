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
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String disponibilidade = request.getParameter("disponibilidade");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("preco"));

		CardapioTO to = new CardapioTO( tipo, disponibilidade, descricao, preco);

		CardapioService service = new CardapioService();
		service.criar(to); 
		
	    //carrega o ultimo inserido
		to = service.carregarUltimo();
		
		//envia para o JSP
		request.setAttribute("cardapio", to); 
		RequestDispatcher view =
				request.getRequestDispatcher("cardapio.jsp");
				view.forward(request, response);
				
		
	}
}
