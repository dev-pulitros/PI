package projeto_pi;

import java.util.Date;

public class Atividade {
	private int idAtividade;
	private Tema tema;
	private int numero;
	private String descricao;
	private String formatoEntrega;
	private Date dataInicio;
	private Date dataFinal;
	
	Atividade(int idAtividade, Tema tema, int numero, String descricao, String formatoEntrega, Date dataInicio, Date dataFinal){
		this.idAtividade = idAtividade;
		this.tema = tema;
		this.numero = numero;
		this.descricao = descricao;
		this.formatoEntrega = formatoEntrega;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}
	
	
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormatoEntrega() {
		return formatoEntrega;
	}
	public void setFormatoEntrega(String formatoEntrega) {
		this.formatoEntrega = formatoEntrega;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
