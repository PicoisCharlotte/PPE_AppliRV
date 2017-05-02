package fr.gsb.app.entites;

import java.util.GregorianCalendar;

public class Visiteur {

	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private int cp;
	private String ville;
	private GregorianCalendar dateEmbauche;
	private String mdp;
	private String region ;
	private boolean connexion ;

	public Visiteur() {
		super();
	}

	public Visiteur(String matricule) {
		super();
		this.matricule = matricule;

	}

	public Visiteur(String matricule, String region , boolean connexion){
		super() ;
		this.matricule = matricule ; 
		this.region = region ;
		this.connexion = connexion ; 
	}
	
	public Visiteur(String matricule, String nom, String prenom,
			String adresse, int cp, String ville,
			GregorianCalendar dateEmbauche, String mdp) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;

		this.mdp = mdp;

	}

	public Visiteur(String matricule, String nom, String prenom, String login,
			String mdp) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.mdp = mdp;

	}

	public Visiteur(String matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public GregorianCalendar getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(GregorianCalendar dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public boolean isConnexion() {
		return connexion;
	}

	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}

	@Override
	public String toString() {
		return "Visiteur [pseudo = " + matricule + " ]";
	}

}
