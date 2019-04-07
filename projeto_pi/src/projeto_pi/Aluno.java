package projeto_pi;

import java.util.ArrayList;

public class Aluno extends Usuario {
	int idAluno;
	int idTurmaAluno;
	String ra;
	ArrayList<Turma> listaTurma;
	
	public Aluno(int idUsuario, String nome, String email, String senha, int idAluno, int idTurmaAluno, String ra, ArrayList<Turma> listaTurma) {
		super(idUsuario, nome, email, senha);
		this.idAluno = idAluno;
		this.idTurmaAluno = idTurmaAluno;
		this.ra = ra;
		this.listaTurma = listaTurma;
	}
	
	public Aluno() {
		
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	
	public int getIdTurmaAluno() {
		return idTurmaAluno;
	}
	
	public void setIdTurmaAluno(int idTurmaAluno) {
		this.idTurmaAluno = idTurmaAluno;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public ArrayList<Turma> getListaTurma(){
		return listaTurma;
	}
	
	public void setListaTurma(ArrayList<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}
		
}
