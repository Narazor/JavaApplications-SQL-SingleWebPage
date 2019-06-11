package ua.flowerShop.payment;
public class CreditCardPaymentStrategy implements Payment {

	@Override
	public boolean pay(double price) {
		System.out.printf("Paying $%.2f using credit card payment \n", price);
		return true;
	}

}
