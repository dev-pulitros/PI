import javafx.scene.chart.PieChart.Data;

public class Avaliacao {
	
	int entregaId;
    int turmaAlunoId;
	double nota;
	Data dtAvaliacao;
	String comentario;
	
	public Avaliacao(int entregaId, int turmaAlunoId, double nota, Data dtAvaliacao, String comentarios) {
		
		this.entregaId = entregaId;
		this.turmaAlunoId = turmaAlunoId;
		this.nota = nota;
		this.dtAvaliacao = dtAvaliacao;
		this.comentario = comentarios;
		
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

	public Data getDtAvaliacao() {
		return dtAvaliacao;
	}

	public void setDtAvaliacao(Data dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
