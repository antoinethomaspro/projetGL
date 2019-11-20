package ticket_me;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//CTRL + SHIFT + O pour g�n�rer les imports
public class WindowsTech_afficheTickets extends JFrame {
	DefaultTableModel tableModel;

	public WindowsTech_afficheTickets() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tickets");
		this.setSize(300, 120);
		
		Vector rowData = TicketsJdbcs.getRows();//get data
		Vector columnNames = TicketsJdbcs.getHead();//get the names of the attribut

		// Les donnees du tableau
		Object[][] data = { { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" }, { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" },
				{ "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" }, { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" } };

		// Les titres des colonnes
		tableModel = new DefaultTableModel(rowData,columnNames);	
		JTable tableau = new JTable(tableModel);
		// Nous ajoutons notre tableau � notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		this.getContentPane().add(new JScrollPane(tableau));
	}

	public static void main(String[] args) {
		WindowsTech_afficheTickets fen = new WindowsTech_afficheTickets();
		fen.setVisible(true);
	}
}

