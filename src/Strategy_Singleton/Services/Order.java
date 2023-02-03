package Strategy_Singleton.Services;

import Strategy_Singleton.Strategy.PayMethod;

public class Order {

	private double purchaseValue = 0;
	private boolean closed = false;
	
	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue += purchaseValue;
	}

	public boolean Closed() {
		return closed;
	}

	public void setClosed() {
		this.closed = true;
	}

	public void processOrder(PayMethod strategy) {
        strategy.receivePaymentDetails(); 
    }
}
