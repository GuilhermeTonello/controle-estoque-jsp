<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Controle de estoque</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" type="text/css" />
	</head>
	<body>
		<%@ include file="../../resources/layouts/cabecalho.jsp" %>
		<div class="container">
			<c:if test="<%= request.getParameter(\"acao\").equals(\"adicionar\") %>">
				<h1>Novo produto</h1>
			</c:if>
			<c:if test="<%= request.getParameter(\"acao\").equals(\"editar\") %>">
				<h1>Editando produto</h1>
			</c:if>
			<form method="post" action="produtos">
				<input name="id" hidden="hidden" type="number" value="${produto.id}">
				<div class="form-group">
					<label for="nome">Nome: </label>
					<input class="form-control" id="nome" name="nome" type="text" max="100" value="${produto.nome}" />
				</div>
				<div class="form-group">
					<label for="descricao">Descri��o: </label>
					<input class="form-control" id="descricao" name="descricao" type="text" max="255" value="${produto.descricao}" />
				</div>
				<div class="form-group">
					<label for="quantidade">Quantidade: </label>
					<input class="form-control" id="quantidade" name="quantidade" type="number" value="${produto.quantidade}" />
				</div>
				<div class="form-group">
					<label for="valor">Valor: </label>
					<input class="form-control" id="valor" name="valor" type="number" value="${produto.valor}" />
				</div>
				<button class="btn btn-primary d-block mx-auto px-5" type="submit">Salvar produto</button>
			</form>
		</div>
		<%@ include file="../../resources/layouts/rodape.html" %>
	</body>
</html>