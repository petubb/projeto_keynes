package controller;

import java.io.IOException;
import java.util.List;
import dao.AlunoDAO;
import model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarAlunos")
public class AlunoController extends HttpServlet {
    private AlunoDAO dao = new AlunoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<Aluno> lista = dao.listarTodos();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("lista_alunos.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}