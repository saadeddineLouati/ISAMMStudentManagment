package metier;

import java.util.ArrayList;

import beans.Etudiant;

public class GestionEtudiants {
	static ArrayList<String> Matierese1=new ArrayList<>();
	static ArrayList<String> Matierese2=new ArrayList<>();
	static ArrayList<String> Matierese3=new ArrayList<>();
	static ArrayList<String> Matierese4=new ArrayList<>();
	static ArrayList<String> TousLesMati�res=new ArrayList<String>() {{
		add("Fran�ais");
		add("Anglais");
		add("Arabe");
		add("Math�matiques");
		add("Phusiques");
		add("Programmation oo");
		add("D�veloppement web");
		add("Algorithmique");
		add("Compilation");
	};
	};
	static Etudiant e1=new Etudiant(0, "Louati", "Saadeddine","Etudiant", 19, Matierese1);
	static Etudiant e2=new Etudiant(1, "Chammem", "Khalil","Etudiant", 15, Matierese2);
	static Etudiant e3=new Etudiant(2, "Msakni", "Youssef","Etudiant", 13, Matierese3);
	static Etudiant e4=new Etudiant(3, "Badri", "Anis","Etudiant", 8, Matierese4);
	public static ArrayList<Etudiant> ListeEtudiants=new ArrayList<Etudiant>() {{
		add(e1);
		add(e2);
		add(e3);
		add(e4);
	}};
	public ArrayList<Etudiant> getListeEtudiants() {
		return ListeEtudiants;
	}
	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
		ListeEtudiants = listeEtudiants;
	}
	public ArrayList<String> getTousLesMati�res() {
		return TousLesMati�res;
	}
	public void setTousLesMati�res(ArrayList<String> tousLesMati�res) {
		TousLesMati�res = tousLesMati�res;
	}
	

	
}
