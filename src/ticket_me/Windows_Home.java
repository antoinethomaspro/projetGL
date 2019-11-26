package ticket_me;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JComboBox;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JComboBox;

public class Windows_Home extends JFrame {
	private JTextField username = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblUsername = new JLabel("Username");
	private JLabel lblPassword = new JLabel("Password");
	private JButton ButtonLogin = new JButton("Login");
	private JPanel panelNorth = new JPanel();
	private JButton ButtonConnexion = new JButton("Connexion");
	private JButton ButtonInscription = new JButton("Inscription");
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPanel PanelLogin = new JPanel();
	private JPanel PanelMainLogin = new JPanel();
	private JPanel PanelLogin_2 = new JPanel();
	private JPanel PanelSignUp = new JPanel();
	private JPanel PanelMainSignUp = new JPanel();
	private JPanel PanelSignUp_2 = new JPanel();
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblMotDePasse = new JLabel("Mot de passe");
	private JLabel lblConfirmation = new JLabel("Confirmation");
	private JTextField fieldName = new JTextField();
	private JTextField fieldPwd = new JTextField();
	private JTextField fieldPwd_2 = new JTextField();
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnDone = new JButton("Done");
	private final JLabel lblStatus = new JLabel("Status");
	private final JComboBox<String> comboBox = new JComboBox<String>();
	ActionListener ListernerConnexion = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			PanelConnexion();
			ButtonLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String uname = username.getText();
					String psd = passwordField.getText();
					String status = comboBox.getSelectedItem().toString();
					System.out.println(status);

					/*if (uname.equals("root") && psd.equals("root") && status.equals("User")) {
						JOptionPane.showMessageDialog(layeredPane, "you are connected");
						Window_User ticket = new Window_User();
						dispose();
					} else {
						JOptionPane.showMessageDialog(layeredPane, "invalid username or password");
					}*/
					PersonJdbcs d = new PersonJdbcs();
					String nom = username.getText();
					String pwd = passwordField.getText();
					String role = comboBox.getSelectedItem().toString();
					
					try {
						d.signIn(nom, pwd, role);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}
	};
	ActionListener ListernerInscription = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			PanelInscription();
		}
	};

	public Windows_Home() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setVisible(true); // page visible
		setTitle("Home"); // title
		setSize(600, 250); // size
		setLocationRelativeTo(null); // fenetre centrée
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arret du processus quand fermeture de la fenetre

		getContentPane().add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelNorth.add(ButtonConnexion);
		panelNorth.add(ButtonInscription);

		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));

		layeredPane.add(PanelMainLogin);
		layeredPane.add(PanelMainSignUp);
		
		PanelLogin_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		PanelMainLogin.setLayout(new BorderLayout(0, 0));
		PanelMainLogin.add(PanelLogin_2, BorderLayout.SOUTH);
		PanelMainLogin.add(PanelLogin, BorderLayout.CENTER);
		
		PanelSignUp_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		PanelMainSignUp.setLayout(new BorderLayout(0, 0));
		PanelMainSignUp.add(PanelSignUp_2, BorderLayout.SOUTH);
		PanelMainSignUp.add(PanelSignUp, BorderLayout.CENTER);
		
		fieldPwd_2.setColumns(10);
		fieldPwd.setColumns(10);
		fieldName.setColumns(10);

		GridBagLayout gridBagLayoutLogin = new GridBagLayout();
		gridBagLayoutLogin.columnWidths = new int[] { 47, 86, 0 };
		gridBagLayoutLogin.rowHeights = new int[] { 23, 23, 0, 0, 0 };
		gridBagLayoutLogin.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayoutLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		PanelLogin.setLayout(gridBagLayoutLogin);
		
		GridBagLayout gridBagLayoutSignUp = new GridBagLayout();
		gridBagLayoutSignUp.columnWidths = new int[] {86, 495, 0};
		gridBagLayoutSignUp.rowHeights = new int[] { 0, 0, 0, 50, 0 };
		gridBagLayoutSignUp.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayoutSignUp.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		PanelSignUp.setLayout(gridBagLayoutSignUp);

		ButtonConnexion.addActionListener(ListernerConnexion);
		ButtonInscription.addActionListener(ListernerInscription);
	}
	
	public final void PanelConnexion() {
		PanelLogin_2.add(ButtonLogin);
		
		comboBox.addItem("User");
		comboBox.addItem("Technician");
		comboBox.addItem("Admin");
		
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(15, 15, 10, 10);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		PanelLogin.add(lblUsername, gbc_lblUsername);

		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_username.insets = new Insets(15, 0, 10, 15);
		gbc_username.gridx = 1;
		gbc_username.gridy = 0;
		PanelLogin.add(username, gbc_username);
		username.setColumns(10);

		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 15, 10, 10);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		PanelLogin.add(lblPassword, gbc_lblPassword);

		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 10, 15);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		PanelLogin.add(passwordField, gbc_passwordField);
		
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.insets = new Insets(0, 15, 15, 10);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 2;
		PanelLogin.add(lblStatus, gbc_lblStatus);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 15, 15);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		PanelLogin.add(comboBox, gbc_comboBox);
		
		layeredPane.removeAll();
		layeredPane.add(PanelMainLogin);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		PanelMainLogin.removeAll();
		PanelMainLogin.add(PanelLogin, BorderLayout.CENTER);
		PanelMainLogin.add(PanelLogin_2, BorderLayout.SOUTH);
		PanelMainLogin.repaint();
		PanelMainLogin.revalidate();
	}
	
	public final void PanelInscription() {
		PanelSignUp_2.add(btnDone);
		PanelSignUp_2.add(btnCancel);
		
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(15, 15, 10, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 0;
		PanelSignUp.add(lblNom, gbc_lblNom);
		
		GridBagConstraints gbc_fieldName = new GridBagConstraints();
		gbc_fieldName.insets = new Insets(15, 10, 10, 15);
		gbc_fieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldName.gridx = 1;
		gbc_fieldName.gridy = 0;
		PanelSignUp.add(fieldName, gbc_fieldName);
		
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.anchor = GridBagConstraints.WEST;
		gbc_lblMotDePasse.insets = new Insets(0, 15, 10, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 1;
		PanelSignUp.add(lblMotDePasse, gbc_lblMotDePasse);
		
		GridBagConstraints gbc_fieldPwd = new GridBagConstraints();
		gbc_fieldPwd.insets = new Insets(0, 10, 10, 15);
		gbc_fieldPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPwd.gridx = 1;
		gbc_fieldPwd.gridy = 1;
		PanelSignUp.add(fieldPwd, gbc_fieldPwd);
		
		GridBagConstraints gbc_lblConfirmation = new GridBagConstraints();
		gbc_lblConfirmation.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmation.insets = new Insets(0, 15, 15, 5);
		gbc_lblConfirmation.gridx = 0;
		gbc_lblConfirmation.gridy = 2;
		PanelSignUp.add(lblConfirmation, gbc_lblConfirmation);
		
		GridBagConstraints gbc_fieldPwd_2 = new GridBagConstraints();
		gbc_fieldPwd_2.insets = new Insets(0, 10, 15, 15);
		gbc_fieldPwd_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPwd_2.gridx = 1;
		gbc_fieldPwd_2.gridy = 2;
		PanelSignUp.add(fieldPwd_2, gbc_fieldPwd_2);
		
		layeredPane.removeAll();
		layeredPane.add(PanelMainSignUp);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		PanelMainSignUp.removeAll();
		PanelMainSignUp.add(PanelSignUp, BorderLayout.CENTER);
		PanelMainSignUp.add(PanelSignUp_2, BorderLayout.SOUTH);
		PanelMainSignUp.repaint();
		PanelMainSignUp.revalidate();
	}
	
	/*private void signUp() {
		PersonJdbcs d = new PersonJdbcs();
		String nom = fieldName.getText();
		String pwd = fieldPwd.getText();
		String pwd2 = fieldPwd_2.getText();
		
		d.signUp(nom, pwd, pwd2);
	}*/
	
	private void signIn() throws SQLException {
		PersonJdbcs d = new PersonJdbcs();
		String nom = username.getText();
		String pwd = passwordField.getText();
		String role = comboBox.getSelectedItem().toString();
		
		d.signIn(nom, pwd, role);
	}
	
	
	public static void main(String[] args) {
		Windows_Home login = new Windows_Home();
		login.setVisible(true);
	}
	
	
}