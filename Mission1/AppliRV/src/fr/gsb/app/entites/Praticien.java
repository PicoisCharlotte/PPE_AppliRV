package fr.gsb.app.entites;

import java.util.ArrayList;
import java.util.List;

public class Praticien {
	private String pra_num;
	private String nom;
	private String prenom;
	private String ville;
	private String cp;
	private String adresse;

	private List<RapportVisite> lesRapports = new ArrayList<RapportVisite>();
	private RapportVisite unRapport;
	private String coefNotoriete;

	public Praticien() {

	}

	public Praticien(String pra_num, String nom, String prenom, String ville,
			List<RapportVisite> lesRapports) {
		super();
		this.pra_num = pra_num;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.lesRapports = lesRapports;
	}

	public Praticien(String pra_num, String nom, String prenom, String ville) {
		super();
		this.pra_num = pra_num;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
	}

	public Praticien(String pra_num, String nom, String ville,
			String coefNotoriete, RapportVisite unRapport) {
		// TODO Auto-generated constructor stub
		super();
		this.pra_num = pra_num;
		this.nom = nom;
		this.ville = ville;
		this.coefNotoriete = coefNotoriete;
		this.unRapport = unRapport;
	}

	public Praticien(String pra_num, String nom, String prenom, String adresse,
			String ville, String cp, String coefNoto, RapportVisite unRapport) {

		super();
		this.pra_num = pra_num;
		this.nom = nom;
		this.ville = ville;
		this.coefNotoriete = coefNoto;
		this.unRapport = unRapport;
		this.adresse = adresse;
		this.prenom = prenom;
		this.cp = cp;

	}

	public String getPra_num() {
		return pra_num;
	}

	public void setPra_num(String pra_num) {
		this.pra_num = pra_num;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<RapportVisite> getLesRapports() {
		return lesRapports;
	}

	public void setLesRapports(List<RapportVisite> lesRapports) {
		this.lesRapports = lesRapports;
	}

	public String getCoefNotoriete() {
		return coefNotoriete;
	}

	public void setCoefNotoriete(String coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}

	public RapportVisite getUnRapport() {
		return unRapport;
	}

	public void setUnRapport(RapportVisite unRapport) {
		this.unRapport = unRapport;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Praticien [pra_num=" + pra_num + ", nom=" + nom + ", prenom="
				+ prenom + ", ville=" + ville + ", lesRapports=" + lesRapports
				+ ", unRapport=" + unRapport + ", coefNotoriete="
				+ coefNotoriete + "]";
	}

}
