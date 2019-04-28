import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.sql.*;

public class PetitCarton extends Carton {
	private String nom;
	private String carton;
	private Connection connexion;


	public PetitCarton(String n) {
		super(n);
		this.nom = n;
	}

	public void voirPetitCarton(Carton c) {
		this.carton = c.getTypeCarton();

		try{
			ConnexionBDD connexionBDD = new ConnexionBDD();

			PreparedStatement preparedStatement = this.connexion.prepareStatement("SELECT * FROM Carton WHERE nom = ?");
			preparedStatement.setString(1, c.getTypeCarton());
			preparedStatement.executeQuery();

		} catch(SQLException e){
			System.err.println("Erreur SQL");
		}
	}
}
