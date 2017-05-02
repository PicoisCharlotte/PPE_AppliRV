package fr.gsb.app.modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsb.app.entites.Visiteur;
import fr.gsb.app.techniques.Session;

public class ModeleListeVisiteurs extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] entetes = { "Matricule", "Nom", "Prénom" };
	private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>(ModeleAppliRV
			.getModele().getVisiteurs(Session.getSession().getLeVisiteur().getRegion()));

	public ModeleListeVisiteurs() {
		super();
	}

	public ModeleListeVisiteurs(String[] entetes) {
		super();
		this.entetes = entetes;
	}

	public int getRowCount() {
		return lesVisiteurs.size();
	}

	public int getColumnCount() {
		return this.entetes.length;

	}

	public String getColumnName(int columnIndex) {
		;
		return entetes[columnIndex];

	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Object objet = new Object();
		switch (columnIndex) {

		case 0:
			objet = new String(this.lesVisiteurs.get(rowIndex).getMatricule());
			break;

		case 1:

			objet = new String(this.lesVisiteurs.get(rowIndex).getNom());
			break;

		case 2:

			objet = new String(this.lesVisiteurs.get(rowIndex).getPrenom());
			break;

		default:
			objet = null;
			break;
		}

		return objet;

	}

	public Class<?> getColumnClass(int columnIndex) {

		Class<?> classe;
		switch (columnIndex) {

		case 0:
			classe = String.class;
			break;

		case 1:
			classe = String.class;
			break;

		case 2:
			classe = String.class;
			break;

		default:
			classe = null;
			break;

		}

		return classe;
	}

	public void actualiser() {
		this.fireTableDataChanged();

	}

}
