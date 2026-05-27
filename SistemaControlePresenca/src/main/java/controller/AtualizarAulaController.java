package controller;

import java.io.IOException;
import java.time.LocalDate;
import dao.AulaDAO;
import model.Aula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/atualizarAula")
public class AtualizarAulaController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aula aula = new Aula();
        aula.setId(Integer.parseInt(request.getParameter("id")));
        aula.setDataAula(LocalDate.parse(request.getParameter("dataAula")));
        aula.setDescricao(request.getParameter("descricao"));
        
        try {
            new AulaDAO().atualizar(aula);
            response.sendRedirect("listarAulas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}