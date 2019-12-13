import java.awt.Color;
import javax.swing.JFrame;

/**
 * 
 * @author Liza BOUMALI
 * @version 1.0
 * FrameBar crée le Frame et manipule les composantes de la fenêtre des statistiques.
 *
 */
public class FrameBar extends JFrame {
	/**
	 * Constructeur de la classe FrameBar.
	 * @param pl
	 * qui est de type PanelBar 
	 * @see PanelBar
	 */
	public FrameBar (PanelBar pl) {
		
		   this.setVisible(true);
		   // window visible now.
		   
		   this.setBackground(Color.WHITE);
		   
				this.setTitle("Technician's Average");
		   //title set.
				this.setSize(1300, 600);
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

}
