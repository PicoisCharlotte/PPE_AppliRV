package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import fr.gsb.app.vues.VueListeRapportVisiteur;
import fr.gsb.app.vues.VueMoisAnnee;

public class ControleurMoisAnnee implements ActionListener {

	private VueMoisAnnee vue;

	public ControleurMoisAnnee(VueMoisAnnee vue) {
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	}

	private void enregistrerEcouteur() {

		this.vue.getcMois().addActionListener(this);

		this.vue.getcAnnee().addActionListener(this);

		this.vue.getbAnnuler().addActionListener(this);

		this.vue.getbValider().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceEvenement = e.getSource();

		if (sourceEvenement == this.vue.getbValider()) {
			this.getRapportMoisAnnee();
		}

		else if (sourceEvenement == this.vue.getbAnnuler()) {
			this.quitter();
		}
	}

	private void quitter() {
		System.out.println("L'utilisateur veut quitter Mois-Annee.");
			this.vue.dispose();
	
	}

	private void getRapportMoisAnnee() {
		
		Object mois = this.vue.getcMois().getSelectedItem();
		System.out.println(mois.toString());
		String moisInt = "00";
		switch (mois.toString()) {

		case "Janvier":
			moisInt = "01";
			break;
		case "Férvier":
			moisInt = "02";
			break;
		case "Mars":
			moisInt = "03";
			break;
		case "Avril":
			moisInt = "04";
			break;
		case "Mai":
			moisInt = "05";
			break;
		case "Juin":
			moisInt = "06";
			break;
		case "Juillet":
			moisInt = "07";
			break;
		case "Août":
			moisInt = "08";
			break;
		case "Septembre":
			moisInt = "09";
			break;
		case "Octobre":
			moisInt = "10";
			break;
		case "Novembre":
			moisInt = "11";
			break;
		case "Décembre":
			moisInt = "12";
			break;

		}

		Object annee = this.vue.getcAnnee().getSelectedItem();
		String anneeStr = annee.toString();

		String date = anneeStr + "-" + moisInt + "-";
		System.out.println(date);

		new VueListeRapportVisiteur(this.vue, this.vue.getMatricule(), date);

		this.vue.dispose();
	}

}
