<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<title>Controle de estoque</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" type="text/css" />
	</head>
	<body>
		<%@ include file="../../resources/layouts/cabecalho.jsp" %>
		<div class="container">
			<form action="pesquisar" method="post">
				<input hidden="hidden" type="text" name="tipo" value="produto" />
				<div class="form-group">
					<div class="row justify-content-center">
						<div class="col-4">
							<label for="produto-pesquisa">Pesquisar produto:</label>
							<input class="form-control" id="produto-pesquisa" placeholder="Nome do produto..." type="text" name="pesquisa" />
						</div>
					</div>
				</div>
				<button class="btn btn-primary d-block mx-auto px-5" type="submit">Procurar</button>
			</form>
			<br />
			<c:if test="${erro != null && !erro.isEmpty()}">
				<div class="alert alert-danger">
					${erro}
				</div>
			</c:if>
			<c:if test="${sucesso != null && !sucesso.isEmpty()}">
				<div class="alert alert-success">
					${sucesso}
				</div>
			</c:if>
			<h1>Listagem de produtos</h1>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th scope="col">NOME</th>
						<th scope="col">DESCRIÇÃO</th>
						<th scope="col">QUANTIDADE</th>
						<th scope="col">VALOR (R$)</th>
						<th scope="col">VER</th>
						<th scope="col">EXCLUIR</th>
						<th scope="col">EDITAR</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.nome}</td>
							<td>${produto.descricao}</td>
							<td>${produto.quantidade}</td>
							<td>${produto.valor}</td>
							<td>
								<a href="produtos?acao=ver&id=${produto.id}" rel="noopener noreferrer">
								<span class="glyphicon glyphicon-search"></span>
								</a>
							</td>
							<td>
								<a href="produtos?acao=deletar&id=${produto.id}" onclick="return confirm('Deseja mesmo excluir o produto ${produto.nome}')" rel="noopener noreferrer">
									<span class="glyphicon glyphicon-trash"></span>
								</a>
							</td>
							<td>
								<a href="produtos?acao=editar&id=${produto.id}" rel="noopener noreferrer">
									<span class="glyphicon glyphicon-pencil"></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<%@ include file="../../resources/layouts/rodape.html" %>
	</body>
</html>