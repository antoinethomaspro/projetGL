package fr.projetgl.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(53, 76, 123, 32);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(53, 144, 123, 53);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(157, 83, 171, 25);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 161, 171, 25);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String uname = username.getText();
				String psd = passwordField.getText();
				
				if(uname.equals("name") && psd.equals("password"))
				{
					JOptionPane.showMessageDialog(frame, "you are connected");
				}
					else 
					{
						JOptionPane.showMessageDialog(frame, "invalid username or password");
					}
				
				
				
			}
		});
		btnNewButton.setBounds(157, 217, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
