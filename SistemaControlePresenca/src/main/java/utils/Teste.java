package utils;

import dao.AlunoDAO;
import model.Aluno;

public class Teste {
    public static void main(String[] args) {
        try {
            AlunoDAO dao = new AlunoDAO();
            Aluno novo = new Aluno();
            novo.setNome("Aluno Teste");
            novo.setMatricula("1298");
            novo.setAtivo(true);
            
            dao.salvar(novo);
            System.out.println("LESGOOO! Aluno gravado no banco");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}