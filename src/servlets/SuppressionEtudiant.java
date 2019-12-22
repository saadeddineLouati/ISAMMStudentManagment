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
 * Servlet implementation class SuppressionEtudiant
 */
@WebServlet("/SuppressionEtudiant")
public class SuppressionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionEtudiants gestionEtudiants =new GestionEtudiants();
		ArrayList<Etudiant> etudiants =gestionEtudiants.getListeEtudiants();
		int id=Integer.parseInt(request.getParameter("id"));
		boolean trouv=false;
		int i =0;
		while(trouv !=true && i< etudiants.size() ) {
			if (etudiants.get(i).id==id) {
				trouv=true;
				etudiants.remove(i);
			}else {
				i++;
			}
		}
		request.setAttribute("etudiants", etudiants);
  		RequestDispatcher dispatcher =request.getRequestDispatcher("/etudiants.jsp");
		dispatcher.forward(request, response);	

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
