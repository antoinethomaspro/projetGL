package ticket_me;


import java.util.Vector;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.JOptionPane;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * @author YANG Zilu 
 * @author ZHANG Zimeng
 * @version 1.1
 * @since   1.0
 * Cette classe permet de gérer les personnes et avoir le lien entre BD,c'est à dire que ,
 * premièrement,si une personneest déja dans le BD,elle vérifie si son username et password sont correspondant aux informations du BD;
 * dexièment,si la personne est nouvelle ,elle fait l'inscription .
 *  
 */
public class PersonJdbcs {
	Connection con = null;
    Statement statement = null;
    /*PreparedStatement Pstatement1 = null;
    PreparedStatement Pstatement2 = null;*/
    ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD =  "root";
    
    
    public PersonJdbcs() {
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
     * 
     * @param nom le nom d'utilisateur ou technicien
     * @param pwd le mot de passe 
     * @param pwd2 confirmer le mot de passe
     * @param adress l'adresse
     * @param phone le telephone
     * @param email l'email
     * @param role le role de la personne
     */
public void signUp(String nom, String pwd, String pwd2,String adress,String phone,String email,String role) {
    	if(pwd.equals(pwd2)) {
    		String sql = "insert into person(password,email,name, adress,phone,name_role) values(\"" + pwd + "\",\"" + email + "\",\"" + nom + "\",\""+adress+"\",\""+phone+"\",\""+role+"\")";
    		try {
    			int a = statement.executeUpdate(sql);
                con.close();
                statement.close();
                if (a == 1) {
                	JOptionPane.showMessageDialog(null, "Your account has been created!");
                }
    			               
    		} catch (SQLException e) {
    			JOptionPane.showMessageDialog(null, "error");
    			e.printStackTrace();
    		}
    	}else {
        	JOptionPane.showMessageDialog(null, "Your password is not correct!");
    	}
       }
    
    /**
     * 
     * @param nom le nom de la personne
     * @param pwd le mot de passe
     * @param role le role de la personne
     * @return true si il n'y a pas d'erreurs
     * @throws SQLException cela donne une expception si la requette n'est pas correcte
     */
    public boolean signIn(String nom, String pwd, String role) throws SQLException  {
    	 boolean b = false;
        String sql = 
       "select * from person where password=\"" + pwd + "\"and name=\"" + nom + "\"and name_role=\"" + role + "\"";

           try {
        	   res = statement.executeQuery(sql);
        	   if(role == "User" ) {
               if (res.next()) {
                   String pwdBDD = res.getString(2);
                   System.out.println(pwdBDD+ " " + pwd);
                   if (pwdBDD.equals(pwd)) {
                       b = true;
                       JOptionPane.showMessageDialog(null, "Your password is correct!");
                       Window_Main_User u = new Window_Main_User();
                   } else  {
                	   b = false;
                       JOptionPane.showMessageDialog(null, "error");
                    }
               }else {
                   JOptionPane.showMessageDialog(null, "error");
                 
               }
           } 
        	
        	if(role == "Technician"){
               if (res.next() ) {
                   String pwdBDD= res.getString(2);
                   System.out.println(pwdBDD + " " + pwd);
                   if (pwdBDD.equals(pwd)) {
                       b = true;
                       JOptionPane.showMessageDialog(null, "Your password is correct!");
                       WindowsTech_afficheTickets wus = new WindowsTech_afficheTickets("select id_ticket, name_ticket, urgency, category, description from ticket where status = 1 ORDER by id_ticket DESC");                       wus.setVisible(true);
                   } else {
                	   b = false;
                       JOptionPane.showMessageDialog(null, "error2");
                   }
               } else {
                   JOptionPane.showMessageDialog(null, "error2");
               }
          }    
        	
        	   res.close();
               con.close();
               statement.close();
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Sorry, you're not connected!");
               e.printStackTrace();
           }
           return b;
       } 
    /**
     * Cette methode permet d'ajouter le note pour un technicien
     * @param sks skill_satisfaction 
     */
public void insertS(String sks,int idT) {
    try {    
  
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_me", "root", "root");  
	PreparedStatement st = con.prepareStatement("insert into satisfaction(skill_satisfaction,id_person) values(?,?)");           		  
	st.setString(1,sks);
    st.setInt(2, idT);
    		
    int count = st.executeUpdate();  
	if (count > 0) {  
		System.out.println("noted");
	} else {  
		JOptionPane.showMessageDialog(null, "Error Saving Data");  
	}
}catch (SQLException e) {  
	JOptionPane.showInputDialog(this, "not succeed");  
}  

}

}
