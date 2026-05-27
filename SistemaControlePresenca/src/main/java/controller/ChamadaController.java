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

@WebServlet("/fazerChamada")
public class ChamadaController extends HttpServlet {
    private AlunoDAO alunoDao = new AlunoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String aulaIdStr = request.getParameter("aulaId");
        
        try {
            // verifica todos alunos pra listar na chamada
            List<Aluno> listaAlunos = alunoDao.listarTodos();
            
            request.setAttribute("aulaId", aulaIdStr);
            request.setAttribute("listaAlunos", listaAlunos);
            
            // redirect pra presenca
            request.getRequestDispatcher("fazer_chamada.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}