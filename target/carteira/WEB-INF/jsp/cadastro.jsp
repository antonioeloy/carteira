<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Carteira</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
	
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  	<div class="container-fluid">
	    	<a class="navbar-brand mb-0 h1" href="#">CARTEIRA</a>
	    	<div class="collapse navbar-collapse" id="navbarNav">
	    		<!-- Menu -->
		    	<ul class="navbar-nav">
		        	<!-- Transações -->
		        	<li class="nav-item">
		          		<a class="nav-link active" aria-current="page" href="/carteira/transacoes">Transações</a>
		        	</li>
		      	</ul>
    		</div>
	  	</div>
	</nav>
	
	<!-- Formulário de cadastro de transação -->
	<div class="container">
		<div class="card mt-3">
		
			<!-- Cabeçalho (título do formulário) -->
			<div class="card-header">
				<h1 class="text-center">Cadastrar Transação</h1>
			</div>
			
			<!-- Corpo (campos do formulário) -->
			<div class="card-body">
				<form action='<c:url value="cadastro"></c:url>' method="post">
			
					<!-- Ticker -->
					<div class="mb-3">
						<label for="ticker" class="form-label">Ticker</label>
						<input type="text" id="ticker" name="ticker" placeholder="Ticker do ativo" class="form-control" required>
					</div>
					
					<!-- Preço -->
					<div class="mb-3">
						<label for="preco" class="form-label">Preço</label>
						<input type="text" id="preco" name="preco" placeholder="Valor em R$" class="form-control" required>
					</div>
					
					<!-- Quantidade -->
					<div class="mb-3">
						<label for="quantidade" class="form-label">Quantidade</label>
						<input type="number" id="quantidade" name="quantidade" placeholder="Quantidade do ativo" class="form-control" required>
					</div>
					
					<!-- Data -->
					<div class="mb-3">
						<label for="data" class="form-label">Data</label>
						<input type="date" id="data" name="data" class="form-control" required>
					</div>
					
					<!-- Tipo -->
					<div class="mb-3">
						<label for="tipo" class="form-label">Tipo</label>
						<select id="tipo" name="tipo" class="form-select">
						  <option value="COMPRA">COMPRA</option>
						  <option value="VENDA">VENDA</option>
						</select>
					</div>
					
					<!-- Botão "Cadastrar" -->
					<button type="submit" class="btn btn-primary mt-3 mb-3">Cadastrar</button>
					
					<!-- Botão "Voltar" -->
					<a class="btn btn-secondary mt-3 mb-3" href="/carteira/transacoes" role="button">Voltar</a>
					
				</form>
			</div>
			
		</div>
	</div>

</body>
</html>