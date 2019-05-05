package service;

import model.Professor;
import dao.ProfessorDAO;
import java.util.ArrayList;

public class ProfessorService {
	ProfessorDAO dao;
	
	public ProfessorService() {
		dao = new ProfessorDAO();
	}
	
	public void criar(Professor to) {
		dao.criar(to);
	}
	
	public void atualizar(Professor to) {
		dao.atualizar(to);
	}
	
	public void excluir(Professor to) {
		dao.excluir(to);
	}
	
	public ArrayList<Professor> carregar(int id) {
		ArrayList<Professor> to = dao.carregar(id);
		return to;
	}
	
	public ArrayList<Professor> carregar(){
		return dao.carregar();
	}
	
	public Professor carregarP(int id) {
		return dao.carregarP(id);
	}
}
