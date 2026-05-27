package controller;

import java.io.IOException;
import dao.AlunoDAO;
import model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/atualizarAluno")
public class AtualizarAlunoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Aluno aluno = new Aluno();
        aluno.setId(Integer.parseInt(request.getParameter("id")));
        aluno.setNome(request.getParameter("nome"));
        aluno.setMatricula(request.getParameter("matricula"));
        aluno.setAtivo(request.getParameter("ativo") != null); 
        
        try {
            new AlunoDAO().atualizar(aluno);
            response.sendRedirect("listarAlunos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}