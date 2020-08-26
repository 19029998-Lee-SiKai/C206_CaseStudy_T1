
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
	    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		
		int option = 0;
		
		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter option: ");
			
			//currency
			if (option == 1) {
				
			}
			
			
			//money holdings
			else if (option == 2) {
			
		        
			}
			
			//transaction
			else if (option == 3) {
				C206_CaseStudy.menu();
				C206_CaseStudy.opt();
				int opt = Helper.readInt("Enter option: ");
				
				if (opt == 1) {
					Transaction tt = inputTransaction();
					C206_CaseStudy.addTransaction(transactionList, tt);
				}
				
				else if (opt == 2) {
					viewAllTransaction(transactionList);
				}
				
				else if (opt == 3) {
					C206_CaseStudy.deleteTransaction(transactionList);
				}
				else if (opt == 4) {
					viewFilteredDateTransaction(transactionList);
				}
				else if (opt == 5) {
					viewFilteredCurrencyTransaction(transactionList);
				}
				
				else {
					System.out.println("Invalid Option!");
				}
			}
			
			// end of prog
			else if (option == 4) {
				System.out.println("Bye!");
			}
			
			else {
				System.out.println("Invalid!");
			}
		}
	
		}
	public static void opt() {
		C206_CaseStudy.setHeader ("TRANSACTION");
		System.out.println("1. New Transaction");
		System.out.println("2. View All Transactions");	
		System.out.println("3. Delete Transactions");
		System.out.println("4. View Specified Date Transactions");
		System.out.println("5. View Specified Currency Converted Transactions");
		Helper.line(100, "-");
	}
	public static void menu() {
		C206_CaseStudy.setHeader ("MONEY EXCHANGE");
		System.out.println("1. Currency");
		System.out.println("2. Holding Currency and SGD Value");
		System.out.println("3. Transaction");
		System.out.println("4. Quit");
		Helper.line(100, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}
	
		  
	// input transaction
	public static Transaction inputTransaction() {
		LocalDate date = LocalDate.now();
		date.toString();
		String type = Helper.readString("Enter transaction type (Buy or Sell): ");
		String ccyIn = Helper.readString("Enter currrency to exchange (USD, MYR, THB, CNY, CAD): ");
		double amtIn = Helper.readDouble("Enter amount to exchange: ");
		String ccyOut = Helper.readString("Enter currency converted (USD, MYR, THB, CNY, CAD): ");
		double rate = Helper.readDouble("Enter the rate: ");
		double amtOut = rate * amtIn; // if type is buy/sell, use buy/sell rate * amtIn
		System.out.println("Money to be given back to customer: " + amtOut);
		
		Transaction tt = new Transaction ( date, type, ccyIn, amtIn, ccyOut, rate, amtOut);
		return tt;
	
		
	}
	// add transaction
	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction tt) {
		transactionList.add(tt);
		System.out.println("New transaction added");
	}
	
	// retrieve and view transaction
	public static String viewAllTransaction(ArrayList<Transaction> transactionList) {
		C206_CaseStudy.setHeader ("Transaction List");
		String output = ""; 
		System.out.println(String.format(" %-30s %-30s %-30s %-30s %-30s %-30s %-30s \n ", "Date", "Type", "Currency Exchange", 
				"Amount Exchange", "Currency Converted", "Rate", "Amount to Customer"));
		for (int i = 0; i < transactionList.size(); i++) {

			output += String.format(" %-30s %-30s %-30s %-30.2f %-30s %-30.2f %-30.2f \n", transactionList.get(i).getdate().toString(), 
					transactionList.get(i).getType(), transactionList.get(i).getCcyIn(), transactionList.get(i).getamtIn(),
					transactionList.get(i).getCcyOut(), transactionList.get(i).getRate(), transactionList.get(i).getamtOut());
		}
		System.out.println(output);
		return output;
		
	}
	
	// delete transaction
	public static void deleteTransaction(ArrayList<Transaction> transactionList) {
		viewAllTransaction(transactionList);
		String date = Helper.readString("Enter date to delete: ");
		for (int i = 0; i < transactionList.size(); i++ ) {
			if (date.equalsIgnoreCase(transactionList.get(i).getdate().toString())) {
				transactionList.remove(i);
				System.out.println("Successfully Deleted!"); 
			}
			else {
				System.out.println("Invalid");
			}
		
		}
		
		
		}
	//new requirements view by date
	public static void viewFilteredDateTransaction(ArrayList<Transaction> transactionList) {
		
		String date = Helper.readString("Enter Transaction date to view (yyyy-MM-dd): ");
		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).getdate().toString().equalsIgnoreCase (date)) {
				C206_CaseStudy.viewAllTransaction(transactionList);
				break;
			}
			else {
				System.out.println("No matching Transaction");
			}
		}
		
	}
	
	//new requirements view by total transactions of currency out 
	public static void viewFilteredCurrencyTransaction(ArrayList<Transaction> transactionList) {
		viewAllTransaction(transactionList);
		String currency = Helper.readString("Enter currency converted to view: ");
		int count = 0;
		for (int i = 0; i < transactionList.size(); i++) {
			if (currency.equalsIgnoreCase (transactionList.get(i).getCcyOut())){
				count+= 1;
			}
			else {
				System.out.println("No such currency converted!");
			}
			System.out.println(count);
		}
	}
	
}
		
