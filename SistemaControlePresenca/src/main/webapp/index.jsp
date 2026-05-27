<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Início - Controle de Presença</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <div class="p-5 mb-4 bg-white rounded-3 shadow-sm border text-center">
            <div>
                <h1 class="fw-bold text-dark">Diário de Classe Digital</h1>
                <p class="col-md-8 fs-4 mx-auto mt-3">
                    Bem-vindo ao Sistema de Controle de Presença.
                </p>
                <hr class="my-4" style="max-width: 400px; margin: auto;">
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mt-4">
                    <a href="listarAulas" class="btn btn-primary btn-lg px-4 gap-3">Listar Aulas</a>
                    <a href="listarAlunos" class="btn btn-outline-secondary btn-lg px-4">Ver Alunos</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>