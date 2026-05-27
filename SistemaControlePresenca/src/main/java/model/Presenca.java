package model;

public class Presenca {
    private int id;
    private int alunoId;
    private int aulaId;
    private boolean presente;
    
    public Presenca() {}
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAlunoId() { return alunoId; }
    public void setAlunoId(int j) { this.alunoId = j; }
    public int getAulaId() { return aulaId; }
    public void setAulaId(int aulaId) { this.aulaId = aulaId; }
    public boolean isPresente() { return presente; }
    public void setPresente(boolean presente) { this.presente = presente; }
}