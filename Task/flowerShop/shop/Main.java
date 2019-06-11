package ua.flowerShop.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ua.flowerShop.delivery.DHLDeliveryStrategy;
import ua.flowerShop.delivery.Delivery;
import ua.flowerShop.delivery.PostDeliveryStrategy;
import ua.flowerShop.delivery.WithoutDeliveryStrategy;
import ua.flowerShop.exception.EnteringDateException;
import ua.flowerShop.payment.CreditCardPaymentStrategy;
import ua.flowerShop.payment.PayPalPaymentStrategy;
import ua.flowerShop.payment.Payment;
import ua.flowerShop.product.Bouquet;
import ua.flowerShop.product.Flower;
import ua.flowerShop.product.Product;

public class Main {

	private FlowerShop shop = new FlowerShop();
	private Order order = new Order();
	private Florist florist = new Florist();
	private Scanner scanner = new Scanner(System.in);
	private String continueChoice;

	public static void main(String[] args) {
		new Main().entryPoint();
	}

	// The method checks passage of the order and controls its finish
	public void entryPoint() {
		while (!order.isCompleted()) {
			try {
				getAnswerOnContinueShopping();
			} catch (EnteringDateException e) {
				System.out.println(e);
			}
			orderProcess();
			order.setCompleted();
		}
	}

	// The method asks to user about continue forming order
	public String getAnswerOnContinueShopping() throws EnteringDateException {
		do {
			try {
				addNecessaryProductToBasket();
			} catch (EnteringDateException e) {
				System.out.println(e);
			}
			System.out.println("Continue shopping? (Yes/No): ");
			continueChoice = scanner.nextLine();
		} while (continueChoice.equalsIgnoreCase("Yes"));
		return continueChoice;
	}

	// The method invokes the method, which returns necessary kind of goods and adds
	// them into basket
	public void addNecessaryProductToBasket() throws EnteringDateException {
		System.out.println("We can offer the following goods: \n 1.Flower \n 2.Flowerpot \n 3.Paper "
				+ "\n 4.Ribbon \n 5.Ready bouquet \n 6.Bouquet to order.");
		System.out.println("Your choice (input number): ");
		Product product = getNecessaryProduct();
		System.out.println(product);
		System.out.println("Add this product to the basket? (Yes/ No): ");
		if (scanner.nextLine().equalsIgnoreCase("Yes")) {
			order.addGoods(product);
			order.setTotalCost(product.getPrice());
			System.out.println("Product has been added!");
		} else {
			System.out.println("To add product you need to enter \"Yes\".");
			System.out.println("Product hasn't been added.");
		}
	}

	// The method offers a list of goods and returns the user-selected goods
	public Product getNecessaryProduct() throws EnteringDateException {
		String choice = scanner.nextLine();
		switch (choice) {
		case "1": case "2":	case "3": case "4":
			System.out.println("You can choose from these: ");
			System.out.println(shop.getSpecifiedDescriptionOfGoods(choice));
			System.out.println("Your choice (input name of product): ");
			return florist.getSpecifiedProduct(scanner.nextLine());
		case "5":
			System.out.println("You can choose from these: ");
			System.out.println(shop.getSpecifiedDescriptionOfGoods(choice));
			return getBouquetWithRibbonOrPaper(florist.getSpecifiedProduct(scanner.nextLine()));
		case "6":
			System.out.println("You can choose from these: ");
			System.out.println(shop.getSpecifiedDescriptionOfGoods(choice));
			return getBouquetWithRibbonOrPaper(new Bouquet("Bouquet", getFlowersForBouquetOfUser()));
		default:
			throw new EnteringDateException("You can choose only 1, 2, 3, 4, 5 or 6. Try again!");

		}
	}

	// The method offers to user different decorations for bouquet and returns or
	// only flowers or a processed bouquet
	public Product getBouquetWithRibbonOrPaper(Product setOfFlowers) throws EnteringDateException {
		System.out.println("You want bouquet with ribbon OR with paper and ribbon OR only flowers?");
		return florist.getBouquet(setOfFlowers, scanner.nextLine().toLowerCase());
	}

	// The method returns a list of flowers for bouquet to order with the specified
	// number of
	public List<Flower> getFlowersForBouquetOfUser() throws NumberFormatException {
		List<Flower[]> chosenFlowers = new ArrayList<Flower[]>();
		System.out.println("How many dif1ferent type of flowers would you like in you bouquet? ");
		int answer = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= answer; i++) {
			System.out.print("Input please the " + i + " necessary type of flower: ");
			String flower = scanner.nextLine().toLowerCase();
			System.out.print("How many flowers this kind of type do you want?: ");
			int numberOfFlowers = Integer.parseInt(scanner.nextLine());
			try {
				chosenFlowers.add(florist.getSpecifiedInstancesOfFlowers(flower, numberOfFlowers));
			} catch (EnteringDateException e) {
				System.out.println(e);
				i--;
			}
		}
		List<Flower> list = florist.convertListArraysOfFlowers(chosenFlowers);
		return list;
	}

	// The method returns the appropriate payment method entered by the user
	public Payment paymentProcess() {
		while (order.getPaymentStrategy() == null) {
			System.out.println("Select a payment method: \n 1. PayPal payment \n 2. Credit card payment");
			System.out.println("Your choice: ");
			switch (scanner.nextLine().toLowerCase()) {
			case "1":
				order.setPaymentStrategy(new PayPalPaymentStrategy());
				break;
			case "2":
				order.setPaymentStrategy(new CreditCardPaymentStrategy());
				break;
			default:
				try {
					throw new EnteringDateException("You can choose only 1 OR 2. Try again!");
				} catch (EnteringDateException e) {
					System.out.println(e);
				}
			}
		}
		return order.getPaymentStrategy();
	}

	// The method returns the appropriate delivery method entered by the user
	public Delivery deliveryProcess() {
		while (order.getDeliveryStrategy() == null) {
			System.out.println("Select a delivery method: \n 1. New Post \n 2. DHL Express \n 3.Whitout delivery");
			System.out.println("Your choice: ");
			switch (scanner.nextLine().toLowerCase()) {
			case "1":
				order.setDeliveryStrategy(new PostDeliveryStrategy());
				break;
			case "2":
				order.setDeliveryStrategy(new DHLDeliveryStrategy());
				break;
			case "3":
				order.setDeliveryStrategy(new WithoutDeliveryStrategy());
				break;
			default:
				try {
					throw new EnteringDateException("You can choose only 1, 2 OR 3. Try again!");
				} catch (EnteringDateException e) {
					System.out.println(e);
				}
			}
		}
		return order.getDeliveryStrategy();
	}

	// The method invokes methods delivery and payment, and controls the finishing
	// of ordering when user didn't choose any product or doesn't want to continue
	// shopping.
	public void orderProcess() {
		if (!continueChoice.equalsIgnoreCase("Yes") && (order.getProducts().size() == 0)) {
			System.out.println("You exited shop. If you want to buy something you need to start at first. Bye!");
			System.exit(0);
		} else {
			double generalPrice = order.getTotalCost();
			System.out.println("In your basket: " + order.getProducts());
			System.out.println("General price = " + generalPrice + "hrn! \n");

			deliveryProcess();
			paymentProcess();
			System.out.println("Would you like to pay? (Yes/No)");
			if (scanner.nextLine().toLowerCase().equals("yes")) {
				order.getPaymentStrategy().pay(generalPrice);
				order.getDeliveryStrategy().delivery(order.getProducts());
			} else {
				System.out.println("Payment failed. You need to start at first!");
				System.exit(0);
			}
		}
	}

}
