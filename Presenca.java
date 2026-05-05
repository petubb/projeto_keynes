package presenca;

import java.time.LocalDate;

import Aluno.Aluno;

public class Presenca {
    private Aluno aluno;
    private LocalDate data;
    private boolean presente;

    public Presenca(Aluno aluno, LocalDate data, boolean presente) {
        this.aluno = aluno;
        this.data = data;
        this.presente = presente;
    }

    public Aluno getAluno() { return aluno; }
    public boolean isPresente() { return presente; }
}