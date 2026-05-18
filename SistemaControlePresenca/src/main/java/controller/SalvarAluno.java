package controller;

import java.io.IOException;
import dao.AlunoDAO;
import model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salvarAluno")
public class SalvarAluno extends HttpServlet {
    private AlunoDAO dao = new AlunoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String matricula = request.getParameter("matricula");

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setAtivo(true);

        try {
            dao.salvar(aluno);

            response.sendRedirect("listarAlunos");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao salvar: " + e.getMessage());
        }
    }
}