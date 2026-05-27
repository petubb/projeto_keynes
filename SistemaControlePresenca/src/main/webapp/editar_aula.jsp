<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Aula</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <div class="card shadow-sm mx-auto" style="max-width: 600px;">
            <div class="card-header bg-warning text-dark">
                <h4 class="mb-0">✏Editar Aula</h4>
            </div>
            <div class="card-body">
                <form action="atualizarAula" method="POST">
                    <input type="hidden" name="id" value="${aula.id}">
                    
                    <div class="mb-3">
                        <label class="form-label">Data da Aula:</label>
                        <input type="date" name="dataAula" class="form-control" value="${aula.dataAula}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Descrição / Tema:</label>
                        <input type="text" name="descricao" class="form-control" value="${aula.descricao}" required>
                    </div>
                    <div class="d-flex justify-content-end gap-2">
                        <a href="listarAulas" class="btn btn-secondary">Cancelar</a>
                        <button type="submit" class="btn btn-warning">Salvar Alterações</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>