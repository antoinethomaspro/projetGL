

import java.sql.*;
/**
 * La classe qui gère la connection à la base de données.
 * @author Liza BOUMALI
 * @version 1.0
 * 
 * 
 *
 */

public class Connectit {


	Connection con = null;
	Statement statement = null;

	ResultSet res = null;
	String driver = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
	public static final String USER = "root";
	public static final String PASSWD =  "";
/**
 * Le constructeur de la connexion.
 */
	public Connectit() {
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
	/**
	 * @author Liza BOUMALI
	 * @version 1.2
	 * tryit crée la connexion à la base de données.
	 */
	public static void tryit() {
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found !!");
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		String url="jdbc:mysql://localhost:3306/ticket_me";
		try {
			connection = DriverManager
					.getConnection(url, "root", "");
			System.out.println("SQL Connection to database established!");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return;
		} finally {
			try
			{
				if(connection != null)
					connection.close();
				System.out.println("Connection closed !!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}



}





