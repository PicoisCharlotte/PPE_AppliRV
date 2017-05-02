package fr.gsb.app.vues;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;

import fr.gsb.app.controleurs.ControleurPraticien;
import fr.gsb.app.entites.Praticien;

public class VuePraticien extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VueListePraticiens vueParente;
	private ControleurPraticien controleur;

	private Praticien praticien;
	private String pra_num;
	private String nom;
	private String prenom;
	private String adresse;
	private String cp;
	private String ville;
	private String coefNoto;
	private String coefConf;
	private String date;

	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Annuler");

	public VuePraticien() {
		super();
	}

	public VuePraticien(VueListePraticiens vueParente, String pra_num,
			String nom, String prenom, String adresse, String cp, String ville,
			String coefNoto, String coefConf, String date) {
		super();
		this.vueParente = vueParente;

		this.pra_num = pra_num;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.coefNoto = coefNoto;
		this.coefConf = coefConf;
		this.date = date;

		this.setTitle("Praticien");

		this.setSize(300, 400);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setResizable(false);

		this.controleur = new ControleurPraticien(this);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));
		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.setVisible(true);

		this.creerInterface();

	}

	public void creerInterface() {

		Container panneau = this.getContentPane();
		panneau.setLayout(new GridLayout(10, 2, 20, 20));
		Border border = BorderFactory.createTitledBorder("PROFIL PRATICIEN");
		((JComponent) panneau).setBorder(border);

		panneau.add(new JLabel("N° Praticien   "));
		panneau.add(new JLabel(pra_num));

		panneau.add(new JLabel("Nom  "));
		panneau.add(new JLabel(nom));

		panneau.add(new JLabel("Prénom  "));
		panneau.add(new JLabel(prenom));

		panneau.add(new JLabel("Adresse  "));
		panneau.add(new JLabel(adresse));

		panneau.add(new JLabel("Code Postal "));
		panneau.add(new JLabel(cp));

		panneau.add(new JLabel("Ville "));
		panneau.add(new JLabel(ville));

		panneau.add(new JLabel("Coeff Notoriété "));
		panneau.add(new JLabel(coefNoto));

		panneau.add(new JLabel("Coeff Confiance "));
		panneau.add(new JLabel(coefConf));

		panneau.add(new JLabel("Dernier Rapport "));
		panneau.add(new JLabel(date));

		panneau.add(bValider);

		bValider.setBackground(Color.WHITE);
		bValider.setForeground(Color.black);
		bValider.setFocusPainted(false);
		bValider.setFont(new Font("TimesNew", Font.BOLD, 12));

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

}
