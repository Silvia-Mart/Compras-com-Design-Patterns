package Strategy_Singleton.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Strategy_Singleton.Strategy.PayByCreditCard;
import Strategy_Singleton.Strategy.PayByPix;
import Strategy_Singleton.Strategy.PayMethod;

public class ClientCode {
	
	private static Map<Integer, Double> priceOnProducts = new HashMap<>();
	static Scanner scan = new Scanner(System.in);
    private static Order order = new Order();
    private static PayMethod strategy;

    static {
        priceOnProducts.put(1, 299.91);
        priceOnProducts.put(2, 149.90);
        priceOnProducts.put(3, 126.90);
        priceOnProducts.put(4, 172.43);
    }

	public static void start() {
		
		while (!order.Closed()) {
            double value;

            String continueChoice;
            do {
                System.out.print("Please, select a Box:" + "\n" +
                        "1 - Box Harry Potter Tradicional         299.91" + "\n" +
                        "2 - Box Jurassic Park-Edição Capa Dura   149.90" + "\n" +
                        "3 - Box Amor & Livros                    126.90" + "\n" +
                        "4 - Box Trilogia O Senhor dos Anéis      172.43" + "\n");
                int choice = scan.nextInt();
                value = priceOnProducts.get(choice);
                System.out.print("QuantityProduct: ");
                int quantityProduct = scan.nextInt();
                if(quantityProduct == 0 || quantityProduct > 100) {
                	System.out.print("enter product quantity from 1 to 100 units: ");
                    quantityProduct = scan.nextInt();
                }
                order.setPurchaseValue(value * quantityProduct);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = scan.next();
            } while (continueChoice.equalsIgnoreCase("Y"));
		
            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - Pix" + "\n" +
                        "2 - Visa Credit Card");
                String paymentMethod = scan.next();

                if (paymentMethod.equals("1")) {
                    strategy = new PayByPix();
                    System.out.print("The pix key is a cnpj: ");
                    strategy.receivePaymentDetails();
                    
                } else {
                    strategy = new PayByCreditCard();
                    System.out.println("enter your details to continue:");
                    strategy.receivePaymentDetails();
                  
                }
            }
            System.out.printf("Total purchase amount: %.2f.Do you want to continue shopping or checkout? P-> Pay/S-> Shopping : %n",order.getPurchaseValue());
            String proceed = scan.next();
    	    if (proceed.equalsIgnoreCase("P")) 
    	        if (strategy.payment(order.getPurchaseValue())) {
    	            System.out.println("Payment has been successful.");
    	            order.setClosed();
    	        } else {
    	            System.out.println("FAIL! Please, check your data.");
    	        }
    	    }
		}
}