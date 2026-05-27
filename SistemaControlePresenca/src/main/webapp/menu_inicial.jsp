<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<a href="cadastro_aluno.jsp" class="btn btn-primary mb-3">+ Novo Aluno</a>
<a href="cadastro_aula.jsp" class="btn btn-primary mb-3">+ Nova Aula</a>
<a href="lista_aulas.jsp" class="btn btn-primary mb-3">Listar aulas</a>
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

        </tbody>
    </table>
</body>
</html>