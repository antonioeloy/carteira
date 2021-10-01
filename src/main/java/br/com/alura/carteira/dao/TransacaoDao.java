package br.com.alura.carteira.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TransacaoDao {
	
	private Connection conexao;
	
	public TransacaoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Transacao transacao) {
		
		try {
			
			// Monta o comando SQL (parametrizado).
			String sql = "insert into transacoes(ticker,data,preco,quantidade,tipo) values(?,?,?,?,?)";
			
			// Prepara o comando SQL (substitui os parâmetros).
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, transacao.getTicker());
			ps.setDate(2, Date.valueOf(transacao.getData()));
			ps.setBigDecimal(3, transacao.getPreco());
			ps.setInt(4, transacao.getQuantidade());
			ps.setString(5, transacao.getTipo().toString());
			
			// Executa o comando SQL.
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar transação.");
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Transacao> listar() {
		
		try {
			
			// Monta o comando SQL.
			String sql = "select * from transacoes";
			
			// Prepara o comando SQL.
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			// Executa o comando SQL.
			ResultSet rs = ps.executeQuery();
			
			// Cria uma lista de transações.
			List<Transacao> transacoes = new ArrayList<>();
			
			// Percorre o conjunto de resultados provenientes da consulta ao banco de dados e monta a lista de transações.
			while (rs.next()) {
				Transacao t = new Transacao();
				
				t.setId(rs.getInt("id"));
				t.setTicker(rs.getString("ticker"));
				t.setPreco(rs.getBigDecimal("preco"));
				t.setQuantidade(rs.getInt("quantidade"));
				t.setData(rs.getDate("data").toLocalDate());
				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
				
				transacoes.add(t);
			}
			
			// Retorna a lista de transações.
			return transacoes;
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar transações.");
			throw new RuntimeException(e);
		}
		
	}
	
	public Transacao buscarPorId(int id) {
		
		try {
			
			// Monta o comando SQL (parametrizado).
			String sql = "select * from transacoes where id=?";
			
			// Prepara o comando SQL (substitui o parâmetro "id").
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			
			// Executa o comando SQL.
			ResultSet rs = ps.executeQuery();
			
			// Cria a transação.
			Transacao transacao = new Transacao();
			
			// Preenche a transação.
			rs.next();
			transacao.setId(rs.getInt("id"));
			transacao.setTicker(rs.getString("ticker"));
			transacao.setPreco(rs.getBigDecimal("preco"));
			transacao.setQuantidade(rs.getInt("quantidade"));
			transacao.setData(rs.getDate("data").toLocalDate());
			transacao.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
				
			// Retorna a transação.
			return transacao;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar transação.");
			throw new RuntimeException(e);
		}
		
	}
	
	public void excluir(int id) {
		
		try {
			
			// Monta o comando SQL (parametrizado).
			String sql = "delete from transacoes where id=?";
			
			// Prepara o comando SQL (substitui o parâmetro "id").
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			
			// Executa o comando SQL.
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir transação.");
			throw new RuntimeException(e);
		}
		
	}
	
	public void editar(Transacao transacao) {
		
		try {
			
			// Monta o comando SQL (parametrizado).
			String sql = "update transacoes set ticker=?, data=?, preco=?, quantidade=?, tipo=? where id=?";
			
			// Prepara o comando SQL (substitui os parâmetros).
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, transacao.getTicker());
			ps.setDate(2, Date.valueOf(transacao.getData()));
			ps.setBigDecimal(3, transacao.getPreco());
			ps.setInt(4, transacao.getQuantidade());
			ps.setString(5, transacao.getTipo().toString());
			ps.setInt(6, transacao.getId());
			
			// Executa o comando SQL.
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao editar transação.");
			throw new RuntimeException(e);
		}
		
	}

}
