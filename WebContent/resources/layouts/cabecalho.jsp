<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<header>
	<nav class="navbar navbar-default navbar-expand">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand text-white" rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos">Estoque de produtos</a>
			</div>
			<div class="navbar-nav">
				<div class="dropdown">
					<button class="dropbtn">Listar</button>
					<div class="dropdown-content">
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos">Listar produtos</a>
						<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/usuarios">Listar usuários</a>
					</div>
				</div>
				<div class="dropdown">
					<button class="dropbtn">Novo</button>
					<div class="dropdown-content">
					<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/produtos?acao=adicionar">Novo produto</a>
					<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/usuarios?acao=adicionar">Novo usuário</a>
					</div>
				</div>
				<a rel="noopener noreferrer" href="${pageContext.request.contextPath}/logout">Sair</a>
			</div>
		</div>
	</nav>
</header>