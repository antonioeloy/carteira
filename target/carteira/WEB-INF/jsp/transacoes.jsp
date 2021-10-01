<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<!-- Tabela com as transações -->
	<div class="container">
		<div class="card mt-3 mb-3">
	
			<!-- Cabeçalho (título da tabela) -->
			<div class="card-header">
				<h1 class="text-center">Lista de Transações</h1>
			</div>
			
			<!-- Corpo -->
			<div class="card-body">
			
				<!-- Botão para cadastrar um nova transação. -->
				<a class="btn btn-primary mb-3" href="/carteira/cadastro" role="button">Cadastrar transação</a>
			
				<!-- Tabela com as transações -->
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>TICKER</th>
							<th>PREÇO</th>
							<th>QUANTIDADE</th>
							<th>DATA</th>
							<th>TIPO</th>
							<th>AÇÕES</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transacoes}" var="transacao">
							<tr>
								<td>${transacao.ticker}</td>
								<td>${transacao.preco}</td>
								<td>${transacao.quantidade}</td>
								<td><fmt:parseDate value="${transacao.data}" pattern="yyyy-MM-dd" var="formatada" type="date" /><fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy" type="date"/></td>
								<td>${transacao.tipo}</td>
								<td>
									<a class="btn btn-success mr-3" href="/carteira/edicao?id=${transacao.id}" role="button">Editar</a>
									<a class="btn btn-danger" href="/carteira/exclusao?id=${transacao.id}" role="button">Excluir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>