package fr.gsb.app.modeles;

import fr.gsb.app.entites.Praticien;
import fr.gsb.app.entites.RapportVisite;
import fr.gsb.app.entites.Visiteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import fr.gsb.app.techniques.ConnexionBD;
import fr.gsb.app.techniques.ConnexionException;

public class ModeleAppliRV {

	private static ModeleAppliRV modele = null;

	private ModeleAppliRV() {
		super();
	}

	public static ModeleAppliRV getModele() {
		if (modele == null) {
			modele = new ModeleAppliRV();
		}
		return modele;
	}

	public Visiteur seConnecter(String login, String mdp) throws Exception {
		
		Connection connexion = ConnexionBD.getConnexion();
		
		Visiteur unVisiteur = new Visiteur("", "" , false) ;

		String requete = "select *"
				+ " from VISITEUR V inner join TRAVAILLER T"
				+ " on V.VIS_MATRICULE = T.VIS_MATRICULE"
				+ " where V.VIS_MATRICULE = ?" + " and V.MDP = ?"
				+ " and TRA_ROLE = 'Délégué'"
				+ " and T.JJMMAA = (Select Max(JJMMAA) from TRAVAILLER where VIS_MATRICULE = ?)";

		PreparedStatement requetePreparee = (PreparedStatement) connexion
				.prepareStatement(requete);

		requetePreparee.setString(1, login);
		requetePreparee.setString(2, mdp);
		requetePreparee.setString(3, login);

		//System.out.println("" + requetePreparee.toString());

		ResultSet resultat = requetePreparee.executeQuery();

		//System.out.println("*" + resultat.getFetchSize());

		boolean connexionOk  = false;

		if (resultat != null) {

			connexionOk = true;
			
			try {
				while (resultat.next()) {

					String matricule = resultat.getString("VIS_MATRICULE");
					String region = resultat.getString("REG_CODE") ;
					unVisiteur = new Visiteur(matricule , region ,  connexionOk);
					System.out.println(region) ;
					

				}
				resultat.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else {

			connexionOk = false;
		}

		requetePreparee.close();

		return unVisiteur;
	}

	public List<Visiteur> getVisiteurs(String region) {

		List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		String requete = "Select V.VIS_MATRICULE, V.VIS_NOM, V.VIS_PRENOM from VISITEUR V INNER JOIN TRAVAILLER T "
				+ " ON V.VIS_MATRICULE = T.VIS_MATRICULE"
				+ " where T.REG_CODE = ? ";

		Connection connexion = null;
		Statement stmt = null;
		ResultSet resultat = null;

		try {
			connexion = ConnexionBD.getConnexion();
			PreparedStatement requetePreparee = (PreparedStatement) connexion
					.prepareStatement(requete);
			
			requetePreparee.setString(1, region);
			
			resultat = requetePreparee.executeQuery();

		} catch (Exception e) {

			System.out.println("Echec getVisiteurs() " + e.getMessage());

		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String matricule = resultat.getString("VIS_MATRICULE");
						String nom = resultat.getString("VIS_NOM");
						String prenom = resultat.getString("VIS_PRENOM");
						Visiteur unVisiteur = new Visiteur(matricule, nom,
								prenom);
						lesVisiteurs.add(unVisiteur);

					}
					resultat.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return lesVisiteurs;
	}

	public List<RapportVisite> getRapportVisite(String matricule, String date) {

		List<RapportVisite> lesRapports = new ArrayList<RapportVisite>();
		String requete = "Select * from RAPPORT_VISITE R inner join PRATICIEN  P"
				+ " ON R.PRA_NUM = P.PRA_NUM "
				+ " where VIS_MATRICULE = ? and RAP_DATE LIKE ? "
				+ " Order by RAP_DATEREDAC";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {

			connexion = ConnexionBD.getConnexion();

			pstmt = (PreparedStatement) connexion.prepareStatement(requete);

			pstmt.setString(1, matricule);
			pstmt.setString(2, date + '%');

			resultat = pstmt.executeQuery();

		} catch (Exception e) {

			System.out.println("Echec getRapportVisite() " + e.getMessage());

		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String rap_num = resultat.getString("RAP_NUM");
						String visMatricule = resultat
								.getString("VIS_MATRICULE");
						String rap_date = resultat.getString("RAP_DATE");
						String rap_motif = resultat.getString("RAP_MOTIF");
						String rap_bilan = resultat.getString("RAP_BILAN");
						String pra_num = resultat.getString("PRA_NUM");
						String rap_coef = resultat
								.getString("RAP_COEFCONFIANCE");
						boolean etat = resultat.getBoolean("RAP_ETAT");
						String date_redac = resultat.getString("RAP_DATEREDAC");
						String nom_pra = resultat.getString("PRA_NOM");
						String prenom_pra = resultat.getString("PRA_PRENOM");
						String ville_pra = resultat.getString("PRA_VILLE");
						RapportVisite unRapport = new RapportVisite(
								visMatricule, rap_num, pra_num, rap_date,
								rap_bilan, rap_motif, rap_coef, etat,
								date_redac, new Praticien(pra_num, nom_pra,
										prenom_pra, ville_pra));
						lesRapports.add(unRapport);

					}
					resultat.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

		return lesRapports;

	}

	public RapportVisite getLeRapportVisite(String matricule, String rap_num) {

		String requete = "Select * from RAPPORT_VISITE where VIS_MATRICULE = ? and RAP_NUM = ? ";

		RapportVisite unRapport = null;
		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {

			connexion = ConnexionBD.getConnexion();

			pstmt = (PreparedStatement) connexion.prepareStatement(requete);

			pstmt.setString(1, matricule);
			pstmt.setString(2, rap_num);
			resultat = pstmt.executeQuery();

		} catch (Exception e) {

			System.out.println("Echec getLeRapportVisite() " + e.getMessage());

		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String num_rap = resultat.getString("RAP_NUM");
						String visMatricule = resultat
								.getString("VIS_MATRICULE");
						String rap_date = resultat.getString("RAP_DATE");
						String rap_motif = resultat.getString("RAP_MOTIF");
						String rap_bilan = resultat.getString("RAP_BILAN");
						String pra_num = resultat.getString("PRA_NUM");
						String rap_coef = resultat
								.getString("RAP_COEFCONFIANCE");
						boolean etat = resultat.getBoolean("RAP_ETAT");
						String date_redac = resultat.getString("RAP_DATEREDAC");
						unRapport = new RapportVisite(visMatricule, num_rap,
								pra_num, rap_date, rap_bilan, rap_motif,
								rap_coef, etat, date_redac);

					}
					resultat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return unRapport;
	}

	public boolean consulterRapport(String matricule, String rap_num) {

		String requete = "Update RAPPORT_VISITE SET RAP_ETAT = true WHERE VIS_MATRICULE =  ?   AND RAP_NUM = ? ";

		boolean Ok = false;
		Connection connexion = null;
		PreparedStatement pstmt = null;
		int resultat = 0;

		try {

			connexion = ConnexionBD.getConnexion();

			pstmt = (PreparedStatement) connexion.prepareStatement(requete);

			pstmt.setString(1, matricule);
			pstmt.setString(2, rap_num);

			resultat = pstmt.executeUpdate();

		} catch (Exception e) {

			System.out.println("Echec consulterRapport() " + e.getMessage());

		} finally {

			if (resultat > 0) {
				Ok = true;

			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Ok;
	}

	public List<Praticien> getPraticienDate() {

		List<Praticien> lstPraticien = new ArrayList<Praticien>();

		String requete = "SELECT  distinct *"
				+ " FROM PRATICIEN P INNER JOIN RAPPORT_VISITE RV ON RV.PRA_NUM = P.PRA_NUM "
				+ " Where RAP_DATE = (Select Max(RAP_DATE) FROM RAPPORT_VISITE where PRA_NUM = P.PRA_NUM ) "
				+ " AND RV.RAP_COEFCONFIANCE BETWEEN 0 AND 5 "
				+ " ORDER BY RAP_DATE ASC ";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {

				e.printStackTrace();
			}
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			resultat = pstmt.executeQuery();

		} catch (SQLException e) {

			System.out.println("Echec getPraticienDate() " + e.getMessage());
		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String pra_num = resultat.getString("PRA_NUM");
						String rap_date = resultat.getString("RAP_DATE");
						String coefconfiance = resultat
								.getString("RAP_COEFCONFIANCE");
						String coefnoto = resultat
								.getString("PRA_COEFNOTORIETE");
						String pra_nom = resultat.getString("PRA_NOM");
						String pra_ville = resultat.getString("PRA_VILLE");
						RapportVisite unRapport = new RapportVisite(rap_date,
								pra_num, coefconfiance);
						Praticien unPraticien = new Praticien(pra_num, pra_nom,
								pra_ville, coefnoto, unRapport);
						lstPraticien.add(unPraticien);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return lstPraticien;
	}

	public List<Praticien> getPraticienCoefConf() {

		List<Praticien> lstPraticien = new ArrayList<Praticien>();
		String requete = "SELECT distinct * "
				+ " FROM PRATICIEN P INNER JOIN RAPPORT_VISITE RV ON RV.PRA_NUM = P.PRA_NUM "
				+ " Where RAP_DATE = (Select Max(RAP_DATE) FROM RAPPORT_VISITE where PRA_NUM = P.PRA_NUM )"
				+ " AND RV.RAP_COEFCONFIANCE BETWEEN 0 AND 5 "
				+ " ORDER BY RV.RAP_COEFCONFIANCE ASC ";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			resultat = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Echec getPraticienCoefConf() " + e.getMessage());
		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String pra_num = resultat.getString("PRA_NUM");
						String rap_date = resultat.getString("RAP_DATE");
						String coefconfiance = resultat
								.getString("RAP_COEFCONFIANCE");
						String coefnoto = resultat
								.getString("PRA_COEFNOTORIETE");
						String pra_nom = resultat.getString("PRA_NOM");
						String pra_ville = resultat.getString("PRA_VILLE");
						RapportVisite unRapport = new RapportVisite(rap_date,
								pra_num, coefconfiance);
						Praticien unPraticien = new Praticien(pra_num, pra_nom,
								pra_ville, coefnoto, unRapport);
						lstPraticien.add(unPraticien);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return lstPraticien;
	}

	public List<Praticien> getPraticienCoefNoto() {

		List<Praticien> lstPraticien = new ArrayList<Praticien>();
		String requete = " Select *"
				+ " FROM PRATICIEN P INNER JOIN RAPPORT_VISITE RV ON RV.PRA_NUM = P.PRA_NUM "

				+ " Where RAP_DATE = (Select Max(RAP_DATE) FROM RAPPORT_VISITE where PRA_NUM = P.PRA_NUM ) "
				+ " AND RV.RAP_COEFCONFIANCE BETWEEN 0 AND 5 "
				+ " ORDER BY PRA_COEFNOTORIETE DESC ";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			resultat = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec getPraticienCoefNoto" + e.getMessage());
		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String pra_num = resultat.getString("PRA_NUM");
						String rap_date = resultat.getString("RAP_DATE");
						String coefconfiance = resultat
								.getString("RAP_COEFCONFIANCE");
						String coefnoto = resultat
								.getString("PRA_COEFNOTORIETE");
						String pra_nom = resultat.getString("PRA_NOM");
						String pra_ville = resultat.getString("PRA_VILLE");
						RapportVisite unRapport = new RapportVisite(rap_date,
								pra_num, coefconfiance);
						Praticien unPraticien = new Praticien(pra_num, pra_nom,
								pra_ville, coefnoto, unRapport);
						lstPraticien.add(unPraticien);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return lstPraticien;
	}

	public Praticien getUnPraticien(String pra_num1) {

		Praticien unPraticien = new Praticien();
		String requete = "SELECT *"
				+ " FROM PRATICIEN P INNER JOIN RAPPORT_VISITE RV ON RV.PRA_NUM = P.PRA_NUM "
				+ " Where RAP_DATE = (Select Max(RAP_DATE) FROM RAPPORT_VISITE where PRA_NUM = P.PRA_NUM )"
				+ " AND P.PRA_NUM = ? ";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			pstmt.setString(1, pra_num1);
			resultat = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec getUnPraticien() " + e.getMessage());
		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String pra_num = resultat.getString("PRA_NUM");
						String rap_date = resultat.getString("RAP_DATE");
						String coefconfiance = resultat
								.getString("RAP_COEFCONFIANCE");
						String coefnoto = resultat
								.getString("PRA_COEFNOTORIETE");
						String pra_nom = resultat.getString("PRA_NOM");
						String pra_ville = resultat.getString("PRA_VILLE");
						String pra_adresse = resultat.getString("PRA_ADRESSE");
						String pra_prenom = resultat.getString("PRA_PRENOM");
						String pra_cp = resultat.getString("PRA_CP");

						RapportVisite unRapport = new RapportVisite(rap_date,
								pra_num, coefconfiance);
						unPraticien = new Praticien(pra_num, pra_nom,
								pra_prenom, pra_adresse, pra_ville, pra_cp,
								coefnoto, unRapport);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return unPraticien;
	}

	public List<Praticien> getPraticiens() {

		List<Praticien> lstPraticien = new ArrayList<Praticien>();
		String requete = "SELECT distinct * "
				+ " FROM PRATICIEN P INNER JOIN RAPPORT_VISITE RV ON RV.PRA_NUM = P.PRA_NUM "
				+ " Where RAP_DATE = (Select Max(RAP_DATE) FROM RAPPORT_VISITE where PRA_NUM = P.PRA_NUM )"
				+ " Order by P.PRA_NUM ";

		Connection connexion = null;
		PreparedStatement pstmt = null;
		ResultSet resultat = null;

		try {
			try {
				connexion = ConnexionBD.getConnexion();
			} catch (ConnexionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt = (PreparedStatement) connexion.prepareStatement(requete);
			resultat = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec getPraticiens() " + e.getMessage());
		} finally {

			if (resultat != null) {

				try {
					while (resultat.next()) {

						String pra_num = resultat.getString("PRA_NUM");
						String rap_date = resultat.getString("RAP_DATE");
						String coefconfiance = resultat
								.getString("RAP_COEFCONFIANCE");
						String coefnoto = resultat
								.getString("PRA_COEFNOTORIETE");
						String pra_nom = resultat.getString("PRA_NOM");
						String pra_ville = resultat.getString("PRA_VILLE");
						String pra_adresse = resultat.getString("PRA_ADRESSE");
						String pra_prenom = resultat.getString("PRA_PRENOM");
						String pra_cp = resultat.getString("PRA_CP");
						RapportVisite unRapport = new RapportVisite(rap_date,
								pra_num, coefconfiance);
						Praticien unPraticien = new Praticien(pra_num, pra_nom,
								pra_prenom, pra_adresse, pra_ville, pra_cp,
								coefnoto, unRapport);
						lstPraticien.add(unPraticien);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return lstPraticien;
	}

	public static void setModele(ModeleAppliRV modele) {
		ModeleAppliRV.modele = modele;
	}

}
