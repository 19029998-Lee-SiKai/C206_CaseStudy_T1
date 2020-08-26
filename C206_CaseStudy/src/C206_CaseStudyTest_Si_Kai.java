import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Transaction tt1;
	private Transaction tt2;
	
	private ArrayList<Transaction> transactionList;
	
	public C206_CaseStudyTest(){
		super();
	}
	@Before
	public void setUp() throws Exception {
		//prepare test data
		tt1 = new Transaction( LocalDate.now(), "Buy", "USD", 110, "MYR", 0.7304, 80.34 );
		tt2 = new Transaction( LocalDate.now(), "Sell", "USD", 110, "CNY", 0.7278, 80.06 );
	}

	@After
	public void addTransactionTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Transaction arraylist to add to", transactionList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addTransaction(transactionList, tt1);		
		assertEquals("Test if that Transaction arraylist size is 1?", 1, transactionList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Transaction is added same as 1st item of the list?", tt1, transactionList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addTransaction(transactionList, tt2);	
		assertEquals("Test if that Transaction arraylist size is 2?", 2, transactionList.size());
	}

	@Test
	public void viewAllTransactionTest() {
		//fail("Not yet implemented"); 
		
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Transaction arraylist to add to", transactionList);
		
		//test if the list of transaction retrieved from the SourceCentre is empty
		String allTransaction= C206_CaseStudy.viewAllTransaction(transactionList);
		String testOutput = "";
		assertEquals("Check that ViewAllTransactionlist", testOutput, allTransaction);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addTransaction(transactionList, tt1);
		C206_CaseStudy.addTransaction(transactionList, tt2);
		assertEquals("Test if that Transaction arraylist size is 2?", 2, transactionList.size());
		
		//test if the expected output string same as the list of transaction retrieved from the SourceCentre
		allTransaction = C206_CaseStudy.viewAllTransaction(transactionList);

		testOutput = String.format(" %-30s %-30s %-30s %-30.2f %-30s %-30.2f %-30.2f\n",LocalDate.now(), "Buy", "USD", 110, "MYR", 0.7304, 80.34);
		testOutput += String.format(" %-30s %-30s %-30s %-30.2f %-30s %-30.2f %-30.2f\n","Sell", "USD", 110, "CNY", 0.7278, 80.06);
	
		assertEquals("Check that ViewAllTransactionlist", testOutput, allTransaction);

	}
}
