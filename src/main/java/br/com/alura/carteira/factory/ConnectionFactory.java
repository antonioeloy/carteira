package br.com.alura.carteira.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class ConnectionFactory {
	
	public Connection getConnection() {

		Connection conexao = null;
		Integer tentativasConexao = 0;
		while (conexao == null && tentativasConexao <= 20) {
			try {
				String url = "jdbc:mysql://mysqldb:3306/carteira";
				String usuario = "root";
				String senha = "root";
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection(url, usuario, senha);
				return conexao;
			} catch (SQLException | ClassNotFoundException e) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException ex) {
					throw new RuntimeException(ex);
				}
				tentativasConexao++;
				System.out.println("Erro ao estabelecer conexão com o banco de dados. Tentando novamente...");
			}
		}
		throw new RuntimeException("Não foi possível estabelecer conexão com o banco de dados.");
	}
		
}
