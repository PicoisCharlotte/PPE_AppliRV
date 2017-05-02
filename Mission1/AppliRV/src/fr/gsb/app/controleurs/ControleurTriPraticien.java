package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import fr.gsb.app.vues.VueListePraticiens;
import fr.gsb.app.vues.VueTriPraticien;

public class ControleurTriPraticien implements ActionListener {

	private VueTriPraticien vue;

	public ControleurTriPraticien(VueTriPraticien vue) {
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

			this.getPraticienTri();
		} else if (sourceEvenement == this.vue.getbAnnuler()) {

			this.quitter();
		}
	}

	private void getPraticienTri() {
		
		if (this.vue.getbDate().isSelected()) {

			new VueListePraticiens("DATE",
					"LISTE DES PRATICIENS - TRI PAR DATE ");

		} else if (this.vue.getbCoefConf().isSelected()) {

			new VueListePraticiens("CONF",
					"LISTE DES PRATICIENS - TRI PAR COEFFICIENT DE CONFIANCE ");

		} else if (this.vue.getbCoefNoto().isSelected()) {

			new VueListePraticiens("NOTO",
					"LISTE DES PRATICIENS - TRI PAR COEFFICIENT DE NOTORIETE ");

		} else {

			new VueListePraticiens("NOTRI",
					"LISTE DES PRATICIENS - AUCUN TRI SPECIFIQUE ");

		}

		//this.vue.dispose();
	}

	private void quitter() {
		System.out.println("L'utilisateur veut quitter.");

		int reponse = JOptionPane.showConfirmDialog(this.vue,
				"Voulez vous vraiment quitter ?", "Quitter",
				JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {

			this.vue.dispose();

		}
	}
}