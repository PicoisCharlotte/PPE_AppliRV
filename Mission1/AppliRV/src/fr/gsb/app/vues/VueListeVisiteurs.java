package fr.gsb.app.vues;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.app.controleurs.ControleurListeVisiteurs;
import fr.gsb.app.modeles.ModeleListeVisiteurs;

public class VueListeVisiteurs extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VueAppliRV vueParente;
	JTable tVisiteurs = new JTable();
	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Annuler");
	private ControleurListeVisiteurs controleur;

	public VueListeVisiteurs(VueAppliRV vueParente) {
		super();
		this.vueParente = vueParente;

		this.setTitle("Liste des visiteurs");
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.controleur = new ControleurListeVisiteurs(this);

		// Affiche la fenêtre
		this.setVisible(true);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));
		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.creerInterface();
	}

	private void creerInterface() {

		Box bPrincipale = Box.createVerticalBox();
		bPrincipale.add(Box.createVerticalStrut(10));
		bPrincipale.add(new JLabel("Liste des Visiteurs"));
		bPrincipale.add(Box.createVerticalStrut(10));

		this.tVisiteurs = new JTable(new ModeleListeVisiteurs());
		this.tVisiteurs.setRowHeight(30);

		JScrollPane spVisiteurs = new JScrollPane(this.tVisiteurs);

		spVisiteurs.setPreferredSize(new Dimension(1090, 420));

		bPrincipale.add(spVisiteurs);

		bPrincipale.add(Box.createVerticalStrut(10));

		JPanel panneau1 = new JPanel();
		panneau1.add(bValider);
		panneau1.add(bAnnuler);

		bPrincipale.add(panneau1);

		bValider.setBackground(Color.WHITE);
		bValider.setForeground(Color.black);
		bValider.setFocusPainted(false);
		bValider.setFont(new Font("TimesNew", Font.BOLD, 12));

		bAnnuler.setBackground(Color.WHITE);
		bAnnuler.setForeground(Color.black);
		bAnnuler.setFocusPainted(false);
		bAnnuler.setFont(new Font("TimesNew", Font.BOLD, 12));

		this.add(bPrincipale);

	}

	public JTable gettVisiteurs() {
		return tVisiteurs;
	}

	public void settVisiteurs(JTable tVisiteurs) {
		this.tVisiteurs = tVisiteurs;
	}

	public JButton getbValider() {
		return bValider;
	}

	public void setbValider(JButton bValider) {
		this.bValider = bValider;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

	public void setbAnnuler(JButton bAnnuler) {
		this.bAnnuler = bAnnuler;
	}

	public ControleurListeVisiteurs getControleur() {
		return controleur;
	}

	public void setControleur(ControleurListeVisiteurs controleur) {
		this.controleur = controleur;
	}

}
