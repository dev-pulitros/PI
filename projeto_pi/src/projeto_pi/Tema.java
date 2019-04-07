package projeto_pi;

import javafx.scene.chart.PieChart.Data;

public class Tema {
	
	private Data dtCadastro;
	private String titulo;
	private String introducao;
	private String requisitos;
	
	public Tema(Data dtCadastro, String titulo, String introducao, String requisitos) {
		this.dtCadastro = dtCadastro;
		this.titulo = titulo;
		this.introducao = introducao;
		this.requisitos = requisitos;
	}

	public Data getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Data dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
}
