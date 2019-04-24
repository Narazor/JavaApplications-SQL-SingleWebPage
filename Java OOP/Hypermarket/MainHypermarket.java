package ua.myHypermarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainHypermarket {
	static int inputNumber;
	static Hypermarket h = new Hypermarket();

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try {
			createOffer(bf);
		} catch (NumberFormatException | IOException e) {
			System.err.println("Check inputted dates!");
		}

	}

	// The method forms the offer for the customer
	public static void createOffer(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("Take your choice: 1)plumbing; 2)wooden products; 3) specific plumbing or wooden products: ");
		inputNumber = Integer.parseInt(bf.readLine());
		switch (inputNumber) {
		case 1:
			System.out.println(h.getPlumbingOrWoodenProducts("plumbing"));
			break;
		case 2:
			System.out.println(h.getPlumbingOrWoodenProducts("wooden products"));
			break;
		case 3:
			filterProducts(bf);
			break;
		default:
			System.out.println("Incorrected input");
			break;
		}

	}

	// The method filters the goods according to the given parameters
	public static void filterProducts(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("We can offer: 1)bathes; 2)washbasins; 3)door; 4)wardrobe: ");
		inputNumber = Integer.parseInt(bf.readLine());
		switch (inputNumber) {
		case 1:
			System.out.println(h.getSpecificProduct("bathes"));
			checkPrice(bf, h.getSpecificProduct("bathes"), h);
			break;
		case 2:
			System.out.println(h.getSpecificProduct("washbasins"));
			checkPrice(bf, h.getSpecificProduct("washbasins"), h);
			break;
		case 3:
			System.out.println(h.getSpecificProduct("door"));
			checkPrice(bf, h.getSpecificProduct("door"), h);
			break;
		case 4:
			System.out.println(h.getSpecificProduct("wardrobes"));
			checkPrice(bf, h.getSpecificProduct("wardrobes"), h);
			break;
		default:
			System.out.println("Incorrected input");
			break;
		}

	}

	// The method filters the goods according to the given price
	public static void checkPrice(BufferedReader bf, List<Product> list, Hypermarket h)
			throws NumberFormatException, IOException {
		System.out.println("Our range of prices [" + h.getMinPrice(list) + "$ : " + h.getMaxPrice(list) + "$]");
		System.out.print("How much money can you spend?: ");
		inputNumber = Integer.parseInt(bf.readLine());
		System.out.println(h.getCheaperProduct(list, inputNumber));
	}
}
