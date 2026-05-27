<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Nova Aula</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-5">
	<jsp:include page="navbar.jsp" />
	<div class="card shadow" style="max-width: 500px; margin: auto;">
		<div class="card-header bg-dark text-white">
			<h3 class="mb-0">Cadastrar Nova Aula</h3>
		</div>
		<div class="card-body">
			<form action="salvarAula" method="POST">
				<div class="mb-3">
					<label class="form-label">Data da Aula</label> <input type="date"
						name="dataAula" class="form-control" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Descrição / Tema da Aula</label> <input
						type="text" name="descricao" class="form-control"
						placeholder="Ex: Introdução ao Java Web" required>
				</div>
				<button type="submit" class="btn btn-success w-100">Criar
					Aula</button>
				<a href="listarAulas" class="btn btn-link w-100 mt-2">Voltar
					para Lista</a>
			</form>
		</div>
	</div>
</body>
</html>