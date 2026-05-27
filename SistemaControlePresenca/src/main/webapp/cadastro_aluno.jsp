<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Novo Aluno</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-5">
	<jsp:include page="navbar.jsp" />
	<div class="card shadow" style="max-width: 500px; margin: auto;">
		<div class="card-header bg-primary text-white">
			<h3 class="mb-0">Cadastrar Novo Aluno</h3>
		</div>
		<div class="card-body">
			<form action="salvarAluno" method="POST">
				<div class="mb-3">
					<label class="form-label">Nome Completo</label> <input type="text"
						name="nome" class="form-control" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Número de Matrícula</label> <input
						type="text" name="matricula" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-success w-100">Salvar
					Aluno</button>
				<a href="listarAlunos" class="btn btn-link w-100 mt-2">Voltar
					para Lista</a>
			</form>
		</div>
	</div>
</body>
</html>