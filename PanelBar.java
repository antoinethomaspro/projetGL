import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * 
 * @author Liza BOUMALI
 * @version 1.0
 * Class PanelBar qui s'occupe du dessin � afficher sous forme de bars de statistiques.
 *
 */

public class PanelBar extends JPanel {
	
	public static ArrayList<Double> list_tech= new ArrayList<>();
	public  ArrayList<Color> list_colors_tech= new ArrayList<>();
	
	/**************************************************************/
	//list_tech full filled!
	/**Remplissage couleurs**/
	//pas la peine.
	/**
	 * Partie Bar Technician.
	 */
	/**
	 * M�thode paint qui g�re l'affichage des bars en 2 dimensions dans la fen�tre du FrameBar.
	 * @param g
	 * qui est un graphique 2D.
	 */
	public void paint(Graphics g) {
		//initialisation des param�tres de graphics fill rectangle.
		int x=20;
		int yd=(int) (300+(450-(300+(list_tech.get(0)))));
		int width=30;
		double height=(list_tech.get(0));
		int l=(int)height;
		//set color for rectangles.
		g.setColor(new Color(180,60,100));
		g.fillRect(x, yd, width, l);
		//afficher la moyenne au dessous de la bar.
		double moy=(list_tech.get(0))*5/270;
		g.setColor(Color.black);
		g.drawString(""+(int)moy, x, yd+l+30);
		//Fonctionne parfaitement pour le premiere element.
		//Boucle qui parcours les moyennes et les affiches sous forme de bars.
		for(int i=1;i<=(list_tech.size())-1;i++) {
			/**
			 * Ce while evite les espaces ind�sirables entre les bars dans la fen�tre des moyennes des techniciens.
			 */
			try {
			if((list_tech.get(i))==0) {
				g.setColor(Color.pink);
				x=x+width+30;
				yd=(int) (yd+((list_tech.get(i-1))-(list_tech.get(i))));
				height=(list_tech.get(i));
				l=(int)height;
				g.drawString("NULL",x,yd);
				g.setColor(Color.black);
				g.drawString("0", x, yd+30);
				}//end if.
				//if il fait la m�me chose mais ne considere pas la bar � 0 de moyenne comme une bare.
			else {
			g.setColor(new Color(180,60,100));
			x=x+width+30;
			yd=(int) (yd+((list_tech.get(i-1))-(list_tech.get(i))));
			height=(list_tech.get(i));
			l=(int)height;
			g.fillRect(x, yd, width,l);
			moy=(list_tech.get(i))*5/270;
			g.setColor(Color.black);
			g.drawString(""+(int)moy, x, yd+l+30);
			
			//else {
			//	x=x;
			}
			}
			finally {}
			
			
		}//end for.
		/**
		 * Appel de la m�thode paint qui g�re le titre du dessin et sa l�gende en les affichant dans le Panel.
		 * @see Technician_note
		 */
		Technician_note.paint(g);
	}

}
/**
 * 
 * public void paint(Graphics g) {
		int x=10;
		int yd=300;
		int w=30;
		int l=150;
		g.setColor(Color.yellow);
		g.fillRect(x,yd,w,l);
		x=x+w+10;
		l=100;
		yd=yd+50;
		g.setColor(Color.CYAN);
		g.fillRect(x, yd, w, l);
		x=x+w+10;
		yd=180;
		l=170;
		g.fillRect(x, yd, w, l);
	}**/
