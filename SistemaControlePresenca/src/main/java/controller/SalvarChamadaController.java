package controller;

import java.io.IOException;
import java.sql.SQLException;
import dao.PresencaDAO;
import model.Presenca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salvarChamada")
public class SalvarChamadaController extends HttpServlet {
    private PresencaDAO presencaDao = new PresencaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int aulaId = Integer.parseInt(request.getParameter("aulaId"));
        // recebe os id de todos os alunos da lista
        String[] alunoIds = request.getParameterValues("alunoIds");

        if (alunoIds != null) {
            try {
                for (String alunoIdStr : alunoIds) {
                    int alunoId = Integer.parseInt(alunoIdStr);
                    
                    // verifica se o checkbox daquele aluno foi marcado
                    String presenteParam = request.getParameter("presente_" + alunoId);
                    boolean presente = (presenteParam != null); // se vier marcado, nao e nulo

                    Presenca p = new Presenca();
                    p.setAulaId(aulaId);
                    p.setAlunoId(alunoId);
                    p.setPresente(presente);

                    presencaDao.salvarPresenca(p);
                }
                response.sendRedirect("listarAulas");
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Erro ao salvar chamada: " + e.getMessage());
            }
        }
    }
}