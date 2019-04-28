

import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.sql.*;
import java.sql.ResultSet;

public class Controller implements ActionListener {

	private JFrame fenetre;
	private File nomImage;
	private Meuble meuble;
	private Connection connexion;
 	public Controller(JFrame f, Meuble m) {
		this.fenetre = f;
		this.meuble = m;
			try {
		this.connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/simona","simona","simona");
		} catch(SQLException e) {
			System.err.println("Pilote Indisponible");
		} 

	}

	public void actionPerformed(ActionEvent e) {

		try {
		if (e.getActionCommand().equals("Ajouter un meuble")) {

			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(fenetre);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				this.nomImage = chooser.getSelectedFile();


				String s = (String)JOptionPane.showInputDialog(fenetre, "Description","Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "description");


				if ((s != null) && (s.length() > 0)) {
					meuble.setDescription(s);
					String vol = (String)JOptionPane.showInputDialog(fenetre,"Volume","Customized Dialog",JOptionPane.PLAIN_MESSAGE, null, null, "10");
					int volume = 0;
					volume = Integer.parseInt(vol);


					if(volume != 0) {
						meuble.setVolume(volume);
						String pie = (String)JOptionPane.showInputDialog(fenetre,"Si démontable mettre nombre de pièces, sinon laisser à 0","Customized Dialog",JOptionPane.PLAIN_MESSAGE, null, null, "0");
						int pieces = 0;
						pieces = Integer.parseInt(pie);
						if(pieces <= 0) {
							meuble.setDemontable(false);
					} else if(pieces > 0){
						meuble.setDemontable(true);
						meuble.setNombreElement(pieces);
						String volElement = (String)JOptionPane.showInputDialog(fenetre,"Mettre volume des élements","Customized Dialog",JOptionPane.PLAIN_MESSAGE, null, null, "0");
						int volEl = 0;
						volEl = Integer.parseInt(volElement);
						meuble.setVolumeElement(volEl);
					}





					String p = (String)JOptionPane.showInputDialog(fenetre, "Dans quelle pièce voulez-vous mettre le meuble ?","Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "Piece");
					meuble.setPiece(p);

					int input = JOptionPane.showConfirmDialog(null, "Description:" + meuble.getDescription() + 
					"\nVolume:" + meuble.getVolume() + "\nDemontable:" + meuble.getDemontable() + "\nNombre éléments:" + 
					meuble.getNombreElement() + "\nVolume élément:" + meuble.getVolumeElement() + "\nPiece:" + meuble.getPiece() , "Récapitulatif du meuble",JOptionPane.YES_NO_OPTION );
					if (input == JOptionPane.OK_OPTION) {
						meuble.ajoutMeuble();
					}
					//meuble.ajoutMeuble();

				}
				}


				//nomImage.getAbsolutePath()



			}

		} else {
			String results="";
			try{
			PreparedStatement preparedStatement = this.connexion.prepareStatement("SELECT * FROM Meuble ORDER BY piece");
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				results += resultset.getString("description");
				results += " dans : " + resultset.getString("piece");
				results += "\n_______\n";

			}
						JOptionPane.showMessageDialog(null, results, "Inventaire",JOptionPane.PLAIN_MESSAGE);

			}catch(SQLException reinedesneiges){
				System.err.println("meh");
			}

		}

		} catch(NumberFormatException a) {
					System.err.println("Erreur de format");
				}

	}
}
