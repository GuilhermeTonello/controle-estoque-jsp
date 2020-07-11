<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<title>Controle de estoque</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" />
		<style type="text/css">
			body * {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<div class="row">
			<div class="col-centered mt-5 col-6">
				<div class="login-form-body">
					<div class="login-form-header pt-3 mb-4">
						<p class="pl-5">Login</p>
					</div>
					<form class="mb-4" method="post" action="logar">
						<div class="row">
							<div class="form-group mt-3 mb-3 col-6 col-centered">
								<label for="login">Login:</label>
								<input class="form-control" type="text" name="login" id="login" />
							</div>
						</div>
						<div class="row">
							<div class="form-group mt-3 mb-3 col-6 col-centered">
								<label for="senha">Senha:</label>
								<input class="form-control" type="password" name="senha" id="senha" />
							</div>
						</div>
						<div class="row">
							<div class="mt-3 col-3 col-centered">
								<button type="submit" class="btn btn-block login-button">Logar</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="resources/layouts/rodape.html" %>
	</body>
</html>