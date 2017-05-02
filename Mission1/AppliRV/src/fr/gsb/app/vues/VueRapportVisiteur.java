package fr.gsb.app.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fr.gsb.app.controleurs.ControleurRapportVisiteur;
import fr.gsb.app.entites.Praticien;

public class VueRapportVisiteur extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VueListeRapportVisiteur vueParente;

	private ControleurRapportVisiteur controleur;
	private String rap_num;
	private String matricule;
	private String date;
	private String motif;
	private String bilan;
	private String coef;
	private String pra_num;
	private String date_redac;
	private Praticien praticien;

	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Terminer");

	public VueRapportVisiteur() {
		super();
	}

	public VueRapportVisiteur(VueListeRapportVisiteur vueParente,
			String rap_num, String matricule, String date, String motif,
			String bilan, String coef, String pra_num, String date_redac,
			Praticien praticien) {
		super();
		this.vueParente = vueParente;
		this.rap_num = rap_num;
		this.matricule = matricule;
		this.date = date;
		this.motif = motif;
		this.bilan = bilan;
		this.coef = coef;
		this.pra_num = pra_num;
		this.date_redac = date_redac;
		this.praticien = praticien;

		this.setTitle("Rapport");

		this.setSize(300, 400);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

		this.controleur = new ControleurRapportVisiteur(this);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.setVisible(true);

		this.creerInterface();

	}

	public void creerInterface() {

		Box bPrincipale = Box.createHorizontalBox();
		JPanel panneau = new JPanel();
		panneau.setLayout(new GridLayout(8, 2, 20, 20));
		Border border = BorderFactory.createTitledBorder("RAPPORT VISITE");
		((JComponent) panneau).setBorder(border);

		panneau.add(new JLabel("N° Rapport "));
		panneau.add(new JLabel(rap_num));

		panneau.add(new JLabel("Matricule"));
		panneau.add(new JLabel(matricule));

		panneau.add(new JLabel("Date"));
		panneau.add(new JLabel(date));

		panneau.add(new JLabel("Motif"));
		panneau.add(new JLabel(motif));

		panneau.add(new JLabel("Bilan"));
		panneau.add(new JLabel(bilan));

		panneau.add(new JLabel("N° Praticien"));
		panneau.add(new JLabel(pra_num));

		panneau.add(new JLabel("Coeff Confiance"));
		panneau.add(new JLabel(coef));

		
		panneau.add(bValider);

		bPrincipale.add(panneau);
		
		bPrincipale.setBackground(new Color(0, 100, 200, 20));

		this.getContentPane().add(bPrincipale);

		bValider.setBackground(Color.WHITE);
		bValider.setForeground(Color.black);
		bValider.setFocusPainted(false);
		bValider.setFont(new Font("TimesNew", Font.BOLD, 12));

	}

	public VueListeRapportVisiteur getVueParente() {
		return vueParente;
	}

	public void setVueParente(VueListeRapportVisiteur vueParente) {
		this.vueParente = vueParente;
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

	public ControleurRapportVisiteur getControleur() {
		return controleur;
	}

	public void setControleur(ControleurRapportVisiteur controleur) {
		this.controleur = controleur;
	}

	public String getRap_num() {
		return rap_num;
	}

	public void setRap_num(String rap_num) {
		this.rap_num = rap_num;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getBilan() {
		return bilan;
	}

	public void setBilan(String bilan) {
		this.bilan = bilan;
	}

	public String getCoef() {
		return coef;
	}

	public void setCoef(String coef) {
		this.coef = coef;
	}

	public String getPra_num() {
		return pra_num;
	}

	public void setPra_num(String pra_num) {
		this.pra_num = pra_num;
	}

	public String getDate_redac() {
		return date_redac;
	}

	public void setDate_redac(String date_redac) {
		this.date_redac = date_redac;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

}
