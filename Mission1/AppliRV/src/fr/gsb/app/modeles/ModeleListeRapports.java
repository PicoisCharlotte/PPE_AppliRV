package fr.gsb.app.modeles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import fr.gsb.app.entites.RapportVisite;

public class ModeleListeRapports extends AbstractTableModel {

	private String[] entetes = { "N°Rapport", "Matricule Visiteur",
			"Date Rapport", "Motif", "Date Rédaction", "Nom Praticien",
			"Prénom Praticien", "Ville Praticien" };

	private String matricule;
	private String date;
	private List<RapportVisite> lesRapports = new ArrayList<RapportVisite>();

	public ModeleListeRapports(String matricule, String date) {
		super();
		this.matricule = matricule;
		this.date = date;
		lesRapports = ModeleAppliRV.getModele().getRapportVisite(matricule,
				date);
	}

	public ModeleListeRapports(String[] entetes) {
		super();
		this.entetes = entetes;
	}

	public int getRowCount() {
		return lesRapports.size();
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
			objet = new String(this.lesRapports.get(rowIndex).getRap_num());
			break;

		case 1:

			objet = new String(this.lesRapports.get(rowIndex).getMatricule());
			break;

		case 2:

			objet = new String(this.lesRapports.get(rowIndex).getRap_date());
			break;

		case 3:

			objet = new String(this.lesRapports.get(rowIndex).getRap_motif());
			break;

		case 4:

			objet = new String(this.lesRapports.get(rowIndex).getDate_redac());
			break;

		case 5:
			objet = new String(this.lesRapports.get(rowIndex).getSonPraticien()
					.getNom());
			break;
		case 6:
			objet = new String(this.lesRapports.get(rowIndex).getSonPraticien()
					.getPrenom());
			break;
		case 7:
			objet = new String(this.lesRapports.get(rowIndex).getSonPraticien()
					.getVille());
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

		case 3:
			classe = String.class;
			break;
		case 4:
			classe = String.class;
			break;
		case 5:
			classe = String.class;
			break;
		case 6:
			classe = String.class;
			break;
		case 7:
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
