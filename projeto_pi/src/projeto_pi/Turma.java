package projeto_pi;

import java.util.ArrayList;

public class Turma {
	
	private int semestreLetivo;
	private int anoLetivo;
	private String sigla;
	private Tema tema;
	ArrayList<Aluno> listaAluno;
	
	public Turma(int semestreLetivo, int anoLetivo, String sigla, Tema tema, ArrayList<Aluno> listaAluno) {
		this.semestreLetivo = semestreLetivo;
		this.anoLetivo = anoLetivo;
		this.sigla = sigla;
		this.tema = tema;
		this.listaAluno = listaAluno;
	}

	public int getSemestreLetivo() {
		return semestreLetivo;
	}

	public void setSemestreLetivo(int semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public ArrayList<Aluno> getListaAluno(){
		return listaAluno;
	}
	
	public void setListaTurma(ArrayList<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	
}
