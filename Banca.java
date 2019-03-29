package projeto_pi;

import java.util.ArrayList;
import java.util.Date;

public class Banca {
	
	private int idBanca;
	private Date data;
	private String sala;
	private Grupo grupo;
	private ArrayList<Professor> listaProfessor;
	
	public Banca(int idBanca, Date data, String sala, Grupo grupo, ArrayList<Professor> listaProfessor) {
		this.idBanca = idBanca;
		this.data = data;
		this.sala = sala;
		this.grupo = grupo;
		this.listaProfessor = listaProfessor;
	}
	
	public Banca() {
		
	}

	public int getIdBanca() {
		return idBanca;
	}

	public void setIdBanca(int idBanca) {
		this.idBanca = idBanca;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
