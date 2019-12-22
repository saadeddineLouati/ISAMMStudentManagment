package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Etudiant;
import metier.GestionEtudiants;

/**
 * Servlet implementation class InsertionEtudiant
 */
@WebServlet("/InsertionEtudiant")
public class InsertionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionEtudiant() {
        super();
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
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		float moyenne=Float.parseFloat(request.getParameter("moyenne"));
		
		ArrayList<String> matieres =new ArrayList<>();
		GestionEtudiants gestionEtudiants=new GestionEtudiants();
		ArrayList<Etudiant> etudiants=gestionEtudiants.getListeEtudiants();
		
		int id=0;
		if (etudiants.size()>0) {
			id=etudiants.get(etudiants.size()-1).id+1;
		}
		
		Etudiant e=new Etudiant(id, nom, prenom, "Etudiant", moyenne, matieres);

		etudiants.add(e);
		
		request.setAttribute("etudiants", etudiants);
		
  		RequestDispatcher dispatcher =request.getRequestDispatcher("/etudiants.jsp");
		dispatcher.forward(request, response);
	}

}
