package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import fr.gsb.app.entites.Visiteur;
import fr.gsb.app.modeles.ModeleAppliRV;
import fr.gsb.app.techniques.Session;
import fr.gsb.app.vues.VueListeVisiteurs;
import fr.gsb.app.vues.VueMoisAnnee;

public class ControleurListeVisiteurs implements ActionListener {

	private VueListeVisiteurs vue;

	public ControleurListeVisiteurs(VueListeVisiteurs vue) {
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

			this.getLeVisiteur();

		} else if (sourceEvenement == this.vue.getbAnnuler()) {

			this.quitter();
		}
	}

	private void getLeVisiteur() {
		int ligne = this.vue.gettVisiteurs().getSelectedRow();
		if (ligne == -1){
			JOptionPane.showMessageDialog(null, "Vous devez sélectionner un visiteur.  ",
					"Attention", JOptionPane.WARNING_MESSAGE);
		}
		else {
		

		List<Visiteur> lesVisiteurs = ModeleAppliRV.getModele().getVisiteurs(Session.getSession().getLeVisiteur().getRegion());

		String matricule = lesVisiteurs.get(ligne).getMatricule();

		new VueMoisAnnee(this.vue, matricule);

		//this.vue.dispose();
		}
	}

	private void quitter() {
		System.out.println("L'utilisateur veut quitter.");
		int reponse = JOptionPane.showConfirmDialog(this.vue,
				"Voulez-vous vraiment quitter ?", "Quitter",
				JOptionPane.YES_NO_OPTION);

		if (reponse == JOptionPane.YES_OPTION) {

			this.vue.dispose();

		}
	}
}
