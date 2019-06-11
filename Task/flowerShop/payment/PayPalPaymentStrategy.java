package ua.flowerShop.payment;
public class PayPalPaymentStrategy implements Payment {

	@Override
	public boolean pay(double price) {
		System.out.printf("Paying $%.2f using PayPal payment \n", price);
		return true;
	}

}
