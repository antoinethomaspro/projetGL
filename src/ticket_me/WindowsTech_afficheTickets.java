package Ticketing_Projet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import projet_ticketing_back.TicketsJdbcs;

import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;

public class WindowsTech_afficheTickets extends JFrame {
	private JPanel pane = new JPanel();
	private JPanel southPane = new JPanel();
	private JButton button = new JButton();
	private JTextField textfield = new JTextField();
	private JLabel label = new JLabel();
	private ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String buff = "123456789";
			String t = textfield.getText();
			boolean verif = false;
			for (int i = 0; i < t.length(); i++) {
				for (int j = 0; j < buff.length(); j++) {
					if(t.charAt(i) == buff.charAt(j)) {
						verif = true;
						break;
					}
					else verif = false;
				}
			}
			if(verif == true)
				connexionBD("select * from ticket where id_ticket =" + textfield.getText());
			else JOptionPane.showMessageDialog(null, "La valeur du ticket inserée est invalide ou n'existe pas.");
		}
	};
	DefaultTableModel tableModel;

	public WindowsTech_afficheTickets() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Technician Window");
		this.setSize(800, 300);
		this.getContentPane().add(pane);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		Vector rowData = TicketsJdbcs.getRows("select id_ticket, name_ticket, urgency, category, description from ticket ORDER by id_ticket DESC");//get data
		Vector columnNames = TicketsJdbcs.getHead("select id_ticket, name_ticket, urgency, category, description from ticket ORDER by id_ticket DESC");//get the names of the attribut
		
		// Les titres des colonnes
		tableModel = new DefaultTableModel(rowData,columnNames);	
		JTable tableau = new JTable(tableModel);
		tableau.setEnabled(false);
		tableau.setSurrendersFocusOnKeystroke(true);
		tableau.setFillsViewportHeight(true);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Nous ajoutons notre tableau a notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		
		pane.setLayout(new BorderLayout());
		pane.add(new JScrollPane(tableau),BorderLayout.CENTER);
		pane.add(southPane, BorderLayout.SOUTH);
		
		label.setText("Choix du ticket : ");
		
		southPane.setLayout(new FlowLayout());
		southPane.add(label);
		southPane.add(textfield);
		southPane.add(button);
		
		textfield.setColumns(7);
		button.setText("Valider");
		button.addActionListener(listener);
	}
	private void connexionBD(String SQLRequest){
		String sql_url = "jdbc:mysql://localhost:3306/ticket_me";	
		String name = "root";
		String password = "root";
		Connection conn;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql_url, name, password);
			preparedStatement = conn.prepareStatement(SQLRequest);
			ResultSet result1 = preparedStatement.executeQuery();
			
			if(result1.next() == false) {
				JOptionPane.showMessageDialog(null, "La valeur du ticket qui vient d'être insérer est invalide");
			}
			else {
				result1.close();
				Resolution_Ticket reso_ticket = new Resolution_Ticket(SQLRequest);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("error class no found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("exception sql");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WindowsTech_afficheTickets t = new WindowsTech_afficheTickets();
	}
}
