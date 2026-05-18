<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Alunos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<a href="cadastro_aluno.jsp" class="btn btn-primary mb-3">+ Novo Aluno</a>
    <h2 class="mb-4">Alunos Cadastrados</h2>
    <table class="table table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Matrícula</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${lista}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.matricula}</td>
                    <td>
                        <span class="badge ${aluno.ativo ? 'bg-success' : 'bg-secondary'}">
                            ${aluno.ativo ? 'Ativo' : 'Inativo'}
                        </span>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>