package ua.myDwelling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainEstate {

	public static int inputedNumber;
	public static EstateAgency agency = new EstateAgency();

	public static void main(String[] args) {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		try {
			checkPrices(bf);
			questionToTheClient(bf);
		} catch (NumberFormatException | IOException e) {
			System.err.println("Incorrect input");
		}

	}

	// The method shows the price range for the houses that the user has chosen
	public static void checkPrices(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("What do you want to rent: 1)show all prices; 2)flat; 3)penthouse; 4)mansion : ");
		inputedNumber = Integer.parseInt(bf.readLine());
		switch (inputedNumber) {
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("The range of prices [" + agency.getMinPrice(inputedNumber) + "$:"
					+ agency.getMaxPrice(inputedNumber) + "$]");
			break;
		default:
			System.out.println("Incorrected input. Try again!");
			System.exit(0);
		}
	}

	// The method searches the specified kinds of houses using the user-defined
	// parameters
	public static List<Estate> searchByParameters(BufferedReader bf) throws NumberFormatException, IOException {
		System.out
				.print("We can filter dwelling by: 1)price and infrastructure; 2)kind of dwelling and infrustructure; "
						+ "3)kind of dwelling and price :");
		inputedNumber = Integer.parseInt(bf.readLine());
		switch (inputedNumber) {
		case 1:
			return agency.searchByPrice_Infrastr(checkInfrastr(bf), checkPrice(bf), checkDistance(bf));
		case 2:
			return agency.searchByType_Infrastr(checkDwelling(bf), checkInfrastr(bf), checkDistance(bf));
		case 3:
			return agency.searchByType_Price(checkDwelling(bf), checkPrice(bf));
		default:
			return null;
		}
	}

	// The method returns a user-defined social infrastructure
	public static String checkInfrastr(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print(
				"What kind of social infrastructure do you want to have near: 1)kindergarten; 2)school; 3)playgound: ");
		inputedNumber = Integer.parseInt(bf.readLine());
		switch (inputedNumber) {
		case 1:
			return "kindergarten";
		case 2:
			return "school";
		case 3:
			return "playground";
		default:
			return null;
		}
	}

	// The method returns a user-defined price
	public static int checkPrice(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("How much money can you spend for it? :");
		inputedNumber = Integer.parseInt(bf.readLine());
		return inputedNumber;
	}

	// The method returns the user-defined distance to social infrastructure
	public static int checkDistance(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("The distance from the house isn't more than (in km): ");
		inputedNumber = Integer.parseInt(bf.readLine());
		return inputedNumber;
	}

	// The method returns a user-defined kind of dwelling
	public static String checkDwelling(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("What kind of dwelling do you want to rent: 1)flat; 2)penthouse; 3)mansion :");
		inputedNumber = Integer.parseInt(bf.readLine());
		switch (inputedNumber) {
		case 1:
			return "flat";
		case 2:
			return "penthouse";
		case 3:
			return "mansion";
		default:
			return "Incorrected input";
		}
	}

	// The method asks the client whether he wants continue or not
	public static void questionToTheClient(BufferedReader bf) throws NumberFormatException, IOException {
		System.out.print("Are you interested in something: 1)yes; 2)no : ");
		inputedNumber = Integer.parseInt(bf.readLine());
		switch (inputedNumber) {
		case 1:
			System.out.println(searchByParameters(bf));
		case 2:
			System.out.println("Thank you!");
			System.exit(0);
			break;
		default:
			System.out.println("You can choose only 1 or 2. Please try again!");
			break;
		}
	}

}
