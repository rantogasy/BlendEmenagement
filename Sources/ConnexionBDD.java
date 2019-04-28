import java.sql.*;

public class ConnexionBDD {
	public ConnexionBDD() {
		try {
			Class.forName("arg.mariadb.jdbc.Driver");
			try {
				Connection connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/simona","simona","simona");
			} catch(SQLException e) {
				System.err.println("Erreur de connexion:"+e.getMessage());
			}

		} catch(ClassNotFoundException e) {
			System.err.println("Pilote indisponible");
		}
		
	}

}