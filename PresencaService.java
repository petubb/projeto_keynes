package service;

import java.util.List;

import Aluno.Aluno;
import presenca.Presenca;

public class PresencaService {

    public double calcularPercentual(List<Presenca> presencas, Aluno aluno) {
        int total = 0;
        int presentes = 0;

        for (Presenca p : presencas) {
            if (p.getAluno().getId() == aluno.getId()) {
                total++;
                if (p.isPresente()) presentes++;
            }
        }

        if (total == 0) return 0;

        return (presentes * 100.0) / total;
    }
}