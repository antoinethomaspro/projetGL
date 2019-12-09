package ticket_me;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ticket_me.TicketsJdbcs;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class Window_Main_User extends JFrame implements ConnexionBDD{
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel panelWest = new JPanel();
	private JPanel panelNorth = new JPanel();
	private JButton btnCreateANew = new JButton("Create a new ticket");
	private JLabel lblTicketsStatus = new JLabel("Tickets Status");
	public static Vector rowData = new Vector();
	public static Vector columnNames = new Vector();
	public static JTable tableau;
	public static JPanel mainPane = new JPanel();
	private ActionListener createTicket = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			WindowsUser_insertTicket t = new WindowsUser_insertTicket();
		}
	};
	public Window_Main_User() {
		mainPane = (JPanel) getContentPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		setVisible(true); // page visible
		setTitle("User Home"); // title
		setSize(723, 320); // size
		setLocationRelativeTo(null); // fenetre centrée
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arret du processus quand fermeture de la fenetre

		connexionBD("select * from ticket where isCreatedBy = "+"\""+Windows_Home.nom+"\"");
		
		// Les titres des colonnes
		tableModel = new DefaultTableModel(rowData, columnNames);
		JTable tableau = new JTable(tableModel);
		tableau.setEnabled(false);
		tableau.setSurrendersFocusOnKeystroke(true);
		tableau.setFillsViewportHeight(true);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane = new JScrollPane(tableau);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelWest, BorderLayout.WEST);
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[] { 120, 0, 0 };
		gbl_panelWest.rowHeights = new int[] { 0, 0, 0 };
		gbl_panelWest.columnWeights = new double[] { 0.0, 10.0, Double.MIN_VALUE };
		gbl_panelWest.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelWest.setLayout(gbl_panelWest);

		GridBagConstraints gbc_btnCreateANew = new GridBagConstraints();
		gbc_btnCreateANew.insets = new Insets(15, 10, 5, 5);
		gbc_btnCreateANew.gridx = 0;
		gbc_btnCreateANew.gridy = 0;
		panelWest.add(btnCreateANew, gbc_btnCreateANew);
		btnCreateANew.addActionListener(createTicket);

		panelNorth.add(lblTicketsStatus);
	}
		public void connexionBD(String SQLRequest){
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
				try {
				columnNames = TicketsJdbcs.getHead("select name_ticket,description, status from ticket");// get the names of the attribut			
				rowData = TicketsJdbcs.getRows("select name_ticket,description, status from ticket where isCreatedBy = \""
+ Windows_Home.username.getText()+"\"");// get data
				tableModel = new DefaultTableModel(rowData, columnNames);
				} catch (ClassCastException e) {
					System.out.println("error jtable");
				}

			}
			else {
				result1.close();
				rowData = TicketsJdbcs.getRows("select name_ticket,description, status from ticket where isCreatedBy = \""
						+ Windows_Home.username.getText()+"\"");// get data
				columnNames = TicketsJdbcs.getHead("select name_ticket,description, status from ticket");// get the names of the attribut
				tableModel = new DefaultTableModel(rowData, columnNames);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("error class no found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("exception sql");
		}
	}
}
