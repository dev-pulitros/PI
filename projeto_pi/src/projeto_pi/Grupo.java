package projeto_pi;

public class Grupo {
	
	private int idGrupo;
	private int numero;
	private String nome;
	private Professor orientador;
	
	public Grupo(int idGrupo, int numero, String nome, Professor orientador) {
		this.idGrupo = idGrupo;
		this.numero = numero;
		this.nome = nome;
		this.orientador = orientador;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}
}
