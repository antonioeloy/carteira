package br.com.alura.carteira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.factory.ConnectionFactory;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {
	
	private TransacaoDao transacaoDao;
	
	public TransacoesServlet () {	
		this.transacaoDao = new TransacaoDao(new ConnectionFactory().getConnection()); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Obtém a lista de transações no banco de dados e adiciona essa lista na requisição.
		req.setAttribute("transacoes", this.transacaoDao.listar());
		
		// Encaminha a requisição para a página JSP.
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, resp);
		
	}
	
}
