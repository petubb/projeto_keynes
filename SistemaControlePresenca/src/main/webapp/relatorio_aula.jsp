<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Relatório de Presença</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5 text-white"> <h2 class="mb-4 text-dark">📊 Relatório de Frequência - Aula ID: ${aulaId}</h2>
    
    <table class="table table-hover table-bordered bg-light">
        <thead class="table-dark">
            <tr>
                <th>Matrícula</th>
                <th>Nome do Aluno</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${listaPresenca}">
                <tr>
                    <td class="text-dark">${aluno.matricula}</td>
                    <td class="text-dark">${aluno.nome}</td>
                    <td>
                        <c:choose>
                            <c:when test="${aluno.ativo}">
                                <span class="badge bg-success p-2">Presente</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge bg-danger p-2">Ausente</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="mt-4">
        <a href="listarAulas" class="btn btn-primary">Voltar para Aulas</a>
    </div>
</body>
</html>