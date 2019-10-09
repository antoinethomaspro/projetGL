import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.TextField;
import java.awt.TextArea;

public class Window_User extends JFrame {
	private JPanel panel = new JPanel();
	private JButton reset = new JButton("Reinitialiser");
	private JButton done = new JButton("Valider");
	private JButton cancel = new JButton("Annuler");
	private JComboBox<String> boxType = new JComboBox<String>();
	private JLabel titre = new JLabel("Titre du ticket");
	private JLabel description = new JLabel("Description");
	private JTextField titreField = new JTextField("");
	private JLabel priority = new JLabel("Echelle d'importance");
	private JLabel lblOrigineDuTicket = new JLabel("Origine du ticket");
	private JComboBox<String> importance = new JComboBox<String>();
	private TextArea desc = new TextArea();

	public Window_User() {
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		this.setVisible(true); // page visible
		this.setTitle("User Window"); // title
		this.setSize(731, 327); // size
		this.setLocationRelativeTo(null); // fenetre centrée
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arret du processus quand fermeture de la fenetre
		this.setContentPane(panel); // mise en place du jpanel
		panel.setLayout(null); 											//AJOUT DES ELEMENTS DANS LE JPANEL + MISE EN PLACE AVEC COORDONNEES
		cancel.setBounds(627, 254, 78, 23);
		panel.add(cancel);
		done.setBounds(539, 254, 78, 23);
		panel.add(done);
		priority.setBounds(325, 167, 130, 23);
		panel.add(priority);
		description.setBounds(25, 56, 97, 23);
		panel.add(description);
		titreField.setBounds(154, 22, 441, 23);
		titreField.setPreferredSize(new Dimension(450, 30));
		panel.add(titreField);
		titre.setBounds(25, 22, 97, 23);
		panel.add(titre);
		titre.setAlignmentX(400);
		boxType.setBounds(154, 167, 130, 23);
		panel.add(boxType);
		boxType.setPreferredSize(new Dimension(100, 20));
		importance.addItem("Haute");
		importance.addItem("Normale");
		importance.addItem("Faible");
		importance.setBounds(465, 167, 130, 23);
		panel.add(importance);
		lblOrigineDuTicket.setBounds(25, 169, 106, 19);
		panel.add(lblOrigineDuTicket);
		desc.setBounds(154, 56, 441, 96);
		panel.add(desc);
		boxType.addItem("Problème");
		boxType.addItem("Question");
		boxType.addItem("Incident");									//FIN MISE EN PLACE
	}
}
