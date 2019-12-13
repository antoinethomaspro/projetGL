package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class FAQ extends JFrame implements ConnexionBDD{
	public ArrayList<String> tabID = new ArrayList<String>();
	public ArrayList<String> tabName = new ArrayList<String>();
	public ArrayList<String> tabAsk = new ArrayList<String>();
	public ArrayList<String> tabAns = new ArrayList<String>();
	private JPanel panel = new JPanel();
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JLabel labelNameFAQ = new JLabel("");
	private JLabel labelDescFAQ = new JLabel("");
	public ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			labelNameFAQ.setText(tabAsk.get(comboBox.getSelectedIndex()));
			labelDescFAQ.setText(tabAns.get(comboBox.getSelectedIndex()));
		}
	};
	public FAQ() {
		setVisible(true);
		setTitle("Frequently Asked Questions");
		setSize(805, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		connexionBD("SELECT * FROM faq");
		
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 180, 280, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 51, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		for (int i = 0; i < tabName.size(); i++) {
			comboBox.addItem(""+tabName.get(i));
		}
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(15, 15, 10, 10);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_labelNameFAQ = new GridBagConstraints();
		gbc_labelNameFAQ.insets = new Insets(15, 0, 10, 15);
		gbc_labelNameFAQ.gridx = 2;
		gbc_labelNameFAQ.gridy = 1;
		panel.add(labelNameFAQ, gbc_labelNameFAQ);
		
		comboBox.addActionListener(listener);
		
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 15, 15);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panel.add(labelDescFAQ, gbc_lblNewLabel);
		getContentPane().repaint();
		getContentPane().revalidate();
	}
	public static void main(String[] args) {
		FAQ t = new FAQ();
	}
	@Override
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
				JOptionPane.showMessageDialog(null, "None data.");
			} 
			else {
				while(result1.next()) {
					tabID.add(result1.getString("id_faq"));
					tabName.add(result1.getString("name_faq"));
					tabAsk.add(result1.getString("question_faq"));
					tabAns.add(result1.getString("answer_faq"));
				}
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
