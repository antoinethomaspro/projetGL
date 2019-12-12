package ticket_me;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 * @author Antoine THOMAS 
 * @author ZHANG Zimeng 
 * @author YANG Zilu
 * cette classe permet d'envoyer l'email apres avoir resolu un ticket a createur
 * 
 *
 */
public class Email {
	
	static Connection con = null;
    static Statement statement = null;
    static PreparedStatement Pstatement = null;
    static ResultSet res = null;
    String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ticket_me";
    public static final String USER = "root";
    public static final String PASSWD = "root";
   
    
   	//ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.config");
   	static String mail = "ticketme41000@gmail.com"; //bundle.getString("sgbd.mail");
   	static String pwd = "Blois41000";//bundle.getString("sgbd.password");
   	
    static final String username = mail;   // EMAIL ACCOUNT OF THE SOFTWAR
    static final String password = pwd;
       
    public Email() {
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
     * cette methode permet d'obtenir l'email de la BDD
     * @param username vient de getIsCreatedBy
     * @return l'email de username
     */
    public String getEmailFromBD(String username) {
    	 String result = "";
  
        String sql = "select email from person where name = " + "'"+username+"'";
        		  		
        try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(URL,USER,PASSWD);
			 statement = con.createStatement();
            ResultSet a = statement.executeQuery(sql);
            a.beforeFirst();
            if(a.next()) {
                result = a.getString(1);//column email
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
	 * 
	 * @param to vient de getEmailFromBD(username),c'est l'email du createur qui va recevoir cet email
	 * @param name vient de TicketsJdbcs.getIsCreatedBy(int idUser) ,c'est le nom du createur
	 * @param nameT vient de TicketsJdbcs.getTicket(Id),c'est le nom du ticket
	 */
	public static void sendEmail(String to,String name,String nameT){
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, "hunosvvnlklrkghj");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to) 
            );
            message.setSubject("Ticket Closed");
            message.setText("Dear "+ name                               
                    + ", Your ticket title : "+ nameT +" has been resolved!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
		

}
