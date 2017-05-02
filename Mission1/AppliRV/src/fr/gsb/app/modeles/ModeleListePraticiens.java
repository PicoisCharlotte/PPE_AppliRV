package fr.gsb.app.modeles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import fr.gsb.app.entites.Praticien;

public class ModeleListePraticiens extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] entetes = { "Numéro du Praticien", "Nom du Praticien",
			"Ville du Praticien", "Coefficiant de Confiance",
			"Coefficient de Notoriete", "Date du dernier Rapport" };

	private List<Praticien> lstPraticiens = new ArrayList<Praticien>();
	private String tri;

	public ModeleListePraticiens(String tri) {
		super();
		this.tri = tri;
		if (tri == "DATE") {
			String[] entetes2 = { "Numéro du Praticien", "Nom du Praticien",
					"Ville du Praticien", "Date du dernier Rapport" };
			this.entetes = entetes2;
			lstPraticiens = ModeleAppliRV.getModele().getPraticienDate();

		} else if (tri == "CONF") {
			String[] entetes2 = { "Numéro du Praticien", "Nom du Praticien",
					"Ville du Praticien", "Coefficiant de Confiance" };
			this.entetes = entetes2;
			lstPraticiens = ModeleAppliRV.getModele().getPraticienCoefConf();
		} else if (tri == "NOTO") {
			String[] entetes2 = { "Numéro du Praticien", "Nom du Praticien",
					"Ville du Praticien", "Coefficient de Notoriete" };
			this.entetes = entetes2;
			lstPraticiens = ModeleAppliRV.getModele().getPraticienCoefNoto();
		} else if (tri == "NOTRI") {

			lstPraticiens = ModeleAppliRV.getModele().getPraticiens();
		}

	}

	public ModeleListePraticiens(String[] entetes) {
		super();
		this.entetes = entetes;
	}

	public int getRowCount() {
		return this.lstPraticiens.size();
	}

	public int getColumnCount() {
		return this.entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object objet;

		if (tri == "DATE") {
			switch (columnIndex) {

			case 0:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getPra_num());
				break;

			case 1:
				objet = new String(this.lstPraticiens.get(rowIndex).getNom());
				break;

			case 2:
				objet = new String(this.lstPraticiens.get(rowIndex).getVille());
				break;

			case 3:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getUnRapport().getRap_date());
				break;

			default:
				objet = null;
				break;
			}
		} else if (tri == "CONF") {

			switch (columnIndex) {

			case 0:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getPra_num());
				break;

			case 1:
				objet = new String(this.lstPraticiens.get(rowIndex).getNom());
				break;

			case 2:
				objet = new String(this.lstPraticiens.get(rowIndex).getVille());
				break;

			case 3:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getUnRapport().getRap_coefConf());
				break;

			default:
				objet = null;
				break;

			}

		} else if (tri == "NOTO") {

			switch (columnIndex) {

			case 0:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getPra_num());
				break;

			case 1:
				objet = new String(this.lstPraticiens.get(rowIndex).getNom());
				break;

			case 2:
				objet = new String(this.lstPraticiens.get(rowIndex).getVille());
				break;

			case 3:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getCoefNotoriete());
				break;

			default:
				objet = null;
				break;
			}
		} else {

			switch (columnIndex) {

			case 0:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getPra_num());
				break;

			case 1:
				objet = new String(this.lstPraticiens.get(rowIndex).getNom());
				break;

			case 2:
				objet = new String(this.lstPraticiens.get(rowIndex).getVille());
				break;

			case 3:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getUnRapport().getRap_coefConf());
				break;

			case 4:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getCoefNotoriete());
				break;

			case 5:
				objet = new String(this.lstPraticiens.get(rowIndex)
						.getUnRapport().getRap_date());
				break;

			default:
				objet = null;
				break;
			}
		}
		return objet;
	}

	public Class<?> getColumnClass(int columnIndex) {

		Class<?> classe;
		if (tri == "NOTRI") {
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

			default:
				classe = null;
				break;

			}
		}

		else {
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

			default:
				classe = null;
				break;

			}
		}
		return classe;
	}

	public void actualiser() {
		this.fireTableDataChanged();
	}

	public String[] getEntetes() {
		return entetes;
	}

	public void setEntetes(String[] entetes) {
		this.entetes = entetes;
	}

}
