package controller;

import java.io.IOException;
import dao.AulaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/excluirAula")
public class ExcluirAulaController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new AulaDAO().excluir(id);
            response.sendRedirect("listarAulas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}