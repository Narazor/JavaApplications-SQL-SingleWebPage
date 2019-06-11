package ua.flowerShop.properties;

import ua.flowerShop.enums.CountryEnum;

public abstract class PropertyFlower {

	private CountryEnum countrySupplier;

	public PropertyFlower(CountryEnum countrySupplier) {
		this.countrySupplier = countrySupplier;
	}

	public CountryEnum getCountrySupplier() {
		return countrySupplier;
	}

	public abstract double getPrice();

	public abstract boolean equals(Object obj);

}
