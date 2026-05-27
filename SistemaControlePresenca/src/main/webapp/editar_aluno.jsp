<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Aluno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <div class="card shadow-sm mx-auto" style="max-width: 600px;">
            <div class="card-header bg-warning text-dark">
                <h4 class="mb-0">Editar Aluno</h4>
            </div>
            <div class="card-body">
                <form action="atualizarAluno" method="POST">
                    <input type="hidden" name="id" value="${aluno.id}">
                    
                    <div class="mb-3">
                        <label class="form-label">Nome do Aluno:</label>
                        <input type="text" name="nome" class="form-control" value="${aluno.nome}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Matrícula:</label>
                        <input type="text" name="matricula" class="form-control" value="${aluno.matricula}" required>
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" name="ativo" class="form-check-input" id="checkAtivo" value="true" ${aluno.ativo ? 'checked' : ''}>
                        <label class="form-check-label" for="checkAtivo">Aluno Ativo</label>
                    </div>
                    <div class="d-flex justify-content-end gap-2">
                        <a href="listarAlunos" class="btn btn-secondary">Cancelar</a>
                        <button type="submit" class="btn btn-warning">Salvar Alterações</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>