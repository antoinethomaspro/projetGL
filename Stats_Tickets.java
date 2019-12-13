import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;

/**
 * 
 * @author Liza BOUMALI
 * @version 2.0
 * 
 * 
 *
 */
/**cette Classe permet de connecter le logiciel à la base de données et de faire les stats sur les tickets sur plusieurs critères**/
public class Stats_Tickets {
/**
 * le main de notre programme.
 * @author Liza BOUMALI
 *
 * 
 * @throws SQLException
 * **/
	public static void main(String[] args) throws SQLException {
		
		// TODO Auto-generated method stub
		Panel panel1= new Panel();
		Frame frame1= new Frame(panel1);
		Connectit connection1= new Connectit();
		connection1.tryit();
		
		/****************************************/
		//requete sur le cas ticket resolu
		String requete = "SELECT completion_code from ticket where status=0";
		double training=0;
		double abandonned_by_user=0;
		double impossible=0;
		double bug_resolved=0;
		double solved_with_a_workaround=0;
		Color c= new Color(255,150,12);
		
		try {
		ResultSet results= connection1.statement.executeQuery(requete);

		while(results.next()) {
			String completion_code=results.getString("completion_code");


			//System.out.println(""+completion_code);
			
			if("training".equals(completion_code)) {
				training++;
			}
			else if("abandonned by user".equals(completion_code)) {
				abandonned_by_user++;
				}
			else if("impossible".equals(completion_code)) {
				impossible++;
			}
			else if("bug resolved".equals(completion_code)) {
				bug_resolved++;
			}
			else  
				solved_with_a_workaround++;
			
			//else System.out.println("Completion Null");
		}// end while
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		 
		System.out.println("End of research Completion_code");
		//Get # of tickets
		double nbr_tickets=0;
		nbr_tickets=training+abandonned_by_user+impossible+bug_resolved+solved_with_a_workaround;
		System.out.println(""+nbr_tickets);
		System.out.println("tr "+training);
		System.out.println("ab "+abandonned_by_user);
		System.out.println("im  "+impossible);
		System.out.println("res "+bug_resolved);
		System.out.println("work  "+solved_with_a_workaround);
		
		//angles of the arc
		
		double degree_training=(training*360)/nbr_tickets;
		double degree_abandonned_by_user=(abandonned_by_user*360)/nbr_tickets;
		double degree_impossible=(impossible*360)/nbr_tickets;
		double degree_bug_resolved=(bug_resolved*360)/nbr_tickets;
		double degree_solved_with_a_workaround=(solved_with_a_workaround*360)/nbr_tickets;
		//i got all the angles
		
		//add them to the piechart
		/**
		 * on ajoute les angles à notre liste de la classe Panel.
		 * @author Liza BOUMALI
		 * @see Panel
		 */
		panel1.list.add(degree_training);
		panel1.list.add(degree_abandonned_by_user);
		panel1.list.add(degree_impossible);
		panel1.list.add(degree_bug_resolved);
		panel1.list.add(degree_solved_with_a_workaround);
		
		//frame1.repaint();
		//for(int i=0;i<4;i++) {
			/*appel de la méthode repaint prédifinis avec swing*/
			frame1.repaint();
			try {
				Thread.sleep(1000);				
			} catch(Exception ignored) {

			}
		}
	
	//}
	/**
	 * la méthode paint dessine les strings dans des positions spécifiques sur notre frame, qui représente la légende de notre piechart.
	 * @author Liza BOUMALI
	 * @version 1.0
	 * @param g qui est un graphique 2D de la librairie java Graphics 
	 * 
	 */
	public static void paint(Graphics g) {
		g.drawString("The Most Used Methods in Resolving a Ticket", 248, 45);
		g.drawString("Piechart Key:", 10, 260);
		g.drawString("_________________", 10, 265);
		g.drawString("CYAN : Training", 10, 280);
		g.drawString("GREEN : Abandonned by user", 10, 295);
		g.drawString("MAGENTA : Impossible", 10, 310);
		g.drawString("RED : Bug Resolved", 10, 325);
		g.drawString("PINK : Solved with a workaround", 10, 340);
		
	}
	
	
}
