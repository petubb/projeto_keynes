package controller;

import java.io.IOException;
import dao.AulaDAO;
import model.Aula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editarAula")
public class CarregarAulaController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Aula aula = new AulaDAO().buscarPorId(id);
            request.setAttribute("aula", aula);
            request.getRequestDispatcher("editar_aula.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}