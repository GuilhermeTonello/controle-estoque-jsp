<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<%@ include file="../resources/layouts/cabecalho.jsp" %>
		<div class="container">
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
					<tr>
						<td>Sabão em pó</td>
						<td>Limpa tudo bem rápido</td>
						<td>75</td>
						<td>3,99</td>
						<td><a href="produtos?acao=ver&id=1" rel="noopener noreferrer"><span class="glyphicon glyphicon-search"></span></a></td>
						<td><a href="produtos?acao=deletar&id=1" rel="noopener noreferrer"><span class="glyphicon glyphicon-trash"></span></a></td>
						<td><a href="produtos?acao=editar&id=1" rel="noopener noreferrer"><span class="glyphicon glyphicon-pencil"></span></a></td>
					</tr>
					<tr>
						<td>Geladeira</td>
						<td>Freezer incluído</td>
						<td>20</td>
						<td>1499,99</td>
						<td><a href="produtos?acao=ver&id=2" rel="noopener noreferrer"><span class="glyphicon glyphicon-search"></span></a></td>
						<td><a href="produtos?acao=deletar&id=2" rel="noopener noreferrer"><span class="glyphicon glyphicon-trash"></span></a></td>
						<td><a href="produtos?acao=editar&id=2" rel="noopener noreferrer"><span class="glyphicon glyphicon-pencil"></span></a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<%@ include file="../resources/layouts/rodape.html" %>
	</body>
</html>