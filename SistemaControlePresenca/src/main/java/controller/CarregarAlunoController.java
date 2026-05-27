package controller;

import java.io.IOException;
import dao.AlunoDAO;
import model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editarAluno")
public class CarregarAlunoController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Aluno aluno = new AlunoDAO().buscarPorId(id);
            request.setAttribute("aluno", aluno);
            request.getRequestDispatcher("editar_aluno.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}