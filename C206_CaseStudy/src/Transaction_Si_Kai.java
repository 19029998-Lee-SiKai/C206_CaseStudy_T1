
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class Transaction {
	
	
	private LocalDate txnDate;
	private String type; 
	private String ccyIn;
	private double amtIn;
	private String ccyOut;
	private double amtOut;
	private double rate;
	
	public Transaction (  LocalDate date, String type, String ccyIn, double amtIn, String ccyOut, double rate, double amtOut) {
		
		this.type = type;
		this.ccyIn = ccyIn;
		this.amtIn = amtIn;
		this.ccyOut = ccyOut;
		this.rate = rate;
		this.amtOut= amtOut;
	}
	
	public LocalDate getdate() {
		LocalDate date = LocalDate.now();
		date.toString();
		 return date;
	 }
	
	public String getType() {
		return type;
	}
	
	public String getCcyIn() {
		return ccyIn;
	}
	
	public double getamtIn() {
		return amtIn;
	}
	
	public String getCcyOut() {
		return ccyOut;
	}
	
	public double getRate() {
		return rate;
	}
	
	public double getamtOut() {
		return amtOut;
	}
	
	
}
