package Ticketing_Projet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import projet_ticketing_back.PersonJdbcs;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Window.Type;
/**
 * Give a note to the technician who have resolved your ticket
 * @author MARTIN Thomas
 */
public class Window_Satisfaction extends JFrame implements ConnexionBDD{
	private JPanel mainPane = new JPanel();
	private String name_tech = "";
	private JLabel lblGiveANote = new JLabel();
	private JComboBox<Integer> comboBox = new JComboBox<Integer>();
	private JButton btnValidate = new JButton("Validate");
	String giveAnote = "";
	public ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(getContentPane(), "Thank you for rating us");
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
		giveAnote = "Rate";
		connexionBD("select name from person where id_person = "+name_tech+" and name_role = \"Technician\"");
		giveAnote+= " the Technicians:  ";
		lblGiveANote.setText(giveAnote);
		setType(Type.POPUP);
		setVisible(true);
		setTitle("Your satisfaction");
		setSize(550, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
	   * cette methode permet d'inserer une note
	   */
		private void insererSatisfaction() {
			PersonJdbcs d = new PersonJdbcs();
			String sks = comboBox.getSelectedItem().toString();
			int idTech = Integer.parseInt(name_tech);
			//String isSolvedBy = Windows_Home.username.getText();// Pour que user affiche la lise de tickets
			d.insertS(sks,idTech);
			}
	@Override
	public void connexionBD(String SQLRequest) {
			String sql_url = "jdbc:mysql://localhost:3306/ticket_me";
			String name = "root";
			String password = "root";
			Connection conn;
			Statement preparedStatement;

			try {
				conn = DriverManager.getConnection(sql_url, name, password);
				preparedStatement = conn.createStatement();
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(sql_url, name, password);
				ResultSet result1 = preparedStatement.executeQuery(SQLRequest);
				if (result1.next()) {
					giveAnote += result1.getString("name");
				}
				result1.close();

			} catch (ClassNotFoundException e) {
				System.out.println("error class no found");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("exception sql");
				e.printStackTrace();
			}
		
	}
}
