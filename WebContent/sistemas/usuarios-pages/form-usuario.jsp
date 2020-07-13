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
				<h1>Novo usuário</h1>
			</c:if>
			<c:if test="<%= request.getParameter(\"acao\").equals(\"editar\") %>">
				<h1>Editando usuário</h1>
			</c:if>
			<form method="post" action="usuarios">
				<input name="id" hidden="hidden" type="number" value="${usuario.id}">
				<div class="form-group">
					<label for="nome">Nome: </label>
					<input class="form-control" id="nome" name="nome" type="text" max="255" value="${usuario.nome}" />
				</div>
				<div class="form-group">
					<label for="login">Login: </label>
					<input class="form-control" id="login" name="login" type="text" max="255" value="${usuario.login}" />
				</div>
				<div class="form-group">
					<label for="senha">Senha: </label>
					<input class="form-control" id="senha" name="senha" type="password" max="255" value="${usuario.senha}" />
				</div>
				<button class="btn btn-primary d-block mx-auto px-5" type="submit">Salvar usuário</button>
			</form>
		</div>
		<%@ include file="../../resources/layouts/rodape.html" %>
	</body>
</html>