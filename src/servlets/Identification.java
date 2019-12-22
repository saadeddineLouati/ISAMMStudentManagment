package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Etudiant;
import beans.Utilisateur;
import metier.GestionEtudiants;
import metier.GestionUtilisateurs;

/**
 * Servlet implementation class Identification
 */
@WebServlet(description = "Servlet de connexion", urlPatterns = { "/Identification" })
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Identification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionUtilisateurs gestionUtilisateurs = new GestionUtilisateurs();
		boolean trouv=false;
		Utilisateur e = null;
		for (int i=0; i<gestionUtilisateurs.ListeUtilisateurs.size(); i++) {
			if (gestionUtilisateurs.ListeUtilisateurs.get(i).id==Integer.parseInt(request.getParameter("login"))) {
				trouv=true;
				e=gestionUtilisateurs.ListeUtilisateurs.get(i);
			}
		}
		if(e!=null && request.getParameter("password").equals(e.getMdp())) {
			  HttpSession session = request.getSession(true);	    
	          session.setAttribute("id",e.id); 
	          session.setAttribute("nom",e.nom); 
	          session.setAttribute("prenom",e.prenom); 
	          session.setAttribute("status",e.status); 
	          session.setAttribute("mdp",e.mdp); 
	          
	          request.setAttribute("message", "saadoun");

			
	  		RequestDispatcher dispatcher =request.getRequestDispatcher("/profil.jsp");
			dispatcher.forward(request, response);	
		}else {
	  		RequestDispatcher dispatcher =request.getRequestDispatcher("/echec.html");
			dispatcher.forward(request, response);	
		}
	}

}
