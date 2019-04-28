import java.sql.*;


public class Piece {
	private String nomPiece;
	private String meuble;
	private Carton carton;
	private Connection connexion;

	public Piece(String n) {
		this.nomPiece = n;
	}

	public void setNomPiece(String n) {
		this.nomPiece = n;
	}

	public String getNomPiece() {
		return this.nomPiece;
	}


	public void ajoutPiece(String n) {

		try{
			ConnexionBDD connexionBDD = new ConnexionBDD();
			this.nomPiece = n;

			Statement statement = connexion.createStatement();
			PreparedStatement preparedStatement = this.connexion.prepareStatement("INSERT INTO Piece(nom) VALUES(?)");
			preparedStatement.setString(1, nomPiece);

			int statut = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			System.err.println("Erreur SQL");
		}
	}


	public void ajoutMeubleDansPiece(Meuble m, String n) {
		this.nomPiece = n;
		this.meuble = m.getDescription();

		try{
			ConnexionBDD connexionBDD = new ConnexionBDD();

			Statement statement = connexion.createStatement();
			PreparedStatement preparedStatement = this.connexion.prepareStatement("INSERT INTO Piece(nom, description) VALUES(?, ?)");
			preparedStatement.setString(1, nomPiece);
			preparedStatement.setString(2, m.getDescription());

			int statut = preparedStatement.executeUpdate();
		} catch(SQLException e){
			System.err.println("Erreur SQL");
		}
	}

	public void voirPiece(){
		try{
			ConnexionBDD connexionBDD = new ConnexionBDD();

			PreparedStatement preparedStatement = this.connexion.prepareStatement("SELECT * FROM Piece");
			preparedStatement.executeQuery();

		} catch(SQLException e){
			System.err.println("Erreur SQL");
		}
	}




}