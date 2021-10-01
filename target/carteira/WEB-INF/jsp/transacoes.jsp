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
		        	<!-- Transa��es -->
		        	<li class="nav-item">
		          		<a class="nav-link active" aria-current="page" href="/carteira/transacoes">Transa��es</a>
		        	</li>
		      	</ul>
    		</div>
	  	</div>
	</nav>

	<!-- Tabela com as transa��es -->
	<div class="container">
		<div class="card mt-3 mb-3">
	
			<!-- Cabe�alho (t�tulo da tabela) -->
			<div class="card-header">
				<h1 class="text-center">Lista de Transa��es</h1>
			</div>
			
			<!-- Corpo -->
			<div class="card-body">
			
				<!-- Bot�o para cadastrar um nova transa��o. -->
				<a class="btn btn-primary mb-3" href="/carteira/cadastro" role="button">Cadastrar transa��o</a>
			
				<!-- Tabela com as transa��es -->
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>TICKER</th>
							<th>PRE�O</th>
							<th>QUANTIDADE</th>
							<th>DATA</th>
							<th>TIPO</th>
							<th>A��ES</th>
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