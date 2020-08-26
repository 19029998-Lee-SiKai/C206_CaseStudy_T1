import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<MoneyHolding> moneyHoldingList = new ArrayList<MoneyHolding>();

		moneyHoldingList.add(new MoneyHolding("USD", 100000.00));
		moneyHoldingList.add(new MoneyHolding("MYR", 500000.00));
		moneyHoldingList.add(new MoneyHolding("THB", 2000000.00));
		moneyHoldingList.add(new MoneyHolding("CNY", 1500000.00));
		moneyHoldingList.add(new MoneyHolding("CAD", 200000.00));

		double[] thresholdList = new double[5];

		int option = 0;

		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter option > ");

			// currency
			if (option == 1) {

			}

			// Money Holding
			else if (option == 2) {
				C206_CaseStudy.chooseMenu();
				int chooseMenu = Helper.readInt("Enter option > ");

				if (chooseMenu == 1) {
					C206_CaseStudy.viewAllHoldingAndSgdValue(moneyHoldingList);

				} else if (chooseMenu == 2) {
					C206_CaseStudy.searchHoldingCurrencies(moneyHoldingList);
				} else {
					System.out.println("Invalid");
				}
			}

			// Transaction
			else if (option == 3) {

			}
			// Threshold
			else if (option == 4) {
				C206_CaseStudy.thresholdMenu();
				int thresholdMenu = Helper.readInt("Enter option >");

				if (thresholdMenu == 1) {
					C206_CaseStudy.updateThreshold(moneyHoldingList);
				} else if (thresholdMenu == 2) {
					C206_CaseStudy.viewAllThresholdHoldings(moneyHoldingList);
				} else {
					System.out.println("Invalid");
				}
			}

			// Quit
			else if (option == 5) {
				System.out.println("Bye");

			}

			// invalid
			else {
				System.out.println("Invalid option");
			}

		}
	}

	public static void currencyMenu() {
		C206_CaseStudy.setHeader("Currency");
		System.out.println("1. Add currency");
		System.out.println("2. View currency");
		System.out.println("3. Delete currency");
	}

	public static void menu() {

		C206_CaseStudy.setHeader("MONEY EXCHANGE");
		System.out.println("1. Currency");
		System.out.println("2. Holding Currency and SGD Value");
		System.out.println("3. Transaction");
		System.out.println("4. Threshold");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static void chooseMenu() {

		C206_CaseStudy.setHeader("MONEY HOLDING SYSTEM");
		System.out.println("1. VIEW VARIOUS CURRENCIES");
		System.out.println("2. SEARCH HOLDING CURRENCIES");
		Helper.line(80, "-");
	}

	public static void thresholdMenu() {
		C206_CaseStudy.setHeader("THRESHOLD");
		System.out.println("1. UPDATE THRESHOLD");
		System.out.println("2. VIEW ALL THRESHOLD");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {

		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
//retrieve all holding and sgd value 
	public static String retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> moneyHoldingList) {
		String output = " ";
		for (int i = 0; i < moneyHoldingList.size(); i++) {
			String iso = moneyHoldingList.get(i).getIso();
			double holdingAmt = moneyHoldingList.get(i).getHoldingAmt();
			output += String.format("%-80s \n", moneyHoldingList.get(i).toString());
		}
		return output;
	}
//view all holding and sgd value
	public static void viewAllHoldingAndSgdValue(ArrayList<MoneyHolding> moneyHoldingList) {
		C206_CaseStudy.setHeader("Money Holder List ");
		String output = " ";
		System.out.println(String.format("%-20s %-20s %-20s\n", "ISO", "HOLDINGS", "SGD_VALUE"));
		for (int i = 0; i < moneyHoldingList.size(); i++) {
			double rate = 0.0;
			if (moneyHoldingList.get(i).getIso().equals("USD")) {
				rate = 0.7278;
			} else if (moneyHoldingList.get(i).getIso().equals("MYR")) {
				rate = 3.0700;
			} else if (moneyHoldingList.get(i).getIso().equals("THB")) {
				rate = 55.6700;
			} else if (moneyHoldingList.get(i).getIso().equals("CNY")) {
				rate = 5.06;
			} else if (moneyHoldingList.get(i).getIso().contentEquals("CAD")) {
				rate = 0.9633;
			} else {
				System.out.println("Invalid");
			}
			output += String.format("%-20s %-20.2f %-20.2f \n", moneyHoldingList.get(i).getIso(),
					moneyHoldingList.get(i).getHoldingAmt(), (moneyHoldingList.get(i).getHoldingAmt() * rate));
		}
		System.out.println(output);
	}
//search holding currencies 
	public static void searchHoldingCurrencies(ArrayList<MoneyHolding> moneyHoldingList) {
		String output = " ";
		Helper.line(80, "-");
		String search = Helper.readString("Enter Currency to Search > ");
		System.out.println(String.format("%-20s %-20s %-20s\n", "ISO", "HOLDINGS", "SGD_VALUE"));

		double rate = 0.0;
		if (search.equals("USD")) {
			rate = 0.7278;
			System.out.println(String.format("%-20s %-20.2f %-20.2f \n", "USD", 100000.00, 100000.00 * rate));
		} else if (search.equals("MYR")) {
			rate = 3.0700;
			System.out.println(String.format("%-20s %-20.2f %-20.2f \n", "MYR", 500000.00, 100000.00 * rate));
		} else if (search.equals("THB")) {
			rate = 55.6700;
			System.out.println(String.format("%-20s %-20.2f %-20.2f \n", "THB", 2000000.00, 100000.00 * rate));
		} else if (search.equals("CNY")) {
			rate = 5.06;
			System.out.println(String.format("%-20s %-20.2f %-20.2f \n", "CNY", 1500000.00, 100000.00 * rate));
		} else if (search.equals("CAD")) {
			rate = 0.9633;
			System.out.println(String.format("%-20s %-20.2f %-20.2f \n", "CAD", 200000.00, 100000.00 * rate));
		} else {
			System.out.println("Invalid");
		}
	}
//update threshold
	public static void updateThreshold(ArrayList<MoneyHolding> moneyHoldingList) {
		String output = " ";
		C206_CaseStudy.setHeader("UPDATE THRESHOLD");

		double[] thresholdList = { 10000.00, 2000.00, 3000.00, 4000.00, 50000.00 };

		for (int i = 0; i < thresholdList.length; i++) {
			
			String iso = Helper.readString("Enter Currency type > ");
			double threshold = Helper.readDouble("Enter Threshold amount to update > ");
			
			if (iso.equalsIgnoreCase("USD")) {
				thresholdList[0] = threshold;

			} else if (iso.equalsIgnoreCase("MYR")) {
				thresholdList[1] = threshold;

			} else if (iso.equalsIgnoreCase("THB")) {
				thresholdList[2] = threshold;

			} else if (iso.equalsIgnoreCase("CNY")) {
				thresholdList[3] = threshold;

			} else if (iso.equalsIgnoreCase("CAD")) {
				thresholdList[4] = threshold;
			}
			output += String.format("%-20s %-20.2f \n", iso, thresholdList[i]);
			System.out.println(String.format("%-20s %-20s \n", "CURRENCY", "THRESHOLD"));
			System.out.println(output);

		}
	}
// viewAllThresholdingHoldings	
	public static void viewAllThresholdHoldings(ArrayList<MoneyHolding> moneyHoldingList) {
		String output = " ";
		C206_CaseStudy.setHeader("VIEW THRESHOLD HOLDING");
		
		double threshold = Helper.readDouble("Enter threshold amount > ");
		System.out.println(String.format("%-20s %-20s", "ISO", "HOLDING"));
		
		double [] thresholdList = {10000.00, 50000.00, 100000.00, 500000.00, 1000000.00};
		int n = 0;
		
		for (int i = 0; i<thresholdList.length; i++) {
			if (thresholdList[i] < threshold) {
				n = i;
				output += String.format("%-20s %-20.2f \n", moneyHoldingList.get(n).getIso(),
						moneyHoldingList.get(n).getHoldingAmt());
			}
		}
		System.out.println(output);
	}
}
