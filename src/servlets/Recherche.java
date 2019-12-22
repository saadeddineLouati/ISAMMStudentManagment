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
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  		RequestDispatcher dispatcher =request.getRequestDispatcher("/recherche.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("search"));
		GestionEtudiants gestionEtudiants =new GestionEtudiants();
		ArrayList<Etudiant> etudiants = gestionEtudiants.getListeEtudiants();
		boolean trouv=false;
		int i=0;
		Etudiant etudiant=null;
		while(i<etudiants.size() && trouv==false) {
			if (etudiants.get(i).id==id) {
				trouv=true;
				etudiant=etudiants.get(i);
			}else {
				i++;
			}
		}
		request.setAttribute("etudiant", etudiant);
		if (etudiant!=null) {
	  		RequestDispatcher dispatcher =request.getRequestDispatcher("/resultatsRecheche.jsp");
			dispatcher.forward(request, response);
		}else {
	  		RequestDispatcher dispatcher =request.getRequestDispatcher("/recherchEchec.html");
			dispatcher.forward(request, response);
		}
	}

}
