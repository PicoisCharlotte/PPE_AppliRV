package fr.gsb.app.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import fr.gsb.app.techniques.Session;
import fr.gsb.app.vues.VueAppliRV;
import fr.gsb.app.vues.VueConnexion;
import fr.gsb.app.vues.VueListeVisiteurs;
import fr.gsb.app.vues.VueTriPraticien;

public class ControleurAppliRV implements ActionListener {
	
	private VueAppliRV vue ;					
	
	public ControleurAppliRV(VueAppliRV vue){
		super() ;		
		this.vue = vue ;
		this.enregistrerEcouteur();
	}
	


	private void enregistrerEcouteur(){
		
		this.vue.getItemSeConnecter().addActionListener(this) ;
		
		
		this.vue.getItemSeDeconnecter().addActionListener(this) ;
		
		
		this.vue.getItemQuitter().addActionListener(this) ;
		
		
		this.vue.getItemRapportVisiteur().addActionListener(this) ;
		
		
		this.vue.getItemListePraticiens().addActionListener(this) ;
		
		
		this.vue.getItemApropos().addActionListener(this) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getItemSeDeconnecter() ){
			this.seDeconnecter();
		}
		
		else if( sourceEvenement == this.vue.getItemQuitter() ){
			this.quitter();
		}
		else if (sourceEvenement == this.vue.getItemSeConnecter()){
			this.seConnecter();
		}
		else if( sourceEvenement == this.vue.getItemRapportVisiteur() ){
			this.consulterRapport();
		}
		else if( sourceEvenement == this.vue.getItemListePraticiens() ) {
			this.consulterListe();
		}
		else if (sourceEvenement == this.vue.getItemApropos() ){
			this.afficherApropos();
		}
		
	}
	
	private void seConnecter(){
		System.out.println("L'utilisateur veut se connecter.");
		new VueConnexion(this.vue) ;
	}
	
	private void seDeconnecter(){
		System.out.println("L'utilisateur veut se déconnecter.");
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment vous déconnecter ?","Déconnexion",JOptionPane.YES_NO_OPTION) ;
		
		if( reponse == JOptionPane.YES_OPTION ){
		
			Session.fermer();
			this.vue.setBarreMenusModeDeconnecte();			
			JOptionPane.showMessageDialog(null, "Vous êtes maintenant déconnecté.","Déconnexion",JOptionPane.INFORMATION_MESSAGE) ;
		}
	}
	
	private void quitter(){
		System.out.println("L'utilisateur veut quitter.");
		int reponse = JOptionPane.showConfirmDialog(this.vue, "Voulez-vous vraiment quitter ?","Quitter",JOptionPane.YES_NO_OPTION) ;
		
		
		if( reponse == JOptionPane.YES_OPTION ){
			
			
			if( Session.getSession() != null ){
				
				
				Session.fermer();
				
			}
			
			
			System.exit(0) ;
		}
	}
	
	private void consulterRapport(){
		System.out.println("L'utilisateur veut consulter le rapport d'un visiteur.");
		new VueListeVisiteurs(this.vue) ;
	}
	
	private void consulterListe(){
		System.out.println("L'utilisateur veut consulter la liste des praticiens hésitants.");
		new VueTriPraticien(this.vue) ;
	}
	
	private void afficherApropos(){
		System.out.println("L'utilisateur veut afficher la fenêtre A propos...");
		JOptionPane.showMessageDialog(this.vue, "GSB - Galaxy Swiss Bourdin\n2016","A propos...",JOptionPane.INFORMATION_MESSAGE) ;
	}

}

