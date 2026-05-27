<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fazer Chamada</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Diário de Classe - Aula ID: ${aulaId}</h2>
    
    <form action="salvarChamada" method="POST">
        <input type="hidden" name="aulaId" value="${aulaId}">
        
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Matrícula</th>
                    <th>Nome do Aluno</th>
                    <th class="text-center">Presença</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="aluno" items="${listaAlunos}">
                    <tr>
                        <td>${aluno.matricula}</td>
                        <td>${aluno.nome}</td>
                        <td class="text-center">
                            <input type="hidden" name="alunoIds" value="${aluno.id}">
                            
                            <input type="checkbox" name="presente_${aluno.id}" value="sim" class="form-check-input" style="transform: scale(1.3);">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="mt-4">
            <button type="submit" class="btn btn-success btn-lg">Finalizar e Salvar Chamada</button>
            <a href="listarAulas" class="btn btn-secondary btn-lg ms-2">Cancelar</a>
        </div>
    </form>
</body>
</html>