package beans;

import java.util.ArrayList;

public class Etudiant{
	public int id;
	public String nom;
	public String prenom;
	public String status;
	public float moyenne;
	public ArrayList<String> matieres;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float moyenne() {
		return moyenne;
	}
	public void setValid(float moyenne) {
		this.moyenne = moyenne;
	}
	public ArrayList<String> getMatieres() {
		return matieres;
	}
	public void setMatieres(ArrayList<String> matieres) {
		this.matieres = matieres;
	}
	public Etudiant(int id, String nom, String prenom, String status, float moyenne, ArrayList<String> matieres) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.status = status;
		this.moyenne = moyenne;
		this.matieres = matieres;
	}
	public Etudiant() {
		super();
	}
}
