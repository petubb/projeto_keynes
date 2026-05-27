package controller;

import java.io.IOException;
import java.util.List;
import dao.AulaDAO;
import model.Aula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarAulas")
public class AulaController extends HttpServlet {
    private AulaDAO dao = new AulaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<Aula> lista = dao.listarTodas();
            request.setAttribute("listaAulas", lista);
            request.getRequestDispatcher("lista_aulas.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}