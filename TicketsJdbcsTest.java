package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.Ignore;
import ticket_me.Person;
import ticket_me.Tickets;
import ticket_me.TicketsJdbcs;
/**
 * 
 * @author YANG Zilu
 * This class is used for testing the class TicketsJdbcs
 *
 */
class TicketsJdbcsTest {
	TicketsJdbcs tj = new TicketsJdbcs();
	
	

	/**
	 *  testInsert1() 
	 * test with a normal ticket
	 */
	
	@Test
	void testInsert1() {
		String titre = "testWithScreenshot";
		 String description ="test with screenshot";
		 String screenshot = "C:\\Users\\ASUS\\Pictures\\photo1.png";
		 String categorie = "youtube";
		 String priorite ="High";
		 String isCreatedBy = "testerY";
		 tj.insert(titre, description,screenshot, categorie, priorite,isCreatedBy) ;
		System.out.println("insert successfully");
		 
		
	}

	/**
	 *  testInsert2()
	 * test with ticket without screenshot
	 */
	@Test
	void testInsert2() {
		
		 String titre ="TicketWithoutScreenshot";
		 String description ="titleOftest";
		 String categorie = "youtube";
		 String priorite ="High";
		 String isCreatedBy = "testerY";
		 tj.insert(titre,description,categorie,priorite,isCreatedBy) ;
		System.out.println("insert successfully");
		 
		
	}
	/**
	 *  testInsert3
	 * test without title but with screenshot
	 */
	
	@Test
	void testInsert3() {
		String titre = "";
		 String description ="test without title but with screenshot";
		 String screenshot = "C:\\Users\\ASUS\\Pictures\\photo1.png";
		 String categorie = "youtube";
		 String priorite ="High";
		 String isCreatedBy = "testerY";
		 tj.insert(titre, description,screenshot, categorie, priorite,isCreatedBy) ;
		System.out.println("insert successfully");
		 
		
	}
	/**
	 *  testInsert4()
	 * test the ticket without screenshot and without title neither
	 */
	@Test
	void testInsert4() {
		
		 String titre ="";
		 String description ="you don't have title and screenshot!";
		 String categorie = "youtube";
		 String priorite ="High";
		 String isCreatedBy = "testerY";
		 tj.insert(titre,description,categorie,priorite,isCreatedBy) ;
		System.out.println("insert successfully");
		 
		
	}
	
	/**
	 * testGetTicket1()
	 * test with a existed ticket in the database,
	 * we choose ticket 1  here to test.
	 */
	@Test
	void testGetTicket1() {
		 int id = 1; 
		String res = TicketsJdbcs.getTicket(id);
		System.out.println( "Your ticket is  "+res);
		Assert.assertEquals("there is a trouble",   "blue screen",res);
		 
		
	}
	/**
	 * testGetTicket2()
	 * test with a ticket which is not in database,
	 * we choose the ticket 100 here to test.
	 */
	@Test
	void testGetTicket2() {
		 int id = 100; 
		 String res = TicketsJdbcs.getTicket(id);
		System.out.println( "Your ticket is  "+res);
		Assert.assertEquals("There is a trouble", "",res);
		 
			}
	/**
	 * testGetTicket3()
	 * test with a ticket that we don't put the id,
	 * we choose the ticket 100 here to test.
	 */
	@Ignore
	void testGetTicket3() {
		 int id = (Integer) null; 
		 String res = TicketsJdbcs.getTicket(id);
		System.out.println( "Your ticket is  "+res);
		Assert.assertEquals("There is a trouble", "",res);
		 
			}

	/**
	 * testGetRows()
	 * test if we can exactly obtain all the rows from 
	 * table ticket which their status are equal to 1.
	 */
	@Test
	void testGetRows() {
		 @SuppressWarnings("rawtypes")
		Vector res = TicketsJdbcs.getRows();
		System.out.println( "Your rows of ticket are  "+res);
		 
	}
	/**
	 * testGetHead()
	 *Test if we can get the column names of table ticket which are not resovle
	 */
	@Test
	void testGetHead() {
		 @SuppressWarnings("rawtypes")
		Vector res = TicketsJdbcs.getHead();
		System.out.println( "Your head of ticket is  "+res);
		
		 
	}
	 
	/**
	 *  testAnswerT()
	 * Test if the table of ticket can be updated with the completion_code,solution , id_ticket
	 * and the technician who resolved this ticket
	 */
	@Test
	void testAnswerT() {
		String comCode = "training";
		String sl = "It is your solution";
		String id ="57";
		String  isSolvedBy ="TesterY";
		boolean res = tj.answerT(comCode, sl, id, isSolvedBy);
		System.out.println(res);
		assertTrue(res);
		
     }
	/**
	 * testGetIsCreatedBy()
	 * Test if we can get the person who created the ticket

	 */
	@Test
	void testGetIsCreatedBy() {
		int idUser = 24;
		String res = TicketsJdbcs.getIsCreatedBy(idUser);
		System.out.println(res);
		Assert.assertEquals("There is a trouble", "glegrand29",res);
		
     }
	
	
	
	@After
    public void after() {
        System.out.println("we finished");
    }
	
	
}
