package ua.myDwelling;

import java.util.Comparator;

public abstract class Estate implements TypeEstate {
	// The class describes all properties and methods for all estates and describes
	// the method that return distance to social infrastructure for each dwelling

	private static PriceComparator priceComparator = new PriceComparator();
	private String type;
	private String district;
	private int price;
	private int numberOfRooms;
	private double distanceToKindergarten;
	private double distanceToSchool;
	private double distanceToPlayground;

	public Estate(String type, String district, int price, int numberOfRooms, double distanceToKindergarten,
			double distanceToSchool, double distanceToPlayground) {
		this.type = type;
		this.district = district;
		this.price = price;
		this.numberOfRooms = numberOfRooms;
		this.distanceToKindergarten = distanceToKindergarten;
		this.distanceToSchool = distanceToSchool;
		this.distanceToPlayground = distanceToPlayground;
	}

	public static PriceComparator getPriceComparator() {
		return priceComparator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public double getDistanceToKindergarten() {
		return distanceToKindergarten;
	}

	public void setDistanceToKindergarten(double distanceToKindergarten) {
		this.distanceToKindergarten = distanceToKindergarten;
	}

	public double getDistanceToSchool() {
		return distanceToSchool;
	}

	public void setDistanceToSchool(double distanceToSchool) {
		this.distanceToSchool = distanceToSchool;
	}

	public double getDistanceToPlayground() {
		return distanceToPlayground;
	}

	public void setDistanceToPlayground(double distanceToPlayground) {
		this.distanceToPlayground = distanceToPlayground;
	}

	// The method returns for each dwelling it's own distance to the social
	// infrastructure
	public double getDistance(String infrastructure) {
		switch (infrastructure.toLowerCase()) {
		case "kindergarten":
			return getDistanceToKindergarten();
		case "school":
			return getDistanceToSchool();
		case "playground":
			return getDistanceToPlayground();
		default:
			return 0;
		}
	}

	private static class PriceComparator implements Comparator<Estate> {
		@Override
		public int compare(Estate est1, Estate est2) {
			return est1.getPrice() - est2.getPrice();
		}

	}

	@Override
	public String toString() {
		return getType() + " - " + getDistrict() + " district, " + "rental price: " + getPrice()
				+ "$, number of rooms: " + getNumberOfRooms() + ", distance to: kindergarten=" + getDistanceToKindergarten()
				+ "km, school=" + getDistanceToSchool() + "km, playground=" + getDistanceToPlayground() + "km.";
	}

}
