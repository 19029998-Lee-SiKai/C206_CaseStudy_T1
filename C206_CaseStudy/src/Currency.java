/**
 * 
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19044418, 21 Aug 2020 10:06:35 am
 */

public class Currency {
	private String iso;
	private String currencyName;
	private double buyRate;
	private double sellRate;
	public Currency(String iso, String currencyName, double buyRate, double sellRate) {
		this.iso = iso;
		this.currencyName = currencyName;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}
	public String getIso() {
		return iso;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public double getBuyRate() {
		return buyRate;
	}
	public double getSellRate() {
		return sellRate;
	}
	public String output() {
		String output = String.format("%-10s %20s %15s %20s", iso, currencyName, buyRate, sellRate);
		return output;
	}

}
