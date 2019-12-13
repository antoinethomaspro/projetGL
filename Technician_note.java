import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class Technician_note qui transforme les données récuperées sur la base de données en moyennes représentées par des graphiques en forme de bars.
 * @author Liza BOUMALI
 * @version 1.0
 * 
 * 
 *
 */

public class Technician_note {
	
		public Technician_note() throws SQLException {
		// TODO Auto-generated method stub
		PanelBar panel2= new PanelBar();
		FrameBar frame2= new FrameBar(panel2);
		Connectit connection2= new Connectit();
		connection2.tryit();
		/**
		 * skills part
		 */
		double skill4=0,skill5=0,skill6=0,skill7=0,skill8=0,skill9=0,skill10=0,skill11=0,skill12=0,skill13=0,skill14=0,skill15=0,skill16=0,skill17=0,skill18=0,skill19=0,skill20=0,skill21=0,skill22=0,skill23=0;
		//total of 20 Technicians
		double t4=0,t5=0,t6=0,t7=0,t8=0,t9=0,t10=0,t11=0,t12=0,t13=0,t14=0,t15=0,t16=0,t17=0,t18=0,t19=0,t20=0,t21=0,t22=0,t23=0;
		//chaque t représente le nombre totale de notes pour chaque technician.
		
		/**
		 * SQL PART
		 */
		String requete="SELECT skill_satisfaction,id_person FROM satisfaction";
		ResultSet results= connection2.statement.executeQuery(requete);
		while(results.next()) {
			Integer id_person=results.getInt("id_person");
			Integer skill_satisfaction=results.getInt("skill_satisfaction");
			/***************************************************************/
			switch (id_person) {
			case 4:
				skill4+=skill_satisfaction;
				t4++;
				break;
			case 5:
				skill5+=skill_satisfaction;
				t5++;
				break;
			case 6:
				skill6+=skill_satisfaction;
				t6++;
				break;
			case 7:
				skill7+=skill_satisfaction;
				t7++;
				break;
			case 8:
				skill8+=skill_satisfaction;
				t8++;
				break;
			case 9:
				skill9+=skill_satisfaction;
				t9++;
				break;
			case 10:
				skill10+=skill_satisfaction;
				t10++;
				break;
			case 11:
				skill11+=skill_satisfaction;
				t11++;
				break;
			case 12:
				skill12+=skill_satisfaction;
				t12++;
				break;
			case 13:
				skill13+=skill_satisfaction;
				t13++;
				break;
			case 14:
				skill14+=skill_satisfaction;
				t14++;
				break;
			case 15:
				skill15+=skill_satisfaction;
				t15++;
				break;
			case 16:
				skill16+=skill_satisfaction;
				t16++;
				break;
			case 17:
				skill17+=skill_satisfaction;
				t17++;
				break;
			case 18:
				skill18+=skill_satisfaction;
				t18++;
				break;
			case 19:
				skill9+=skill_satisfaction;
				t19++;
				break;
			case 20:
				skill20+=skill_satisfaction;
				t20++;
				break;
			case 21:
				skill21+=skill_satisfaction;
				t21++;
				break;
			case 22:
				skill22+=skill_satisfaction;
				t22++;
				break;
			case 23:
				skill23+=skill_satisfaction;
				t23++;
				break;
			default:
				System.err.println("Innexistant Technician!");
			}//end switch statement
		}//end while
		
		/**
		 * Méthode pour calculer la moyenne de chaque Technician.
		 */
		double lmax=270;
		double moy4=(skill4/t4)*270/5;
		double moy5=(skill5/t5)*270/5;
		double moy6=(skill6/t6)*270/5;
		double moy7=(skill7/t7)*270/5;
		double moy8=(skill8/t8)*270/5;
		double moy9=(skill9/t9)*270/5;
		double moy10=(skill10/t10)*270/5;
		double moy11=(skill11/t11)*270/5;
		double moy12=(skill12/t12)*270/5;
		double moy13=(skill13/t13)*270/5;
		double moy14=(skill14/t14)*270/5;
		double moy15=(skill15/t15)*270/5;
		double moy16=(skill16/t16)*270/5;
		double moy17=(skill17/t17)*270/5;
		double moy18=(skill18/t18)*270/5;
		double moy19=(skill19/t19)*270/5;
		double moy20=(skill20/t20)*270/5;
		double moy21=(skill21/t21)*270/5;
		double moy22=(skill22/t22)*270/5;
		double moy23=(skill23/t23)*270/5;
		//fin de calcule des moyennes.
		/**
		 * AFFICHAGE DES MOYENNES TEST/
		 */
		
		System.out.println("Technician: "+4+" Average= "+moy4);
		System.out.println("Technician "+16+ " av   "+moy16);
		/**
		 * ADD the averages to the correct list_tech.
		 */
		panel2.list_tech.add(moy4);
		panel2.list_tech.add(moy5);
		panel2.list_tech.add(moy6);
		panel2.list_tech.add(moy7);
		panel2.list_tech.add(moy8);
		panel2.list_tech.add(moy9);
		panel2.list_tech.add(moy10);
		panel2.list_tech.add(moy11);
		panel2.list_tech.add(moy12);
		panel2.list_tech.add(moy13);
		panel2.list_tech.add(moy14);
		panel2.list_tech.add(moy15);
		panel2.list_tech.add(moy16);
		panel2.list_tech.add(moy17);
		panel2.list_tech.add(moy18);
		panel2.list_tech.add(moy19);
		panel2.list_tech.add(moy20);
		panel2.list_tech.add(moy21);
		panel2.list_tech.add(moy22);
		panel2.list_tech.add(moy23);
		//fin de l'ajout.
		frame2.repaint();
		try {
			Thread.sleep(1000);				
		} catch(Exception ignored) {

		}
		
	}
	
	/**
	 * Méthode main du programme.
	 * ici se créent les objets et se fait la récupération de données plus les règles de calcules.
	 * @param args
	 * @throws SQLException
	 */

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		PanelBar panel2= new PanelBar();
		FrameBar frame2= new FrameBar(panel2);
		Connectit connection2= new Connectit();
		connection2.tryit();
		/**
		 * skills part
		 */
		double skill4=0,skill5=0,skill6=0,skill7=0,skill8=0,skill9=0,skill10=0,skill11=0,skill12=0,skill13=0,skill14=0,skill15=0,skill16=0,skill17=0,skill18=0,skill19=0,skill20=0,skill21=0,skill22=0,skill23=0;
		//total of 20 Technicians
		double t4=0,t5=0,t6=0,t7=0,t8=0,t9=0,t10=0,t11=0,t12=0,t13=0,t14=0,t15=0,t16=0,t17=0,t18=0,t19=0,t20=0,t21=0,t22=0,t23=0;
		//chaque t représente le nombre totale de notes pour chaque technician.
		
		/**
		 * SQL PART
		 */
		String requete="SELECT skill_satisfaction,id_person FROM satisfaction";
		ResultSet results= connection2.statement.executeQuery(requete);
		while(results.next()) {
			Integer id_person=results.getInt("id_person");
			Integer skill_satisfaction=results.getInt("skill_satisfaction");
			/***************************************************************/
			switch (id_person) {
			case 4:
				skill4+=skill_satisfaction;
				t4++;
				break;
			case 5:
				skill5+=skill_satisfaction;
				t5++;
				break;
			case 6:
				skill6+=skill_satisfaction;
				t6++;
				break;
			case 7:
				skill7+=skill_satisfaction;
				t7++;
				break;
			case 8:
				skill8+=skill_satisfaction;
				t8++;
				break;
			case 9:
				skill9+=skill_satisfaction;
				t9++;
				break;
			case 10:
				skill10+=skill_satisfaction;
				t10++;
				break;
			case 11:
				skill11+=skill_satisfaction;
				t11++;
				break;
			case 12:
				skill12+=skill_satisfaction;
				t12++;
				break;
			case 13:
				skill13+=skill_satisfaction;
				t13++;
				break;
			case 14:
				skill14+=skill_satisfaction;
				t14++;
				break;
			case 15:
				skill15+=skill_satisfaction;
				t15++;
				break;
			case 16:
				skill16+=skill_satisfaction;
				t16++;
				break;
			case 17:
				skill17+=skill_satisfaction;
				t17++;
				break;
			case 18:
				skill18+=skill_satisfaction;
				t18++;
				break;
			case 19:
				skill9+=skill_satisfaction;
				t19++;
				break;
			case 20:
				skill20+=skill_satisfaction;
				t20++;
				break;
			case 21:
				skill21+=skill_satisfaction;
				t21++;
				break;
			case 22:
				skill22+=skill_satisfaction;
				t22++;
				break;
			case 23:
				skill23+=skill_satisfaction;
				t23++;
				break;
			default:
				System.err.println("Innexistant Technician!");
			}//end switch statement
		}//end while
		
		/**
		 * Méthode pour calculer la moyenne de chaque Technician.
		 */
		double lmax=270;
		double moy4=(skill4/t4)*270/5;
		double moy5=(skill5/t5)*270/5;
		double moy6=(skill6/t6)*270/5;
		double moy7=(skill7/t7)*270/5;
		double moy8=(skill8/t8)*270/5;
		double moy9=(skill9/t9)*270/5;
		double moy10=(skill10/t10)*270/5;
		double moy11=(skill11/t11)*270/5;
		double moy12=(skill12/t12)*270/5;
		double moy13=(skill13/t13)*270/5;
		double moy14=(skill14/t14)*270/5;
		double moy15=(skill15/t15)*270/5;
		double moy16=(skill16/t16)*270/5;
		double moy17=(skill17/t17)*270/5;
		double moy18=(skill18/t18)*270/5;
		double moy19=(skill19/t19)*270/5;
		double moy20=(skill20/t20)*270/5;
		double moy21=(skill21/t21)*270/5;
		double moy22=(skill22/t22)*270/5;
		double moy23=(skill23/t23)*270/5;
		//fin de calcule des moyennes.
		/**
		 * AFFICHAGE DES MOYENNES TEST/
		 */
		
		System.out.println("Technician: "+4+" Average= "+moy4);
		System.out.println("Technician "+16+ " av   "+moy16);
		/**
		 * ADD the averages to the correct list_tech.
		 */
		panel2.list_tech.add(moy4);
		panel2.list_tech.add(moy5);
		panel2.list_tech.add(moy6);
		panel2.list_tech.add(moy7);
		panel2.list_tech.add(moy8);
		panel2.list_tech.add(moy9);
		panel2.list_tech.add(moy10);
		panel2.list_tech.add(moy11);
		panel2.list_tech.add(moy12);
		panel2.list_tech.add(moy13);
		panel2.list_tech.add(moy14);
		panel2.list_tech.add(moy15);
		panel2.list_tech.add(moy16);
		panel2.list_tech.add(moy17);
		panel2.list_tech.add(moy18);
		panel2.list_tech.add(moy19);
		panel2.list_tech.add(moy20);
		panel2.list_tech.add(moy21);
		panel2.list_tech.add(moy22);
		panel2.list_tech.add(moy23);
		//fin de l'ajout.
		frame2.repaint();
		try {
			Thread.sleep(1000);				
		} catch(Exception ignored) {

		}
		
	}//end main methode.
	/**
	 * Methode qui affiche la légende du graphe en bar.
	 * 
	 */
	/**
	 * La méthode paint instroduite dans PanelBar, se charge de l'affichage des composantes du dessin hors les formes des bars.
	 * C'est à dire: le titre du dessin et sa légende.
	 * @param r  r est un graphique en 2D.
	 *
	 * on utilise ce graphique pour les methodes prédefinies dans cette librairie telle que: set.Color ou drawString ou fillRect...
	 * REMARQUE/ les boucles for sont séparées pour seule raison de gestion d'interface.
	 * @see PanelBar
	 */
	public static void paint(Graphics r) {
		//Le titre.
		r.setColor(Color.LIGHT_GRAY);
		r.fillRect(350,495,440,80);
		r.setColor(Color.BLACK);
		String titre="Bar's Average Skill by Technician.";
		r.drawString(titre, 460, 530);
		//La légende.
		/*r.setColor(new Color(200,230,198));
		r.fillRect(595, 10, 680, 90);*/
		/*******************************/
		int xs=600;
		int ys=20;
		r.drawString("Graph Key:", xs, ys);
		for(int i=1;i<=4;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+90, ys);
			ys+=15;
		}
		xs=710;
		ys=20;
		for(int i=5;i<=8;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+70, ys);
			ys+=15;
		}
		xs=790;
		ys=20;
		for(int i=9;i<=12;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+90, ys);
			ys+=15;
		}
		xs=890;
		ys=20;
		for(int i=12;i<=15;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+90, ys);
			ys+=15;
		}
		xs=990;
		ys=20;
		for(int i=16;i<=19;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+90, ys);
			ys+=15;
		}
		xs=1090;
		ys=20;
		for(int i=20;i<=20;i++) {
			r.drawString("Bar"+i+": id"+(i+3), xs+90, ys);
			ys+=15;
		}
		
		
		
	}

}
