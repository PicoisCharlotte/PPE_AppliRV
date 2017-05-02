package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import fr.gsb.app.entites.Praticien;
import fr.gsb.app.entites.RapportVisite;
import fr.gsb.app.modeles.ModeleAppliRV;
import fr.gsb.app.vues.VueListeRapportVisiteur;
import fr.gsb.app.vues.VueRapportVisiteur;

public class ControleurListeRapportVisiteur implements ActionListener {

	private VueListeRapportVisiteur vue;

	public ControleurListeRapportVisiteur(VueListeRapportVisiteur vue) {
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	}

	private void enregistrerEcouteur() {

		this.vue.getbAnnuler().addActionListener(this);

		this.vue.getbValider().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceEvenement = e.getSource();

		if (sourceEvenement == this.vue.getbValider()) {
			this.getRapport();
		}

		else if (sourceEvenement == this.vue.getbAnnuler()) {
			this.quitter();
		}
	}

	private void quitter() {
		System.out.println("L'utilisateur veut revenir en arrière.");
		int reponse = JOptionPane.showConfirmDialog(this.vue,
				"Retour en arrière ?", "Redirection",
				JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {

			this.vue.dispose();

		}
	}

	private void getRapport() {

		

		int ligne = this.vue.gettRapports().getSelectedRow();
		
		if (ligne == -1){
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner un visiteur.  ",
					"Attention", JOptionPane.WARNING_MESSAGE);
		} else {

		List<RapportVisite> lesRapports = ModeleAppliRV.getModele()
				.getRapportVisite(this.vue.getMatricule(), this.vue.getDate());

		String rap_num = lesRapports.get(ligne).getRap_num();
		String matricule = lesRapports.get(ligne).getMatricule();
		String bilan = lesRapports.get(ligne).getRap_bilan();
		String motif = lesRapports.get(ligne).getRap_motif();
		String rap_date = lesRapports.get(ligne).getRap_date();
		String coef = lesRapports.get(ligne).getRap_coefConf();
		String pra_num = lesRapports.get(ligne).getPra_num();
		String date_redac = lesRapports.get(ligne).getDate_redac();
		String nom = lesRapports.get(ligne).getSonPraticien().getNom();
		String prenom = lesRapports.get(ligne).getSonPraticien().getPrenom();
		String ville = lesRapports.get(ligne).getSonPraticien().getVille();

		new VueRapportVisiteur(this.vue, matricule, rap_num, rap_date, motif,
				bilan, coef, pra_num, date_redac, new Praticien(pra_num, nom,
						prenom, ville));

		ModeleAppliRV.getModele().consulterRapport(matricule, rap_num);

		//this.vue.dispose();
		}

	}

}
