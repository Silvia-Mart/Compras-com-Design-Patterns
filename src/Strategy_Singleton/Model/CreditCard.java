package Strategy_Singleton.Model;

public class CreditCard {

	private double cardLimit = 1000;
	private String cardNumber;
	private String cardExpirationDate;
	private String cvv;
	
	public CreditCard(String cardNumber, String cardExpirationDate, String cvv){
		this.cardNumber = cardNumber;
		this.cardExpirationDate = cardExpirationDate;
		this.cvv = cvv;
	}

	public double getAmount() {
		return cardLimit;
	}

	public void setAmount(double amount) {
		this.cardLimit = amount;
	}
	
}