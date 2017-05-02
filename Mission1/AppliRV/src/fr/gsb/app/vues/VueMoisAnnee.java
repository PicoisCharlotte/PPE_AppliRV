package fr.gsb.app.vues;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.border.Border;

import fr.gsb.app.controleurs.ControleurMoisAnnee;

public class VueMoisAnnee extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControleurMoisAnnee controleur;
	private Object[] mois = { "Janvier", "Férvier", "Mars", "Avril", "Mai",
			"Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre",
			"Décembre" };
	private Object[] annee = { 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007,
			2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018,
			2019, 2020 };

	private JComboBox cMois = new JComboBox(mois);
	private JComboBox cAnnee = new JComboBox(annee);

	private JButton bValider = new JButton("Valider");
	private JButton bAnnuler = new JButton("Annuler");

	private String matricule;

	public VueMoisAnnee(VueListeVisiteurs vueParente, String matricule) {
		super();
		this.matricule = matricule;

		this.setTitle("Date");

		this.setSize(200, 120);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

		this.controleur = new ControleurMoisAnnee(this);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.setVisible(true);

		this.creerInterface();
	}

	private void creerInterface() {

		GridLayout agenceur = new GridLayout(3, 2);

		agenceur.setHgap(5);
		agenceur.setVgap(5);

		this.setLayout(agenceur);

		Container panneau = this.getContentPane();

		panneau.setLayout(new GridLayout(2, 2, 5, 5));
		panneau.add(this.cMois);
		panneau.add(this.cAnnee);

		panneau.add(this.bValider);
		panneau.add(this.bAnnuler);
		Border border = BorderFactory.createTitledBorder(" Choisir une date ");
		((JComponent) panneau).setBorder(border);

		bValider.setBackground(Color.WHITE);
		bValider.setForeground(Color.black);
		bValider.setFocusPainted(false);
		bValider.setFont(new Font("TimesNew", Font.BOLD, 12));

		bAnnuler.setBackground(Color.WHITE);
		bAnnuler.setForeground(Color.black);
		bAnnuler.setFocusPainted(false);
		bAnnuler.setFont(new Font("TimesNew", Font.BOLD, 12));

	}

	public ControleurMoisAnnee getControleur() {
		return controleur;
	}

	public void setControleur(ControleurMoisAnnee controleur) {
		this.controleur = controleur;
	}

	public JComboBox getcMois() {
		return cMois;
	}

	public void setcMois(JComboBox cMois) {
		this.cMois = cMois;
	}

	public JComboBox getcAnnee() {
		return cAnnee;
	}

	public void setcAnnee(JComboBox cAnnee) {
		this.cAnnee = cAnnee;
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

	public Object[] getMois() {
		return mois;
	}

	public void setMois(Object[] mois) {
		this.mois = mois;
	}

	public Object[] getAnnee() {
		return annee;
	}

	public void setAnnee(Object[] annee) {
		this.annee = annee;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
