package projeto_pi;

import java.util.*;

public class Professor extends Usuario {
	int idProf;
	int administrador;
	String matricula; 
	ArrayList<Banca> listaBanca;
	
	public Professor(int idUsuario, String nome, String email, String senha, int idProf, int administrador, String matricula, ArrayList<Banca> listaBanca) {
		
		super(idUsuario, nome, email, senha);
		this.idProf = idProf;
		this.administrador = administrador;
		this.matricula = matricula;
		this.listaBanca = listaBanca;
	}
	
	public Professor() {
		
	}
	
	public int getIdProf() {
		return idProf;
	}
	
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	
	public int getAdm() {
		return administrador;
	}
	
	public void setAdm(int administrador) {
		this.administrador = administrador;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
