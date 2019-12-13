package Ticketing_Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import projet_ticketing_back.TicketsJdbcs;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

/**
 * @author MARTIN Thomas
 * @author THOMAS Antoine
 * @since 1.0 (decs)
 * @version 1.1 （ajouter status,solution,completion_code a afficher）
 * @version 1.2 new way to select the ticket
 *
 */
public class WindowsTech_afficheTickets extends JFrame implements ConnexionBDD {
	private JPanel pane = new JPanel();
	private JButton button = new JButton();
	public static JTextField textfield = new JTextField();
	private JLabel label = new JLabel();
	private JPanel southPane = new JPanel();
	public DefaultTableModel tableModel;
	private JLabel labelTri = new JLabel("Sorting : ");
	private JComboBox<String> comboBoxTri = new JComboBox<String>();
	private JButton buttonTri = new JButton("Sort");
	private JButton btnRefresh = new JButton("Refresh");
	public String request = "";
	public static JTable tableau;
	public ActionListener listenerSorting = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (comboBoxTri.getSelectedIndex() == 0) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets(
						"select id_ticket, name_ticket, urgency, category, description from ticket where status = 1 ORDER by id_ticket DESC");

			} else if (comboBoxTri.getSelectedIndex() == 1) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets(
						"select id_ticket, name_ticket, urgency, category, description from ticket order by name_ticket");

			} else if (comboBoxTri.getSelectedIndex() == 2) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets(
						"select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"High\"");
			} else if (comboBoxTri.getSelectedIndex() == 3) {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets(
						"select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"Medium\"");
			} else {
				dispose();
				WindowsTech_afficheTickets t1 = new WindowsTech_afficheTickets(
						"select id_ticket, name_ticket, urgency, category, description from ticket where urgency = \"Low\"");
			}
		}
	};
	public ActionListener refresh = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			WindowsTech_afficheTickets w = new WindowsTech_afficheTickets(request);
			dispose();
		}
	};

	/**
	 * This class permit to display a list of tickets within a SQL request
	 * 
	 * @param SQLRequest : The SQL request to the display of this list
	 */
	public WindowsTech_afficheTickets(String SQLRequest) {
		request = SQLRequest;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Technician Window");
		this.setSize(800, 300);
		this.getContentPane().add(pane);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

		Vector rowData = TicketsJdbcs.getRows(SQLRequest);// get data
		Vector columnNames = TicketsJdbcs.getHead(SQLRequest);// get the names of the attribut

		// Les titres des colonnes
		tableModel = new DefaultTableModel(rowData, columnNames);
		tableau = new JTable(tableModel);
		tableau.setSurrendersFocusOnKeystroke(true);
		tableau.setFillsViewportHeight(true);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableau.getSelectionModel().addListSelectionListener(new RowListener());

		pane.setLayout(new BorderLayout());
		pane.add(new JScrollPane(tableau), BorderLayout.CENTER);
		pane.add(southPane, BorderLayout.SOUTH);

		label.setText("Choose a ticket : ");

		FlowLayout fl_northPane = new FlowLayout();
		fl_northPane.setAlignment(FlowLayout.RIGHT);
		southPane.setLayout(fl_northPane);
		labelTri.setHorizontalAlignment(SwingConstants.RIGHT);

		comboBoxTri.addItem("Ticket status");
		comboBoxTri.addItem("Alphabetical order");
		comboBoxTri.addItem("High priority");
		comboBoxTri.addItem("Medium priority");
		comboBoxTri.addItem("Low priority");
		southPane.add(btnRefresh);
		btnRefresh.addActionListener(refresh);

		southPane.add(labelTri);
		southPane.add(comboBoxTri);
		southPane.add(buttonTri);
		
		buttonTri.addActionListener(listenerSorting);
	}
	/**
	 * Method to show a window to know the informations of the ticket which was selected.
	 */
    private void outputSelection() {
    		connexionBD("select * from ticket where id_ticket =" + tableau.getValueAt(tableau.getSelectedRow(), 0));
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
				JOptionPane.showMessageDialog(null, "The value of this ticket isn't done.");
			} else {
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
		WindowsTech_afficheTickets fen = new WindowsTech_afficheTickets(
				"select id_ticket, name_ticket, urgency, category, description from ticket where status = 1 ORDER by id_ticket DESC");
	}
}
