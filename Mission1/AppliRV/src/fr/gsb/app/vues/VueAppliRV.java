package fr.gsb.app.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import fr.gsb.app.controleurs.ControleurAppliRV;

public class VueAppliRV extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ControleurAppliRV controleur;

	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuActions = new JMenu("Actions");
	private JMenu menuAide = new JMenu("Aide");

	private JMenuItem itemSeConnecter = new JMenuItem("Se connecter");
	private JMenuItem itemSeDeconnecter = new JMenuItem("Se déconnecter");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");

	private JMenuItem itemRapportVisiteur = new JMenuItem(
			"Rapport de Visiteurs");
	private JMenuItem itemListePraticiens = new JMenuItem(
			"Liste des Praticiens");

	private JMenuItem itemApropos = new JMenuItem("A Propos...");

	public VueAppliRV() {
		super();

		this.setTitle("AppliRV");

		this.setSize(1200, 800);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.creerInterface();

		this.creerBarreMenus();

		this.setBarreMenusModeDeconnecte();

		this.controleur = new ControleurAppliRV(this);

		// this.getContentPane().setBackground(Color.decode("#FFFFF0"));

		this.setVisible(true);

	}

	private void creerBarreMenus() {

		JMenuBar barreMenus = new JMenuBar();

		this.menuFichier.add(this.itemSeConnecter);
		this.menuFichier.add(this.itemSeDeconnecter);
		this.menuFichier.add(new JSeparator());
		this.menuFichier.add(this.itemQuitter);

		this.menuActions.add(this.itemRapportVisiteur);
		this.menuActions.add(this.itemListePraticiens);

		this.menuAide.add(this.itemApropos);

		barreMenus.add(menuFichier);
		barreMenus.add(menuActions);
		barreMenus.add(menuAide);

		this.setJMenuBar(barreMenus);

	}

	public void setBarreMenusModeConnecte() {

		this.itemSeConnecter.setEnabled(false);

		this.itemSeDeconnecter.setEnabled(true);

		this.menuActions.setEnabled(true);
	}

	public void setBarreMenusModeDeconnecte() {

		this.itemSeConnecter.setEnabled(true);
		this.itemSeDeconnecter.setEnabled(false);
		this.menuActions.setEnabled(false);
	}

	public void creerInterface() {
		JPanel panneau = new JPanel();
		JLabel titre = new JLabel("Bienvenue sur AppliRV");
		titre.setFont(new Font("Courier New", 10, 25));

		panneau.add(titre);
		titre.setLayout(null);
		titre.setPreferredSize(new Dimension(300, 400));
		panneau.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				Color.BLACK));
		panneau.setBackground(new Color(0, 102, 153, 50));

		this.getContentPane().add(panneau);

	}

	public ControleurAppliRV getControleur() {
		return controleur;
	}

	public JMenuItem getItemSeConnecter() {
		return itemSeConnecter;
	}

	public JMenuItem getItemSeDeconnecter() {
		return itemSeDeconnecter;
	}

	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemRapportVisiteur() {
		return itemRapportVisiteur;
	}

	public JMenuItem getItemListePraticiens() {
		return itemListePraticiens;
	}

	public JMenuItem getItemApropos() {
		return itemApropos;
	}

}
