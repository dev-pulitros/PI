package projeto_pi;

public class Turma {
	
	private int semestreLetivo;
	private int anoLetivo;
	private String sigla;
	private Tema tema;
	
	public Turma(int semestreLetivo, int anoLetivo, String sigla, Tema tema) {
		this.semestreLetivo = semestreLetivo;
		this.anoLetivo = anoLetivo;
		this.sigla = sigla;
		this.tema = tema;
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
	
	
}
