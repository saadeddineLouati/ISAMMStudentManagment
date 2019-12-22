package metier;

import java.util.ArrayList;

import beans.Utilisateur;

public class GestionUtilisateurs {
	Utilisateur u1=new Utilisateur(0, "Louati", "Saadeddine", "Etudiant", "saad12345");
	Utilisateur u2=new Utilisateur(1, "Khezami", "Oumaima", "Etudiant", "saad12345");
	Utilisateur u3=new Utilisateur(2, "Maiza", "Chaime", "Etudiant", "saad12345");
	Utilisateur u4=new Utilisateur(3, "Traoui", "Majdi", "Enseignant", "saad12345");
	Utilisateur u5=new Utilisateur(4, "Chaabani", "Mouin", "Enseignant", "saad12345");
	
	public ArrayList<Utilisateur> ListeUtilisateurs=new ArrayList<Utilisateur>() {{
		add(u1);
		add(u2);
		add(u3);
		add(u4);
		add(u5);
	}};

	public ArrayList<Utilisateur> getListeUtilisateurs() {
		return ListeUtilisateurs;
	}

	public void setListeUtilisateurs(ArrayList<Utilisateur> listeUtilisateurs) {
		ListeUtilisateurs = listeUtilisateurs;
	}
	
	

}
