import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private MoneyHolding mh1;
	private MoneyHolding mh2;
	private MoneyHolding mh3;
	private MoneyHolding mh4;
	private MoneyHolding mh5;

	private ArrayList<MoneyHolding> moneyHoldingList;

	@Before
	public void setUp() throws Exception {
		mh1 = new MoneyHolding("USD", 100000.00);
		mh2 = new MoneyHolding("MYR", 500000.00);
		mh3 = new MoneyHolding("THB", 2000000.00);
		mh4 = new MoneyHolding("CNY", 1500000.00);
		mh5 = new MoneyHolding("CAD", 200000.00);

		moneyHoldingList = new ArrayList<MoneyHolding>();
		
		double[] thresholdList = { 1000.00, 2000.00, 3000.00, 4000.00, 5000.00 };
		
	}
	

	@Test
	public void retrieveAllHoldingAndSgdValueTest() {
		// Test if moneyHoldingList is not null but empty - boundary
		assertNotNull("Test is there is valid MoneyHolding arraylist to retrieve item", moneyHoldingList);

		// test if the list of moneyHolding retrieved from the MoneyHolding is empty
		String moneyHolding = C206_CaseStudy.retrieveAllHoldingAndSgdValue(moneyHoldingList); 
		String testOutput = " ";
		assertEquals("Check that viewAllMoneyHoldingAndSgdValue", testOutput, moneyHolding);

	}

	@Test
	public void viewAllHoldingAndSgdValue() {
		// Test if moneyHoldingList is not null but empty - boundary
		assertNotNull("Test is there is valid MoneyHolding arraylist to retrieve item", moneyHoldingList);

		// check arraylist is not empty - normal 
		
		String moneyHolding = C206_CaseStudy.retrieveAllHoldingAndSgdValue(moneyHoldingList);
		String testOutput = String.format("%-15s\n", moneyHoldingList.get(0).toString());
		assertEquals("Test that moneyHoldingList is not empty", testOutput, moneyHolding);
	}
	
	@Test
	public void updateThreshold() {
		// check if list is not null - boundary 
		assertNotNull("Test if there is a valid threshold to update from", thresholdList);
		
	}
	
	@Test
	public void viewAllThresholdHoldings() {
		// Test if thresholdList is not null but empty - boundary
		assertNotNull("Test is there is valid thresholdList arraylist to retrieve item", thresholdList);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
		mh1 = null;
		mh2 = null;
		mh3 = null;
		mh4 = null;
		mh5 = null;
		moneyHoldingList = null;
	}

}
