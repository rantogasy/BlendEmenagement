import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.sql.*;


public class Meuble extends File {

	private String description;
	private int volume;
	private String chemin;
	private Boolean demontable;
	private int nombreElement;
	private int volumeElement;
	private String piece;
	private Connection connexion;


	public Meuble(String c) {
		super(c);
		this.chemin = c;
		try {
		this.connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/simona","simona","simona");
		} catch(SQLException e) {
			System.err.println("Pilote Indisponible");
		} 
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public String getDescription() {
		return this.description;
	}

	public void setVolume(int vol) {
		this.volume = vol;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setNombreElement(int nbElement) {
		this.nombreElement = nbElement;
	}

	public int getNombreElement() {
		return this.nombreElement;
	}

	public void setVolumeElement(int volEl) {
		this.volumeElement = volEl;
	}

	public int getVolumeElement() {
		return this.volumeElement;
	}

	public void setDemontable(boolean a){
		this.demontable=a;
	}
	public boolean getDemontable(){
		return this.demontable;
	}


	public void setPiece(String p){
		this.piece = p;
	}
	public String getPiece(){
		return this.piece;
	}


	public void ajoutMeuble() {

		try{

			Statement statement = this.connexion.createStatement();
			PreparedStatement preparedStatement = this.connexion.prepareStatement("INSERT INTO Meuble(description, volume, demontable, nombreElement, volumeElement, piece) VALUES(?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, this.description);
			preparedStatement.setInt(2, this.volume);
			preparedStatement.setBoolean(3, this.demontable);
			preparedStatement.setInt(4, this.nombreElement);
			preparedStatement.setInt(5, this.volume);
			preparedStatement.setString(6, this.piece);

			int statut = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			System.err.println("Erreur SQL");
		}
	}







}
