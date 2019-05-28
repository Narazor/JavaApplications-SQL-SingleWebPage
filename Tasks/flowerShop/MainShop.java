package ua.flowerShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ua.flowerShop.materialForFloristry.*;
import ua.flowerShop.plant.*;

public class MainShop {

	public static void main(String[] args) {

		new MainShop().entryPoint();

	}

	public void entryPoint() {
		Scanner sc = new Scanner(System.in);
		FlowerShop shop = new FlowerShop();
		Florist florist = new Florist();
		boolean checkCondition = true;

		while (checkCondition) {
			System.out.println("We can you offer the following goods: ");
			System.out.println(shop.getAllNamesOfGoods());
			try {
				Product product = createOfferForUser(shop, florist, sc);
				shop.addGoodsToTheShoppingBasket(product);
				System.out.println(product + " - added to the shopping basket. \n");
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input + \n");
			} catch (EnteringDateException e) {
				System.out.println(e + "\n");
			}
			checkCondition = let_sContinue(sc);
		}
		shop.basket.stream().forEach(System.out::println);
		if (shop.basket.size() > 0) {
		System.out.println("General price = " + shop.calculatingPricesBoughtGoods());
			System.out.println("Make a payment thanks to: Pay Pal (OR) cash (OR) terminal: ");
			System.out.println("The payment was successful - " + shop.payAFee(sc.nextLine().toLowerCase()));
			System.out.println("We can offer such delivery: New Post OR courier OR another type of delivery:");
			System.out.println(shop.deliveryGoods(sc.nextLine().toLowerCase()));
			System.out.println("Thank you for your purchase!");
		}
		System.out.println("Thank you!");
	}

	public List<Flower> getFlowersForUser_sBouquet(Florist florist, Scanner sc) throws NumberFormatException {
		List<Flower[]> chosenFlowers = new ArrayList<Flower[]>();
		System.out.println("How many different flowers would you like in you bouquet? ");
		int answer = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= answer; i++) {
			System.out.print("Input please the " + i + " necessary type of flower: ");
			String flower = sc.nextLine().toLowerCase();
			System.out.print("How many number of this type of flower do you want?: ");
			int numberOfFlowers = Integer.parseInt(sc.nextLine());
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

	public Tape getSpecifiedTape(Florist florist, Scanner sc) throws EnteringDateException {
		System.out.println("We can offer the following tape's colors - white OR blue OR yellow:");
		return florist.getSpecifiedTape(sc.nextLine().toLowerCase());
	}

	public WrapperBouquet getSpecifiedWrapper(Florist florist, Scanner sc) throws EnteringDateException {
		System.out.println("We can offer the following wrappers - craft paper OR transparent film:");
		return florist.getSpecifiedWrapper(sc.nextLine().toLowerCase());
	}

	public Flower getSpecifiedFlower(Florist florist, Scanner sc, FlowerShop shop) throws EnteringDateException {
		System.out.println("All flowers sorted by price");
		printAllFlowersSortedByPrice(shop);
		System.out.println("Your choice - red/white/pink rose OR "
				+ "red/yellow/purple tulip OR purple/yellow/white chrysanthemum OR red/white peony:");
		return florist.getSpecifiedFlower(sc.nextLine().toLowerCase());
	}

	public Bouquet getSpecifiedBouquet(Florist florist, Scanner sc) throws EnteringDateException {
		System.out.println("We can offer the following bouquets - mix roses and mix chrysanthemums:");
		return florist.getSpecifiedBouquet(sc.nextLine().toLowerCase());
	}

	public Flowerpot getSpecifiedFlowerpot(Florist florist, Scanner sc) throws EnteringDateException {
		System.out.println("We can offer the following flowerpot - orchid, dracaena, palm Pandanus or cactus:");
		return florist.getSpecifiedFlowerpot(sc.nextLine().toLowerCase());
	}

	public Product createOfferForUser(FlowerShop shop, Florist florist, Scanner sc)
			throws NumberFormatException, EnteringDateException {
		System.out.println("What would you like to buy? Inpute, please, your choice: ");
		String userChoice = sc.nextLine();
		switch (userChoice.toLowerCase()) {
		case "bouquet to order":
			return new Bouquet("Bouquet", getFlowersForUser_sBouquet(florist, sc), getSpecifiedTape(florist, sc),
					getSpecifiedWrapper(florist, sc));
		case "flower":
			return getSpecifiedFlower(florist, sc, shop);
		case "wrapper":
			return getSpecifiedWrapper(florist, sc);
		case "tape":
			return getSpecifiedTape(florist, sc);
		case "bouquet":
			return getSpecifiedBouquet(florist, sc);
		case "flowerpot":
			return getSpecifiedFlowerpot(florist, sc);
		case "tree":
			florist.getSpecifiedTree(userChoice);
		}
		throw new EnteringDateException("Incorected input");
	}

	public void printAllFlowersSortedByPrice(FlowerShop shop) {
		shop.products.stream().filter(p -> p.getNameOfGoods().equals("Flower"))
				.sorted((p1, p2) -> p1.getPrice() - p2.getPrice()).forEach(System.out::println);
	}

	public boolean let_sContinue(Scanner sc) {
		System.out.println("Do you want to continue shopping(yes OR no)?");
		String answer = sc.nextLine();
		switch (answer.toLowerCase()) {
		case "yes":
			return true;
		case "no":
			return false;
		default:
			return let_sContinue(sc);
		}
	}

}
