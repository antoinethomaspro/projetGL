package ticket_me;


import java.util.Vector;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PersonJdbcs {
	Connection con = null;
    Statement statement = null;
    /*PreparedStatement Pstatement1 = null;
    PreparedStatement Pstatement2 = null;*/
    ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD =  "7ZPHpq17wqRDVtKo";
    
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
/*public void signUp(String nom, String pwd, String pwd2) {
        
        String sql = 
       "insert into users(name_ticket,urgency,category, description) values(\"" + titre + "\",\"" + priorite + "\",\"" + categorie + "\",\""+description+"\")";
           		
           try {
               int a = statement.executeUpdate(sql);
               con.close();
               statement.close();
               if (a == 1) {
                   JOptionPane.showMessageDialog(null, "Vous avez bien cree un compte!");
               }
               
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Desole,nous n'avez pas reussit");
               e.printStackTrace();
           }
       }*/
    
    
    public boolean signIn(String nom, String pwd, String role) throws SQLException  {
    	 boolean b = false;
        String sql = 
       "select * from users where password=\"" + pwd + "\"and name=\"" + nom + "\"and role=\"" + role + "\"";

           try {
        	   res = statement.executeQuery(sql);
        	   if(role == "User" ) {
               if (res.next()) {
                   String pwdBDD = res.getString(2);
                   System.out.println(pwdBDD+ " " + pwd);
                   if (pwdBDD.equals(pwd)) {
                       b = true;
                       JOptionPane.showMessageDialog(null, "Le mot de passe est  correcte！");
                       WindowsUser_insertTicket wus = new WindowsUser_insertTicket();
                   } else  {
                	   b = false;
                       JOptionPane.showMessageDialog(null, "Vous n'est pas reussit！");
                    }
               }else {
                   JOptionPane.showMessageDialog(null, "Vous n'est pas reussit！");
                 
               }
           } 
        	
        	if(role == "Technician"){
               if (res.next() ) {
                   String pwdBDD= res.getString(2);
                   System.out.println(pwdBDD + " " + pwd);
                   if (pwdBDD.equals(pwd)) {
                       b = true;
                       JOptionPane.showMessageDialog(null, "Le mot de passe est  correcte！");
                       WindowsTech_afficheTickets wus = new WindowsTech_afficheTickets();
                       wus.setVisible(true);
                   } else {
                	   b = false;
                       JOptionPane.showMessageDialog(null, "Vous n'est pas reussit2！");
                   }
               } else {
                   JOptionPane.showMessageDialog(null, "Vous n'est pas reussit2！");
               }
          }    
        	
        	/*
        	if(role == "Admin"){
               if (res.next() ) {
                   String pwdBDD= res.getString(2);
                   System.out.println(pwdBDD + " " + pwd);
                   if (pwdBDD.equals(pwd)) {
                       b = true;
                       JOptionPane.showMessageDialog(null, "Le mot de passe est  correcte！");
                      quelle fenetre va s'afficher?
                       wus.setVisible(true);
                   } else {
                	   b = false;
                       JOptionPane.showMessageDialog(null, "Vous n'est pas reussit2！");
                   }
               } else {
                   JOptionPane.showMessageDialog(null, "Vous n'est pas reussit2！");
               }
          }  */
        	   res.close();
               con.close();
               statement.close();
           } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Desole,vous etes pas reussit de connercté");
               e.printStackTrace();
           }
           return b;
       } 
    
    

    }