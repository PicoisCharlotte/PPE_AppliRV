package fr.gsb.app.entites;

public class RapportVisite {

	private String matricule;
	private String rap_num;
	private String pra_num;
	private String rap_date;
	private String rap_bilan;
	private String rap_motif;
	private String rap_coefConf;
	private boolean etat;
	private String date_redac;
	private Praticien sonPraticien;

	public RapportVisite(String matricule, String rap_num, String pra_num,
			String rap_date, String rap_bilan, String rap_motif,
			String rap_coefConf, boolean etat, String date_redac) {
		super();
		this.matricule = matricule;
		this.rap_num = rap_num;
		this.pra_num = pra_num;
		this.rap_date = rap_date;
		this.rap_bilan = rap_bilan;
		this.rap_motif = rap_motif;
		this.rap_coefConf = rap_coefConf;
		this.etat = etat;
		this.date_redac = date_redac;

	}

	public RapportVisite(String matricule, String rap_num, String pra_num,
			String rap_date, String rap_bilan, String rap_motif,
			String rap_coefConf, boolean etat, String date_redac,
			Praticien sonPraticien) {
		super();
		this.matricule = matricule;
		this.rap_num = rap_num;
		this.pra_num = pra_num;
		this.rap_date = rap_date;
		this.rap_bilan = rap_bilan;
		this.rap_motif = rap_motif;
		this.rap_coefConf = rap_coefConf;
		this.etat = etat;
		this.date_redac = date_redac;
		this.sonPraticien = sonPraticien;
		sonPraticien.getLesRapports().add(this);

	}

	public RapportVisite(String matricule, String rap_num, String rap_date,
			String rap_bilan, String rap_motif) {
		super();
		this.matricule = matricule;
		this.rap_num = rap_num;
		this.rap_date = rap_date;
		this.rap_bilan = rap_bilan;
		this.rap_motif = rap_motif;
	}

	public RapportVisite(String matricule, String rap_date) {
		super();
		this.matricule = matricule;
		this.rap_date = rap_date;
	}

	public RapportVisite(String matricule, String rap_num, String rap_date,
			String rap_motif) {
		super();
		this.matricule = matricule;
		this.rap_num = rap_num;
		this.rap_date = rap_date;
		this.rap_motif = rap_motif;
	}

	public RapportVisite(String rap_date, String rap_num, String rap_coefConf) {
		super();
		this.rap_num = rap_num;
		this.rap_date = rap_date;
		this.rap_coefConf = rap_coefConf;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getRap_num() {
		return rap_num;
	}

	public void setRap_num(String rap_num) {
		this.rap_num = rap_num;
	}

	public String getPra_num() {
		return pra_num;
	}

	public void setPra_num(String pra_num) {
		this.pra_num = pra_num;
	}

	public String getRap_date() {
		return rap_date;
	}

	public void setRap_date(String rap_date) {
		this.rap_date = rap_date;
	}

	public String getRap_bilan() {
		return rap_bilan;
	}

	public void setRap_bilan(String rap_bilan) {
		this.rap_bilan = rap_bilan;
	}

	public String getRap_motif() {
		return rap_motif;
	}

	public void setRap_motif(String rap_motif) {
		this.rap_motif = rap_motif;
	}

	public String getRap_coefConf() {
		return rap_coefConf;
	}

	public void setRap_coefConf(String rap_coefConf) {
		this.rap_coefConf = rap_coefConf;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getDate_redac() {
		return date_redac;
	}

	public void setDate_redac(String date_redac) {
		this.date_redac = date_redac;
	}

	public Praticien getSonPraticien() {
		return sonPraticien;
	}

	public void setSonPraticien(Praticien sonPraticien) {
		this.sonPraticien = sonPraticien;
	}

	@Override
	public String toString() {
		return "RapportVisite [matricule=" + matricule + ", rap_num=" + rap_num
				+ ", pra_num=" + pra_num + ", rap_date=" + rap_date
				+ ", rap_bilan=" + rap_bilan + ", rap_motif=" + rap_motif
				+ ", rap_coefConf=" + rap_coefConf + "]";
	}

}
