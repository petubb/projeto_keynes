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

@WebServlet("/verRelatorio")
public class RelatorioController extends HttpServlet {
    private AlunoDAO alunoDao = new AlunoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String aulaIdStr = request.getParameter("aulaId");
        
        // Proteção: Se o ID vier vazio ou nulo, manda o usuário de volta para a lista de aulas
        if (aulaIdStr == null || aulaIdStr.trim().isEmpty()) {
            response.sendRedirect("listarAulas");
            return;
        }
        
        // Se passou pela proteção, faz o que já fazia antes:
        int aulaId = Integer.parseInt(aulaIdStr);
        
        try {
            List<Aluno> listaPresenca = alunoDao.listarPorAula(aulaId);
            request.setAttribute("aulaId", aulaId);
            request.setAttribute("listaPresenca", listaPresenca);
            request.getRequestDispatcher("relatorio_aula.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}