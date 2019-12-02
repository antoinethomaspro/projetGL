package Ticketing_Projet;

import javax.swing.*;

import projet_ticketing_back.PersonJdbcs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Windows_Home extends JFrame {
	
	public static JTextField username = new JTextField();//A recuperer pour indiquer le ticket inséré est à qui
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblUsername = new JLabel("Username");
	private JLabel lblPassword = new JLabel("Password");
	private JButton ButtonLogin = new JButton("Login");
	private JPanel panelNorth = new JPanel();
	private JButton ButtonConnexion = new JButton("Sign In");
	private JButton ButtonInscription = new JButton("Sign Up");
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPanel PanelLogin = new JPanel();
	private JPanel PanelMainLogin = new JPanel();
	private JPanel PanelLogin_2 = new JPanel();
	private JPanel PanelSignUp = new JPanel();
	private JPanel PanelMainSignUp = new JPanel();
	private JPanel PanelSignUp_2 = new JPanel();
	private JLabel lblNom = new JLabel("Name");
	private JLabel lblMotDePasse = new JLabel("Password");
	private JLabel lblConfirmation = new JLabel("Confirmation");
	private JTextField fieldName = new JTextField();
	private JTextField fieldPwd = new JTextField();
	private JTextField fieldPwd_2 = new JTextField();
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnDone = new JButton("Done");
	private JLabel lblStatus = new JLabel("Status");
	private JLabel lblStatus_1 = new JLabel("Status");
	private JComboBox<String> comboBox_status = new JComboBox<String>();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JLabel lblAdress = new JLabel("Adress");
	private JLabel lblPhone = new JLabel("Phone");
	private JLabel lblEmail = new JLabel("E-Mail");
	private JTextField textField_adress = new JTextField();
	private JTextField textField_phone = new JTextField();
	private JTextField textField_mail = new JTextField();
	public ActionListener ListernerConnexion = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			PanelConnexion();
			ButtonLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PersonJdbcs d = new PersonJdbcs();
					String nom = username.getText();
					String pwd = passwordField.getText();
					String role = comboBox.getSelectedItem().toString();
					try {
						d.signIn(nom, pwd, role);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	};
	public ActionListener ListernerInscription = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			PanelInscription();
			btnDone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					PersonJdbcs d = new PersonJdbcs();
					String nom =  fieldName.getText();
					String pwd1 = fieldPwd.getText();
					String pwd2 = fieldPwd_2.getText();
					String adress = textField_adress.getText();
					String phone = textField_phone.getText();
					String email = textField_mail.getText();
					String role = comboBox_status.getSelectedItem().toString();
					d.signUp(nom, pwd1,pwd2,adress,phone,email,role);
				}
			});
		}
	};

	public Windows_Home() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setVisible(true); // page visible
		setTitle("Home"); // title
		setSize(600, 270); // size
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
		textField_mail.setColumns(10);
		textField_phone.setColumns(10);
		textField_adress.setColumns(10);

		GridBagLayout gridBagLayoutLogin = new GridBagLayout();
		gridBagLayoutLogin.columnWidths = new int[] { 47, 86, 0 };
		gridBagLayoutLogin.rowHeights = new int[] { 23, 23, 0, 0, 0 };
		gridBagLayoutLogin.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayoutLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		PanelLogin.setLayout(gridBagLayoutLogin);
		
		GridBagLayout gridBagLayoutSignUp = new GridBagLayout();
		gridBagLayoutSignUp.columnWidths = new int[] {86, 188, 65, 0, 0};
		gridBagLayoutSignUp.rowHeights = new int[] { 0, 0, 34, 20, 0, 0 };
		gridBagLayoutSignUp.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayoutSignUp.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
		
		GridBagConstraints gbc_lblAdress = new GridBagConstraints();
		gbc_lblAdress.anchor = GridBagConstraints.WEST;
		gbc_lblAdress.insets = new Insets(15, 0, 10, 15);
		gbc_lblAdress.gridx = 2;
		gbc_lblAdress.gridy = 0;
		PanelSignUp.add(lblAdress, gbc_lblAdress);
		
		GridBagConstraints gbc_textField_adress = new GridBagConstraints();
		gbc_textField_adress.insets = new Insets(15, 0, 10, 15);
		gbc_textField_adress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_adress.gridx = 3;
		gbc_textField_adress.gridy = 0;
		PanelSignUp.add(textField_adress, gbc_textField_adress);
		
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
		
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 10, 15);
		gbc_lblPhone.gridx = 2;
		gbc_lblPhone.gridy = 1;
		PanelSignUp.add(lblPhone, gbc_lblPhone);
		
		GridBagConstraints gbc_textField_phone = new GridBagConstraints();
		gbc_textField_phone.insets = new Insets(0, 0, 10, 15);
		gbc_textField_phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_phone.gridx = 3;
		gbc_textField_phone.gridy = 1;
		PanelSignUp.add(textField_phone, gbc_textField_phone);
		
		GridBagConstraints gbc_lblConfirmation = new GridBagConstraints();
		gbc_lblConfirmation.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmation.insets = new Insets(0, 15, 10, 5);
		gbc_lblConfirmation.gridx = 0;
		gbc_lblConfirmation.gridy = 2;
		PanelSignUp.add(lblConfirmation, gbc_lblConfirmation);
		
		GridBagConstraints gbc_fieldPwd_2 = new GridBagConstraints();
		gbc_fieldPwd_2.insets = new Insets(0, 10, 10, 15);
		gbc_fieldPwd_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPwd_2.gridx = 1;
		gbc_fieldPwd_2.gridy = 2;
		PanelSignUp.add(fieldPwd_2, gbc_fieldPwd_2);
		
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 10, 15);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 2;
		PanelSignUp.add(lblEmail, gbc_lblEmail);
		
		GridBagConstraints gbc_textField_mail = new GridBagConstraints();
		gbc_textField_mail.insets = new Insets(0, 0, 10, 15);
		gbc_textField_mail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_mail.gridx = 3;
		gbc_textField_mail.gridy = 2;
		PanelSignUp.add(textField_mail, gbc_textField_mail);
		
		GridBagConstraints gbc_lblStatus_1 = new GridBagConstraints();
		gbc_lblStatus_1.anchor = GridBagConstraints.WEST;
		gbc_lblStatus_1.insets = new Insets(0, 15, 10, 5);
		gbc_lblStatus_1.gridx = 0;
		gbc_lblStatus_1.gridy = 3;
		PanelSignUp.add(lblStatus_1, gbc_lblStatus_1);
		
		comboBox_status.addItem("User");
		comboBox_status.addItem("Technician");
		comboBox_status.addItem("Admin");
		GridBagConstraints gbc_comboBox_status = new GridBagConstraints();
		gbc_comboBox_status.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox_status.insets = new Insets(0, 10, 10, 15);
		gbc_comboBox_status.fill = GridBagConstraints.VERTICAL;
		gbc_comboBox_status.gridx = 1;
		gbc_comboBox_status.gridy = 3;
		PanelSignUp.add(comboBox_status, gbc_comboBox_status);
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
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
}
