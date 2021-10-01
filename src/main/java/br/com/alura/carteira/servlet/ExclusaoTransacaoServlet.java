package br.com.alura.carteira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.factory.ConnectionFactory;

@WebServlet("/exclusao")
public class ExclusaoTransacaoServlet extends HttpServlet {
	
	private TransacaoDao transacaoDao;
	
	public ExclusaoTransacaoServlet () {	
		this.transacaoDao = new TransacaoDao(new ConnectionFactory().getConnection()); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Exclui a transação.
		transacaoDao.excluir(Integer.parseInt(req.getParameter("id")));
		
		// Redireciona para a página com a lista de transações.
		resp.sendRedirect("transacoes");
		
	}
	
}
