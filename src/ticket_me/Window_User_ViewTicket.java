package Ticketing_Projet;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import projet_ticketing_back.TicketsJdbcs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**Show informations on the selected ticket.
 * @author MARTIN Thomas
 * @param SQLRequest a SQLRequest to collect the differents attributs of the ticket on the database.
 */
public class Window_User_ViewTicket extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> tab = new ArrayList<>();
	private JPanel MainPanel = new JPanel();
	private JPanel NorthPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JLabel LabelPart1 = new JLabel("Generals informations");
	private JLabel labelTitre = new JLabel("Title");
	private JLabel labelTitreValue = new JLabel("test");
	private JLabel labelDescription = new JLabel("Description");
	private JLabel labelDescriptionValue = new JLabel("description");
	private JLabel labelPriority = new JLabel("Priority");
	private JLabel labelPriorityValue = new JLabel("Priority level");
	private JSeparator separator = new JSeparator();
	private JLabel labelPart2 = new JLabel("Classification");
	private JLabel labelCategory = new JLabel("Category");
	private JLabel labelCategoryValue = new JLabel("test category");
	private JLabel labelResquestFor = new JLabel("Resquest for");
	private JLabel labelResquestForValue = new JLabel();
	private JSeparator separator_1 = new JSeparator();
	private JLabel labelPart3 = new JLabel("Resolution");
	private JLabel labelSolution = new JLabel("Solution");
	private JLabel labelCompletionCode = new JLabel("Completion code");
	private JLabel labelNumTicket = new JLabel("Ticket n° :");
	private JLabel NumTicket = new JLabel("id ticket");
	private JLabel labelTitre2 = new JLabel("Title :");
	private JLabel labelTitreValue2 = new JLabel("titreTicket");
	private JButton buttonClose = new JButton("Home");
	private String request = "";
	private JLabel labelSolutionValue = new JLabel("completion code");
	private JLabel labelCompletionCodeValue = new JLabel("solution");
	private JButton btnGiveAnOpinion = new JButton("Give an opinion");
	private JLabel labelStatus = new JLabel("Status : ");
	private JLabel labelStatusValue = new JLabel("status value");
	private JButton btnViewScreenshot = new JButton("View screenshot");
	private ActionListener ListenerClose = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	};
	public ActionListener opinionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(labelStatusValue.getText().equals("Résolu")) {
			Window_Satisfaction s = new Window_Satisfaction(tab.get(10),tab.get(7));
			}
			else JOptionPane.showMessageDialog(null, "This ticket isn't yet resolved, please wait.");
		}
	};
	public ActionListener screen = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DisplayImage n = new DisplayImage(Integer.parseInt(tab.get(0)));
				n.setVisible(true);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};

	public Window_User_ViewTicket(String SQLRequest) throws SQLException {
		this.request = SQLRequest;
		connexionBD();
		setVisible(true);
		setTitle("Ticket n° : "+ tab.get(0));
		setSize(800, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		labelTitreValue.setText(tab.get(1));
		labelTitreValue2.setText(tab.get(1));
		NumTicket.setText(tab.get(0));
		labelPriorityValue.setText(tab.get(2));
		labelCategoryValue.setText(tab.get(3));
		labelDescriptionValue.setText(tab.get(4));
		labelSolutionValue.setText(tab.get(6));
		labelCompletionCodeValue.setText(tab.get(5));
		labelResquestForValue.setText(tab.get(7));
		labelStatusValue.setText(tab.get(8));
		if(labelStatusValue.getText().equals("1")) {
			labelStatusValue.setForeground(Color.RED);
			labelStatusValue.setText("En cours de résolution");
		}
		else {
			labelStatusValue.setForeground(Color.GREEN);
			labelStatusValue.setText("Résolu");
		}

		getContentPane().add(MainPanel, BorderLayout.CENTER);
		getContentPane().add(NorthPanel, BorderLayout.NORTH);
		getContentPane().add(SouthPanel, BorderLayout.SOUTH);
		SwingUtilities.updateComponentTreeUI(this);

		LabelPart1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPart2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPart3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 348, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		MainPanel.setLayout(gbl_panel);

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 15, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		MainPanel.add(CenterPanel, gbc_panel_3);

		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		CenterPanel.setLayout(gbl_panel_3);

		GridBagConstraints gbc_lblGeneralsInformations = new GridBagConstraints();
		gbc_lblGeneralsInformations.insets = new Insets(10, 0, 10, 5);
		gbc_lblGeneralsInformations.gridx = 0;
		gbc_lblGeneralsInformations.gridy = 0;
		CenterPanel.add(LabelPart1, gbc_lblGeneralsInformations);

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		CenterPanel.add(labelTitre, gbc_lblNewLabel_1);

		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 15);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		CenterPanel.add(labelTitreValue, gbc_lblNewLabel_2);

		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 2;
		CenterPanel.add(labelDescription, gbc_lblDescription);

		GridBagConstraints gbc_lblDescription_1 = new GridBagConstraints();
		gbc_lblDescription_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDescription_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescription_1.insets = new Insets(0, 0, 5, 15);
		gbc_lblDescription_1.gridx = 2;
		gbc_lblDescription_1.gridy = 2;
		CenterPanel.add(labelDescriptionValue, gbc_lblDescription_1);
		
		GridBagConstraints gbc_btnViewScreenshot = new GridBagConstraints();
		gbc_btnViewScreenshot.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnViewScreenshot.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewScreenshot.gridx = 0;
		gbc_btnViewScreenshot.gridy = 3;
		CenterPanel.add(btnViewScreenshot, gbc_btnViewScreenshot);

		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriority.anchor = GridBagConstraints.WEST;
		gbc_lblPriority.gridx = 0;
		gbc_lblPriority.gridy = 4;
		CenterPanel.add(labelPriority, gbc_lblPriority);

		GridBagConstraints gbc_lblNive = new GridBagConstraints();
		gbc_lblNive.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNive.insets = new Insets(0, 0, 5, 0);
		gbc_lblNive.gridx = 2;
		gbc_lblNive.gridy = 4;
		CenterPanel.add(labelPriorityValue, gbc_lblNive);

		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 5;
		CenterPanel.add(separator, gbc_separator);

		GridBagConstraints gbc_lblClassification = new GridBagConstraints();
		gbc_lblClassification.anchor = GridBagConstraints.WEST;
		gbc_lblClassification.insets = new Insets(5, 0, 10, 5);
		gbc_lblClassification.gridx = 0;
		gbc_lblClassification.gridy = 6;
		CenterPanel.add(labelPart2, gbc_lblClassification);

		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.WEST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 7;
		CenterPanel.add(labelCategory, gbc_lblCategory);

		GridBagConstraints gbc_lblTestCategory = new GridBagConstraints();
		gbc_lblTestCategory.anchor = GridBagConstraints.WEST;
		gbc_lblTestCategory.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestCategory.gridx = 2;
		gbc_lblTestCategory.gridy = 7;
		CenterPanel.add(labelCategoryValue, gbc_lblTestCategory);

		GridBagConstraints gbc_lblResquestFor = new GridBagConstraints();
		gbc_lblResquestFor.anchor = GridBagConstraints.WEST;
		gbc_lblResquestFor.insets = new Insets(5, 0, 5, 5);
		gbc_lblResquestFor.gridx = 0;
		gbc_lblResquestFor.gridy = 8;
		CenterPanel.add(labelResquestFor, gbc_lblResquestFor);

		GridBagConstraints gbc_lblMrD = new GridBagConstraints();
		gbc_lblMrD.anchor = GridBagConstraints.WEST;
		gbc_lblMrD.insets = new Insets(5, 0, 5, 0);
		gbc_lblMrD.gridx = 2;
		gbc_lblMrD.gridy = 8;
		CenterPanel.add(labelResquestForValue, gbc_lblMrD);

		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 9;
		CenterPanel.add(separator_1, gbc_separator_1);

		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(5, 0, 10, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 10;
		CenterPanel.add(labelPart3, gbc_lblNewLabel_3);

		GridBagConstraints gbc_lblSolution = new GridBagConstraints();
		gbc_lblSolution.anchor = GridBagConstraints.WEST;
		gbc_lblSolution.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolution.gridx = 0;
		gbc_lblSolution.gridy = 11;
		CenterPanel.add(labelSolution, gbc_lblSolution);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 11;
		CenterPanel.add(labelCompletionCodeValue, gbc_lblNewLabel);

		GridBagConstraints gbc_lblCompletionCode = new GridBagConstraints();
		gbc_lblCompletionCode.anchor = GridBagConstraints.WEST;
		gbc_lblCompletionCode.insets = new Insets(5, 0, 5, 5);
		gbc_lblCompletionCode.gridx = 0;
		gbc_lblCompletionCode.gridy = 12;
		CenterPanel.add(labelCompletionCode, gbc_lblCompletionCode);
		
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(5, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 12;
		CenterPanel.add(labelSolutionValue, gbc_label);

		NorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		NorthPanel.add(labelNumTicket);
		NorthPanel.add(NumTicket);
		NorthPanel.add(labelTitre2);
		NorthPanel.add(labelTitreValue2);
		
		NorthPanel.add(labelStatus);
		
		NorthPanel.add(labelStatusValue);

		FlowLayout flowLayout = (FlowLayout) SouthPanel.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		SouthPanel.add(btnGiveAnOpinion);
		SouthPanel.add(buttonClose);
		buttonClose.addActionListener(ListenerClose);
		btnGiveAnOpinion.addActionListener(opinionListener);
		btnViewScreenshot.addActionListener(screen);
	}
	/**
	 * To connect you on the database and collect informations of the ticket
	 * @throws SQLException
	 */
	public void connexionBD() throws SQLException {
		String sql_url = "jdbc:mysql://localhost:3306/ticket_me";
		String name = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(sql_url, name, password);
		Statement preparedStatement = conn.createStatement();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql_url, name, password);
			ResultSet result1 = preparedStatement.executeQuery(request);
			result1.beforeFirst();
			while (result1.next()) {
				tab.add(0,result1.getString("id_ticket"));
				tab.add(1, result1.getString("name_ticket"));
				tab.add(2, result1.getString("urgency"));
				tab.add(3, result1.getString("category"));
				tab.add(4, result1.getString("description"));
				tab.add(5, result1.getString("solution"));
				tab.add(6, result1.getString("completion_code"));
				tab.add(7, result1.getString("isCreatedBy"));
				tab.add(8, result1.getString("status"));
				tab.add(9, result1.getString("isSolvedBy"));
				tab.add(10, result1.getString("id_person"));
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
