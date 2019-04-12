package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;

/**
 * Servlet implementation class ManterProfessorController
 */
@WebServlet("/ManterProfessor.do")
public class ManterProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ManterProfessorController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Professor professor = new Professor();
		ProfessorService professorService = new ProfessorService();
		
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int pAdmin = Integer.parseInt(request.getParameter("administrador"));
		String pMatricula = request.getParameter("matricula");
		
		professor.setNome(pNome);
		professor.setEmail(pEmail);
		professor.setSenha(pSenha);
		professor.setAdm(pAdmin);
		professor.setMatricula(pMatricula);
		
		professorService.criar(professor);
		
		request.setAttribute("professor", professor);
		RequestDispatcher view =
		request.getRequestDispatcher("Professor.jsp");
		view.forward(request, response);
		
	}

}