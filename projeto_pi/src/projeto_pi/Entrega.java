package projeto_pi;

import java.util.Date;

public class Entrega {
	private Grupo grupo;
	private Atividade atividade;
	private int idEntrega;
	private Date dataCadastro;
	
	Entrega(Grupo grupo, Atividade atividade, int idEntraga, Date dataCadastro){
		this.grupo = grupo;
		this.atividade = atividade;
		this.idEntrega = idEntraga;
		this.dataCadastro = dataCadastro;
	}
	
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public int getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
