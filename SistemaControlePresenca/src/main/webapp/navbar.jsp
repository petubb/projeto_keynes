<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4 shadow-sm">
    <div class="container-fluid container">
        <a class="navbar-brand" href="index.jsp">Controle de Presença</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="listarAulas">Gerenciar Aulas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listarAlunos">Gerenciar Alunos</a>
                </li>
            </ul>
            <span class="navbar-text text-muted small">
                Módulo Professor
            </span>
        </div>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>