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
import javax.websocket.Session;

import beans.Etudiant;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import metier.GestionEtudiants;

/**
 * Servlet implementation class Matires
 */
@WebServlet("/Matieres")
public class Matieres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Matieres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  HttpSession session = request.getSession(true);	    
		int id= (int) session.getAttribute("id");
		GestionEtudiants gestionEtudiants = new GestionEtudiants();
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
		
		request.setAttribute("matieres", gestionEtudiants.getTousLesMatières());
		request.setAttribute("mesMatieres", etudiant.getMatieres());
		
  		RequestDispatcher dispatcher =request.getRequestDispatcher("/matieres.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
