package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import fr.gsb.app.entites.Visiteur;
import fr.gsb.app.modeles.ModeleAppliRV;
import fr.gsb.app.techniques.Session;
import fr.gsb.app.vues.VueConnexion;

public class ControleurConnexion implements ActionListener {

	private VueConnexion vue;

	public ControleurConnexion(VueConnexion vue) {
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	}

	private void enregistrerEcouteur() {

		this.vue.getbConnecter().addActionListener(this);
		this.vue.getbAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceEvenement = e.getSource();
		if (sourceEvenement == this.vue.getbConnecter()) {
			this.seConnecter();
		} else if (sourceEvenement == this.vue.getbAnnuler()) {
			this.annuler();
		}
	}

	private void seConnecter() {

		String login = this.vue.getTfLogin().getText();

		String mdp = new String(this.vue.getPfMdp().getPassword());

		try {

			boolean connexionOk = ModeleAppliRV.getModele().seConnecter(login,
					mdp).isConnexion();

			if (connexionOk == true) {

				Visiteur leVisiteur = ModeleAppliRV.getModele().seConnecter(login,
						mdp) ;
				//leVisiteur.setMatricule(login);
				

				Session.ouvrir(leVisiteur);
				this.vue.getVueParente().setBarreMenusModeConnecte();
				JOptionPane.showMessageDialog(null, "Connexion réussie. ",
						"Connexion", JOptionPane.INFORMATION_MESSAGE);
				this.vue.dispose();
			} else {

				JOptionPane.showMessageDialog(null, "Echec de la connexion.",
						"Connexion", JOptionPane.ERROR_MESSAGE);
				this.vue.getPfMdp().setText("");
			}

		} catch (Exception e) {
			System.out.println("Pb connexion");
			JOptionPane.showMessageDialog(null, "Accès à la BD impossible.",
					"Connexion", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void annuler() {
		this.vue.dispose();
	}

}
