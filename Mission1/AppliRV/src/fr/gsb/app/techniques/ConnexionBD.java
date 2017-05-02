package fr.gsb.app.techniques;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {

	private static String dbURL = "jdbc:mysql://localhost:3306/GsbCRSlamV2015";
	private static String user = "root";
	private static String password = "azerty";

	private static Connection connexion = null;

	private ConnexionBD() throws ConnexionException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = (Connection) DriverManager.getConnection(dbURL, user,
					password);
			System.out.println("Connexion Ok");
		} catch (Exception e) {
			System.out.println("Erreur ! : " + e.getMessage());
			throw new ConnexionException();
		}
	}

	public static Connection getConnexion() throws ConnexionException {
		if (connexion == null) {
			new ConnexionBD();
		}
		return connexion;
	}

}
