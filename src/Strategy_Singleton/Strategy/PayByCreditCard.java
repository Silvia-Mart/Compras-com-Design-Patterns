package Strategy_Singleton.Strategy;

import java.util.Scanner;

import Strategy_Singleton.Model.CreditCard;
import Strategy_Singleton.Validator.CreditVisaValidator;
import Strategy_Singleton.Validator.DateValidator;

public class PayByCreditCard implements PayMethod {
	
	Scanner scan = new Scanner(System.in);
    private CreditCard card;
    private CreditVisaValidator cardVisa;
    private DateValidator date;
    
    @Override
	public void receivePaymentDetails() {
    	
    	boolean incompleteData = true;
		while(incompleteData) {
			try {
	            System.out.print("Enter the Visa card number: ");
	            String cardNumber = scan.next();
	            cardVisa.isValidVisaCard(cardNumber);
	            
	            System.out.print("Enter the card expiration date 'mm/yyyy': ");
	            String cardExpirationDate = scan.next();
	            date.isValid(cardExpirationDate);
	            
	            System.out.print("Enter the CVV code: ");
	            String cvv = scan.next();
	            cardVisa.isValidCvv(cvv);
	            
	            card = new CreditCard(cardNumber, cardExpirationDate, cvv);
	            incompleteData = false;
	            
	            System.out.println("Authorized data for payment.");
	            
			} catch (RuntimeException ex) {
				System.out.println("Oops! Something went wrong, check your data.");
	        }
		}
	}

    private boolean cardIsPresent() {
        return card != null;
    }
    
	@Override
	public boolean payment(double paymentAmount) {
		
		if (cardIsPresent()) {
			System.out.printf("Paying %.2f using Credit Card.%n",paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
	}

}