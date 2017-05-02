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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import fr.gsb.app.controleurs.ControleurConnexion;

public class VueConnexion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	VueAppliRV vueParente;

	ControleurConnexion controleur;

	JLabel lbLogin = new JLabel("Login :");
	JLabel lbMdp = new JLabel("Mot de passe :");

	JTextField tfLogin = new JTextField();

	JPasswordField pfMdp = new JPasswordField();

	JButton bConnecter = new JButton("Se connecter");
	JButton bAnnuler = new JButton("Annuler");

	public VueConnexion(VueAppliRV vueParente) {

		super(vueParente, "Connexion", true);

		this.vueParente = vueParente;

		this.creerInterface();

		this.pack();

		this.setLocationRelativeTo(null);

		this.setResizable(false);

		this.controleur = new ControleurConnexion(this);

		//this.getContentPane().setBackground(Color.decode("#FFFFF0"));
		this.getContentPane().setBackground(new Color(0, 100, 200, 20)) ;

		this.setVisible(true);
	}

	private void creerInterface() {

		GridLayout agenceur = new GridLayout(3, 2);

		agenceur.setHgap(5);
		agenceur.setVgap(5);

		this.setLayout(agenceur);

		Container panneau = this.getContentPane();

		panneau.setLayout(new GridLayout(3, 2, 20, 20));
		panneau.add(this.lbLogin);
		panneau.add(this.tfLogin);

		panneau.add(this.lbMdp);
		panneau.add(this.pfMdp);

		panneau.add(this.bConnecter);
		panneau.add(this.bAnnuler);

		Border border = BorderFactory.createTitledBorder("Connexion ");
		((JComponent) panneau).setBorder(border);
		
		 bConnecter.setBackground(Color.WHITE);
		 bConnecter.setForeground(Color.black);
		 bConnecter.setFocusPainted(false);
		 bConnecter.setFont(new Font("TimesNew", Font.BOLD, 12));
		  
		 bAnnuler.setBackground(Color.WHITE);
		 bAnnuler.setForeground(Color.black);
		 bAnnuler.setFocusPainted(false);
		 bAnnuler.setFont(new Font("TimesNew", Font.BOLD, 12));

	}

	public ControleurConnexion getControleur() {
		return controleur;
	}

	public JLabel getLbIdentifiant() {
		return lbLogin;
	}

	public JLabel getLbMdp() {
		return lbMdp;
	}

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public JPasswordField getPfMdp() {
		return pfMdp;
	}

	public JButton getbConnecter() {
		return bConnecter;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

	public VueAppliRV getVueParente() {
		return vueParente;
	}

}
