package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Etudiant;
import metier.GestionEtudiants;

/**
 * Servlet implementation class AjouterMatiere
 */
@WebServlet("/AjouterMatiere")
public class AjouterMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterMatiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionEtudiants gestionEtudiants = new GestionEtudiants();
		ArrayList<String> matieres = new ArrayList<>();
		matieres = gestionEtudiants.getTousLesMatières();
		HttpSession session = request.getSession(true);
		int id = (int) session.getAttribute("id");
		ArrayList<Etudiant> etudiants = new ArrayList<>();
		etudiants = gestionEtudiants.getListeEtudiants();
		boolean trouv = false;
		int i = 0;
		Etudiant etudiant = new Etudiant();
		while (i < etudiants.size() && trouv == false) {
			if (etudiants.get(i).id == id) {
				trouv = true;
				etudiant=etudiants.get(i);
				etudiant.matieres.add(request.getParameter("matiere"));
			} else {
				i++;
			}
		}
				
		request.setAttribute("matieres", matieres);
		request.setAttribute("mesMatieres", etudiant.getMatieres());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/matieres.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
