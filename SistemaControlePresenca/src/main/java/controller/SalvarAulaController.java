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

@WebServlet("/salvarAula")
public class SalvarAulaController extends HttpServlet {
    private AulaDAO dao = new AulaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String dataStr = request.getParameter("dataAula");
        String descricao = request.getParameter("descricao");

        Aula aula = new Aula();
        // trabnsforma o texto da data vindo do html para LocalDate
        aula.setDataAula(LocalDate.parse(dataStr));
        aula.setDescricao(descricao);

        try {
            dao.salvar(aula);
            response.sendRedirect("listarAulas");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao salvar aula: " + e.getMessage());
        }
    }
}