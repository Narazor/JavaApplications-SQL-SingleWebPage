package com.myGem;

import java.util.Comparator;

public abstract class Gem {
	// An abstract class Gem describe all the necessary properties and methods for
	// all gems

	private static PriceComparator priceComparator = new PriceComparator();
	private String name;
	private double caratWeight;
	private double price;
	private boolean transparency;

	public Gem(String name, double caratWeight, double price, boolean transparency) {
		this.name = name;
		this.transparency = transparency;
		this.caratWeight += caratWeight;
		this.price += price;
	}

	public static PriceComparator getPriceComparator() {
		return priceComparator;
	}

	public static void setPriceComparator(PriceComparator priceComparator) {
		Gem.priceComparator = priceComparator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCaratWeight() {
		return caratWeight;
	}

	public void setCaratWeight(double caratWeight) {
		this.caratWeight = caratWeight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getTransparency() {
		return transparency;
	}

	public void setTransparency(boolean transparency) {
		this.transparency = transparency;
	}

	 // The method returns the following string if the transparent of the gem is true
	 // of false
	public String checkTransperency() {
		if (getTransparency() == true) {
			return "transparent";
		} else {
			return "non-transparent";
		}
	}

	private static class PriceComparator implements Comparator<Gem> {
		@Override
		public int compare(Gem g1, Gem g2) {
			return (int) (g1.getPrice() - g2.getPrice());
		}

	}

	@Override
	public String toString() {
		return getName() + " (" + getCaratWeight() + " carats) " + checkTransperency() + " " + getPrice() + "$";
	}

}
