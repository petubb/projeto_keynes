package controller;

import java.io.IOException;
import dao.AlunoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/excluirAluno")
public class ExcluirAlunoController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AlunoDAO().excluir(id);
            response.sendRedirect("listarAlunos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}