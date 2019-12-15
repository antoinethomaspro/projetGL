package Ticketing_Projet;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import projet_ticketing_back.TicketsJdbcs;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
/**
 * @author MARTIN Thomas
 * @author THOMAS Antoine
 * This class show the list of tickets which are created by the user.
 */
public class Window_Main_User extends JFrame implements ConnexionBDD {
	public static DefaultTableModel tableModel;
	private static JScrollPane scrollPane;
	private JPanel panelWest = new JPanel();
	private JPanel panelNorth = new JPanel();
	private JButton btnCreateANew = new JButton("Create a new ticket");
	private JLabel lblTicketsStatus = new JLabel("Tickets Status");
	public static Vector rowData = new Vector();
	public static Vector columnNames = new Vector();
	public static JTable tableau;
	public static JPanel mainPane = new JPanel();
	private JButton btnRefresh = new JButton("Refresh");
	private JButton btnStats = new JButton("Resolutions's statistics");
	private JButton btnFaq = new JButton("FAQ");
	private ActionListener createTicket = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			WindowsUser_insertTicket t = new WindowsUser_insertTicket();

		}
	};
	public ActionListener refresh = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Window_Main_User w = new Window_Main_User();
			dispose();
		}
	};
	public ActionListener stats = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Stats_Tickets s = new Stats_Tickets();
			
		}
	};
	public ActionListener faq = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FAQ f = new FAQ();
			
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
		connexionBD("select * from ticket where isCreatedBy = " + "\"" + Windows_Home.nom + "\"");

		// Les titres des colonnes
		tableau = new JTable(tableModel);
		tableau.setSurrendersFocusOnKeystroke(true);
		tableau.setFillsViewportHeight(true);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane = new JScrollPane(tableau);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelWest, BorderLayout.WEST);
		getContentPane().add(panelNorth, BorderLayout.NORTH);

		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[] { 120, 0, 0 };
		gbl_panelWest.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelWest.columnWeights = new double[] { 0.0, 10.0, Double.MIN_VALUE };
		gbl_panelWest.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelWest.setLayout(gbl_panelWest);

		GridBagConstraints gbc_btnCreateANew = new GridBagConstraints();
		gbc_btnCreateANew.insets = new Insets(30, 10, 5, 5);
		gbc_btnCreateANew.gridx = 0;
		gbc_btnCreateANew.gridy = 0;
		panelWest.add(btnCreateANew, gbc_btnCreateANew);
		
		GridBagConstraints gbc_btnStats = new GridBagConstraints();
		gbc_btnStats.insets = new Insets(30, 10, 5, 5);
		gbc_btnStats.gridx = 0;
		gbc_btnStats.gridy = 1;
		panelWest.add(btnStats, gbc_btnStats);
		
		GridBagConstraints gbc_btnFaq = new GridBagConstraints();
		gbc_btnFaq.insets = new Insets(30, 15, 0, 5);
		gbc_btnFaq.gridx = 0;
		gbc_btnFaq.gridy = 2;
		panelWest.add(btnFaq, gbc_btnFaq);
		
		btnCreateANew.addActionListener(createTicket);
		btnRefresh.addActionListener(refresh);
		btnStats.addActionListener(stats);
		btnFaq.addActionListener(faq);
		tableau.getSelectionModel().addListSelectionListener(new RowListener());
		
		panelNorth.add(btnRefresh);
		panelNorth.add(lblTicketsStatus);
	}
	/**
	 * Method to show a window to know the informations of the ticket which was selected.
	 */
    private void outputSelection() {
    	try {
			Window_User_ViewTicket v = new Window_User_ViewTicket("select * from ticket where id_ticket = "+tableau.getValueAt(tableau.getSelectedRow(), 0));
		} catch (SQLException e) {
			System.out.println("SQL error");
		}
    }
    /**
     * Method implemented by ListSelectionListener and which use the method outputSelection when a row is selected
     */
    private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            outputSelection();
        }
    }

	public void connexionBD(String SQLRequest) {
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
			if (result1.next() == false) {
				try {
					columnNames = TicketsJdbcs.getHead("select id_ticket,name_ticket,description, status from ticket");// get the
																												// names
																												// of
																												// the
																												// attribut
					rowData = TicketsJdbcs
							.getRows("select id_ticket,name_ticket,description, status from ticket where isCreatedBy = \""
									+ Windows_Home.username.getText() + "\"");// get data
					tableModel = new DefaultTableModel(rowData, columnNames);
				} catch (ClassCastException e) {
					System.out.println("error jtable");
				}

			} else {
				result1.close();
				rowData = TicketsJdbcs
						.getRows("select id_ticket,name_ticket,description, status from ticket where isCreatedBy = \""
								+ Windows_Home.username.getText() + "\"");// get data
				columnNames = TicketsJdbcs.getHead("select id_ticket,name_ticket,description, status from ticket");// get the
																											// names of
																											// the
																											// attribut
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
