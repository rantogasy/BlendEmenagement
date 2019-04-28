import java.sql.*;


public class Carton {
	private String type;
	private Connection connexion;

	public Carton(String t) {
		this.type = t;
	}


	public void setTypeCarton(String t) {
		this.type = t;
	}

	public String getTypeCarton() {
		return this.type;
	}

	public void ajoutCarton(String t) {
		this.type = t;
		if ((t != "Petit") || (t != "Moyen") || (t !="Barrel") || (t != "Penderie") || (t!="Tableau")) {
			System.err.println("Erreur type de carton");
		}
		try {
			ConnexionBDD connexionBDD = new ConnexionBDD();

			this.type = t;
			Statement statement = this.connexion.createStatement();
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Carton(type) VALUES(?)");
			preparedStatement.setString(1, type);
			int statut = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			System.err.println("Erreur SQL");
		}

	}

	public void voirCarton() {
		try{
			ConnexionBDD connexionBDD = new ConnexionBDD();

			PreparedStatement preparedStatement = this.connexion.prepareStatement("SELECT * FROM Carton");
			preparedStatement.executeQuery();

		} catch(SQLException e){
			System.err.println("Erreur SQL");
		}
	}

}