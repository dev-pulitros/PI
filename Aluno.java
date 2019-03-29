package projeto_pi;

public class Aluno extends Usuario {
	int idAluno;
	String ra;
	
	public Aluno(int idUsuario, String nome, String email, String senha, int idAluno, String ra) {
		super(idUsuario, nome, email, senha);
		this.idAluno = idAluno;
		this.ra = ra;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
		
}
