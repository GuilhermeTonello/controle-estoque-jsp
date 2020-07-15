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
			<c:if test="<%= request.getParameter(\"erro\") != null && !request.getParameter(\"erro\").trim().isEmpty() %>">
				<div class="alert alert-danger">
					<c:if test="<%= request.getParameter(\"erro\").equals(\"no-numeric\") %>">
						Erro no(s) campo(s) de quantidade/valor.
					</c:if>
					<c:if test="<%= request.getParameter(\"erro\").equals(\"null-input\") %>">
						Algum(ns) campo(s) está(ão) vazio(s).
					</c:if>
					<c:if test="<%= request.getParameter(\"erro\").equals(\"ja-existe\") %>">
						Esse produto já existe.
					</c:if>
				</div>
			</c:if>
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
					<input placeholder="Nome do produto..." class="form-control" id="nome" name="nome" type="text" max="100" value="${produto.nome}" />
				</div>
				<div class="form-group">
					<label for="descricao">Descrição: </label>
					<input placeholder="Descrição do produto..." class="form-control" id="descricao" name="descricao" type="text" max="255" value="${produto.descricao}" />
				</div>
				<div class="form-group">
					<label for="quantidade">Quantidade: </label>
					<input placeholder="Quantidade do produto..." class="form-control" id="quantidade" name="quantidade" type="text" value="${produto.quantidade}" />
				</div>
				<div class="form-group">
					<label for="valor">Valor: </label>
					<input placeholder="Valor do produto..." class="form-control" id="valor" name="valor" type="text" value="${produto.valor}" />
				</div>
				<button class="btn btn-primary d-block mx-auto px-5" type="submit">Salvar produto</button>
			</form>
		</div>
		<%@ include file="../../resources/layouts/rodape.html" %>
	</body>
</html>