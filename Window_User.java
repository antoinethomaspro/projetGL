package Ticketing_Projet;
import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_User extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JButton done = new JButton("Valider");
	private JButton cancel = new JButton("Annuler");
	private JComboBox<String> boxType = new JComboBox<String>();
	private JLabel titre = new JLabel("Titre du ticket");
	private JLabel description = new JLabel("Description");
	private JTextField titreField = new JTextField("");
	private JLabel priority = new JLabel("Priorité");
	private JLabel lblOrigineDuTicket = new JLabel("Catégorie");
	private JComboBox<String> importance = new JComboBox<String>();
	private TextArea desc = new TextArea();
	private JButton reset = new JButton("Reinitialiser");
	private ActionListener resetListener = new ActionListener() { //implementation du reset
		
		public void actionPerformed(ActionEvent e) {
			titreField.setText("");
			desc.setText(" ");desc.setText("");
			boxType.setSelectedIndex(0);
			importance.setSelectedIndex(0);
		}
	};
	private ActionListener doneListener = new ActionListener() { //validation du ticket
		
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(panel, "ticket added");
		}
	};

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
		priority.setBounds(400, 167, 55, 23);
		panel.add(priority);
		description.setBounds(54, 56, 78, 23);
		panel.add(description);
		titreField.setBounds(154, 22, 441, 23);
		titreField.setPreferredSize(new Dimension(450, 30));
		panel.add(titreField);
		titre.setBounds(54, 22, 90, 23);
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
		lblOrigineDuTicket.setBounds(54, 169, 78, 19);
		panel.add(lblOrigineDuTicket);
		desc.setBounds(154, 56, 441, 96);
		panel.add(desc);
		reset.setBounds(440, 254, 89, 23);
		panel.add(reset);
		boxType.addItem("Problème");
		boxType.addItem("Question");
		boxType.addItem("Incident");	
		reset.addActionListener(resetListener);
		cancel.addActionListener(this);
		done.addActionListener(doneListener);//FIN MISE EN PLACE
	}
	public void actionPerformed(ActionEvent e) { // annulation création ticket 
		this.dispose();
	}
}
