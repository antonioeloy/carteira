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
		
		// Busca a transa��o e adiciona na requisi��o.
		req.setAttribute("transacao", this.transacaoDao.buscarPorId(Integer.parseInt(req.getParameter("id"))));
		
		// Encaminha a requisi��o para a p�gina JSP de edi��o de uma transa��o.
		req.getRequestDispatcher("WEB-INF/jsp/edicao.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Obt�m os dados passados no formul�rio.
		int id = Integer.parseInt(req.getParameter("id"));
		String ticker = req.getParameter("ticker");
		BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(',', '.'));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		LocalDate data = LocalDate.parse(req.getParameter("data"));
		TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));
		
		// Cria um objeto do tipo "Transacao".
		Transacao transacao = new Transacao(id, ticker, preco, quantidade, data, tipo);
		
		// Edita a transa��o.
		this.transacaoDao.editar(transacao);
		
		// Redireciona para a p�gina com a lista de transa��es.
		resp.sendRedirect("transacoes");
		
	}

}
