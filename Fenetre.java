package interfaceSupport;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//CTRL + SHIFT + O pour générer les imports
public class Fenetre extends JFrame {

	public Fenetre() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(300, 120);

		// Les données du tableau
		Object[][] data = { { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" }, { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" },
				{ "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" }, { "A_MODIFIER", "A_MODIFIER", "A_MODIFIER","A_MODIFIER" } };

		// Les titres des colonnes
		String title[] = { "Id", "Title", "Priority", "Requested for" };
		JTable tableau = new JTable(data, title);
		// Nous ajoutons notre tableau à notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		this.getContentPane().add(new JScrollPane(tableau));
	}

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
	}
}