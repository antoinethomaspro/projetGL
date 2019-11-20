package ticket_me;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketsJdbcs {
    
    static Connection con = null;
    static Statement statement = null;
    static PreparedStatement Pstatement = null;
    static ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD = "7ZPHpq17wqRDVtKo";
    
    public TicketsJdbcs() {
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
    
   /*Permettre user d'inserer un ticket */ 
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

    /*Permettre user de supprimer un ticket */ 
    public void deleteTicket(String titre, String description, String categorie, String priorite) {
    	String sql = 
    		       "delete from ticket(name_ticket,urgency,category, description) values(\"" + titre + "\",\"" + priorite + "\",\"" + categorie + "\",\""+description+"\")";
    		           		
    		           try {
    		               int a = statement.executeUpdate(sql);
    		               con.close();
    		               statement.close();
    		               if (a == 1) {
    		                   JOptionPane.showMessageDialog(null, "Vous avez bien supprimé un ticket.");
    		               }
    		               
    		           } catch (SQLException e) {
    		               JOptionPane.showMessageDialog(null, "Desole,nous n'avez pas reussit");
    		               e.printStackTrace();
    		           }
    }
    
    /*Permettre user d'avoid tous ses tikets poees (mais on manque le BDD correspondant pour l'instant)*/
    public List<Tickets>getTicket(int Id) {
    	 List<Tickets> lT = new ArrayList<Tickets>();
    	 try {
       	  ResultSet res =  statement.executeQuery("SELECT * FROM `ticket` WHERE id_ticket = '"+Id+"'");
       	  while(res.next()) {
       		  Tickets t = new Tickets();
       		  t.setId(res.getInt("id_ticket"));
       		  t.setName(res.getString("name_ticket"));
       		  t.setCategory(res.getString("category"));
       		  t.setDescription(res.getString("description"));
       		  lT.add(t);
       	  }
       	
       	}catch(Exception e){
       		e.printStackTrace();
       		
       	}
       	return lT;
    	 
    }
   

    public void getRequestedfor(Person p) {
    	
    }

    
    /*Ces toirs ci-desous sont pour afficher les tickets pour technicien */
    public static  Vector getRows(){
		Vector rows = null;
		Vector columnHeads = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		//连接驱动
			con = DriverManager.getConnection(URL, USER, PASSWD);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			Pstatement = con.prepareStatement("select * from ticket");
			ResultSet result1 = Pstatement.executeQuery();
			
			if(result1.wasNull())
				JOptionPane.showMessageDialog(null, "il n'y a pas de resultat dans le BDD");
			
			rows = new Vector();
			
			ResultSetMetaData rsmd = result1.getMetaData();
					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("vous n'etes pas reussit de lancer");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Vous n'etes pas reussit d'ouvrir le BDD");
			e.printStackTrace();
		}
		return rows;
	}
	
	// 得到数据库表头
	public static  Vector getHead(){
		String sql_url = "jdbc:mysql://localhost:3306/ticket_me";	//数据库路径（一般都是这样写），test是数据库名称
		String name = "root";		//用户名
		String password = "7ZPHpq17wqRDVtKo";	//密码
		Connection conn;
		PreparedStatement preparedStatement = null;
 
		Vector columnHeads = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			preparedStatement = conn.prepareStatement("select * from ticket");
			ResultSet result1 = preparedStatement.executeQuery();
			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "il n'y a pas de resultat dans le BDD");
			
			columnHeads = new Vector();
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("vous n'etes pas reussit de lancer");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Vous n'etes pas reussit d'ouvrir le BDD");
			e.printStackTrace();
		}
		return columnHeads;
	}
	
	// 得到数据库中下一行数据
	private static  Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	/*Fin d'afficher les tickets pour technicien */
	
}
