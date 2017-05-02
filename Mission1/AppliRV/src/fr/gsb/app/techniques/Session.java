package fr.gsb.app.techniques;

import fr.gsb.app.entites.Visiteur;

public class Session {

	private static Session session = null;
	private Visiteur leVisiteur;

	private Session(Visiteur leVisiteur) {
		super();
		this.leVisiteur = leVisiteur;
	}

	public static void ouvrir(Visiteur leVisiteur) {
		Session.session = new Session(leVisiteur);
	}

	public static void fermer() {
		Session.session = null;
	}

	public static Session getSession() {
		return Session.session;
	}

	public Visiteur getLeVisiteur() {
		return this.leVisiteur;
	}

	@Override
	public String toString() {
		return "Session [ leVisiteur = " + leVisiteur + " ]";
	}
}