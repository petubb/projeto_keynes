package model;

import java.time.LocalDate;

public class Aula {

	private int id;
    private LocalDate dataAula; 
    private String descricao;

    public Aula() {}
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}
	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}