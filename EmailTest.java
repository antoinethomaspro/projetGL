package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ticket_me.Email;
/**
 * 
 * @author YANG Zilu
 * This class is used for testing the class Email
 *
 */
class EmailTest {
	Email e = new Email();

	/**
	 * testGetEmailFromBD1()
	 * This is the case when username is empty
     */
	
	@Test
	void testGetEmailFromBD1() {
		String username = "";
		String res ="";
		res = e.getEmailFromBD(username);
		System.out.println(res);
		assertEquals("", res);
		
	}

   /**
    * testGetEmailFromBD2()
    * This is the case when username exists in the database
    */
	@Test
	void testGetEmailFromBD2() {
		String username = "nmitchelyn";
		String res ="";
		res = e.getEmailFromBD(username);
		System.out.println(res);
		assertEquals("nmitchelyn@yellowpages.com", res);
		
	}

	   /**
	    * testGetEmailFromBD3()
	    * This is the case when username doesn't exist in the database
	    */
		@Test
		void testGetEmailFromBD3() {
			String username = "testerYY";
			String res ="";
			res = e.getEmailFromBD(username);
			System.out.println(res);
			assertEquals("", res);
			
		}
	@Test
	void testSendEmail() {
		String to ="yangzilu049@gmail.com";
		String name = "testerY";
		String nameT ="We can send the Email?";		
		Email.sendEmail(to, name, nameT);
		System.out.println("Your email has been sent");
	}

}
