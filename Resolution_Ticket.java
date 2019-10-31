package Ticketing_Projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resolution_Ticket extends JFrame{
	
	private String titreTicket = "test";
	private int idTicket = 123456789;
	private JPanel MainPanel = new JPanel();
	private JPanel NorthPanel = new JPanel();
	private JPanel SouthPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JLabel LabelPart1 = new JLabel("Generals informations");
	private JLabel labelTitre = new JLabel("Titre");
	private JLabel labelTitreValue = new JLabel("test");
	private JLabel labelDescription = new JLabel("Description");
	private JLabel labelDescriptionValue = new JLabel("description");
	private JLabel labelPriority = new JLabel("Priority");
	private JLabel labelPriorityValue = new JLabel("Niveau de priorit\u00E9");
	private JSeparator separator = new JSeparator();
	private JLabel labelPart2 = new JLabel("Classification");
	private JLabel labelCategory = new JLabel("Category");
	private JLabel labelCategoryValue = new JLabel("test category");
	private JLabel labelResquestFor = new JLabel("Resquest for");
	private JLabel labelResquestForValue = new JLabel("Mr Dupont");
	private JSeparator separator_1 = new JSeparator();
	private JLabel labelPart3 = new JLabel("Resolution");
	private JLabel labelSolution = new JLabel("Solution");
	private JLabel labelSolutionValue = new JLabel("test solution");
	private JLabel labelCompletionCode = new JLabel("Completion code");
	private JComboBox<String> comboBoxCompletion = new JComboBox<String>();
	private JLabel labelNumTicket = new JLabel("Ticket n° :");
	private JLabel NumTicket = new JLabel(idTicket + "");
	private JLabel labelTitre2 = new JLabel("Titre :");
	private JLabel labelTitreValue2 = new JLabel(titreTicket);
	private JButton buttonClose = new JButton("Close ticket");
	private ActionListener ListenerClose = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(getContentPane(), "ticket closed");
			dispose();
			
		}
	};
	
	public Resolution_Ticket() {
		setVisible(true);
		setTitle("Resolution Ticket");
		setSize(800,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(MainPanel, BorderLayout.CENTER);
		getContentPane().add(NorthPanel, BorderLayout.NORTH);
		getContentPane().add(SouthPanel, BorderLayout.SOUTH);
		SwingUtilities.updateComponentTreeUI(this);
		
		LabelPart1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPart2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPart3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{348, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		MainPanel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 15, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		MainPanel.add(CenterPanel, gbc_panel_3);
		
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriority.anchor = GridBagConstraints.WEST;
		gbc_lblPriority.gridx = 0;
		gbc_lblPriority.gridy = 3;
		CenterPanel.add(labelPriority, gbc_lblPriority);
		
		GridBagConstraints gbc_lblNive = new GridBagConstraints();
		gbc_lblNive.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNive.insets = new Insets(0, 0, 5, 0);
		gbc_lblNive.gridx = 2;
		gbc_lblNive.gridy = 3;
		CenterPanel.add(labelPriorityValue, gbc_lblNive);
		
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		CenterPanel.add(separator, gbc_separator);
		
		GridBagConstraints gbc_lblClassification = new GridBagConstraints();
		gbc_lblClassification.anchor = GridBagConstraints.WEST;
		gbc_lblClassification.insets = new Insets(5, 0, 10, 5);
		gbc_lblClassification.gridx = 0;
		gbc_lblClassification.gridy = 5;
		CenterPanel.add(labelPart2, gbc_lblClassification);
		
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.WEST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 6;
		CenterPanel.add(labelCategory, gbc_lblCategory);
		
		GridBagConstraints gbc_lblTestCategory = new GridBagConstraints();
		gbc_lblTestCategory.anchor = GridBagConstraints.WEST;
		gbc_lblTestCategory.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestCategory.gridx = 2;
		gbc_lblTestCategory.gridy = 6;
		CenterPanel.add(labelCategoryValue, gbc_lblTestCategory);
		
		GridBagConstraints gbc_lblResquestFor = new GridBagConstraints();
		gbc_lblResquestFor.anchor = GridBagConstraints.WEST;
		gbc_lblResquestFor.insets = new Insets(5, 0, 5, 5);
		gbc_lblResquestFor.gridx = 0;
		gbc_lblResquestFor.gridy = 7;
		CenterPanel.add(labelResquestFor, gbc_lblResquestFor);
		
		GridBagConstraints gbc_lblMrD = new GridBagConstraints();
		gbc_lblMrD.anchor = GridBagConstraints.WEST;
		gbc_lblMrD.insets = new Insets(5, 0, 5, 0);
		gbc_lblMrD.gridx = 2;
		gbc_lblMrD.gridy = 7;
		CenterPanel.add(labelResquestForValue, gbc_lblMrD);
		
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 8;
		CenterPanel.add(separator_1, gbc_separator_1);
		
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(5, 0, 10, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 9;
		CenterPanel.add(labelPart3, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_lblSolution = new GridBagConstraints();
		gbc_lblSolution.anchor = GridBagConstraints.WEST;
		gbc_lblSolution.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolution.gridx = 0;
		gbc_lblSolution.gridy = 10;
		CenterPanel.add(labelSolution, gbc_lblSolution);
		
		GridBagConstraints gbc_lblTestSolution = new GridBagConstraints();
		gbc_lblTestSolution.anchor = GridBagConstraints.WEST;
		gbc_lblTestSolution.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestSolution.gridx = 2;
		gbc_lblTestSolution.gridy = 10;
		CenterPanel.add(labelSolutionValue, gbc_lblTestSolution);
		
		GridBagConstraints gbc_lblCompletionCode = new GridBagConstraints();
		gbc_lblCompletionCode.anchor = GridBagConstraints.WEST;
		gbc_lblCompletionCode.insets = new Insets(5, 0, 5, 5);
		gbc_lblCompletionCode.gridx = 0;
		gbc_lblCompletionCode.gridy = 11;
		CenterPanel.add(labelCompletionCode, gbc_lblCompletionCode);
		
		comboBoxCompletion.addItem("training");
		comboBoxCompletion.addItem("abandonned by user");
		comboBoxCompletion.addItem("bug resolved");
		comboBoxCompletion.addItem("impossible");
		comboBoxCompletion.addItem("solved with a workaround");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(5, 0, 5, 0);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 11;
		CenterPanel.add(comboBoxCompletion, gbc_comboBox);
		
		NorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		NorthPanel.add(labelNumTicket);
		NorthPanel.add(NumTicket);
		NorthPanel.add(labelTitre2);
		NorthPanel.add(labelTitreValue2);
		
		FlowLayout flowLayout = (FlowLayout) SouthPanel.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		SouthPanel.add(buttonClose);
		buttonClose.addActionListener(ListenerClose);
	}

}
