import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import javax.imageio.ImageIO;


public class EcranAccueil extends JFrame {
	private Image img;
	public EcranAccueil() {
		super();
		this.setLayout(null);
		Meuble meuble = new Meuble("chaise");
		JButton prendrePhoto = new JButton("Ajouter un meuble");
		JButton inventaire = new JButton("Voir l'inventaire");
		JLabel image = new JLabel(new ImageIcon("background.jpg"));
		image.setBounds(0,0, 1000, 1000);
		prendrePhoto.setForeground(Color.BLUE);
		inventaire.setForeground(Color.BLUE);

		prendrePhoto.setBackground(new Color(142, 162, 198));
		inventaire.setBackground(new Color(142, 162, 198));

		prendrePhoto.setBounds(60,200,100,100);
		inventaire.setBounds(270,200,200,100);


		prendrePhoto.setSize(new Dimension(150, 50));
		inventaire.setSize(new Dimension(150, 50));
		this.setSize(508,450);
		this.setLocation(300,300);
		this.setTitle("Ecran d'Accueil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Controller controller = new Controller(this, meuble);
		prendrePhoto.addActionListener(controller);
		inventaire.addActionListener(controller);
		this.add(image);
		image.add(inventaire);
		image.add(prendrePhoto);
		this.setVisible(true);

	}
}
