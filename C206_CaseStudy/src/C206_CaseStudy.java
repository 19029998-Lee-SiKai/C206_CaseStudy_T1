import java.util.ArrayList;



public class C206_CaseStudy {
	private static final int SEARCH_BUY_SELL = 1;
	private static final int CURRENCY_CONVERT = 2;
	private static final int SUMMARY_OF_TRANSACTION = 3;
	private static final int OPTION_QUIT = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		
		currencyList.add(new Currency("USD", "United States Dollar", 0.7304, 0.7278));
		currencyList.add(new Currency("MYR", "Malaysia Ringgit", 3.0750, 3.0700));
		currencyList.add(new Currency("THB", "Thai Baht", 22.7790, 22.8));
		currencyList.add(new Currency("CNY", "Chinese Yuan",5.0813, 5.06));
		currencyList.add(new Currency("CAD", "Canadian Dollar", 0.9689, 0.9633));
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == SEARCH_BUY_SELL) {
				searchCurrency(currencyList);

			} else if (option == CURRENCY_CONVERT) {
				convertCurrency(currencyList);

			} else if (option == SUMMARY_OF_TRANSACTION) {
				summaryTransaction(currencyList);
				
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
				
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");


			} else {
				System.out.println("Invalid option");
			}

		}
	}
	public static void menu() {
		C206_CaseStudy.setHeader("CURRENCY");
		System.out.println("1. Search Buy/Sell Rate");
		System.out.println("2. Convert Currency");
		System.out.println("3. Summary Of Transaction");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String searchCurrency(ArrayList<Currency> currencyList) {
		System.out.println("SEARCH BY CURRENCY");
		String searchStr = Helper.readString("CURRENCY name > ");


		String output = String.format("%-10s %-10s %10s %10s\n","Iso","Currency ","BUY RATE","SELL RATE");
		boolean found = false;
		
		for (Currency i : currencyList) {
			String CURRENCY = i.getIso();
			if (CURRENCY.toUpperCase().contains(searchStr.toUpperCase())) {
				found = true;
				output += String.format("%-10s %-10s %10s %10s",i.getIso(),i.getCurrencyName(),i.getBuyRate(),i.getSellRate());
			}
			
		}
		if (found == true) {
			System.out.println(output);
		} else {
			System.out.println("No match found");
		}
		return output;
	}

    
	
	    public static void convertCurrency(ArrayList<Currency> currencyList) {
	        // TODO Auto-generated method stub
	        System.out.print("CURRENCY CONVERTER");
	        //User Input
	        String transactionType = Helper.readString(" Type of transaction(BUY/SELL) > ");
	        String currencyIn = Helper.readString("Currency In(ISO) > ");
	        String amountIn = Helper.readString("Amount In > ");
	        String currencyOut = Helper.readString("Currency Out(ISO) > ");
	        
	        int b = Integer. parseInt(amountIn);
	        boolean found = false;
	        String output = "";


	        for(Currency i : currencyList) {
	            String currency = i.getIso();
	            if(currency.toUpperCase().contains(currencyIn.toUpperCase()) && transactionType.equals("SELL")){
	                found = true;
	                 int sellRate = (int) (b * i.getSellRate());
	                 output += String.format("SELLING " + currencyIn + currencyIn + " For " + currencyOut + sellRate);
	            }
	            else {
	                if(currency.toUpperCase().contains(currencyIn.toUpperCase()) && transactionType.contentEquals("BUY")) {
	                    found = true;
	                    int buyRate = (int) (b * i.getBuyRate());
	                    output += String.format("BUYING " + currencyIn + amountIn + " For " + currencyOut + buyRate);
	                }
	            }
	        }
	        if(found == true) {
	            System.out.println(output);
	        }
	        else {
	            System.out.println("No match found");
	        }


	    }
	    //V2 
	    public static void summaryTransaction(ArrayList<Currency> currencyList) {
			System.out.println("SUMMARY OF TRANSACTION");
			String weekday = Helper.readString("WEEK or DAY > ");


			String output = String.format("%-10s %-10s \n","TYPE","CURRENCY ");
			boolean found = false;
			
			for (Currency i : currencyList) {
			
	            if(weekday.toUpperCase().contains(weekday.toUpperCase()) && weekday.equals("WEEK")){
	                found = true;
	           
	                 output += String.format("%-10s %-10s \n","SELL",i.getCurrencyName());
	            }
	            else {
	                if(weekday.toUpperCase().contains(weekday.toUpperCase()) && weekday.equals("DAY")){
	                    found = true;
	                    
	                    output += String.format("%-10s %-10s \n","BUY",i.getCurrencyName());
	                }
	            }
	        }
	        if(found == true) {
	            System.out.println(output);
	        }
	        else {
	            System.out.println("No match found");
	        }
		
	    }
	    




}
