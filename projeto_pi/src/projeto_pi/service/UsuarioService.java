package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao;
	
	public UsuarioService() {
		dao = new UsuarioDAO();
	}
	
	public void criar(Usuario to) {
		dao.criar(to);
	}
	
	public void atualizar(Usuario to) {
		dao.atualizar(to);
	}
	
	public void excluir(Usuario to) {
		dao.excluir(to);
	}
}
