package ua.flowerShop.properties;

import ua.flowerShop.enums.CountryEnum;

public class PropertiesBushyFlowers extends PropertyFlower {

	private int amountTheFlowersOnStem;

	public PropertiesBushyFlowers(CountryEnum countrySupplier, int amountTheFlowersOnStem) {
		super(countrySupplier);
		this.amountTheFlowersOnStem = amountTheFlowersOnStem;
	}

	public int getAmountTheFlowersOnStem() {
		return amountTheFlowersOnStem;
	}

	// The method returns the price of flower, which depends on the amount of buds
	// on the stem and on the supplier
	@Override
	public double getPrice() {
		double price = 30;
		if (getAmountTheFlowersOnStem() > 3) {
			price += 5;
		}
		if (getCountrySupplier().equals(CountryEnum.NETHERLANDS)) {
			price += 7;
		}
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountTheFlowersOnStem;
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
		PropertiesBushyFlowers other = (PropertiesBushyFlowers) obj;
		if (amountTheFlowersOnStem != other.amountTheFlowersOnStem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "supplier - " + getCountrySupplier() + ", amount of the flowers on stem = "
				+ getAmountTheFlowersOnStem();
	}

}
