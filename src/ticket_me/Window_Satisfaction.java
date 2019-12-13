package Ticketing_Projet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Window.Type;
/**
 * Give a note to the technician who have resolved your ticket
 * @author MARTIN Thomas YANG zilu
 */
public class Window_Satisfaction extends JFrame{
	private JPanel mainPane = new JPanel();
	private String name_tech = "";
	private JLabel lblGiveANote = new JLabel();
	private JComboBox<Integer> comboBox = new JComboBox<Integer>();
	private JButton btnValidate = new JButton("Validate");
	public ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(getContentPane(), "Successfully");
			insererSatisfaction();
			dispose();
		}
	};
	/**
	 * 
	 * @param name_technician The name of the technician who have resolved the ticket
	 * @param name_user The name of the user who have created the ticket
	 */
	public Window_Satisfaction(String name_technician, String name_user) {
		this.name_tech = name_technician;
		setType(Type.POPUP);
		setVisible(true);
		setTitle("Give a note of satisfaction");
		setSize(550, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(mainPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		mainPane.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblGiveANote = new GridBagConstraints();
		gbc_lblGiveANote.insets = new Insets(15, 15, 15, 10);
		gbc_lblGiveANote.anchor = GridBagConstraints.EAST;
		gbc_lblGiveANote.gridx = 0;
		gbc_lblGiveANote.gridy = 0;
		mainPane.add(lblGiveANote, gbc_lblGiveANote);
		
		comboBox.addItem(0);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(15, 10, 15, 10);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		mainPane.add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_btnValidate = new GridBagConstraints();
		gbc_btnValidate.insets = new Insets(15, 10, 15, 15);
		gbc_btnValidate.gridx = 2;
		gbc_btnValidate.gridy = 0;
		mainPane.add(btnValidate, gbc_btnValidate);
		btnValidate.addActionListener(listener);
		
		getContentPane().removeAll();
		getContentPane().add(mainPane);
		getContentPane().repaint();
		getContentPane().revalidate();
	}
	/**
	 * Set the text of the label GiveANote
	 */
	private void setNameTech() {
		lblGiveANote.setText("Give a note for "+name_tech+" who have resolved your ticket : ");
	}
			
  /**
   * cette methode permet d'inserer une note
   */
	private void insererSatisfaction() {
		PersonJdbcs d = new PersonJdbcs();
		String sks = comboBox.getSelectedItem().toString();
		int idTech = Integer.parseInt(name_tech);
		//String isSolvedBy = Windows_Home.username.getText();// Pour que user affiche la lise de tickets
		d.insertS(sks,idTech);
		}
}
