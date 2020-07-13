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
			<h1>Mostrar ${produtoEscolhido.nome}</h1>
			<ul>
				<li>Descrição: ${produtoEscolhido.descricao}</li>
				<li>Quantidade: ${produtoEscolhido.quantidade}</li>
				<li>Valor: ${produtoEscolhido.valor}</li>
			</ul>
		</div>
		<%@ include file="../../resources/layouts/rodape.html" %>
	</body>
</html>