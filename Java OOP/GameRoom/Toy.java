package com.gameRoom;

import java.util.Comparator;

public class Toy {
	 // The class Toy describe all the necessary properties and methods for all toys


	private static TypeComparator typeComparator = new TypeComparator();
	private static PriceComparator priceComparator = new PriceComparator();
	private String type;
	private SizeToy size; // Enum
	private int price; // hrn;

	public Toy(String type, SizeToy size, int price) {
		this.type = type;
		this.size = size;
		this.price = price;
	}

	public static TypeComparator getNameComparator() {
		return typeComparator;
	}
	
	public static PriceComparator getPriceComparator() {
		return priceComparator;
	}

	public SizeToy getSize() {
		return size;
	}

	public void setSize(SizeToy size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		if (price != other.price)
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	private static class TypeComparator implements Comparator<Toy> {
		@Override
		public int compare(Toy t1, Toy t2) {
			return t1.getType().compareTo((t2.getType()));
		}

	}
	
	private static class PriceComparator implements Comparator<Toy> {
		@Override
		public int compare(Toy t1, Toy t2) {
			return t1.getPrice() - t2.getPrice();
		}

	}
	
	@Override
	public String toString() {
		return "The " + getType() + " (size - "+ getSize() + "), price for one - " + getPrice() + " hrn. amount";
	}

}
