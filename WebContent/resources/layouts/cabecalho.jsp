<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<header>
	<nav class="navbar navbar-default navbar-expand">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand text-white" rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos">Estoque de produtos</a>
			</div>
			<ul class="navbar-nav ml-auto">
				<c:if test="${fn:contains(pageContext.request.requestURI, 'produtos')}">
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos">Listagem de produtos</a>
					</li>
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos?acao=adicionar">Novo produto</a>
					</li>
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/usuarios">Usuários</a>
					</li>
				</c:if>
				<c:if test="${fn:contains(pageContext.request.requestURI, 'usuarios')}">
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/usuarios">Listagem de usuários</a>
					</li>
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/usuarios?acao=adicionar">Novo usuário</a>
					</li>
					<li class="nav-item mr-3 ml-3">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos">Produtos</a>
					</li>
				</c:if>
				<li class="nav-item mr-3 ml-3">
					<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/logout">Sair</a>
				</li>
			</ul>
		</div>
	</nav>
</header>