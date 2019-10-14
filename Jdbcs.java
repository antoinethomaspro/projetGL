package projetL2;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import javax.swing.JOptionPane;

public class Jdbcs {
	Connection con = null;
    Statement statement = null;
    PreparedStatement Pstatement = null;
    ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD = "7ZPHpq17wqRDVtKo";

	
    public Jdbcs() {
        try {
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWD);
            statement = (Statement) con.createStatement();
 
        } catch (ClassNotFoundException e) {
            System.out.println("Desole,on n'a pas trouve ce Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void insert(String titre, String description, String categorie, String priorite) {
        
     String sql = 
    "insert into ticket(name_ticket,urgency,category, description) values(\"" + titre + "\",\"" + priorite + "\",\"" + categorie + "\",\""+description+"\")";
        		
        try {
            int a = statement.executeUpdate(sql);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "Vous avez bien cree un ticket!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Desole,nous n'avez pas reussit");
            e.printStackTrace();
        }
    }

    
    
    public Vector afficherT() {
    	Vector rows = null;
    	Vector colHeads = null;
    	 String sql = "select *from ticket";
    	 try {
		   ResultSet res = (ResultSet) Pstatement.executeQuery(sql);
		   
		   if(res.wasNull())//说明是空列表 vide
				JOptionPane.showMessageDialog(null, "Desole,il n'y a aucuns resultats");
		   
		  rows = new Vector();
	   	ResultSetMetaData rsmd = (ResultSetMetaData) res.getMetaData();
		   //设置行使其显示 mettre la ligne pour au'il s'affiche
		   
		while(res.next()){
			rows.addElement(getNextRow(res,rsmd));//pour donner la next ligne
		}
	   	
	   	
	   	  con.close();
           Pstatement.close();
          
    	
    	 } catch (SQLException e) {
    		  JOptionPane.showMessageDialog(null, "Desole,nous n'avez pas reussit");
              e.printStackTrace();
    }
   return rows ;
    

}


	private Vector getNextRow(ResultSet res2, ResultSetMetaData rsmd) throws SQLException{
		Vector rowActu = new Vector();
		for(int i = 0;i<rsmd.getColumnCount();i++) {
              rowActu.addElement(res2.getString(i));
		}
		return rowActu;
	}
    }
