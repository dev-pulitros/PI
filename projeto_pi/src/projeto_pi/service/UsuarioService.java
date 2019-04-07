package projeto_pi;

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
