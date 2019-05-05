package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Professor;
import service.ProfessorService;

/**
 * Servlet implementation class ManterProfessorController
 */
@WebServlet("/ManterProfessor.do")
public class ManterProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pMatricula = request.getParameter("matricula");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Professor professor = new Professor();
		professor.setIdProf(id);
		professor.setNome(pNome);
		professor.setMatricula(pMatricula);
		professor.setEmail(pEmail);
		professor.setSenha(pSenha);
		
		ProfessorService ps = new ProfessorService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			ps.criar(professor);
			ArrayList<Professor> lista = new ArrayList<>();
			lista.add(professor);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarProfessores.jsp");
		} else if (pAcao.equals("Excluir")) {
			ps.excluir(professor);
			ArrayList<Professor> lista = (ArrayList<Professor>)session.getAttribute("lista");
			lista.remove(busca(professor, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarProfessores.jsp");			
		} else if (pAcao.equals("Alterar")) {
			ps.atualizar(professor);
			ArrayList<Professor> lista = (ArrayList<Professor>)session.getAttribute("lista");
			int pos = busca(professor, lista);
			lista.remove(pos);
			lista.add(pos, professor);
			session.setAttribute("lista", lista);
			request.setAttribute("professor", professor);
			view = request.getRequestDispatcher("VisualizarProfessor.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			professor = ps.carregarP(professor.getIdProf());
			request.setAttribute("professor", professor);
			view = request.getRequestDispatcher("VisualizarProfessor.jsp");		
		} else if (pAcao.equals("Editar")) {
			professor = ps.carregarP(professor.getIdProf());
			request.setAttribute("professor", professor);
			view = request.getRequestDispatcher("AlterarProfessor.jsp");		
		} else if (pAcao.equals("Login")) {
			ArrayList<Professor> lista = ps.carregar();
			for(Professor p : lista) {
				if(professor.getMatricula() == p.getMatricula() && professor.getSenha() == p.getSenha()) {
					professor = ps.carregarP(p.getIdProf());
					session.setAttribute("logged", professor);
				}
				view = request.getRequestDispatcher("Logado.jsp");
			}
		}
		
		view.forward(request, response);

	}

	public int busca(Professor professor, ArrayList<Professor> lista) {
		Professor to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getIdProf() == professor.getIdProf()){
				return i;
			}
		}
		return -1;
	}

}