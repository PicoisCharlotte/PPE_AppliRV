package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import fr.gsb.app.entites.Praticien;
import fr.gsb.app.modeles.ModeleAppliRV;
import fr.gsb.app.vues.VueListePraticiens;
import fr.gsb.app.vues.VuePraticien;

public class ControleurListePraticiens implements ActionListener {

	private VueListePraticiens vue;

	public ControleurListePraticiens(VueListePraticiens vue) {
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	}

	private void enregistrerEcouteur() {

		this.vue.getbValider().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceEvenement = e.getSource();
		if (sourceEvenement == this.vue.getbValider()) {
			this.consulterPraticiens();
		} else if (sourceEvenement == this.vue.getbAnnuler()) {
			this.quitter();
		}

	}

	public void consulterPraticiens() {

		int ligne = this.vue.gettPraticiens().getSelectedRow();
		
		if (ligne == -1){
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner un praticien.  ",
					"Attention", JOptionPane.WARNING_MESSAGE);
		} else {
			
		
		List<Praticien> lesPraticiens = ModeleAppliRV.getModele()
				.getPraticiens();

		String pra_num = lesPraticiens.get(ligne).getPra_num();

		Praticien lePraticien = ModeleAppliRV.getModele().getUnPraticien(
				pra_num);
		String nom = lePraticien.getNom();
		String prenom = lePraticien.getPrenom();
		String adresse = lePraticien.getAdresse();
		String ville = lePraticien.getVille();
		String cp = lePraticien.getCp();
		String coefNoto = lePraticien.getCoefNotoriete();
		String coefConf = lePraticien.getUnRapport().getRap_coefConf();
		String date = lePraticien.getUnRapport().getRap_date();

		new VuePraticien(this.vue, pra_num, nom, prenom, adresse, cp, ville,
				coefNoto, coefConf, date);

		//this.vue.dispose();
		
		}

	}

	private void quitter() {
		System.out.println("L'utilisateur veut quitter.");

		int reponse = JOptionPane.showConfirmDialog(this.vue,
				"Retour en arrière ?", "Quitter",
				JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {

			this.vue.dispose();

		}

	}

}
