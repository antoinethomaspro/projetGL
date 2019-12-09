package ticket_me;
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

import ticket_me.TicketsJdbcs;

import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;

/**
 * 
 * @since 1.0    (decs)
 * @version 1.1 （ajouter status,solution,completion_code a afficher）
 *
 */
public class WindowsTech_afficheTickets extends JFrame {
	private JPanel pane = new JPanel();
	private JPanel southPane = new JPanel();
	private JButton button = new JButton();
	public static JTextField textfield = new JTextField();
	private JLabel label = new JLabel();
	private JLabel labelTri = new JLabel("Sorting : ");
	private JComboBox<String> comboBoxTri = new JComboBox<String>();
	private JButton buttonTri = new JButton("Done");
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
	public ActionListener listenerSorting = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBoxTri.getSelectedIndex() == 0) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where status = 1 ORDER by id_ticket DESC");

				
			}
			else if(comboBoxTri.getSelectedIndex() == 1) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket order by name_ticket");

			}
			else if(comboBoxTri.getSelectedIndex() == 2){
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"High\"");
			}
			else if(comboBoxTri.getSelectedIndex() == 3){
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"Medium\"");
			}
			else{
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"Lowx\"");
			}
		}
	};
	/**
	 * This class permit to display a list of tickets within a SQL request
	 * @param SQLRequest : The SQL request to the display of this list
	 */
	public WindowsTech_afficheTickets(String SQLRequest) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Technician Window");
		this.setSize(800, 300);
		this.getContentPane().add(pane);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		Vector rowData = TicketsJdbcs.getRows(SQLRequest);//get data
		Vector columnNames = TicketsJdbcs.getHead(SQLRequest);//get the names of the attribut
		
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
		pane.add(northPane, BorderLayout.NORTH);
		pane.add(sorthPane, BorderLayout.SOUTH);
		
		label.setText("Choose a ticket : ");
		
		FlowLayout fl_northPane = new FlowLayout();
		fl_northPane.setAlignment(FlowLayout.RIGHT);
		sorthPane.setLayout(fl_northPane);
		labelTri.setHorizontalAlignment(SwingConstants.RIGHT);
		
		comboBoxTri.addItem("Ticket status");
		comboBoxTri.addItem("Alphabetical order");
		comboBoxTri.addItem("High priority");
		comboBoxTri.addItem("Medium priority");
		comboBoxTri.addItem("Low priority");
		
		sorthPane.add(labelTri);
		sorthPane.add(comboBoxTri);
		sorthPane.add(buttonTri);
		
		southPane.setLayout(new FlowLayout());
		southPane.add(label);
		southPane.add(textfield);
		southPane.add(button);
		
		textfield.setColumns(7);
		button.setText("Valider");
		button.addActionListener(listener);
		buttonTri.addActionListener(listenerSorting);
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
				JOptionPane.showMessageDialog(null, "The value of this ticket isn't done.");
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
		WindowsTech_afficheTickets t = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where status = 1 ORDER by id_ticket DESC");
	}
}
