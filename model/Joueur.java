package model;
public class Joueur {
	private static int nbJoueurs = 0;
	private int id;
	private String nom;
	private int score;
	
	public Joueur(String nom) {
		this.id = ++nbJoueurs;
		this.nom = nom;
		this.score = 0;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementerScore() {
		this.score++;
	}
	
	public void decrementerScore() {
		this.score--;
	}
	
	public String toString() {
		return "Joueur " + this.nom + " | Score : " + this.score;
	}
}
