<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Aulas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-5">
	<jsp:include page="navbar.jsp" />
	<div class="d-flex justify-content-between align-items-center mb-4">
		<h2>Aulas Agendadas / Criadas</h2>
		<div>
			<a href="cadastro_aula.jsp" class="btn btn-primary">+ Nova Aula</a> <a
				href="listarAlunos" class="btn btn-outline-secondary">Ver Alunos</a>
		</div>

		<table class="table table-hover">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Data da Aula</th>
					<th>Descrição / Tema</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aula" items="${listaAulas}">
					<tr>
						<td>${aula.descricao}</td>>
						<td class="text-center">
						<a
							href="fazerChamada?aulaId=${aula.id}"
							class="btn btn-sm btn-success me-1">Chamada</a> <a
							href="verRelatorio?aulaId=${aula.id}"
							class="btn btn-sm btn-info text-white me-1">Relatório</a> <a
							href="editarAula?id=${aula.id}"
							class="btn btn-sm btn-warning me-1">Editar</a> <a
							href="excluirAula?id=${aula.id}" class="btn btn-sm btn-danger"
							onclick="return confirm('Tem certeza que deseja apagar esta aula e a chamada?');">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>