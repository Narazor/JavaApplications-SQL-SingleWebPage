package ua.myDwelling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstateAgency {
	// The class creates and sorts a collection of estates. The methods describe
	// different kind of dwelling search by parameters

	// The instance variable stores a sorted list of estates
	public List<Estate> estates = sortedList();

	private List<Estate> createEstates() {
		List<Estate> estates = new ArrayList<Estate>();
		estates.add(new Flat("Flat", "Halych", 250, 2, 2.5, 3, 0.5));
		estates.add(new Flat("Flat", "Railway", 300, 2, 4, 3, 1.5));
		estates.add(new Flat("Flat", "Halych", 350, 3, 1, 2, 0.5));
		estates.add(new Flat("Flat", "Sykhiv", 350, 2, 1.5, 1, 1.5));
		estates.add(new Flat("Flat", "Sykhiv", 200, 1, 1.5, 2, 0.3));
		estates.add(new Penthouse("Penthouse", "Shevchenko", 450, 2, 2, 1.5, 2));
		estates.add(new Penthouse("Penthouse", "Halych", 400, 1, 1, 1, 1.5));
		estates.add(new Penthouse("Penthouse", "Sykhiv", 500, 3, 0.5, 1, 2.5));
		estates.add(new Mansion("Mansion", "Shevchenko", 350, 4, 2, 3.5, 0.5));
		estates.add(new Mansion("Mansion", "Halych", 250, 2, 3, 4.5, 2));
		estates.add(new Mansion("Mansion", "Sykhiv", 500, 3, 1, 0.5, 1.5));
		return estates;
	}

	// The method returns a list of estates sorted by type of dwelling
	public List<Estate> searchByType(int inputedNumber) {
		List<Estate> list = new ArrayList<>();
		for (Estate est : estates) {
			switch (inputedNumber) {
			case 1:
				return estates;
			case 2:
				if (est instanceof Flat) {
					list.add(est);
				}
				break;
			case 3:
				if (est instanceof Penthouse) {
					list.add(est);
				}
				break;
			case 4:
				if (est instanceof Mansion) {
					list.add(est);
				}
				break;
			}
		}
		return list;
	}

	// The method returns a list of estates sorted by price and social
	// infrastructure
	public List<Estate> searchByPrice_Infrastr(String infrastr, int price, double distnce) {
		List<Estate> list = new ArrayList<>();
		for (Estate est : estates) {
			if (est.getPrice() <= price && est.getDistance(infrastr) <= distnce) {
				list.add(est);
			}
		}
		return list;
	}

	// The method returns a list of estates sorted by type of dwelling and price
	public List<Estate> searchByType_Price(String type, int price) {
		List<Estate> list = new ArrayList<>();
		for (Estate est : estates) {
			switch (type.toLowerCase()) {
			case "flat":
				if (est instanceof Flat && est.getPrice() <= price) {
					list.add(est);
				}
				break;
			case "penthouse":
				if (est instanceof Penthouse && est.getPrice() <= price) {
					list.add(est);
				}
				break;
			case "mansion":
				if (est instanceof Mansion && est.getPrice() <= price) {
					list.add(est);
				}
				break;
			default:
				return null;
			}
		}
		return list;
	}

	// The method returns a list of estates sorted by type of dwelling and social
	// infrastructure
	public List<Estate> searchByType_Infrastr(String type, String infrastr, double distance) {
		List<Estate> list = new ArrayList<>();
		for (Estate est : estates) {
			switch (type.toLowerCase()) {
			case "flat":
				if (est instanceof Flat && est.getDistance(infrastr) <= distance) {
					list.add(est);
				}
				break;
			case "penthouse":
				if (est instanceof Flat && est.getDistance(infrastr) <= distance) {
					list.add(est);
				}
				break;
			case "mansion":
				if (est instanceof Flat && est.getDistance(infrastr) <= distance) {
					list.add(est);
				}
				break;
			default:
				return null;
			}
		}
		return list;
	}

	// The methods sorts a collection of estates by price
	public List<Estate> sortedList() {
		List<Estate> createdList = createEstates();
		Collections.sort(createdList, Estate.getPriceComparator());
		return createdList;
	}

	// The method returns the minimum price for specified kind of dwelling
	public int getMinPrice(int inputedNumber) {
		return searchByType(inputedNumber).get(0).getPrice();
	}

	// The method returns the max price for specified kind of dwelling
	public int getMaxPrice(int inputedNumber) {
		return searchByType(inputedNumber).get(searchByType(inputedNumber).size() - 1).getPrice();
	}

}
