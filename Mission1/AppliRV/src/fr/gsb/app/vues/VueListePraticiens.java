package fr.gsb.app.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.app.controleurs.ControleurListePraticiens;
import fr.gsb.app.modeles.ModeleListePraticiens;

public class VueListePraticiens extends JDialog {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	VueAppliRV vueParente;
	JTable tPraticiens = new JTable();
	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Retour");
	private String tri;
	private ControleurListePraticiens controleur;
	JLabel titretb = new JLabel();

	public VueListePraticiens(String tri, String titretb) {
		super();
		this.tri = tri;
		this.titretb.setText(titretb);

		this.setTitle("Liste des Praticiens");
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.controleur = new ControleurListePraticiens(this);

		this.setVisible(true);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.creerInterface();
	}

	private void creerInterface() {

		Box bPrincipale = Box.createVerticalBox();
		bPrincipale.add(Box.createVerticalStrut(10));
		bPrincipale.add(titretb);
		bPrincipale.add(Box.createVerticalStrut(10));

		this.tPraticiens = new JTable(new ModeleListePraticiens(this.tri));
		this.tPraticiens.setRowHeight(30);

		JScrollPane spVisiteurs = new JScrollPane(this.tPraticiens);

		spVisiteurs.setPreferredSize(new Dimension(1090, 420));

		bPrincipale.add(spVisiteurs);

		bPrincipale.add(Box.createVerticalStrut(10));
		bPrincipale.add(Box.createHorizontalStrut(10));

		JPanel panneau = new JPanel();
		panneau.add(bValider);
		panneau.add(bAnnuler);
		bPrincipale.add(panneau);

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

	public ControleurListePraticiens getControleur() {
		return controleur;
	}

	public void setControleur(ControleurListePraticiens controleur) {
		this.controleur = controleur;
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

	public JTable gettPraticiens() {
		return tPraticiens;
	}

	public void settPraticiens(JTable tPraticiens) {
		this.tPraticiens = tPraticiens;
	}

}
