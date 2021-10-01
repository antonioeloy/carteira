package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.factory.ConnectionFactory;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@WebServlet("/edicao")
public class EdicaoTransacaoServlet extends HttpServlet {
	
	private TransacaoDao transacaoDao;
	
	public EdicaoTransacaoServlet () {	
		this.transacaoDao = new TransacaoDao(new ConnectionFactory().getConnection()); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Busca a transação e adiciona na requisição.
		req.setAttribute("transacao", this.transacaoDao.buscarPorId(Integer.parseInt(req.getParameter("id"))));
		
		// Encaminha a requisição para a página JSP de edição de uma transação.
		req.getRequestDispatcher("WEB-INF/jsp/edicao.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Obtém os dados passados no formulário.
		int id = Integer.parseInt(req.getParameter("id"));
		String ticker = req.getParameter("ticker");
		BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(',', '.'));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		LocalDate data = LocalDate.parse(req.getParameter("data"));
		TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));
		
		// Cria um objeto do tipo "Transacao".
		Transacao transacao = new Transacao(id, ticker, preco, quantidade, data, tipo);
		
		// Edita a transação.
		this.transacaoDao.editar(transacao);
		
		// Redireciona para a página com a lista de transações.
		resp.sendRedirect("transacoes");
		
	}

}
