import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 * @author Liza BOUMALI
 * @version 1.0
 * @param 
 * @return
 *cette classe ne fait rien d'autre que construire notre fenetre.
 */

public class Frame extends JFrame{
	/**
	 * constructeur de la classe frame
	 * @param pl 
	 * 
	 * @see Panel
	 */
	public Frame (Panel pl) {
		
		   this.setVisible(true);
		   // window visible now.
		   
		   this.setBackground(Color.WHITE);
		   
				this.setTitle("Stats of tickets");
		   //title set.
				this.setSize(800, 600);
			//size set. x from left to right/ y from up to down
			this.setLocationRelativeTo(null);
			//object put in the center.
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//To close when we click on exit.
				this.setResizable(false);
				//nobody changes the size.
				this.setAlwaysOnTop(false);
				//Can be behind other windows
				this.getContentPane().add(pl);
				//i added the chart to the window
	
	}

	public void paintComponent() {
		// TODO Auto-generated method stub
		
	}

}
