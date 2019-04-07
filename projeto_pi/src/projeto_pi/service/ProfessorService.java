package projeto_pi;

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
	
	public Professor carregar(int id) {
		Professor to = dao.carregar(id);
		return to;
	}
}
