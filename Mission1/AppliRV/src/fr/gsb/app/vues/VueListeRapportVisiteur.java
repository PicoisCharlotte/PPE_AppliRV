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

import fr.gsb.app.controleurs.ControleurListeRapportVisiteur;
import fr.gsb.app.modeles.ModeleListeRapports;
import fr.gsb.app.rendus.RenduListeRapportVisiteur;

public class VueListeRapportVisiteur extends JDialog {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	VueMoisAnnee vueParente;
	JTable tRapports = new JTable();
	JButton bValider = new JButton("Valider");
	JButton bAnnuler = new JButton("Retour");
	private ControleurListeRapportVisiteur controleur;
	private String matricule;
	private String date;
	private int rap_num;

	public VueListeRapportVisiteur(VueMoisAnnee vueParente, String matricule,
			String date) {
		super();
		this.vueParente = vueParente;
		this.matricule = matricule;
		this.date = date;
		this.setTitle("Liste des Rapports");
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.controleur = new ControleurListeRapportVisiteur(this);

		this.setVisible(true);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.getContentPane().setBackground(new Color(0, 100, 200, 20));

		this.creerInterface();
	}

	private void creerInterface() {

		Box bPrincipale = Box.createVerticalBox();
		bPrincipale.add(Box.createVerticalStrut(10));
		bPrincipale.add(new JLabel("Liste des Rapports"));
		bPrincipale.add(Box.createVerticalStrut(10));

		this.tRapports = new JTable(new ModeleListeRapports(this.matricule,
				this.date));
		this.tRapports.setDefaultRenderer(Object.class,
				new RenduListeRapportVisiteur(this));
		this.tRapports.setRowHeight(30);

		JScrollPane spRapports = new JScrollPane(this.tRapports);

		spRapports.setPreferredSize(new Dimension(1090, 420));

		bPrincipale.add(spRapports);

		bPrincipale.add(Box.createVerticalStrut(10));
		bPrincipale.add(Box.createHorizontalStrut(10));

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

	public JTable gettRapports() {
		return tRapports;
	}

	public void settRapports(JTable tRapports) {
		this.tRapports = tRapports;
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

	public ControleurListeRapportVisiteur getControleur() {
		return controleur;
	}

	public void setControleur(ControleurListeRapportVisiteur controleur) {
		this.controleur = controleur;
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

	public int getRap_num() {
		return rap_num;
	}

	public void setRap_num(int rap_num) {
		this.rap_num = rap_num;
	}

}
