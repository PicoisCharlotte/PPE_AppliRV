package fr.gsb.app.vues;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import fr.gsb.app.controleurs.ControleurTriPraticien;

public class VueTriPraticien extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VueAppliRV vueParente;

	private ControleurTriPraticien controleur;
	private ButtonGroup bTri = new ButtonGroup();
	private JRadioButton bCoefNoto = new JRadioButton("Coefficient Notorieté");
	private JRadioButton bDate = new JRadioButton("Date du Rapport");
	private JRadioButton bCoefConf = new JRadioButton("Coefficient Confiance");
	private JRadioButton bNoTri = new JRadioButton("Aucun Tri Spécifique");
	private String coefConfiance;
	private String coefNotoriete;
	private String date;

	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Annuler");

	public VueTriPraticien(VueAppliRV vueParente) {
		super();

		this.vueParente = vueParente;

		this.creerInterface();

		this.pack();

		this.setLocationRelativeTo(null);

		this.setResizable(false);

		this.controleur = new ControleurTriPraticien(this);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.setVisible(true);
	}

	private void creerInterface() {

		GridLayout agenceur = new GridLayout(3, 2);

		agenceur.setHgap(5);
		agenceur.setVgap(5);

		this.setLayout(agenceur);

		Container panneau = this.getContentPane();

		panneau.setLayout(new GridLayout(3, 3, 20, 20));
		Border border = BorderFactory.createTitledBorder("Critère de tri ");
		((JComponent) panneau).setBorder(border);
		bTri.add(bCoefNoto);
		bTri.add(bDate);
		bTri.add(bCoefConf);
		bTri.add(bNoTri);

		panneau.add(bCoefNoto);
		panneau.add(bDate);
		panneau.add(bCoefConf);
		panneau.add(bNoTri);

		panneau.add(this.bValider);
		panneau.add(this.bAnnuler);

		bValider.setBackground(Color.WHITE);
		bValider.setForeground(Color.black);
		bValider.setFocusPainted(false);
		bValider.setFont(new Font("TimesNew", Font.BOLD, 12));

		bAnnuler.setBackground(Color.WHITE);
		bAnnuler.setForeground(Color.black);
		bAnnuler.setFocusPainted(false);
		bAnnuler.setFont(new Font("TimesNew", Font.BOLD, 12));

	}

	public VueAppliRV getVueParente() {
		return vueParente;
	}

	public void setVueParente(VueAppliRV vueParente) {
		this.vueParente = vueParente;
	}

	public ControleurTriPraticien getControleur() {
		return controleur;
	}

	public void setControleur(ControleurTriPraticien controleur) {
		this.controleur = controleur;
	}

	public ButtonGroup getbTri() {
		return bTri;
	}

	public void setbTri(ButtonGroup bTri) {
		this.bTri = bTri;
	}

	public JRadioButton getbCoefNoto() {
		return bCoefNoto;
	}

	public void setbCoefNoto(JRadioButton bCoefNoto) {
		this.bCoefNoto = bCoefNoto;
	}

	public JRadioButton getbDate() {
		return bDate;
	}

	public void setbDate(JRadioButton bDate) {
		this.bDate = bDate;
	}

	public JRadioButton getbCoefConf() {
		return bCoefConf;
	}

	public void setbCoefConf(JRadioButton bCoefConf) {
		this.bCoefConf = bCoefConf;
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

	public String getCoefConfiance() {
		return coefConfiance;
	}

	public void setCoefConfiance(String coefConfiance) {
		this.coefConfiance = coefConfiance;
	}

	public String getCoefNotoriete() {
		return coefNotoriete;
	}

	public void setCoefNotoriete(String coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public JRadioButton getbNoTri() {
		return bNoTri;
	}

	public void setbNoTri(JRadioButton bNoTri) {
		this.bNoTri = bNoTri;
	}

}
