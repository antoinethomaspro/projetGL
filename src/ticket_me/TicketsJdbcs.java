
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author YANG Zilu  
 * @author ZHANG Zimeng
 * cette classe permet d'avoir le lien entre le ticket et le BD
 *
 */

public class TicketsJdbcs {
    
    static Connection con = null;
    static Statement statement = null;
    static PreparedStatement Pstatement = null;
    static ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD = "";
   
    public TicketsJdbcs() {
        try {
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWD);
            statement = (Statement) con.createStatement();
 
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permettre user d'inserer un ticket dans le BD sans screenshot
     * @param titre le titire du ticket 
     * @param description le description du ticket
     * @param categorie le type de ce ticket
     * @param priorite priorite du ticket
     * @param isCreatedBy pour indiquer le createur de ce ticeket
     */

      public void insert(String titre, String description,String categorie, String priorite,String isCreatedBy) {
           
      try { 

  		//loading the Jdbc driver for Sql Operations  
  		Class.forName("com.mysql.jdbc.Driver");  
  		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me", "root", "");  
  		PreparedStatement st = con.prepareStatement("insert into ticket(name_ticket,urgency,category, description,status, isCreatedBy) values(?,?,?,?,?,?)");           		 
  		//st.setBinaryStream(4, fis);  
  		st.setString(1,titre);
  	    st.setString(2,priorite);
  	    st.setString(3,categorie);
  	    st.setString(4,description);
  	    st.setString(5,"1");
  	    st.setString(6,isCreatedBy);
  	    
  		int count = st.executeUpdate();  
  		if (count > 0) {  
  			JOptionPane.showMessageDialog(null, "Your ticket has been created, we well get back to you ASAP!");  
  		} else {  
  			JOptionPane.showInputDialog(this, "Error Saving Data");  
  		}
  	}
      catch (Exception ex) {
      	JOptionPane.showInputDialog(this, ex.getMessage());  
  	}
      }
	
 /**
   * Permettre user d'inserer un ticket dans le BD avec une capture d'écran
   * @param titre le titire du ticket 
   * @param description le description du ticket
   * @param categorie le type de ce ticket
   * @param priorite priorite du ticket
   * @param screenshot capture d'ecran du ticket
   * @param isCreatedBy pour indiquer le createur de ce ticeket
   */
   

    public void insert(String titre, String description,String screenshot, String categorie, String priorite,String isCreatedBy) {
         
    try {  
		byte[] rawBytes = null;  
		FileInputStream fis = null;  

		//if (imagePath.equals("No File Uploaded")) {  
		//ClassLoader cl = this.getClass().getClassLoader();  
		//URL resouces = cl.getResource("resources/blank-image.png");  
		//imagePath = resouces.getFile();  
		//}  

		File fileObj = new File(screenshot);  
		fis = new FileInputStream(fileObj);  

		//loading the Jdbc driver for Sql Operations  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me", "root", "");  
		PreparedStatement st = con.prepareStatement("insert into ticket(name_ticket,urgency,category, description,screenshot,status, isCreatedBy) values(?,?,?,?,?,?,?)");           		 
		//st.setBinaryStream(4, fis);  
		st.setString(1,titre);
	    st.setString(2,priorite);
	    st.setString(3,categorie);
	    st.setString(4,description);
	    
	    int imageLength = Integer.parseInt(String.valueOf(fileObj.length()));  
		rawBytes = new byte[imageLength];  
		fis.read(rawBytes, 0, imageLength);  
		st.setBinaryStream(5, (InputStream) fis, imageLength);  
	    st.setBytes(5, rawBytes);
	    
	    st.setString(6,"1");
	    st.setString(7,isCreatedBy);
	    
		int count = st.executeUpdate();  
		if (count > 0) {  
			JOptionPane.showMessageDialog(null, "Your ticket has been created, we well get back to you ASAP!");  
		} else {  
			JOptionPane.showInputDialog(this, "Error Saving Data");  
		}
	} catch (HeadlessException | IOException  | NumberFormatException | SQLException | ClassNotFoundException ex) {  
		JOptionPane.showInputDialog(this, ex.getMessage());  
	}  
    }

    /**
     * Permettre user de supprimer un ticket 
     * @param titre tickets title
     * @param description tickets description
     * @param categorie tickets category
     * @param priorite tickets priority
     */
    public void deleteTicket(String titre, String description, String categorie, String priorite) {
    	String sql = 
    		       "delete from ticket(name_ticket,urgency,category, description) values(\"" + titre + "\",\"" + priorite + "\",\"" + categorie + "\",\""+description+"\")";
    		           		
    		           try {
    		               int a = statement.executeUpdate(sql);
    		               con.close();
    		               statement.close();
    		               if (a == 1) {
    		                   JOptionPane.showMessageDialog(null, "Ticket was successfully delected.");
    		               }
    		               
    		           } catch (SQLException e) {
    		               JOptionPane.showMessageDialog(null, "SQL Error, please try again.");
    		               e.printStackTrace();
    		           }
    }
    
    /**
     * Permettre un  d'avoir le nom d'un ticket de la BD
     * @param Id id de ce tickets
     * @return nom de ce ticket
     */
    public static String getTicket(int Id) {
    	String result = "";
		 String sql = "select name_ticket from ticket where id_ticket = " + Id;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(URL,USER,PASSWD);
			 statement = con.createStatement();
            ResultSet a = statement.executeQuery(sql);
            a.beforeFirst();
            if(a.next()) {
                result = a.getString(1);
            }
            a.close();
            con.close();
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("SQL Error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			System.out.println("Class Not Found ERROR");
			e.printStackTrace();
		}
		 return result;
	 }

    
    /**
     * Ces trois ci-desous sont pour afficher les tickets pour technicien 
     */
    
    /**
     * Permettre d'obtenir chaque ligne de la table ticket
     * @return un vecteur
     */
    public static  Vector getRows(){
		Vector rows = null;
		Vector columnHeads = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection(URL, USER, PASSWD);
			Pstatement = con.prepareStatement("select `id_ticket`, `name_ticket`,`urgency`,`category`,`status`,`solution`,`completion_code` from ticket where status = 1");
			ResultSet result1 = Pstatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "None results");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error was occured, pleased try again.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL error.");
			e.printStackTrace();
		}
		return rows;
	}
	
	/**
	 * Permettre d'obtenir l'en-tête de base de données
	 * @return vecteur
	 */
	public static  Vector getHead(){
		String sql_url = "jdbc:mysql://localhost:3306/ticket_me";
		String name = "root";
		String password = "";
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		Vector columnHeads = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sql_url, name, password);

			preparedStatement = conn.prepareStatement("select `id_ticket`, `name_ticket`,`urgency`,`category`,`status`,`solution`,`completion_code` from ticket");
			ResultSet result1 = preparedStatement.executeQuery();
			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "None results");
			
			columnHeads = new Vector();
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error was occured, pleased try again.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL error.");
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	/**
	 * Permettre d'obtenir les donees de la prochaine ligne
	 * @param rs le resultat de requête
	 * @param rsmd enregistrer le resultat de requête
	 * @return vecteur
	 * @throws SQLException
	 */
	private static  Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	
	
	
	/**
	 * Surcharge de methode pour fenetre technicien
	 * @param SQLRequest requete sql 
	 * @return vecteur
	 */
	
		public static  Vector getRows(String SQLRequest){
			Vector rows = null;
			Vector columnHeads = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL, USER, PASSWD);
				Pstatement = con.prepareStatement(SQLRequest);
				ResultSet result1 = Pstatement.executeQuery();
				
				if(result1.wasNull()){
					rows = new Vector();
					System.out.println("None rows");
					return rows;
				}
				
				rows = new Vector();
				
				ResultSetMetaData rsmd = result1.getMetaData();
						
				while(result1.next()){
					rows.addElement(getNextRow(result1,rsmd));
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("An error was occured, pleased try again.");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL error.");
				e.printStackTrace();
			}
			return rows;
		}
		
		// Surcharge de methode pour fenetre technicien
		public static  Vector getHead(String SQLRequest){
			String sql_url = "jdbc:mysql://localhost:3306/ticket_me";
			String name = "root";
			String password = "";
			Connection conn;
			PreparedStatement preparedStatement = null;
	 
			Vector columnHeads = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(sql_url, name, password);
				preparedStatement = conn.prepareStatement(SQLRequest);
				ResultSet result1 = preparedStatement.executeQuery();
				
				boolean moreRecords = result1.next();
				if(!moreRecords) {
					columnHeads = new Vector();
					columnHeads.add("Id");
					columnHeads.add("Name");
					columnHeads.add("Description");
					columnHeads.add("Status");
					return columnHeads;
				}
				
				columnHeads = new Vector();
				ResultSetMetaData rsmd = result1.getMetaData();
				for(int i = 1; i <= rsmd.getColumnCount(); i++)
					columnHeads.addElement(rsmd.getColumnName(i));
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("An error was occured, pleased try again.");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL error");
				e.printStackTrace();
			}
			return columnHeads;
		}
		
	
	
		
	
	/**
	 * cette methode permet  technicien sd'inserer la solution
	 * @param sl le solution de ce ticket
	 * @param id est le id de person
	 * @param comCode est le ccompletion code
	 * @param isSolvedBy est le technician
	 * @return true si le ticket est resolu
	 */
	 public boolean answerT(String comCode,String sl,String id,String  isSolvedBy) {
	        boolean judge = false;
	        String sql = 
	        "UPDATE ticket SET "
	        +"completion_code ='"+ comCode+"',"
	        +"solution ='"+ sl + "',"
	        +"isSolvedBy ='"+ isSolvedBy + "',"
	        + "status = 0 where id_ticket ="+id;       		
	           try {
	               int a = statement.executeUpdate(sql);
	              
	               if (a == 1) {
	                   JOptionPane.showMessageDialog(null, "The ticket was successfully resolved !");
	                  judge =  true;
	               }
	               con.close();
	               statement.close();
	               
	           } catch (SQLException e) {
	               JOptionPane.showMessageDialog(null, "Sorry, the ticket wasn't resolved, please try again.");
	               e.printStackTrace();
	           }
	           return judge;
	       }
	 		/**
		 * Methode qui permet de recuperer le nom d'un utilisateur selon
		 * l'identifiant d'un ticket creer par celui-ci
		 * @param idUser Identifiant de l'Utilisateur
		 * @return la requete sql
		 */
	 public static String getIsCreatedBy(int idUser) {
		 String result = "";
		 String sql = "select isCreatedBy from ticket where id_ticket = " + idUser;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(URL,USER,PASSWD);
			 statement = con.createStatement();
             ResultSet a = statement.executeQuery(sql);
             a.beforeFirst();
             if(a.next()) {
                 result = a.getString(1);
             }
             a.close();
             con.close();
             statement.close();
             
         } catch (SQLException e) {
             System.out.println("SQL Error");
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
			System.out.println("Class Not Found ERROR");
			e.printStackTrace();
		}
		 return result;
	 }
	 
	
	
}
