package Strategy_Singleton.Strategy;

import Strategy_Singleton.Singleton.Pix;

public class PayByPix implements PayMethod {

	@Override
	public boolean payment(double paymentAmount) {
		System.out.printf("Pay %.2f using Pix.%n",paymentAmount);
        return true;
	}

	@Override
	public void receivePaymentDetails() {
		String keyPix = Pix.getInstance().getKEY();
		System.out.println(keyPix);
	
	}

}