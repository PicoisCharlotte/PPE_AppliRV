package fr.gsb.app.rendus;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import fr.gsb.app.entites.RapportVisite;
import fr.gsb.app.modeles.ModeleAppliRV;
import fr.gsb.app.vues.VueListeRapportVisiteur;

public class RenduListeRapportVisiteur extends DefaultTableCellRenderer  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VueListeRapportVisiteur vue;

	public RenduListeRapportVisiteur(VueListeRapportVisiteur vue) {
		super();
		this.vue = vue;
	}
	
	

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row , int column) {
		// TODO Auto-generated method stub
	
		List<RapportVisite> lesRapport = ModeleAppliRV.getModele()
				.getRapportVisite(this.vue.getMatricule(), this.vue.getDate());

		RapportVisite unRapport = lesRapport.get(row);
		
		if(table.getSelectedRow() == row && table.hasFocus()) {
	        hasFocus = true;
	    }

	    
	    if (unRapport.isEtat() == true) {
	    	
			this.setBackground(new Color(200, 50, 50, 100));
			

		} else {
			this.setBackground(new Color(211, 237, 200, 100));
		

		}
	    
	    if (hasFocus || isSelected) {
	        this.setBackground(new Color(0, 102, 153, 50));    	  
	    }
	    
	    setValue(value);

	    return this;

	}

}
