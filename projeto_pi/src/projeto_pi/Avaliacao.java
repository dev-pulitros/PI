package projeto_pi;

import java.util.Date;

public class Avaliacao {
	
	int avaliacaoId;
	int entregaId;
    int turmaAlunoId;
	double nota;
	Date dtAvaliacao;
	String comentario;
	
	public Avaliacao(int avaliacaoId, int entregaId, int turmaAlunoId, double nota, Date dtAvaliacao, String comentarios) {
		this.avaliacaoId = avaliacaoId;
		this.entregaId = entregaId;
		this.turmaAlunoId = turmaAlunoId;
		this.nota = nota;
		this.dtAvaliacao = dtAvaliacao;
		this.comentario = comentarios;
	}
	
	public Avaliacao() {
		
	}

	public int getAvaliacaoId() {
		return avaliacaoId;
	}
	
	public void setAvaliacaoId(int avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}
	
	public int getEntregaId() {
		return entregaId;
	}

	public void setEntregaId(int entregaId) {
		this.entregaId = entregaId;
	}

	public int getTurmaAlunoId() {
		return turmaAlunoId;
	}

	public void setTurmaAlunoId(int turmaAlunoId) {
		this.turmaAlunoId = turmaAlunoId;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getDtAvaliacao() {
		return dtAvaliacao;
	}
	
	public void setDtAvaliacao(Date dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
