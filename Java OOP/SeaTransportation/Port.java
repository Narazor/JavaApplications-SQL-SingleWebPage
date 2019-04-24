package com.seaTransportation;

import java.util.Comparator;

public abstract class Port {
	// An abstract class Port describe all the necessary properties and methods for
	// all ports

	private static PriceDryCargoComparator priceDryCargoComparator = new PriceDryCargoComparator();
	private static PriceLiquidsComparator priceLiquidsComparator = new PriceLiquidsComparator();
	private static PriceWithoutTareComparator priceWithoutTareComparator = new PriceWithoutTareComparator();
	private static PriceCargoOnWheels priceCargoOnWheels = new PriceCargoOnWheels();
	private String country;
	private String name;
	// dollar per ton
	private int priceForDryCargo;
	private int priceForLiquids;
	private int priceForWithoutTare;
	private int priceForCargoOnWheels;

	public Port(String country, String name) {
		this.country = country;
		this.name = name;
	}

	public static PriceDryCargoComparator getPriceDryCargoComparator() {
		return priceDryCargoComparator;
	}

	public static PriceLiquidsComparator getPriceLiquidsComparator() {
		return priceLiquidsComparator;
	}

	public static PriceWithoutTareComparator getPriceWithoutTareComparator() {
		return priceWithoutTareComparator;
	}

	public static PriceCargoOnWheels getPriceCargoOnWheels() {
		return priceCargoOnWheels;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceForDryCargo() {
		return priceForDryCargo;
	}

	public int getPriceForLiquids() {
		return priceForLiquids;
	}

	public int getPriceForWithoutTare() {
		return priceForWithoutTare;
	}

	public int getPriceForCargoOnWheels() {
		return priceForCargoOnWheels;
	}

	// The method calculates and returns the price for the dry cargo of the
	// corresponding port
	public int costsForDryCargo(int numberOfTons) {
		return getPriceForDryCargo() * numberOfTons;
	}

	// The method calculates and returns the price for the liquid of the
	// corresponding port
	public int costsForLiquids(int numberOfTons) {
		return getPriceForLiquids() * numberOfTons;
	}

	// The method calculates and returns the price for the bulk cargo without tare
	// of the corresponding port
	public int costsForWithoutTare(int numberOfTons) {
		return getPriceForWithoutTare() * numberOfTons;
	}

	// The method calculates and returns the price for the cargo on wheels of the
	// corresponding port
	public int costsForVehicle(int numberOfTons) {
		return getPriceForCargoOnWheels() * numberOfTons;
	}

	private static class PriceDryCargoComparator implements Comparator<Port> {
		@Override
		public int compare(Port costPort1, Port costPort2) {
			return costPort1.getPriceForDryCargo() - costPort2.getPriceForDryCargo();
		}

	}

	private static class PriceLiquidsComparator implements Comparator<Port> {
		@Override
		public int compare(Port costPort1, Port costPort2) {
			return costPort1.getPriceForLiquids() - costPort2.getPriceForLiquids();
		}
	}

	private static class PriceWithoutTareComparator implements Comparator<Port> {
		@Override
		public int compare(Port costPort1, Port costPort2) {
			return costPort1.getPriceForWithoutTare() - costPort2.getPriceForWithoutTare();
		}
	}

	private static class PriceCargoOnWheels implements Comparator<Port> {
		@Override
		public int compare(Port costPort1, Port costPort2) {
			return costPort1.getPriceForCargoOnWheels() - costPort2.getPriceForCargoOnWheels();
		}
	}

	@Override
	public String toString() {
		return "Port name: " + getName() + ", country - " + getCountry();
	}

}
