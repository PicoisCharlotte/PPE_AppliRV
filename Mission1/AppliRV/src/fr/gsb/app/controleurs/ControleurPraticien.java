package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fr.gsb.app.vues.VuePraticien;

public class ControleurPraticien implements ActionListener {

	private VuePraticien vue;

	public ControleurPraticien(VuePraticien vue) {
		super();
		this.vue = vue;
		this.enregistrerEcouteur();
	}

	private void enregistrerEcouteur() {

		this.vue.getbValider().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object sourceEvenement = e.getSource();
		if (sourceEvenement == this.vue.getbValider()) {
			this.fermer();
		}
	}

	public void fermer() {

		this.vue.dispose();

	}
}
